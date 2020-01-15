package com.techweaversys.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techweaversys.conv.CompliantTypeConvertor;
import com.techweaversys.dto.CompliantTypeDto;
import com.techweaversys.dto.CompliantTypeSpaceDto;
import com.techweaversys.dto.PageDto;
import com.techweaversys.generics.AppConstants;
import com.techweaversys.generics.Code;
import com.techweaversys.generics.Messages;
import com.techweaversys.generics.Response;
import com.techweaversys.model.Admission;
import com.techweaversys.model.Compliant;
import com.techweaversys.model.CompliantType;
import com.techweaversys.repository.AdmissionRepository;
import com.techweaversys.repository.CompliantRepositry;
import com.techweaversys.repository.CompliantTypeRepository;
import com.techweaversys.service.CompliantTypeService;
import com.techweaversys.spec.CompliantTypeSpace;

@Service
@Transactional
public class CompliantTypeImpl implements CompliantTypeService {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private CompliantTypeRepository compliantTypeRepository;

	@Autowired
	private AdmissionRepository admissionRepository;

	@Autowired
	private CompliantRepositry compliantRepositry;

	@Override
	public ResponseEntity<?> createData(CompliantTypeDto compliantDto) {
		logger.info("Creating List Of Compliant..." + compliantDto);
		CompliantType ct = new CompliantType();
		if (compliantDto.getId() != null) {
			ct = compliantTypeRepository.getOne(compliantDto.getId());

		}

		// save data with admission
		if (compliantDto.getAdmission() != null) {
			if (compliantDto.getAdmission().getId() != null) {
				Admission sc = admissionRepository.getOne(compliantDto.getAdmission().getId());
				ct.setAdmission(sc);
			}
		}

		// save data with compliant
		if (compliantDto.getCompliantdto() != null) {
			if (compliantDto.getCompliantdto().getId() != null) {
				Compliant sc = compliantRepositry.getOne(compliantDto.getCompliantdto().getId());
				ct.setCompliant(sc);
			}
		}
		ct.setRemark(compliantDto.getRemark());
		compliantTypeRepository.save(ct);

		return Response.build(Code.CREATED, Messages.USER_CREATED_MSG);
	}

	@Override
	public ResponseEntity<?> findAllData() {
		List<CompliantType> bb = compliantTypeRepository.findAll();
		return Response.build(Code.OK, bb);
	}

	@Override
	public ResponseEntity<?> getDataById(Long id) {
		CompliantType ct = compliantTypeRepository.getOne(id);
		return Response.build(Code.OK, ct);
	}

	@Override
	public ResponseEntity<?> DeletById(Long id) {
		CompliantType ct = new CompliantType();
		if (id != null) {
			ct = compliantTypeRepository.getOne(id);
			ct = compliantTypeRepository.save(ct);
		}
		return Response.build(Code.OK, Messages.DELETED);
	}

	@Override
	public ResponseEntity<?> findAllwithpage(CompliantTypeSpaceDto dto) {

		logger.info("Showing list of Compliant " + dto);
		PageRequest bb = PageRequest.of(dto.getPage() - 1, dto.getSize(), Direction.DESC, AppConstants.MODIFIED);

		Page<CompliantType> c = compliantTypeRepository.findAll(new CompliantTypeSpace(dto.getRemark()), bb);

		List<CompliantTypeDto> list = c.stream().map(new CompliantTypeConvertor()).collect(Collectors.toList());
		PageDto pageDto = new PageDto(list, c.getTotalElements());
		return Response.build(Code.OK, pageDto);

	}

}
