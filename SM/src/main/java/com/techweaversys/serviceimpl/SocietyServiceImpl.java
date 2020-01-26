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

import com.techweaversys.conv.SchooDtoConvertor;
import com.techweaversys.conv.SocietyConvertor;
import com.techweaversys.dto.PageDto;
import com.techweaversys.dto.SchoolDto;
import com.techweaversys.dto.SocietyDto;
import com.techweaversys.dto.SocietySpaceDto;
import com.techweaversys.generics.AppConstants;
import com.techweaversys.generics.Code;
import com.techweaversys.generics.Messages;
import com.techweaversys.generics.Response;
import com.techweaversys.model.SchoolEntityy;
import com.techweaversys.model.SocietyEntity;
import com.techweaversys.repository.SocietyRepository;
import com.techweaversys.service.SocietyService;
import com.techweaversys.spec.SchoolSpace;
import com.techweaversys.spec.SocietySpec;

import ch.qos.logback.classic.Logger;

@Service
@Transactional
public class SocietyServiceImpl implements SocietyService {

	@Autowired
	private SocietyRepository societyRepository;

	private Logger logger = (Logger) LoggerFactory.getLogger(getClass());

	@Override
	public ResponseEntity<?> saveData(SocietyDto dto) {
		logger.info("Creating School" + dto);
		SocietyEntity sh = new SocietyEntity();
		if (dto.getId() != null) {
			sh = societyRepository.getOne(dto.getId());
		}
		sh.setSocietyName(dto.getSocietyName());
		sh.setCode(dto.getCode());
		societyRepository.save(sh);

		return Response.build(Code.CREATED, Messages.USER_CREATED_MSG);
	}

	@Override
	public ResponseEntity<?> findAllData() {
		List<SocietyEntity> list = societyRepository.findAll();
		return Response.build(Code.OK, list);
	}

	@Override
	public ResponseEntity<?> DeletById(Long id) {
		SocietyEntity bb = new SocietyEntity();
		if (id != null) {
			bb = societyRepository.getOne(id);
			bb.setDeleted(true);
			societyRepository.save(bb);
		}
		return Response.build(Code.OK, Messages.DELETED);
	}

	@Override
	public ResponseEntity<?> getById(Long id) {
		Optional<SocietyEntity> bb = societyRepository.findById(id);
		return Response.build(Code.OK, bb);
	}

	@Override
	public ResponseEntity<?> findAllwithpage(SocietySpaceDto dto) {
		logger.info("showing list of sch", dto);
		PageRequest bb = PageRequest.of(dto.getPage() - 1, dto.getSize(), Direction.DESC, AppConstants.MODIFIED);
		Page<SocietyEntity> school = societyRepository.findAll(new SocietySpec(dto.getSocietyName(), dto.getCode()),
				bb);
		List<SocietyDto> list = school.stream().map(new SocietyConvertor()).collect(Collectors.toList());
		PageDto pageDto = new PageDto(list, school.getTotalElements());
		return Response.build(Code.OK, pageDto);
	}

}
