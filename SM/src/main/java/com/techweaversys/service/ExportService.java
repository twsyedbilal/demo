package com.techweaversys.service;

import javax.servlet.http.HttpServletResponse;

public interface ExportService {

	byte[] downloadPdfBonoFide(Long id, HttpServletResponse response);

	byte[] downloadPdfIdCardFront(Long id, HttpServletResponse response);

	byte[] downloadPdfIdCardBack(Long id, HttpServletResponse response);

	byte[] downloadPdfBfByBirth(Long id, HttpServletResponse response);

	byte[] downloadPdfBfByJr(Long id, HttpServletResponse response);

	byte[] downloadPdfBfByAddScience(Long id, HttpServletResponse response);

	byte[] downloadPdfBfBySchoolRecord(Long id, HttpServletResponse response);

	byte[] downloadPdfBfBySchoolWas(Long id, HttpServletResponse response);

	byte[] downloadPdfBfByScience(Long id, HttpServletResponse response);
	
	byte[] downloadPdfPrimaryTc(Long id, HttpServletResponse response);

	byte[] downloadPdfHighSchoolTc(Long id, HttpServletResponse response);

	byte[] downloadPdfJrCollegeTc(Long id, HttpServletResponse response);

	byte[] downloadPdfNilgamutara(Long id, HttpServletResponse response);

	byte[] downloadPdfICard(Long id, HttpServletResponse response);
}
