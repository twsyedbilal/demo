package com.techweaversys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techweaversys.dto.LogDto;
import com.techweaversys.service.LogService;

@RestController
@RequestMapping("/rest/api/log/")
public class LogController {

	@Autowired
	private LogService logService;
	
	@PostMapping(value = "create")
	public ResponseEntity<?> create(@RequestBody LogDto dto) {
		return logService.create(dto);
	}
	
}
