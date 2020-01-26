package com.techweaversys.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.jaxb.SpringDataJaxb.PageRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techweaversys.conv.BranchDtoConvertor;
import com.techweaversys.conv.MothertongueDtoConvertor;
import com.techweaversys.dto.BranchDto;
import com.techweaversys.dto.MotherTongueDto;
import com.techweaversys.dto.MotherTongueSpaceDto;
import com.techweaversys.dto.PageDto;
import com.techweaversys.generics.AppConstants;
import com.techweaversys.generics.Code;
import com.techweaversys.generics.Messages;
import com.techweaversys.generics.Response;
import com.techweaversys.model.MotherTongueEntity;
import com.techweaversys.repository.MotherTongueRepository;
import com.techweaversys.service.MotherTongueService;
import com.techweaversys.spec.MotherTongueSpce;

import ch.qos.logback.classic.Logger;

@Service
@Transactional
public class MotherTongueServiceImpl implements MotherTongueService {

	@Autowired
	private MotherTongueRepository mtr;

	private Logger logger = (Logger) LoggerFactory.getLogger(getClass());

	@Override
	public ResponseEntity<?> saveData(MotherTongueDto dto) {

		logger.info("Creating MoonguetherT: " + dto);
		MotherTongueEntity bb = new MotherTongueEntity();
		if (dto.getId() != null) {
			bb = mtr.getOne(dto.getId());
		}

		bb.setName(dto.getName());
		bb.setCode(dto.getCode());
		mtr.save(bb);

		return Response.build(Code.CREATED, Messages.USER_CREATED_MSG);
	}

	@Override
	public ResponseEntity<?> findAllData() {
		List<MotherTongueEntity> list = mtr.findAll();
		return Response.build(Code.OK, list);
	}

	@Override
	public ResponseEntity<?> DeletById(Long id) {
		MotherTongueEntity bb = new MotherTongueEntity();
		if (id != null) {
			bb = mtr.getOne(id);
			bb.setDeleted(true);
			mtr.save(bb);
		}

		return Response.build(Code.OK, Messages.DELETED);
	}

	@Override
	public ResponseEntity<?> getById(Long id) {
		Optional<MotherTongueEntity> bb = mtr.findById(id);
		return Response.build(Code.OK, bb);
	}

	@Override
	public ResponseEntity<?> findAllwithpage(MotherTongueSpaceDto dto) {
		logger.info("Showing List Of MotherTongue"+dto);
		PageRequest pg =PageRequest.of(dto.getPage(), dto.getSize(), Direction.DESC, AppConstants.MODIFIED);
		Page<MotherTongueEntity> m=(Page<MotherTongueEntity>) mtr.findAll(new MotherTongueSpce(dto.getCode(),dto.getName()));
		List<MotherTongueDto> list = m.stream().map( new MothertongueDtoConvertor() ).collect( Collectors.toList() );
		PageDto pageDto = new PageDto(list, m.getTotalElements());
		return Response.build(Code.OK, pageDto);
	}

}
