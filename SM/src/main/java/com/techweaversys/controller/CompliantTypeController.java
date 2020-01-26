package com.techweaversys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techweaversys.dto.CompliantTypeDtobject;
import com.techweaversys.dto.CompliantTypespceDto;
import com.techweaversys.service.CompliantTypeServicee;

@RestController
@RequestMapping("/rest/api/compliant/type")
public class CompliantTypeController {

	@Autowired
	private CompliantTypeServicee compliantTypeServicee;

	@PostMapping(value = "create")
	public ResponseEntity<?> createData(@RequestBody CompliantTypeDtobject compliantDto) {
		return compliantTypeServicee.createData(compliantDto);

	}

	@GetMapping(value = "findall")
	public ResponseEntity<?> findAllData() {
		return compliantTypeServicee.findAllData();
	}

	@GetMapping(value = "getbyid/{id}")
	public ResponseEntity<?> getDataById(@PathVariable Long id) {
		return compliantTypeServicee.getDataById(id);

	}

	@GetMapping(value = "deletebyid/{id}")
	public ResponseEntity<?> DeletById(@PathVariable Long id) {
		return compliantTypeServicee.DeletById(id);

	}

	@PostMapping(value = "findAllwithpage")
	public ResponseEntity<?> findAllwithpage(@RequestBody CompliantTypespceDto dto) {
		return compliantTypeServicee.findAllwithpage(dto);

	}

}
