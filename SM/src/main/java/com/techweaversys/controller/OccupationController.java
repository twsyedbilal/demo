package com.techweaversys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techweaversys.dto.OccupationDto;
import com.techweaversys.dto.OccupationSpecDto;
import com.techweaversys.service.OccupationService;

@RestController
@RequestMapping("/rest/api/occupation/")
public class OccupationController {
	
	@Autowired
	private OccupationService occupationService;

	@PostMapping(value = "saveoccupation")
	public ResponseEntity<?> saveOccupation(@RequestBody  OccupationDto  occupationDto){
		
		return occupationService.saveOccupation(occupationDto);
	}

	@GetMapping(value = "getbyidoccupation/{id}")
	public ResponseEntity<?> getByIdOccupation(@PathVariable Long id) {
		return occupationService.getByIdOccupation(id);

	}
	
	@GetMapping(value = "findalloccupation")
	public ResponseEntity<?> findAllOccupation() {
		return occupationService.findAllOccupation();

	}
	
	@GetMapping(value = "deleteid/{id}")
	public ResponseEntity<?> deleteOccupationById(@PathVariable Long id) {
		return occupationService.deleteOccupationById(id);

	}
	
	@PostMapping(value = "findAllwithpage")
	public ResponseEntity<?> findAllwithpage(@RequestBody OccupationSpecDto dto) {
		return occupationService.findAllwithpage(dto);

	}

}
