package com.techweaversys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techweaversys.dto.ReligionDto;
import com.techweaversys.dto.ReligionSpecDto;
import com.techweaversys.service.ReligionService;

@RestController
@RequestMapping("/rest/api/religion/")
public class ReligionController {
	
	@Autowired
	private ReligionService religionService;

	@PostMapping(value = "savereligion")
	public ResponseEntity<?> saveaReligion(@RequestBody ReligionDto religionDto){
		
		return religionService.saveReligion(religionDto);
	}

	@GetMapping(value = "getbyidrel/{id}")
	public ResponseEntity<?> getByIdReligion(@PathVariable Long id) {
		return religionService.getByIdReligion(id);

	}
	
	@GetMapping(value = "findallreligion")
	public ResponseEntity<?> findAllReligion() {
		return religionService.findAllReligion();

	}
	
	@GetMapping(value = "deleteid/{id}")
	public ResponseEntity<?> deletReligionById(@PathVariable Long id) {
		return religionService.deletReligionById(id);

	}

	@PostMapping(value = "findAllwithpage")
	public ResponseEntity<?> findAllwithpage(@RequestBody ReligionSpecDto dto) {
		return religionService.findAllwithpage(dto);

	}

}
