package com.techweaversys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techweaversys.dto.BranchDto;
import com.techweaversys.dto.BranchSpacedto;
import com.techweaversys.service.BranchService;

@RestController
@RequestMapping("/rest/api/branch/")
public class BranchController {

	@Autowired
	private BranchService branchservice;

	@PostMapping(value = "save")
	public ResponseEntity<?> saveData(@RequestBody BranchDto dto) {
		return branchservice.saveData(dto);
	}

	@GetMapping(value = "getbyid/{id}")
	public ResponseEntity<?> getDataById(@PathVariable Long id) {
		return branchservice.getDataById(id);

	}

	@PostMapping(value = "findAllwithpage")
	public ResponseEntity<?> findAllwithpage(@RequestBody BranchSpacedto dto) {
		return branchservice.findAllwithpage(dto);

	}
	@GetMapping(value = "findall")
	public ResponseEntity<?> findAlData() {
		return branchservice.findAllData();

	}

	@GetMapping(value = "deletebyid/{id}")
	public ResponseEntity<?> DeletById(@PathVariable Long id) {
		return branchservice.DeletById(id);

	}

}