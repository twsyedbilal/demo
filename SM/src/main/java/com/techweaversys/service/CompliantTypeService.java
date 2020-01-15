package com.techweaversys.service;

import org.springframework.http.ResponseEntity;

import com.techweaversys.dto.CompliantTypeDto;
import com.techweaversys.dto.CompliantTypeSpaceDto;

public interface CompliantTypeService {

	ResponseEntity<?> createData(CompliantTypeDto compliantDto);

	ResponseEntity<?> findAllData();

	ResponseEntity<?> getDataById(Long id);

	ResponseEntity<?> DeletById(Long id);

	ResponseEntity<?> findAllwithpage(CompliantTypeSpaceDto dto);
}
