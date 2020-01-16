package com.techweaversys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techweaversys.dto.StockInOutDto;
import com.techweaversys.service.LibraryStockService;

@RestController
@RequestMapping("stock/")
public class StockController {

	@Autowired
	private LibraryStockService libraryStockService;
	
	@PostMapping(value ="adjust")
	public ResponseEntity<?> adjustStock(@RequestBody StockInOutDto dto) {
		return libraryStockService.adjustStock(dto);
	}

	@GetMapping(value ="bybookid/{id}")
	public ResponseEntity<?> byBookId(@PathVariable Long id) {
		return libraryStockService.byBookId(id);
	}
	@GetMapping(value ="byStockInOut/{id}")
	public ResponseEntity<?> byStockInOut(@PathVariable Long id) {
		return libraryStockService.byStockInOut(id);
	}
	
	/*
	 * @PostMapping(value = "list") public ResponseEntity<?> stockList(@RequestBody
	 * BookSpecDto spectDto) { return libraryStockService.stockList(spectDto); }
	 */
	
}