package com.techweaversys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techweaversys.dto.OpeningStockDto;
import com.techweaversys.service.OpeningStockService;

@RestController
@RequestMapping("rest/api/openingstock/")
public class OpeningStockController {

	@Autowired
	private OpeningStockService openingStockService;

	@PostMapping(value = "add")
	public ResponseEntity<?> addgrn(@RequestBody OpeningStockDto dto) {
		return openingStockService.addOpeningStock(dto);
	}

	@GetMapping("get/{id}")
	public ResponseEntity<?> getGrn(@PathVariable Long id) {
		return openingStockService.getOpeningStock(id);
	}

	@GetMapping("delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		return openingStockService.softDeletedOpenigStock(id);
	}

	@GetMapping(value = "findall")
	public ResponseEntity<?> findAll() {
		return openingStockService.findAll();
	}
}
