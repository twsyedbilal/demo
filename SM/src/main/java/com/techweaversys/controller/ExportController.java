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
@RequestMapping(value = "rest/api/export/pdf/")
public class ExportController {

	@Autowired
	private ExportService exportService;

	@GetMapping("bonafide/{id}")
	@ResponseBody
	public byte[] downloadPdfBonoFide(@PathVariable("id") Long id, HttpServletResponse response)
			throws DocumentException {
		return exportService.downloadPdfBonoFide(id, response);
	}

	@GetMapping("icardfront/{id}")
	@ResponseBody
	public byte[] downloadPdfIdCardFront(@PathVariable("id") Long id, HttpServletResponse response)
			throws DocumentException, IOException {
		return exportService.downloadPdfIdCardFront(id, response);
	}

	@GetMapping("icardback/{id}")
	@ResponseBody
	public byte[] downloadPdfIdCardBack(@PathVariable("id") Long id, HttpServletResponse response)
			throws DocumentException, IOException {
		return exportService.downloadPdfIdCardBack(id, response);
	}

	// 2
	@GetMapping("bonafidebirth/{id}")
	@ResponseBody
	public byte[] downloadPdfBfByBirth(@PathVariable("id") Long id, HttpServletResponse response)
			throws DocumentException {
		return exportService.downloadPdfBfByBirth(id, response);
	}

	// 3
	@GetMapping("bonafideaddscience/{id}")
	@ResponseBody
	public byte[] downloadPdfBfByAddScience(@PathVariable("id") Long id, HttpServletResponse response)
			throws DocumentException {
		return exportService.downloadPdfBfByAddScience(id, response);
	}

	// 4
	@GetMapping("bonafidejr/{id}")
	@ResponseBody
	public byte[] downloadPdfBfByJr(@PathVariable("id") Long id, HttpServletResponse response)
			throws DocumentException {
		return exportService.downloadPdfBfByJr(id, response);
	}

	// 5
	@GetMapping("bonafide5/{id}")
	@ResponseBody
	public byte[] downloadPdfBfBySchoolRecord(@PathVariable("id") Long id, HttpServletResponse response)
			throws DocumentException {
		return exportService.downloadPdfBfBySchoolRecord(id, response);
	}

	// 6
	@GetMapping("bonafidescience/{id}")
	@ResponseBody
	public byte[] downloadPdfBfByScience(@PathVariable("id") Long id, HttpServletResponse response)
			throws DocumentException {
		return exportService.downloadPdfBfByScience(id, response);
	}

	// 7
	@GetMapping("bonafidepast/{id}")
	@ResponseBody
	public byte[] downloadPdfBfByWas(@PathVariable("id") Long id, HttpServletResponse response)
			throws DocumentException {
		return exportService.downloadPdfBfBySchoolWas(id, response);
	}

	@GetMapping("primarytc/{id}")
	@ResponseBody
	public byte[] downloadPdfPrimaryTc(@PathVariable("id") Long id, HttpServletResponse response)
			throws DocumentException, IOException {
		return exportService.downloadPdfPrimaryTc(id, response);
	}

	@GetMapping("highschooltc/{id}")
	@ResponseBody
	public byte[] downloadPdfHighSchoolTc(@PathVariable("id") Long id, HttpServletResponse response)
			throws DocumentException, IOException {
		return exportService.downloadPdfHighSchoolTc(id, response);
	}

	@GetMapping("jrcollegetc/{id}")
	@ResponseBody
	public byte[] downloadPdfJrCollegeTc(@PathVariable("id") Long id, HttpServletResponse response)
			throws DocumentException, IOException {
		return exportService.downloadPdfJrCollegeTc(id, response);
	}

	@GetMapping("nilgamutara/{id}")
	@ResponseBody
	public byte[] downloadPdfNilgamutara(@PathVariable("id") Long id, HttpServletResponse response)
			throws DocumentException, IOException {
		return exportService.downloadPdfNilgamutara(id, response);

	}
	
	@GetMapping("icard/{id}")
	@ResponseBody
	public byte[] downloadPdfICard(@PathVariable("id") Long id, HttpServletResponse response)
			throws DocumentException, IOException {
		return exportService.downloadPdfICard(id, response);
	}

}
