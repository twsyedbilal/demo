package com.techweaversys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.techweaversys.dto.StudentMarkDto;
import com.techweaversys.dto.StudentMarkSpecDto;
import com.techweaversys.dto.SubjectMasterSpaceDto;
import com.techweaversys.service.StudentMarksService;

@RestController
@RequestMapping("/rest/api/student/marks/")
public class StudentMarksController {

	@Autowired
	private StudentMarksService studentMarksService;

	@PostMapping(value = "save")
	public ResponseEntity<?> create(@RequestBody StudentMarkDto studentStatus) {
		return studentMarksService.create(studentStatus);
	}

	@GetMapping(value = "getbyid/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id) {
		return studentMarksService.getById(id);

	}

	@GetMapping(value = "deletebyid/{id}")
	public ResponseEntity<?> DeletById(@PathVariable Long id) {
		return studentMarksService.DeletById(id);
 
	}

	@GetMapping(value = "findall")
	public ResponseEntity<?> findAlData() {
		return studentMarksService.findAllData();

	}
	

	@GetMapping(value = "getbyclassid/{id}")
	public ResponseEntity<?> getByclassId(@PathVariable Long id) {
		return studentMarksService.getByclassId(id);

	}
	
	
	
}