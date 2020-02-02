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

import com.techweaversys.conv.CasteDtoConvertor;
import com.techweaversys.dto.CasteDto;
import com.techweaversys.dto.CasteSpecDto;
import com.techweaversys.dto.PageDto;
import com.techweaversys.generics.AppConstants;
import com.techweaversys.generics.Code;
import com.techweaversys.generics.Messages;
import com.techweaversys.generics.Response;
import com.techweaversys.model.Caste;
import com.techweaversys.model.SubCaste;
import com.techweaversys.repository.CasteRepository;
import com.techweaversys.repository.SubCasteRepository;
import com.techweaversys.service.CasteService;
import com.techweaversys.spec.CasteSpec;

import ch.qos.logback.classic.Logger;

@Service
@Transactional
public class CasteServiceImpl implements CasteService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private CasteRepository casteRepository;

	@Autowired
	private SubCasteRepository subCasteRepository;
	private Logger logger = (Logger) LoggerFactory.getLogger(getClass());

	@Override
	public ResponseEntity<?> saveCaste(CasteDto casteDto) {
		logger.info("Creating Caste " + casteDto);
		Caste caste = new Caste();
		if (casteDto.getId() != null) {
			caste = casteRepository.getOne(casteDto.getId());
		}
		if (casteDto.getSubCasteDto() != null) {
			if (casteDto.getSubCasteDto().getId() != null) {
				SubCaste sc = subCasteRepository.getOne(casteDto.getSubCasteDto().getId());
				caste.setSubCaste(sc);
			}
		}

		caste.setname(casteDto.getname());
		caste.setcode(casteDto.getcode());
		casteRepository.save(caste);

		return Response.build(Code.CREATED, Messages.USER_CREATED_MSG);
	}

	@Override
	public ResponseEntity<?> getByIdCaste(Long id) {
		Caste s = casteRepository.getOne(id);
		CasteDto dto = modelMapper.map(s, CasteDto.class);
		return Response.build(Code.OK, dto);

	}

	@Override
	public ResponseEntity<?> findAllCaste() {
		List<Caste> list = casteRepository.findAll();
		return Response.build(Code.OK, list);
	}

	@Override
	public ResponseEntity<?> deleteCasteById(Long id) {
		Caste caste = new Caste();
		if (id != null) {
			caste = casteRepository.getOne(id);
			caste.setDeleted(true);
			casteRepository.save(caste);
		}
		return Response.build(Code.OK, Messages.DELETED);
	}


	@Override
	public ResponseEntity<?> findAllwithpage(CasteSpecDto dto) {
		PageRequest bb = PageRequest.of(dto.getPage() - 1, dto.getSize(), Direction.DESC, 
				AppConstants.MODIFIED);
		Page<Caste> caste = casteRepository.findAll(new CasteSpec(dto.getname(), dto.getcode()), bb);
		
		List<CasteDto> list = caste.stream().map(new CasteDtoConvertor()).collect(Collectors.toList());
		PageDto pageDto = new PageDto(list, caste.getTotalElements());
		return Response.build(Code.OK, pageDto);
	}
}
