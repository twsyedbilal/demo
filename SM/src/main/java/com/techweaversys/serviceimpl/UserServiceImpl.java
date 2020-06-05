package com.techweaversys.serviceimpl;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techweaversys.conv.UserAddCovertor;
import com.techweaversys.conv.UserDtoAutoConvertor;
import com.techweaversys.conv.UserDtoConvertor;
import com.techweaversys.dto.PageDto;
import com.techweaversys.dto.UserAddDto;
import com.techweaversys.dto.UserDto;
import com.techweaversys.dto.UserEditDto;
import com.techweaversys.dto.UserListDto;
import com.techweaversys.dto.UserSpecDto;
import com.techweaversys.enums.StatusType;
import com.techweaversys.exception.UserAlreadyExistsException;
import com.techweaversys.generics.AppConstants;
import com.techweaversys.generics.Code;
import com.techweaversys.generics.Messages;
import com.techweaversys.generics.Response;
import com.techweaversys.model.Role;
import com.techweaversys.model.User;
import com.techweaversys.repository.RoleRepository;
import com.techweaversys.repository.UserRepository;
import com.techweaversys.security.AuthenticationRequest;
import com.techweaversys.security.AuthenticationResponse;
import com.techweaversys.security.SecureUser;
import com.techweaversys.security.TokenUtils;
import com.techweaversys.service.UserService;
import com.techweaversys.spec.UserByroleSpec;
import com.techweaversys.spec.UserSpec;
import com.techweaversys.utility.Constants;



@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private TokenUtils tokenUtils;
	
	
	
	@Autowired
	ModelMapper modelMapper;

	@Override
	public ResponseEntity<?> authenticationUser(AuthenticationRequest authenticationRequest) {
		try {
			final Authentication authentication = this.authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
							authenticationRequest.getPassword()));
			SecurityContextHolder.getContext().setAuthentication(authentication);
			final SecureUser secureUser = (SecureUser) authentication.getPrincipal();
			final String token = this.tokenUtils.generateObjectToken(secureUser);
			// Return the token;
			
			return ResponseEntity.ok(new AuthenticationResponse(token, secureUser.getId(), secureUser.getName(),
					secureUser.getAuthorities()));
		} catch (DisabledException e) {
			return new ResponseEntity<>(HttpStatus.LOCKED);
		}
	}

	@Override
	public Page<User> userList(Pageable pageable) {
		return userRepository.findAll(pageable);
	}

	@Override
	public ResponseEntity<?> addUser(UserAddDto dto) throws UserAlreadyExistsException {
		
		logger.info("Creating user: " + dto);
		
		Optional<User> userOpt = userRepository.findOneByUsername(dto.getUsername());
		if( userOpt.isPresent() ) {
			logger.info("UserName already exists.");
			throw new UserAlreadyExistsException();
		}
		
		User user = new UserAddCovertor().apply(dto);
		List<Role> roles = roleRepository.findByRoleIn( Arrays.asList( dto.getRoles() ) );
		user.setRoles(roles);

		user.setUsername(dto.getUsername());
		user.setName(dto.getName());
		user.setMobile(dto.getMobile());
		user.setEmail(dto.getEmail());
		user.setPassword(dto.getPassword());
		user.setAddress(dto.getAddress());
		user.setBloodGroup(dto.getBloodGroup());
		user.setDateOfBirth(dto.getDateOfBirth());
		user.setGender(dto.getGender());
		user.setCity(dto.getCity());
		user.setState(dto.getState());
		user.setQualification(dto.getQualification());

		userRepository.save(user);
		
		logger.info(String.format("User %s has been created successfully", user.getUsername()));
		
		return Response.build(Code.CREATED, Messages.USER_CREATED_MSG);
	}
    
	@Override
	public ResponseEntity<?> editUser(UserEditDto dto) throws UserAlreadyExistsException{
		logger.info("editing user " +dto);
		User user = userRepository.findOneById(dto.getId());
		if(dto.getUsername().equals(user.getUsername())) {
			
		}else {
			Optional<User> userOpt = userRepository.findOneByUsername(dto.getUsername());
			if( userOpt.isPresent() ) {
				logger.info("UserName already exists.");
				throw new UserAlreadyExistsException();
			}
		}
		user.setUsername(dto.getUsername());
		user.setName(dto.getName());
		user.setMobile(dto.getMobile());
		user.setEmail(dto.getEmail());
		user.setPassword(dto.getPassword());
		List<Role> roles = roleRepository.findByRoleIn( Arrays.asList( dto.getRoles() ) );
		user.setRoles(roles);
		
		userRepository.save(user);
		return Response.build(Code.ACCEPTED, Messages.EDIT_USER, user);
	}

	
	@Override
	public ResponseEntity<?> resetPassword(UserEditDto dto) {
		logger.info("reseting password "+dto);
		logger.info("password :", dto.getPassword());
		User user = userRepository.findOneById(dto.getId());
		
		user.setPassword(dto.getPassword());
		userRepository.save(user);
		return Response.build(Code.ACCEPTED, Messages.RESET_PASSWORD, user);
	}

	@Override
	public ResponseEntity<?> deactivateUser(Long id) {
		logger.info("deactivating user for id:-"+id);
		User user = userRepository.findOneById(id);
		if(user.getStatus().equals(StatusType.Active.toString())){
			user.setStatus(StatusType.Deactive.toString());
			return Response.build(Code.ACCEPTED, Messages.USER_STATUS_DEACTIVE, user.getStatus());
		}else {
			user.setStatus(StatusType.Active.toString());
			return Response.build(Code.ACCEPTED, Messages.USER_STATUS_ACTIVE, user.getStatus());
		}
			
	}

	@Override
	public ResponseEntity<?> listUser(UserSpecDto dto) {			
		logger.info("showing list of users", dto);

		PageRequest pg = PageRequest.of(dto.getPage() - 1, dto.getSize(), Direction.ASC, AppConstants.MODIFIED);

		Page<User> users = userRepository.findAll(new UserSpec(dto.getName(), dto.getUsername(), dto.getEmail(), dto.getMobile()), pg);
		
		List<UserDto> list = users.stream().map( new UserDtoConvertor() ).collect( Collectors.toList() );		
		PageDto pageDto = new PageDto(list, users.getTotalElements());
		return Response.build(Code.OK, pageDto);
	}

	@Override
	public ResponseEntity<?> findAll() {
		logger.info("showing list of users");
		List<User> users = userRepository.findAll(new UserByroleSpec("","",Constants.ROLE_SALE));
		List<UserListDto> list = users.stream().map( new UserDtoAutoConvertor() ).collect( Collectors.toList() );
		return Response.build(Code.OK, list);
	}

	@Override
	public ResponseEntity<?> findAllTeacher() {

		List<User> userList = userRepository.findAll();
//		List<UserAddDto> dto = userList.stream().map(new UserAddCovertor()).collect(Collectors.toList());
		return Response.build(Code.OK, userList);
	}

	@Override
	public ResponseEntity<?> delete(Long id) {
		User user = new User();
		if (id != null) {
			user = userRepository.getOne(id);
			user.setDeleted(true);
			userRepository.save(user);
		}
		return Response.build(Code.OK, Messages.DELETED);
	}

	@Override
	public ResponseEntity<?> getAllRole() {
		List<Role> list = roleRepository.findAll();
		return Response.build(Code.OK, list);
	}

	@Override
	public ResponseEntity<?> getDataById(Long id) {
		User user = userRepository.getOne(id);
		UserAddDto dto = modelMapper.map(user, UserAddDto.class);
		return Response.build(Code.OK, dto);
	}
}