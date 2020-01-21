package com.techweaversys.service;

import javax.servlet.http.HttpServletResponse;

public interface ExportService {

	byte[] downloadPdfBonoFide(Long id, HttpServletResponse response);

	byte[] downloadPdfIdCardFront(Long id, HttpServletResponse response);

	byte[] downloadPdfIdCardBack(Long id, HttpServletResponse response);


}
