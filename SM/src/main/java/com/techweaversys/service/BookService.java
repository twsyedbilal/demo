package com.techweaversys.service;

import org.springframework.http.ResponseEntity;

import com.techweaversys.dto.BookDto;
import com.techweaversys.dto.BookSpaceDto;

public interface BookService {

	ResponseEntity<?> saveData(BookDto dto);

	ResponseEntity<?> getDataById(Long id);

	ResponseEntity<?> findAllData();

	ResponseEntity<?> DeletById(Long id);

	ResponseEntity<?> findAllwithpage(BookSpaceDto dto);

}
