package com.techweaversys.service;

import org.springframework.http.ResponseEntity;

import com.techweaversys.dto.LogDto;

public interface LogService {

	ResponseEntity<?> create(LogDto dto);

	
}
