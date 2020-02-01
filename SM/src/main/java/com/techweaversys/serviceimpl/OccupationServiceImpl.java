package com.techweaversys.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techweaversys.conv.OccupationDtoConvertor;
import com.techweaversys.dto.OccupationDto;
import com.techweaversys.dto.OccupationSpecDto;
import com.techweaversys.dto.PageDto;
import com.techweaversys.generics.AppConstants;
import com.techweaversys.generics.Code;
import com.techweaversys.generics.Messages;
import com.techweaversys.generics.Response;
import com.techweaversys.model.Occupation;
import com.techweaversys.repository.OccupationRepository;
import com.techweaversys.service.OccupationService;
import com.techweaversys.spec.OccupationSpec;

import ch.qos.logback.classic.Logger;

@Service
@Transactional
public class OccupationServiceImpl implements OccupationService{

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private OccupationRepository occupationRepository;
	
	private Logger logger = (Logger) LoggerFactory.getLogger(getClass());

	@Override
	public ResponseEntity<?> saveOccupation(OccupationDto  occupationDto) {
		logger.info("Creating Occupation "+ occupationDto);
		Occupation occupation = new Occupation();
		if (occupationDto.getId() != null) {
			occupation = occupationRepository.getOne(occupationDto.getId());
		}
		
		occupation.setOccupationName(occupationDto.getname());
		occupation.setOccupationCode(occupationDto.getcode());
		occupationRepository.save(occupation);
		
		return Response.build(Code.CREATED, Messages.USER_CREATED_MSG);	
	}

	@Override
	public ResponseEntity<?> getByIdOccupation(Long id) {
		Occupation s = occupationRepository.getOne(id);
		OccupationDto dto = modelMapper.map(s, OccupationDto.class);
		return Response.build(Code.OK, dto);
	}

	@Override
	public ResponseEntity<?> findAllOccupation() {
		List<Occupation> list = occupationRepository.findAll();
		return Response.build(Code.OK, list);
	}

	@Override
	public ResponseEntity<?> deleteOccupationById(Long id) {
		Occupation occupation = new Occupation();
		if (id != null) {
			occupation = occupationRepository.getOne(id);
			occupation.setDeleted(true);
			occupationRepository.save(occupation);
		}
		return Response.build(Code.OK, Messages.DELETED);
	}

	@Override
	public ResponseEntity<?> findAllwithpage(OccupationSpecDto dto) {

		PageRequest bb = PageRequest.of(dto.getPage() - 1, dto.getSize(), Direction.DESC, 
				AppConstants.MODIFIED);
		Page<Occupation> occupation = occupationRepository.findAll(new OccupationSpec(dto.getname(), dto.getcode()), bb);
		
		List<OccupationDto> list = occupation.stream().map(new OccupationDtoConvertor()).collect(Collectors.toList());
		PageDto pageDto = new PageDto(list, occupation.getTotalElements());
		return Response.build(Code.OK, pageDto);

	}
}
