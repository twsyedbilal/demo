package com.techweaversys.service;

import org.springframework.http.ResponseEntity;

import com.techweaversys.dto.NationalityDto;
import com.techweaversys.dto.NationalitySpaceDto;

public interface NationalityService {

	ResponseEntity<?> saveData(NationalityDto dto);

	ResponseEntity<?> findAllData();

	ResponseEntity<?> DeletById(Long id);

	ResponseEntity<?> getById(Long id);

	ResponseEntity<?> findAllwithpage(NationalitySpaceDto dto);


}
