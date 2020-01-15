package com.techweaversys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techweaversys.dto.AcountFeeDto;
import com.techweaversys.dto.AcountFeeSpaceDto;
import com.techweaversys.service.AcountFeeService;

@RestController
@RequestMapping("/rest/api/fee/")
public class AcountFeeController {

	@Autowired
	private AcountFeeService accountFeeService;

	@PostMapping(value = "save")
	public ResponseEntity<?> saveData(@RequestBody AcountFeeDto dto) {
		return accountFeeService.saveData(dto);
	}

	@GetMapping(value = "getbyid/{id}")
	public ResponseEntity<?> getDataById(@PathVariable Long id) {
		return accountFeeService.getDataById(id);

	}

	@GetMapping(value = "findall")
	public ResponseEntity<?> findAlData() {
		return accountFeeService.findAllData();

	}

	@GetMapping(value = "deletebyid/{id}")
	public ResponseEntity<?> DeletById(@PathVariable Long id) {
		return accountFeeService.DeletById(id);

	}

	@PostMapping(value = "findAllwithpage")
	public ResponseEntity<?> findAllwithpage(@RequestBody AcountFeeSpaceDto dto) {
		return accountFeeService.findAllwithpage(dto);

	}

}
