package com.techweaversys.service;

import org.springframework.http.ResponseEntity;

import com.techweaversys.dto.StudentMarkDto;

public interface StudentMarksService {

	ResponseEntity<?> create(StudentMarkDto studentStatus);

	ResponseEntity<?> getById(Long id);

	ResponseEntity<?> DeletById(Long id);

	ResponseEntity<?> findAllData();
	
	ResponseEntity<?> getByclassId(Long id);







}
