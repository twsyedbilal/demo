package com.techweaversys.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techweaversys.dto.PaymentTypeDto;
import com.techweaversys.generics.Code;
import com.techweaversys.generics.Messages;
import com.techweaversys.generics.Response;
import com.techweaversys.model.PaymentType;
import com.techweaversys.repository.PaymentTypeRepository;
import com.techweaversys.service.PayementTypeService;

import ch.qos.logback.classic.Logger;

@Service
@Transactional
public class PayementTypeServiceImpl implements PayementTypeService {

	@Autowired
	private PaymentTypeRepository paymentTypeRepository;
	
	private Logger logger = (Logger) LoggerFactory.getLogger(getClass());

	@Override
	public ResponseEntity<?> savePayementType(PaymentTypeDto paymentTypeDto) {
		logger.info("Creating Caste "+ paymentTypeDto);
		PaymentType paymentType = new PaymentType();
		if (paymentTypeDto.getId() != null) {
			paymentType = paymentTypeRepository.getOne(paymentTypeDto.getId());
		}
		
		paymentType.setPaymentTypeName(paymentTypeDto.getPayementTypeName());
		paymentType.setPaymentTypeCode(paymentTypeDto.getPayementTypeCode());
		paymentTypeRepository.save(paymentType);
		
		return Response.build(Code.CREATED, Messages.USER_CREATED_MSG);	
	}

	@Override
	public ResponseEntity<?> getByIdPayementType(Long id) {
		Optional<PaymentType> paymentType = paymentTypeRepository.findById(id);
		return Response.build(Code.OK, paymentType);
	}

	@Override
	public ResponseEntity<?> findAllPayementType() {
		List<PaymentType> list = paymentTypeRepository.findAll();
		return Response.build(Code.OK, list);
	}

	@Override
	public ResponseEntity<?> deletePayementTypeById(Long id) {
		PaymentType paymentType = new PaymentType();
		if (id != null) {
			paymentType = paymentTypeRepository.getOne(id);
			paymentType.setDeleted(true);
			paymentTypeRepository.save(paymentType);
		}
		return Response.build(Code.OK, Messages.DELETED);
	}	

}
