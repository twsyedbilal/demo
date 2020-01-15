package com.techweaversys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techweaversys.dto.CompliantTypeDto;
import com.techweaversys.dto.CompliantTypeSpaceDto;
import com.techweaversys.service.CompliantTypeService;

@RestController
@RequestMapping("/rest/api/compliant/type/")
public class CompliantTypeController {

	@Autowired
	private CompliantTypeService compliantTypeService;

	@PostMapping(value = "create")
	public ResponseEntity<?> createData(@RequestBody CompliantTypeDto compliantDto) {
		return compliantTypeService.createData(compliantDto);

	}

	@GetMapping(value = "findall")
	public ResponseEntity<?> findAllData() {
		return compliantTypeService.findAllData();
	}

	@GetMapping(value = "getbyid/{id}")
	public ResponseEntity<?> getDataById(@PathVariable Long id) {
		return compliantTypeService.getDataById(id);

	}

	@GetMapping(value = "deletebyid/{id}")
	public ResponseEntity<?> DeletById(@PathVariable Long id) {
		return compliantTypeService.DeletById(id);

	}

	@PostMapping(value = "findAllwithpage")
	public ResponseEntity<?> findAllwithpage(@RequestBody CompliantTypeSpaceDto dto) {
		return compliantTypeService.findAllwithpage(dto);

	}
}
