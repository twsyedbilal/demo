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

import com.techweaversys.conv.CompliantTypeConvertor;
import com.techweaversys.dto.CompliantTypeDtobject;
import com.techweaversys.dto.CompliantTypespceDto;
import com.techweaversys.dto.PageDto;
import com.techweaversys.generics.AppConstants;
import com.techweaversys.generics.Code;
import com.techweaversys.generics.Messages;
import com.techweaversys.generics.Response;
import com.techweaversys.model.CompliantTypes;
import com.techweaversys.repository.CompliantTypesRepositry;
import com.techweaversys.service.CompliantTypeServicee;
import com.techweaversys.spec.CompliantTypeSpce;

@Service
@Transactional
public class CompliantTypeServiceImple implements CompliantTypeServicee {

	private Logger logger = (Logger) LoggerFactory.getLogger(getClass());
	@Autowired
	private CompliantTypesRepositry compliantTypeRepositry;

	@Override
	public ResponseEntity<?> createData(CompliantTypeDtobject compliantDto) {
		logger.info("Creating List Of Compliant..." + compliantDto);
		CompliantTypes ct = new CompliantTypes();
		if (compliantDto.getId() != null) {
			ct = compliantTypeRepositry.getOne(compliantDto.getId());

		}

		ct.setName(compliantDto.getName());
		ct.setCode(compliantDto.getCode());
		compliantTypeRepositry.save(ct);

		return Response.build(Code.CREATED, Messages.USER_CREATED_MSG);
	}

	@Override
	public ResponseEntity<?> findAllData() {
		List<CompliantTypes> bb = compliantTypeRepositry.findAll();
		return Response.build(Code.OK, bb);
	}

	@Override
	public ResponseEntity<?> getDataById(Long id) {
		CompliantTypes ct = compliantTypeRepositry.getOne(id);
		return Response.build(Code.OK, ct);
	}

	@Override
	public ResponseEntity<?> DeletById(Long id) {
		CompliantTypes ct = new CompliantTypes();
		if (id != null) {
			ct = compliantTypeRepositry.getOne(id);
			ct = compliantTypeRepositry.save(ct);
		}
		return Response.build(Code.OK, Messages.DELETED);
	}

	@Override
	public ResponseEntity<?> findAllwithpage(CompliantTypespceDto dto) {

		logger.info("Showing list of Compliant " + dto);
		PageRequest bb = PageRequest.of(dto.getPage() - 1, dto.getSize(), Direction.DESC, AppConstants.MODIFIED);
		Page<CompliantTypes> c = compliantTypeRepositry.findAll(new CompliantTypeSpce(dto.getCode(), dto.getName()), bb);
		List<CompliantTypeDtobject> list = c.stream().map(new CompliantTypeConvertor()).collect(Collectors.toList());
		PageDto pageDto = new PageDto(list, c.getTotalElements());
		return Response.build(Code.OK, pageDto);

	}

}
