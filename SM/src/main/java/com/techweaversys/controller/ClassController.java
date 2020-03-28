package com.techweaversys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techweaversys.dto.ClassDto;
import com.techweaversys.dto.ClassSpaceDto;
import com.techweaversys.service.ClassService;

@RestController
@RequestMapping("/rest/api/class/")
public class ClassController {
	
	@Autowired
	private ClassService  classService;
	
	@PostMapping(value="save")
	public ResponseEntity<?> save(@RequestBody ClassDto classdto){
		return  classService .save(classdto);
				
	}
	
	@GetMapping(value = "getbyid/{id}")
	public ResponseEntity<?> getDataById(@PathVariable Long id) {
		return classService.getDataById(id);

	}

	@PostMapping(value = "findAllwithpage")
	public ResponseEntity<?> findAllwithpage(@RequestBody ClassSpaceDto dto) {
		return classService.findAllwithpage(dto);

	}
	@GetMapping(value = "findall")
	public ResponseEntity<?> findAlData() {
		return classService.findAllData();

	}

	@GetMapping(value = "deletebyid/{id}")
	public ResponseEntity<?> DeletById(@PathVariable Long id) {
		return classService.DeletById(id);

	}



}
