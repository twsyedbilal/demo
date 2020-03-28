package com.techweaversys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techweaversys.dto.ExamDto;
import com.techweaversys.dto.ExameSpec;
import com.techweaversys.service.ExamService;

	
	@RestController
	@RequestMapping("/rest/api/exam/")
	public class ExamController {

		@Autowired
		private ExamService examService;

		@PostMapping(value = "save")
		public ResponseEntity<?> saveData(@RequestBody ExamDto dto) {
			return examService.saveData(dto);
		}

		@GetMapping(value = "getbyid/{id}")
		public ResponseEntity<?> getDataById(@PathVariable Long id) {
			return examService.getDataById(id);

		}

		@PostMapping(value = "findAllwithpage")
		public ResponseEntity<?> findAllwithpage(@RequestBody ExameSpec dto) {
			return examService.findAllwithpage(dto);

		}
		
		@GetMapping(value = "findall")
		public ResponseEntity<?> findAlData() {
			return examService.findAllData();

		}
		
		
		@GetMapping(value = "deletebyid/{id}")
		public ResponseEntity<?> DeletById(@PathVariable Long id) {
			return examService.DeletById(id);

		}
		

		@GetMapping(value = "getbyclassid/{id}")
		public ResponseEntity<?> getByclassId(@PathVariable Long id) {
			return examService.getByclassId(id);

		}
		
}
