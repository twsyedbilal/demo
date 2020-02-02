package com.techweaversys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techweaversys.dto.MotherTongueDto;
import com.techweaversys.dto.MotherTongueSpaceDto;
import com.techweaversys.service.MotherTongueService;

@RestController
@RequestMapping("/rest/api/mt/")
public class MotherTongueController {

	@Autowired
	private MotherTongueService motherTongueService;
	
	@PostMapping(value = "save")
     public ResponseEntity<?> saveData(@RequestBody MotherTongueDto dto) {
             return motherTongueService.saveData(dto);
     }
     @GetMapping(value = "getbyid/{id}")
     public ResponseEntity<?> getById(@PathVariable Long id) {
             return motherTongueService.getById(id);

     }

     @GetMapping(value = "deletebyid/{id}")
     public ResponseEntity<?> DeletById(@PathVariable Long id) {
             return motherTongueService.DeletById(id);

     }

     @GetMapping(value = "findall")
     public ResponseEntity<?> findAlData() {
             return motherTongueService.findAllData();

     }
     @PostMapping(value = "findAllwithpage")
		public ResponseEntity<?> findAllwithpage(@RequestBody MotherTongueSpaceDto dto) {
			return motherTongueService.findAllwithpage(dto);

		}
}
