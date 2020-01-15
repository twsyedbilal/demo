package com.techweaversys.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.techweaversys.conv.CompliantConvertor;
import com.techweaversys.dto.CompliantDto;
import com.techweaversys.dto.CompliantspaceDto;
import com.techweaversys.dto.PageDto;
import com.techweaversys.generics.AppConstants;
import com.techweaversys.generics.Code;
import com.techweaversys.generics.Messages;
import com.techweaversys.generics.Response;
import com.techweaversys.model.Compliant;
import com.techweaversys.repository.CompliantRepositry;
import com.techweaversys.service.CompliantService;
import com.techweaversys.spec.CompliantSpace;

@Service
@Transactional
public class CompliantServiceImpl implements CompliantService {

	private Logger logger = (Logger) LoggerFactory.getLogger(getClass());
	@Autowired
	private CompliantRepositry compliantRepositry;

	@Override
	public ResponseEntity<?> createData(CompliantDto compliantDto) {
		logger.info("Creating List Of Compliant..." + compliantDto);
		Compliant ct = new Compliant();
		if (compliantDto.getId() != null) {
			ct = compliantRepositry.getOne(compliantDto.getId());

		}

		ct.setName(compliantDto.getName());
		ct.setCode(compliantDto.getCode());
		compliantRepositry.save(ct);

		return Response.build(Code.CREATED, Messages.USER_CREATED_MSG);
	}

	@Override
	public ResponseEntity<?> findAllData() {
		List<Compliant> bb = compliantRepositry.findAll();
		return Response.build(Code.OK, bb);
	}

	@Override
	public ResponseEntity<?> getDataById(Long id) {
		Compliant ct = compliantRepositry.getOne(id);
		return Response.build(Code.OK, ct);
	}

	@Override
	public ResponseEntity<?> DeletById(Long id) {
		Compliant ct = new Compliant();
		if (id != null) {
			ct = compliantRepositry.getOne(id);
			ct = compliantRepositry.save(ct);
		}
		return Response.build(Code.OK, Messages.DELETED);
	}

	@Override
	public ResponseEntity<?> findAllwithpage(CompliantspaceDto dto) {

		logger.info("Showing list of Compliant " + dto);
		PageRequest bb = PageRequest.of(dto.getPage() - 1, dto.getSize(), Direction.DESC, AppConstants.MODIFIED);
		Page<Compliant> c = compliantRepositry.findAll(new CompliantSpace(dto.getCode(), dto.getName()), bb);
		List<CompliantDto> list = c.stream().map(new CompliantConvertor()).collect(Collectors.toList());
		PageDto pageDto = new PageDto(list, c.getTotalElements());
		return Response.build(Code.OK, pageDto);

	}

}
