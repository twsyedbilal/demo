package com.techweaversys.service;

import org.springframework.http.ResponseEntity;

import com.techweaversys.dto.MotherTongueDto;

public interface MotherTongueService {
	
	ResponseEntity<?> saveData(MotherTongueDto dto);

    ResponseEntity<?> getById(Long id);

    ResponseEntity<?> DeletById(Long id);

    ResponseEntity<?> findAllData();

}
