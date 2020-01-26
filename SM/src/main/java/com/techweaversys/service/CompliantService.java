package com.techweaversys.service;

import org.springframework.http.ResponseEntity;

import com.techweaversys.dto.CompliantDto;
import com.techweaversys.dto.CompliantSpceDto;

public interface CompliantService {

	ResponseEntity<?> createData(CompliantDto compliantDto);

	ResponseEntity<?> findAllData();

	ResponseEntity<?> getDataById(Long id);

	ResponseEntity<?> DeletById(Long id);

	ResponseEntity<?> findAllwithpage(CompliantSpceDto dto);
}
