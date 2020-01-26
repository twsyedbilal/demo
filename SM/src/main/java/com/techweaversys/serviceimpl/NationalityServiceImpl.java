package com.techweaversys.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techweaversys.conv.NotionalityDtoConvertor;
import com.techweaversys.dto.NationalityDto;
import com.techweaversys.dto.NationalitySpaceDto;
import com.techweaversys.dto.PageDto;
import com.techweaversys.generics.AppConstants;
import com.techweaversys.generics.Code;
import com.techweaversys.generics.Messages;
import com.techweaversys.generics.Response;
import com.techweaversys.model.NationalityEntity;
import com.techweaversys.repository.NationalityRepository;
import com.techweaversys.service.NationalityService;
import com.techweaversys.spec.NationalitySpce;

import ch.qos.logback.classic.Logger;

@Service
@Transactional
public class NationalityServiceImpl implements NationalityService {

	@Autowired
	private NationalityRepository nationalityRepository;

	private Logger logger = (Logger) LoggerFactory.getLogger(getClass());
	
	@Override
	public ResponseEntity<?> saveData(NationalityDto dto) {
		logger.info("Creating Nationality" + dto);
		NationalityEntity sh = new NationalityEntity();
		if (dto.getId() != null) {
			sh = nationalityRepository.getOne(dto.getId());

		}
		sh.setName(dto.getName());
		sh.setCode(dto.getCode());
		nationalityRepository.save(sh);

		return Response.build(Code.CREATED, Messages.USER_CREATED_MSG);

	}

	@Override
	public ResponseEntity<?> findAllData() {
		List<NationalityEntity> list = nationalityRepository.findAll();
		return Response.build(Code.OK, list);
	}

	@Override
	public ResponseEntity<?> DeletById(Long id) {
		NationalityEntity bb = new NationalityEntity();
		if (id != null) {
			bb = nationalityRepository.getOne(id);
			bb.setDeleted(true);
			nationalityRepository.save(bb);
		}

		return Response.build(Code.OK, Messages.DELETED);
	}

	@Override
	public ResponseEntity<?> getById(Long id) {
		Optional<NationalityEntity> bb = nationalityRepository.findById(id);
		return Response.build(Code.OK, bb);
	}
 
	@Override 
	public ResponseEntity<?> findAllwithpage(NationalitySpaceDto dto) {
		logger.info("Showing list of branch", dto);
		PageRequest pg = PageRequest.of(dto.getPage() - 1, dto.getSize(), Direction.DESC, AppConstants.MODIFIED);
		Page<NationalityEntity> nationality = nationalityRepository.findAll(new NationalitySpce(dto.getName(), dto.getCode()), pg);
		List<NationalityDto> list = nationality.stream().map( new NotionalityDtoConvertor() ).collect( Collectors.toList() );
		PageDto pageDto = new PageDto(list, nationality.getTotalElements());
		return Response.build(Code.OK, pageDto);
	}
	}

