package com.techweaversys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techweaversys.dto.SocietyDto;
import com.techweaversys.service.SocietyService;

@RestController
@RequestMapping("/rest/api/society/")
public class SocietyController {
	
	@Autowired
	private SocietyService societyService;

	@PostMapping(value = "save")
	public ResponseEntity<?> saveData(@RequestBody SocietyDto dto) {
		return societyService.saveData(dto);
	}
	
	@GetMapping(value = "getbyid/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id) {
		return societyService.getById(id);

	}

	@GetMapping(value = "deletebyid/{id}")
	public ResponseEntity<?> DeletById(@PathVariable Long id) {
		return societyService.DeletById(id);

	}

	@GetMapping(value = "findall")
	public ResponseEntity<?> findAlData() {
		return societyService.findAllData();

	}

	
}
