package com.techweaversys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techweaversys.dto.NationalityDto;
import com.techweaversys.service.NationalityService;

@RestController
@RequestMapping("/rest/api/nationality/")
public class NationalityController {

	@Autowired
	private NationalityService nationalityService;
	
	@PostMapping(value = "save")
	public ResponseEntity<?> saveData(@RequestBody NationalityDto dto) {
		return nationalityService.saveData(dto);
	}
	@GetMapping(value = "getbyid/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id) {
		return nationalityService.getById(id);

	}

	@GetMapping(value = "deletebyid/{id}")
	public ResponseEntity<?> DeletById(@PathVariable Long id) {
		return nationalityService.DeletById(id);

	}

	@GetMapping(value = "findall")
	public ResponseEntity<?> findAlData() {
		return nationalityService.findAllData();

	}

}
