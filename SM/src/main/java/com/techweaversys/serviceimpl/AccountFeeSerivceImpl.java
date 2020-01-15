package com.techweaversys.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techweaversys.conv.AccountFeeConvertor;
import com.techweaversys.dto.AcountFeeDto;
import com.techweaversys.dto.AcountFeeSpaceDto;
import com.techweaversys.dto.PageDto;
import com.techweaversys.generics.AppConstants;
import com.techweaversys.generics.Code;
import com.techweaversys.generics.Messages;
import com.techweaversys.generics.Response;
import com.techweaversys.model.AcountFee;
import com.techweaversys.model.Admission;
import com.techweaversys.model.ClassEntity;
import com.techweaversys.model.PaymentType;
import com.techweaversys.repository.AccountFeeRepository;
import com.techweaversys.repository.AdmissionRepository;
import com.techweaversys.repository.ClassRepository;
import com.techweaversys.repository.PaymentTypeRepository;
import com.techweaversys.service.AcountFeeService;
import com.techweaversys.spec.AccountSpace;

@Service
@Transactional
public class AccountFeeSerivceImpl implements AcountFeeService {
	
	@Autowired
	private ModelMapper modelMapper;
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private AccountFeeRepository accountFeeRepository;

	@Autowired
	private ClassRepository cr;

	@Autowired
	private PaymentTypeRepository ptr;

	@Autowired
	private AdmissionRepository ar;

	@Override
	public ResponseEntity<?> saveData(AcountFeeDto dto) {
		logger.info("Creating fee: " + dto);
		AcountFee bb = new AcountFee();
		if (dto.getId() != null) {
			bb = accountFeeRepository.getOne(dto.getId());
		}
		// save data with class
		if (dto.getClasss() != null) {
			if (dto.getClasss().getId() != null) {
				ClassEntity b = cr.getOne(dto.getClasss().getId());
				bb.setClasss(b);
			}
		}

		// save data with admission
		if (dto.getAdmission() != null) {
			if (dto.getAdmission().getId() != null) {
				Admission b = ar.getOne(dto.getAdmission().getId());
				bb.setAdmission(b);
			}
		}

		// save data with payment .
		if (dto.getPaymentType() != null) {
			if (dto.getPaymentType().getId() != null) {
				PaymentType b = ptr.getOne(dto.getPaymentType().getId());
				bb.setPaymentType(b);
			}
		}

		bb.setPaid(dto.getPaid());
		bb.setActualPaid(dto.getActualPaid());
		bb.setBalance(dto.getBalance());
		bb.setFee(dto.getFee());
		accountFeeRepository.save(bb);

		return Response.build(Code.CREATED, Messages.USER_CREATED_MSG);

	}

	@Override
	public ResponseEntity<?> findAllData() {
		List<AcountFee> list = accountFeeRepository.findAll();
		return Response.build(Code.OK, list);
	}

	@Override
	public ResponseEntity<?> DeletById(Long id) {
		AcountFee bb = new AcountFee();
		if (id != null) {
			bb = accountFeeRepository.getOne(id);
			bb.setDeleted(true);
			accountFeeRepository.save(bb);
		}
		return Response.build(Code.OK, Messages.DELETED);
	}

	@Override
	public ResponseEntity<?> getDataById(Long id) {
		AcountFee a= accountFeeRepository.getOne(id);
		AcountFeeDto aa=modelMapper.map(a, AcountFeeDto.class);
		return Response.build(Code.OK, aa);
	}

	@Override
	public ResponseEntity<?> findAllwithpage(AcountFeeSpaceDto dto) {
		logger.info("showing list of account", dto);
		PageRequest pg = PageRequest.of(dto.getPage() - 1, dto.getSize(), Direction.DESC, AppConstants.MODIFIED);
		Page<AcountFee> acc = accountFeeRepository
				.findAll(new AccountSpace(dto.getClasss(), dto.getStudentName(), dto.getUidNo(),
						dto.getIdNo(), dto.getRegisterNo(), dto.getPaymentType()), pg);
		List<AcountFeeDto> list = acc.stream().map(new AccountFeeConvertor()).collect(Collectors.toList());
		PageDto pageDto = new PageDto(list, acc.getTotalElements());
		return Response.build(Code.OK, pageDto);

	}

}
