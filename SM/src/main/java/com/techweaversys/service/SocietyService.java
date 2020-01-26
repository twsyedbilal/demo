package com.techweaversys.service;

import org.springframework.http.ResponseEntity;

import com.techweaversys.dto.SocietyDto;
import com.techweaversys.dto.SocietySpaceDto;

public interface SocietyService {
	
	ResponseEntity<?> saveData(SocietyDto dto);

	ResponseEntity<?> findAllData();

	ResponseEntity<?> DeletById(Long id);

	ResponseEntity<?> getById(Long id);

	ResponseEntity<?> findAllwithpage(SocietySpaceDto dto);


}
