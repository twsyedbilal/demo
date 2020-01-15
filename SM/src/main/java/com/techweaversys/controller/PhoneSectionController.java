package com.techweaversys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techweaversys.dto.PhoneSectionDto;
import com.techweaversys.dto.PhoneSectionSpaceDto;
import com.techweaversys.service.PhoneSectionService;

/**
* The HelloWorld program implements an application that
* simply displays "Hello World!" to the standard output.
*
* @author  0001
* @version 1.0
* @since   2019-12-25 
*/
@RestController
@RequestMapping("/rest/api/phonesection/")
public class PhoneSectionController {

	@Autowired
	private PhoneSectionService phoneSectionService;


	@PostMapping(value = "save")
	public ResponseEntity<?> saveData(@RequestBody PhoneSectionDto pdto) {
		return phoneSectionService.saveData(pdto);

	}

	@GetMapping(value = "getbyid/{id}")
	public ResponseEntity<?> getDataById(@PathVariable Long id) {
		return phoneSectionService.getDataById(id);

	}

	@GetMapping(value = "findall")
	public ResponseEntity<?> findAlData() {
		return phoneSectionService.findAllData();

	}

	@GetMapping(value = "deletebyid/{id}")
	public ResponseEntity<?> DeletById(@PathVariable Long id) {
		return phoneSectionService.DeletById(id);

	}

	@PostMapping(value = "findallwithpage")
	public ResponseEntity<?> findAllwithpage(@RequestBody PhoneSectionSpaceDto phoneSectionSpaceDto) {
		return phoneSectionService.findAllwithpage(phoneSectionSpaceDto);
		
	}
}
