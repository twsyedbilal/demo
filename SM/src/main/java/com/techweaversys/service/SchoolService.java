package com.techweaversys.service;

import org.springframework.http.ResponseEntity;

import com.techweaversys.dto.SchoolDto;
import com.techweaversys.dto.SchoolSpaceDto;

public interface SchoolService {

	ResponseEntity<?> saveRecord(SchoolDto school);

	ResponseEntity<?> getById(Long id);

	ResponseEntity<?> DeletById(Long id);

	ResponseEntity<?> findAllData();

	ResponseEntity<?> findAllwithpage(SchoolSpaceDto dto);	
}
