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
import org.springframework.web.bind.annotation.PathVariable;

import com.techweaversys.conv.SchooDtoConvertor;
import com.techweaversys.dto.PageDto;
import com.techweaversys.dto.SchoolDto;
import com.techweaversys.dto.SchoolSpaceDto;
import com.techweaversys.generics.AppConstants;
import com.techweaversys.generics.Code;
import com.techweaversys.generics.Messages;
import com.techweaversys.generics.Response;
import com.techweaversys.model.BranchEntity;
import com.techweaversys.model.SchoolEntityy;
import com.techweaversys.model.SchoolType;
import com.techweaversys.repository.BranchRepository;
import com.techweaversys.repository.SchoolRepositriy;
import com.techweaversys.repository.SchoolTypeRepository;
import com.techweaversys.service.SchoolService;
import com.techweaversys.spec.SchoolSpace;

import ch.qos.logback.classic.Logger;

@Service
@Transactional
public class SchoolServiceImpl implements SchoolService {

	@Autowired
	private SchoolRepositriy schoolrepositriy;

	@Autowired
	private SchoolTypeRepository schoolTypeRepository;
	
	
	@Autowired
	private BranchRepository br;
	

	private Logger logger = (Logger) LoggerFactory.getLogger(getClass());

	@Override
	public ResponseEntity<?> saveRecord(SchoolDto school) {
		logger.info("Creating School" + school);
		SchoolEntityy sh = new SchoolEntityy();
		if (school.getId() != null) {
			sh = schoolrepositriy.getOne(school.getId());
		}
		if (school.getSchoolTypeId() != null) {
			SchoolType st = schoolTypeRepository.getOne(school.getSchoolTypeId());
				sh.setSchoolType(st);
			}
		
		if (school.getBranch() != null) {
			if (school.getBranch().getId() != null) {
				BranchEntity b = br.getOne(school.getBranch().getId());
				sh.setBranch(b);
			}
		}
		
		sh.setSchoolName(school.getSchoolName());
		sh.setSchoolCode(school.getSchoolCode());
		sh.setSchoolAddress(school.getSchoolAddress());
		schoolrepositriy.save(sh);

		return Response.build(Code.CREATED, Messages.USER_CREATED_MSG);

	}
	
	@Override
	public ResponseEntity<?> getById(@PathVariable Long id) {

		Optional<SchoolEntityy> bb = schoolrepositriy.findById(id);
		return Response.build(Code.OK, bb);
	}

	@Override
	public ResponseEntity<?> DeletById(Long id) {
		SchoolEntityy bb = new SchoolEntityy();
		if (id != null) {
			bb = schoolrepositriy.getOne(id);
			bb.setDeleted(true);
			schoolrepositriy.save(bb);
		}

		return Response.build(Code.OK, Messages.DELETED);
	}

	@Override
	public ResponseEntity<?> findAllData() {
		List<SchoolEntityy> list = schoolrepositriy.findAll();
		return Response.build(Code.OK, list);
	}

	@Override
	public ResponseEntity<?> findAllwithpage(SchoolSpaceDto dto) {
		logger.info("showing list of sch", dto);
		PageRequest bb = PageRequest.of(dto.getPage() - 1, dto.getSize(), Direction.DESC, AppConstants.MODIFIED);
		Page<SchoolEntityy> school = schoolrepositriy
				.findAll(new SchoolSpace(dto.getSchoolName(), dto.getSchoolCode(), dto.getSchoolAddress()), bb);
		List<SchoolDto> list = school.stream().map(new SchooDtoConvertor()).collect(Collectors.toList());
		PageDto pageDto = new PageDto(list, school.getTotalElements());
		return Response.build(Code.OK, pageDto);
	}
}