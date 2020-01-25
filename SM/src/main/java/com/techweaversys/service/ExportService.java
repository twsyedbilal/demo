package com.techweaversys.service;

import javax.servlet.http.HttpServletResponse;

public interface ExportService {

	byte[] downloadPdfBonoFide(Long id, HttpServletResponse response);

	byte[] downloadPdfIdCardFront(Long id, HttpServletResponse response);

	byte[] downloadPdfIdCardBack(Long id, HttpServletResponse response);

	byte[] downloadPdfBfByBirth(Long id, HttpServletResponse response);

	byte[] downloadPdfBfByJr(Long id, HttpServletResponse response);

	byte[] downloadPdfBfByScience(Long id, HttpServletResponse response);

	byte[] downloadPdfBfBySchoolRecord(Long id, HttpServletResponse response);

	byte[] downloadPdfBfBySchoolWas(Long id, HttpServletResponse response);


}
