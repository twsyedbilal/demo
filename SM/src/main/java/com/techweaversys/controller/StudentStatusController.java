package com.techweaversys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techweaversys.model.StudentStatus;
import com.techweaversys.service.StudentStatusService;

@RestController
@RequestMapping("/rest/api/status/")
public class StudentStatusController {

	@Autowired
	private StudentStatusService studentStatusService;
	
	@PostMapping(value = "create")
	public ResponseEntity<?> create(@RequestBody StudentStatus studentStatus) {
		return studentStatusService.create(studentStatus);
	}

	@GetMapping(value = "getbyid/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id) {
		return studentStatusService.getById(id);

	}

	@GetMapping(value = "deletebyid/{id}")
	public ResponseEntity<?> DeletById(@PathVariable Long id) {
		return studentStatusService.DeletById(id);

	}

	@GetMapping(value = "findall")
	public ResponseEntity<?> findAlData() {
		return studentStatusService.findAllData();

	}
}
