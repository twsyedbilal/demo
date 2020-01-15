package com.techweaversys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techweaversys.dto.CasteDto;
import com.techweaversys.dto.CasteSpecDto;
import com.techweaversys.service.CasteService;

@RestController
@RequestMapping("/rest/api/caste/")
public class CasteController {

	@Autowired
	private CasteService casteService;
	
	@PostMapping(value = "savecaste")
	public ResponseEntity<?> saveaCaste(@RequestBody CasteDto casteDto){
		
		return casteService.saveCaste(casteDto);
	}

	@GetMapping(value = "getbyidcaste/{id}")
	public ResponseEntity<?> getByIdCaste(@PathVariable Long id) {
		return casteService.getByIdCaste(id);

	}
	
	@GetMapping(value = "findallcaste")
	public ResponseEntity<?> findAllRCaste() {
		return casteService.findAllCaste();

	}
	
	@GetMapping(value = "deleteid/{id}")
	public ResponseEntity<?> deleteCasteById(@PathVariable Long id) {
		return casteService.deleteCasteById(id);

	}
	
	@PostMapping(value = "findAllwithpage")
	public ResponseEntity<?> findAllwithpage(@RequestBody CasteSpecDto dto) {
		return casteService.findAllwithpage(dto);

	}

}
