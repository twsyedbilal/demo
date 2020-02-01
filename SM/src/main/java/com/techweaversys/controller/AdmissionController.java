package com.techweaversys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techweaversys.dto.AdmissionDto;
import com.techweaversys.dto.AdmissionSpecDto;
import com.techweaversys.exception.AdmissionAlreadyExiststException;
import com.techweaversys.service.AdmissionService;

@RestController
@RequestMapping("/rest/api/admission/")
public class AdmissionController {

	@Autowired
	private AdmissionService admissionService;

	@PostMapping(value = "saveadmission")
	public ResponseEntity<?> saveadmission(@RequestBody AdmissionDto adDto) throws AdmissionAlreadyExiststException {
		return admissionService.saveadmission(adDto);
	}

	@PostMapping(value = "findalladminpaging")
	public ResponseEntity<?> findalladmissionWithPage(@RequestBody AdmissionSpecDto dto) {
		return admissionService.findalladmissionWithPage(dto);
	}

	@GetMapping(value = "getbyidadmi/{id}")
	public ResponseEntity<?> getByIdAdmi(@PathVariable Long id) {
		return admissionService.getByIdAdmi(id);
	}

	@GetMapping(value = "findalladmission")
	public ResponseEntity<?> findAllAdmission() {
		return admissionService.findAllAdmission();
	}

	@GetMapping(value = "deleteid/{id}")
	public ResponseEntity<?> deletId(@PathVariable Long id) {
		return admissionService.deletId(id);
	}

}
