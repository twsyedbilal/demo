package com.techweaversys.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lowagie.text.DocumentException;
import com.techweaversys.service.ExportService;

@RestController
@RequestMapping(value = "/export/")
public class ExportController {

	@Autowired
	private ExportService exportService;

	@GetMapping("bonafide/pdf/{id}")
	@ResponseBody
	public byte[] downloadPdfBonoFide(@PathVariable("id") Long id, HttpServletResponse response)
			throws DocumentException, IOException {
		return exportService.downloadPdfBonoFide(id, response);
	}

	@GetMapping("icardfront/pdf/{id}")
	@ResponseBody
	public byte[] downloadPdfIdCardFront(@PathVariable("id") Long id, HttpServletResponse response)
			throws DocumentException, IOException {
		return exportService.downloadPdfIdCardFront(id, response);
	}
	
	@GetMapping("icardback/pdf/{id}")
	@ResponseBody
	public byte[] downloadPdfIdCardBack(@PathVariable("id") Long id, HttpServletResponse response)
			throws DocumentException, IOException {
		return exportService.downloadPdfIdCardBack(id, response);
	}

}
