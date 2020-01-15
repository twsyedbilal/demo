package com.techweaversys.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import com.techweaversys.dto.UserAddDto;
import com.techweaversys.dto.UserEditDto;
import com.techweaversys.dto.UserSpecDto;
import com.techweaversys.exception.UserAlreadyExistsException;
import com.techweaversys.model.User;
import com.techweaversys.security.AuthenticationRequest;




public interface UserService {
	
	ResponseEntity<?> authenticationUser(AuthenticationRequest authenticationRequest);

	Page<User> userList(Pageable pageable);
	
    public  ResponseEntity<?> addUser(UserAddDto dto) throws UserAlreadyExistsException;
	
	
	public ResponseEntity<?> editUser(UserEditDto dto) throws UserAlreadyExistsException;
	
	public ResponseEntity<?> resetPassword(UserEditDto dto);
	
	public ResponseEntity<?> deactivateUser(Long id);
	
	public ResponseEntity<?> listUser(UserSpecDto dto);

	ResponseEntity<?> findAll();
}
