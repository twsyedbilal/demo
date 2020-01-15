package com.techweaversys.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.techweaversys.conv.ClassDtoConvertor;
import com.techweaversys.dto.ClassDto;
import com.techweaversys.dto.ClassSpaceDto;
import com.techweaversys.dto.PageDto;
import com.techweaversys.generics.AppConstants;
import com.techweaversys.generics.Code;
import com.techweaversys.generics.Messages;
import com.techweaversys.generics.Response;
import com.techweaversys.model.ClassEntity;
import com.techweaversys.repository.ClassRepository;
import com.techweaversys.service.ClassService;
import com.techweaversys.spec.ClassSpace;

import ch.qos.logback.classic.Logger;

@Service
@Transactional
public class ClassServiceImpl  implements ClassService {
	
      @Autowired
	private ClassRepository classRepository;

  	@Autowired
  	ModelMapper modelMapper;
	
	private Logger logger = (Logger) LoggerFactory.getLogger(getClass());

	@Override
	public ResponseEntity<?> save(ClassDto classdto) {
		logger.info("Creating School" + classdto);
		ClassEntity sh = new ClassEntity();
		if (classdto.getId() != null) {
			sh = classRepository.getOne(classdto.getId());
		
		}
		sh.setClassName(classdto.getClassName());
		sh.setCode(classdto.getCode());
		sh.setFees(classdto.getFees());
		classRepository.save(sh);

		return Response.build(Code.CREATED, Messages.USER_CREATED_MSG);

	}

	@Override
	public ResponseEntity<?> getDataById(Long id) {
		Optional<ClassEntity> bb = classRepository.findById(id);
		return Response.build(Code.OK, bb);
	}

	@Override
	public ResponseEntity<?> DeletById(Long id) {
		ClassEntity bb = new ClassEntity();
		if (id != null) {
			bb = classRepository.getOne(id);
			bb.setDeleted(true);
			classRepository.save(bb);
		}

		return Response.build(Code.OK, Messages.DELETED);
	
	}

	@Override
	public ResponseEntity<?> findAllwithpage(ClassSpaceDto dto) {
		logger.info("showing list of classs", dto);
		PageRequest bb = PageRequest.of(dto.getPage() - 1, dto.getSize(), Direction.DESC, AppConstants.MODIFIED);
		Page<ClassEntity> classs = classRepository.findAll(new ClassSpace(dto.getClassName(), dto.getCode(), dto.getFees()), bb);
		List<ClassDto> list = classs.stream().map(new ClassDtoConvertor()).collect(Collectors.toList());
		PageDto pageDto = new PageDto(list, classs.getTotalElements());
		return Response.build(Code.OK, pageDto);
	}

	@Override
	public ResponseEntity<?> findAllData() {
		List<ClassEntity> list = classRepository.findAll();
		return Response.build(Code.OK, list);
	}
		
}
