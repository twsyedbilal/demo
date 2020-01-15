package com.techweaversys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techweaversys.dto.SubCasteDto;
import com.techweaversys.dto.SubCasteSpecDto;
import com.techweaversys.service.SubCasteService;

@RestController
@RequestMapping("/rest/api/subcaste/")
public class SubCasteController {

	@Autowired
	private SubCasteService subCasteService;

	@PostMapping(value = "savesubcaste")
	public ResponseEntity<?> saveaSubCaste(@RequestBody SubCasteDto subCasteDto){
		
		return subCasteService.saveSubCaste(subCasteDto);
	}

	@GetMapping(value = "getbyidsc/{id}")
	public ResponseEntity<?> getByIdSubCaste(@PathVariable Long id) {
		return subCasteService.getByIdSubCaste(id);

	}
	
	@GetMapping(value = "findallsubcaste")
	public ResponseEntity<?> findAllSubCaste() {
		return subCasteService.findAllSubCaste();

	}
	
	@GetMapping(value = "deleteid/{id}")
	public ResponseEntity<?> deleteSubCasteById(@PathVariable Long id) {
		return subCasteService.deleteSubCasteById(id);

	}
	@PostMapping(value = "findAllwithpage")
	public ResponseEntity<?> findAllwithpage(@RequestBody SubCasteSpecDto dto) {
		return subCasteService.findAllwithpage(dto);

	}

}
