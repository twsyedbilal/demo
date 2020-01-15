package com.techweaversys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techweaversys.dto.SubjectMasterDto;
import com.techweaversys.dto.SubjectMasterSpaceDto;
import com.techweaversys.service.SubjectMasterService;

@RestController
@RequestMapping("/rest/api/subject/")
public class SubjectMasterController {

	@Autowired
	private SubjectMasterService subjectMasterService;

	@PostMapping(value = "create")
	public ResponseEntity<?> create(@RequestBody SubjectMasterDto dto) {
		return subjectMasterService.create(dto);
	}

	@GetMapping(value = "getbyid/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id) {
		return subjectMasterService.getById(id);
	}

	@GetMapping(value = "deletedbyid/{id}")
	public ResponseEntity<?> deletedById(@PathVariable Long id) {
		return subjectMasterService.deletedById(id);
	}

	@GetMapping(value = "getsubjectbyclass/{classid}")
	public ResponseEntity<?> getSubjectByClass(@PathVariable Long classid) {
		return subjectMasterService.getSubjectByClass(classid);
	}

	@PostMapping(value = "findAllwithpage")
	public ResponseEntity<?> findAllwithpage(@RequestBody SubjectMasterSpaceDto dto) {
		return subjectMasterService.findAllwithpage(dto);
	}
}
