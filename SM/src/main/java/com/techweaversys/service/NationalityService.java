package com.techweaversys.service;

import org.springframework.http.ResponseEntity;

import com.techweaversys.dto.NationalityDto;

public interface NationalityService {

	ResponseEntity<?> saveData(NationalityDto dto);

	ResponseEntity<?> findAllData();

	ResponseEntity<?> DeletById(Long id);

	ResponseEntity<?> getById(Long id);


}
