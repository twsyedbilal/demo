package com.techweaversys.service;

import org.springframework.http.ResponseEntity;

import com.techweaversys.dto.AdmissionDto;
import com.techweaversys.dto.AdmissionSpecDto;
import com.techweaversys.exception.AdmissionAlreadyExiststException;

public interface AdmissionService {

	ResponseEntity<?> saveadmission(AdmissionDto adDto) throws AdmissionAlreadyExiststException;

	ResponseEntity<?> getByIdAdmi(Long id);

	ResponseEntity<?> findAllAdmission();

	ResponseEntity<?> deletId(Long id);

	ResponseEntity<?> findalladmissionWithPage(AdmissionSpecDto dto);

	ResponseEntity<?> getByView(Long id);

	ResponseEntity<?> getByclassId(Long id);

	
}
