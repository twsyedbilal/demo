package com.techweaversys.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techweaversys.dto.SchoolTypeDto;
import com.techweaversys.generics.Code;
import com.techweaversys.generics.Messages;
import com.techweaversys.generics.Response;
import com.techweaversys.model.SchoolType;
import com.techweaversys.repository.SchoolTypeRepository;
import com.techweaversys.service.SchoolTypeService;

import ch.qos.logback.classic.Logger;

@Service
@Transactional
public class SchoolTypeServiceImpl implements SchoolTypeService {

	private Logger logger = (Logger) LoggerFactory.getLogger(getClass());

	@Autowired
	public SchoolTypeRepository str;

	@Override
	public ResponseEntity<?> saveRecord(SchoolTypeDto ss) {
		logger.info("Creating School" + ss);
		SchoolType sh = new SchoolType();
		if (ss.getId() != null) {
			sh = str.getOne(ss.getId());
		}
		sh.setSchoolTypeName(ss.getSchoolTypeName());
		sh.setCode(ss.getCode());
		str.save(sh);

		return Response.build(Code.CREATED, Messages.USER_CREATED_MSG);

	
		}

	@Override
	public ResponseEntity<?> getById(Long id) {
		Optional<SchoolType> bb = str.findById(id);
		return Response.build(Code.OK, bb);
	}
	
	@Override
	public ResponseEntity<?> DeletById(Long id) {
		SchoolType bb = new SchoolType();
		if (id != null) {
			bb = str.getOne(id);
			bb.setDeleted(true);
			str.save(bb);
		}

		return Response.build(Code.OK, Messages.DELETED);
	}

	@Override
	public ResponseEntity<?> findAllData() {
		List<SchoolType> list = str.findAll();
		return Response.build(Code.OK, list);
	}

	/*
	 * @Override public ResponseEntity<?> findAllwithpage(SchoolTypeSpaceDto dto) {
	 * logger.info("showing list of sch", dto); PageRequest bb =
	 * PageRequest.of(dto.getPage() - 1, dto.getSize(), Direction.DESC,
	 * AppConstants.MODIFIED); Page<SchoolType> school = str.findAll(new
	 * SchoolTypeSpec(dto.getSchool_type_name(), dto.getCode()), bb);
	 * List<SchooltypeDto> list = school.stream().map(new
	 * SchooltypeDtoConvertor()).collect(Collectors.toList()); PageDto pageDto = new
	 * PageDto(list, school.getTotalElements()); return Response.build(Code.OK,
	 * pageDto);
	 * 
	 * }
	 */

}
