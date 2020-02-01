package com.techweaversys.service;

import org.springframework.http.ResponseEntity;

import com.techweaversys.model.StudentStatus;

public interface StudentStatusService {

	ResponseEntity<?> create(StudentStatus studentStatus);

	ResponseEntity<?> getById(Long id);

	ResponseEntity<?> DeletById(Long id);

	ResponseEntity<?> findAllData();

}
