package com.techweaversys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techweaversys.dto.BookDto;
import com.techweaversys.service.BookService;
	
	@RestController
	@RequestMapping("/rest/api/book/")
	public class BookController {

		@Autowired
		private BookService bookService;

		@PostMapping(value = "save")
		public ResponseEntity<?> saveData(@RequestBody BookDto dto) {
			return bookService.saveData(dto);
		}

		@GetMapping(value = "getbyid/{id}")
		public ResponseEntity<?> getDataById(@PathVariable Long id) {
			return bookService.getDataById(id);

		}
		@GetMapping(value = "findall")
		public ResponseEntity<?> findAlData() {
			return bookService.findAllData();

		}

		@GetMapping(value = "deletebyid/{id}")
		public ResponseEntity<?> DeletById(@PathVariable Long id) {
			return bookService.DeletById(id);

		}

	}
