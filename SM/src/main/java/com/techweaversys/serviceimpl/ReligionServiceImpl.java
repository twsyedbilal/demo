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

import com.techweaversys.conv.ReligionDtoConvertor;
import com.techweaversys.dto.PageDto;
import com.techweaversys.dto.ReligionDto;
import com.techweaversys.dto.ReligionSpecDto;
import com.techweaversys.generics.AppConstants;
import com.techweaversys.generics.Code;
import com.techweaversys.generics.Messages;
import com.techweaversys.generics.Response;
import com.techweaversys.model.Religion;
import com.techweaversys.repository.ReligionRepository;
import com.techweaversys.service.ReligionService;
import com.techweaversys.spec.ReligionSpec;

import ch.qos.logback.classic.Logger;

@Service
@Transactional
public class ReligionServiceImpl implements ReligionService {

	@Autowired
	private ReligionRepository religionRepository;
	
	private Logger logger = (Logger) LoggerFactory.getLogger(getClass());
	
	@Override
	public ResponseEntity<?> saveReligion(ReligionDto religionDto) {
		logger.info("Creating Religion "+ religionDto);
		Religion religion = new Religion();
		if (religionDto.getId() != null) {
			religion = religionRepository.getOne(religionDto.getId());
		}
		
		religion.setname(religionDto.getname());
		religion.setcode(religionDto.getcode());
		religionRepository.save(religion);
		
		return Response.build(Code.CREATED, Messages.USER_CREATED_MSG);
	}

	@Override
	public ResponseEntity<?> getByIdReligion(Long id) {
		Optional<Religion> religion = religionRepository.findById(id);
		return Response.build(Code.OK, religion);
	}

	@Override
	public ResponseEntity<?> findAllReligion() {
		List<Religion> list = religionRepository.findAll();
		return Response.build(Code.OK, list);
	}

	@Override
	public ResponseEntity<?> deletReligionById(Long id) {
		Religion religion = new Religion();
		if (id != null) {
			religion = religionRepository.getOne(id);
			religion.setDeleted(true);
			religionRepository.save(religion);
		}
		return Response.build(Code.OK, Messages.DELETED);
	}

	@Override
	public ResponseEntity<?> findAllwithpage(ReligionSpecDto dto) {
		PageRequest bb = PageRequest.of(dto.getPage() - 1, dto.getSize(), Direction.DESC, 
				AppConstants.MODIFIED);
		Page<Religion> religion = religionRepository.findAll(new ReligionSpec(dto.getname(), dto.getcode()), bb);
		
		List<ReligionDto> list = religion.stream().map(new ReligionDtoConvertor()).collect(Collectors.toList());
		PageDto pageDto = new PageDto(list, religion.getTotalElements());
		return Response.build(Code.OK, pageDto);
	}
	
}
