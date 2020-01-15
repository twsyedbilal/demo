package com.techweaversys.service;

import org.springframework.http.ResponseEntity;

import com.techweaversys.dto.BookDto;

public interface BookService {

	ResponseEntity<?> saveData(BookDto dto);

	ResponseEntity<?> getDataById(Long id);

	ResponseEntity<?> findAllData();

	ResponseEntity<?> DeletById(Long id);

}
