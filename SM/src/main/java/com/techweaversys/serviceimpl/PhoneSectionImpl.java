package com.techweaversys.serviceimpl;

import java.util.List;
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

import com.techweaversys.conv.PhonesectionConvertor;
import com.techweaversys.dto.PageDto;
import com.techweaversys.dto.PhoneSectionDto;
import com.techweaversys.dto.PhoneSectionSpaceDto;
import com.techweaversys.generics.AppConstants;
import com.techweaversys.generics.Code;
import com.techweaversys.generics.Messages;
import com.techweaversys.generics.Response;
import com.techweaversys.model.Admission;
import com.techweaversys.model.PhoneSection;
import com.techweaversys.repository.AdmissionRepository;
import com.techweaversys.repository.PhoneSectionRepositrory;
import com.techweaversys.service.PhoneSectionService;
import com.techweaversys.spec.PhoneSectionSpec;

import ch.qos.logback.classic.Logger;

@Service
@Transactional
public class PhoneSectionImpl implements PhoneSectionService {

	@Autowired
	private PhoneSectionRepositrory psr;

	@Autowired
	private AdmissionRepository ar;

	@Autowired
	private ModelMapper modelMapper;

	private Logger logger = (Logger) LoggerFactory.getLogger(getClass());

	@Override
	public ResponseEntity<?> saveData(PhoneSectionDto pdto) {
		logger.info("creating phonesection" + pdto);
		PhoneSection ps = new PhoneSection();
		if (pdto.getId() != null) {
			ps = psr.getOne(pdto.getId());
		}

		if (pdto.getAdmission() != null) {
			if (pdto.getAdmission().getId() != null) {

				Admission ad = ar.getOne(pdto.getAdmission().getId());
				ps.setAdmission(ad);

			}
		}

		ps.setRemainingBalance(pdto.getRemainingBalance());
		ps.setRemark(pdto.getRemark());
		psr.save(ps);

		return Response.build(Code.CREATED, Messages.USER_CREATED_MSG);
	}

	@Override
	public ResponseEntity<?> findAllData() {
		List<PhoneSection> list = psr.findAll();
		return Response.build(Code.OK, list);
	}

	@Override
	public ResponseEntity<?> getDataById(Long id) {
		PhoneSection p = psr.getOne(id);
		PhoneSectionDto pp = modelMapper.map(p, PhoneSectionDto.class);
		return Response.build(Code.OK, pp);
	}

	@Override
	public ResponseEntity<?> DeletById(Long id) {
		PhoneSection bb = new PhoneSection();
		if (id != null) {
			bb = psr.getOne(id);
			bb.setDeleted(true);
			psr.save(bb);
		}

		return Response.build(Code.OK, Messages.DELETED);
	}

	@Override
	public ResponseEntity<?> findAllwithpage(PhoneSectionSpaceDto phoneSectionSpaceDto) {
		logger.info("showing list of phonesection " + phoneSectionSpaceDto);
		PageRequest bb = PageRequest.of(phoneSectionSpaceDto.getPage() - 1, phoneSectionSpaceDto.getSize(),
				Direction.DESC, AppConstants.MODIFIED);
		Page<PhoneSection> classs = psr.findAll(
				new PhoneSectionSpec(phoneSectionSpaceDto.getRemark(), phoneSectionSpaceDto.getRemainingBalance()),
				bb);
		List<PhoneSectionDto> list = classs.stream().map(new PhonesectionConvertor()).collect(Collectors.toList());
		PageDto pageDto = new PageDto(list, classs.getTotalElements());
		return Response.build(Code.OK, pageDto);

	}

}
