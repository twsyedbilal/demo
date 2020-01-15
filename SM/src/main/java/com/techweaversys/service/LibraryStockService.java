package com.techweaversys.service;

import org.springframework.http.ResponseEntity;

import com.techweaversys.dto.StockInOutDto;

public interface LibraryStockService {

	ResponseEntity<?> adjustStock(StockInOutDto dto);

	ResponseEntity<?> byBookId(Long id);

	ResponseEntity<?> byStockInOut(Long id);

}
