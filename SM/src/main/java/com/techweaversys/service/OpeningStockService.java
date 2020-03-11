package com.techweaversys.service;

import org.springframework.http.ResponseEntity;

import com.techweaversys.dto.OpeningStockDto;

public interface OpeningStockService {

	ResponseEntity<?> addOpeningStock(OpeningStockDto dto);

	ResponseEntity<?> getOpeningStock(Long id);

	ResponseEntity<?> softDeletedOpenigStock(Long id);

	ResponseEntity<?> findAll();

}
