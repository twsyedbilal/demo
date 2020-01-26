package com.techweaversys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techweaversys.dto.SchoolSpaceDto;
import com.techweaversys.dto.SchoolTypeDto;
import com.techweaversys.dto.SchoolTypeSpecDto;
import com.techweaversys.service.SchoolTypeService;

@RestController
@RequestMapping("/rest/api/schooltype/")
public class SchoolTypeController {

	@Autowired
	public SchoolTypeService  schooltypeservice;

	
	@PostMapping(value = "save")
	public ResponseEntity<?> saveRecord(@RequestBody SchoolTypeDto schoolType) {
		return schooltypeservice.saveRecord(schoolType);
	}
	@GetMapping(value = "getbyid/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id) {
		return schooltypeservice.getById(id);

	}

	@GetMapping(value = "deletebyid/{id}")
	public ResponseEntity<?> DeletById(@PathVariable Long id) {
		return schooltypeservice.DeletById(id);

	}

	@GetMapping(value = "findall")
	public ResponseEntity<?> findAlData() {
		return schooltypeservice.findAllData();

	}

	@PostMapping(value = "findAllwithpage")
	public ResponseEntity<?> findAllwithpage(@RequestBody SchoolTypeSpecDto dto) {
		return schooltypeservice.findAllwithpage(dto);

	}

	
}
