package com.techweaversys.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techweaversys.dto.SchoolDto;
import com.techweaversys.dto.SchoolSpaceDto;
import com.techweaversys.service.SchoolService;

@RestController
@RequestMapping("/rest/api/school/")
public class SchoolController {

	@Autowired
	private SchoolService schoolservice;

	@PostMapping(value = "save", consumes = { "application/json" })
	public ResponseEntity<?> saveRecord(@RequestBody SchoolDto school) {
		return schoolservice.saveRecord(school);
	}

	@GetMapping(value = "getbyid/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id) {
		return schoolservice.getById(id);

	}

	@GetMapping(value = "deletebyid/{id}")
	public ResponseEntity<?> DeletById(@PathVariable Long id) {
		return schoolservice.DeletById(id);

	}

	@GetMapping(value = "findall")
	public ResponseEntity<?> findAlData() {
		return schoolservice.findAllData();

	}

	@PostMapping(value = "findAllwithpage")
	public ResponseEntity<?> findAllwithpage(@RequestBody SchoolSpaceDto dto) {
		return schoolservice.findAllwithpage(dto);

	}

	@PostMapping(value = "saveall")
	public List<ResponseEntity<?>> saveMultipleRecord(@RequestBody List<SchoolDto> schoolDtos) {
		List<ResponseEntity<?>> saveM = null;
		saveM = new ArrayList<ResponseEntity<?>>();
		for (SchoolDto schoolDto : schoolDtos) {
			ResponseEntity<?> res = schoolservice.saveRecord(schoolDto);
			saveM.add(res);
		}
		return saveM;
	}

}
