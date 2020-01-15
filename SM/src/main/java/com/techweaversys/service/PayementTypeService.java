package com.techweaversys.service;

import org.springframework.http.ResponseEntity;

import com.techweaversys.dto.PaymentTypeDto;

public interface PayementTypeService {

	ResponseEntity<?> savePayementType(PaymentTypeDto paymentTypeDto);

	ResponseEntity<?> getByIdPayementType(Long id);

	ResponseEntity<?> findAllPayementType();

	ResponseEntity<?> deletePayementTypeById(Long id);

	
	
}
