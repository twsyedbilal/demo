package com.techweaversys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techweaversys.dto.CompliantDto;
import com.techweaversys.dto.CompliantSpceDto;
import com.techweaversys.service.CompliantService;

@RestController
@RequestMapping("/rest/api/compliant/")
public class CompliantController {

	@Autowired
	private CompliantService compliantService;

	@PostMapping(value = "create")
	public ResponseEntity<?> createData(@RequestBody CompliantDto compliantDto) {
		return compliantService.createData(compliantDto);

	}

	@GetMapping(value = "findall")
	public ResponseEntity<?> findAllData() {
		return compliantService.findAllData();
	}

	@GetMapping(value = "getbyid/{id}")
	public ResponseEntity<?> getDataById(@PathVariable Long id) {
		return compliantService.getDataById(id);

	}

	@GetMapping(value = "deletebyid/{id}")
	public ResponseEntity<?> DeletById(@PathVariable Long id) {
		return compliantService.DeletById(id);

	}

	@PostMapping(value = "findAllwithpage")
	public ResponseEntity<?> findAllwithpage(@RequestBody CompliantSpceDto dto) {
		return compliantService.findAllwithpage(dto);

	}
}
