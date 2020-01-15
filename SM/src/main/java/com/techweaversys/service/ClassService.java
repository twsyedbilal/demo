package com.techweaversys.service;

import org.springframework.http.ResponseEntity;

import com.techweaversys.dto.ClassDto;
import com.techweaversys.dto.ClassSpaceDto;

public interface ClassService {

	ResponseEntity<?> save(ClassDto classdto);

	ResponseEntity<?> getDataById(Long id);

	ResponseEntity<?> findAllwithpage(ClassSpaceDto dto);

	ResponseEntity<?> findAllData();

	ResponseEntity<?> DeletById(Long id);

}
