package com.techweaversys.service;

import org.springframework.http.ResponseEntity;

import com.techweaversys.dto.CasteDto;
import com.techweaversys.dto.CasteSpecDto;

public interface CasteService {

	ResponseEntity<?> saveCaste(CasteDto casteDto);
	
	ResponseEntity<?> getByIdCaste(Long id);

	ResponseEntity<?> findAllCaste();

	ResponseEntity<?> deleteCasteById(Long id);

	ResponseEntity<?> findAllwithpage(CasteSpecDto dto);


}
