package com.techweaversys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techweaversys.dto.PaymentTypeDto;
import com.techweaversys.service.PayementTypeService;

@RestController
@RequestMapping("/rest/api/paymenttype/")
public class PayementTypeController {

	@Autowired
	private PayementTypeService payementTypeService;

	@PostMapping(value = "savepaymenttype")
	public ResponseEntity<?> saveaPayementType(@RequestBody PaymentTypeDto paymentTypeDto){
		
		return payementTypeService.savePayementType(paymentTypeDto);
	}

	@GetMapping(value = "getbyidpayment/{id}")
	public ResponseEntity<?> getByIdPayementType(@PathVariable Long id) {
		return payementTypeService.getByIdPayementType(id);

	}
	
	@GetMapping(value = "findallpayment")
	public ResponseEntity<?> findAllPayementType() {
		return payementTypeService.findAllPayementType();

	}
	
	@GetMapping(value = "deleteid/{id}")
	public ResponseEntity<?> deletePayementTypeById(@PathVariable Long id) {
		return payementTypeService.deletePayementTypeById(id);

	}
	
}

