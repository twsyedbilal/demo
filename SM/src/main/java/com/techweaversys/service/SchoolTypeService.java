package com.techweaversys.service;

import org.springframework.http.ResponseEntity;

import com.techweaversys.dto.SchoolTypeDto;

public interface SchoolTypeService {

	ResponseEntity<?> saveRecord(SchoolTypeDto school);

	ResponseEntity<?> getById(Long id);

	ResponseEntity<?> DeletById(Long id);

	ResponseEntity<?> findAllData();


//	ResponseEntity<?> findAllwithpage(SchoolTypeSpaceDto dto);

}
