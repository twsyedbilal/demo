package com.techweaversys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techweaversys.dto.ReportSpaceDto;
import com.techweaversys.service.ReportService;

@RestController
@RequestMapping("/rest/api/report/")
public class ReportContoller {

	@Autowired
	private ReportService reportService;

	@PostMapping(value = "findallwithpage")
	public ResponseEntity<?> findAllwithpage(@RequestBody ReportSpaceDto reportDto) {
		return reportService.findAllwithpage(reportDto);
	}

}
