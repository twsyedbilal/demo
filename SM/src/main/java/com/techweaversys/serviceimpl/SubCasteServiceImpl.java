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

import com.techweaversys.conv.SubCasteDtoConvertor;
import com.techweaversys.dto.PageDto;
import com.techweaversys.dto.SubCasteDto;
import com.techweaversys.dto.SubCasteSpecDto;
import com.techweaversys.generics.AppConstants;
import com.techweaversys.generics.Code;
import com.techweaversys.generics.Messages;
import com.techweaversys.generics.Response;
import com.techweaversys.model.SubCaste;
import com.techweaversys.repository.SubCasteRepository;
import com.techweaversys.service.SubCasteService;
import com.techweaversys.spec.SubCasteSpec;

import ch.qos.logback.classic.Logger;

@Service
@Transactional
public class SubCasteServiceImpl implements SubCasteService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private SubCasteRepository subCasteRepository;
	
	private Logger logger = (Logger) LoggerFactory.getLogger(getClass());	
	
	@Override
	public ResponseEntity<?> saveSubCaste(SubCasteDto subCasteDto) {
		logger.info("Creating SubCaste  " + subCasteDto);
		SubCaste subCaste = new SubCaste();
		if (subCasteDto.getId() != null) {
			subCaste = subCasteRepository.getOne(subCasteDto.getId());
		}
		
		subCaste.setSubCasteName(subCasteDto.getname());
		subCaste.setSubCastecode(subCasteDto.getcode());
		subCasteRepository.save(subCaste);
		
		return Response.build(Code.CREATED, Messages.USER_CREATED_MSG);	
	}

	@Override
	public ResponseEntity<?> getByIdSubCaste(Long id) {
		SubCaste s = subCasteRepository.getOne(id);
		SubCasteDto dto = modelMapper.map(s, SubCasteDto.class);
		return Response.build(Code.OK, dto);
	}
	

	@Override
	public ResponseEntity<?> findAllSubCaste() {
		List<SubCaste> list = subCasteRepository.findAll();
		return Response.build(Code.OK, list);
	}

	@Override
	public ResponseEntity<?> deleteSubCasteById(Long id) {
		SubCaste subCaste = new SubCaste();
		if (id != null) {
			subCaste = subCasteRepository.getOne(id);
			subCaste.setDeleted(true);
			subCasteRepository.save(subCaste);
		}
		return Response.build(Code.OK, Messages.DELETED);
	}

	@Override
	public ResponseEntity<?> findAllwithpage(SubCasteSpecDto dto) {
		PageRequest bb = PageRequest.of(dto.getPage() - 1, dto.getSize(), Direction.DESC, 
				AppConstants.MODIFIED);
		Page<SubCaste> subCaste = subCasteRepository.findAll(new SubCasteSpec(dto.getname(), dto.getcode()), bb);
		
		List<SubCasteDto> list = subCaste.stream().map(new SubCasteDtoConvertor()).collect(Collectors.toList());
		PageDto pageDto = new PageDto(list, subCaste.getTotalElements());
		return Response.build(Code.OK, pageDto);
	}	


}
