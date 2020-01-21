package com.techweaversys.serviceimpl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.lowagie.text.DocumentException;
import com.techweaversys.model.Address;
import com.techweaversys.model.Admission;
import com.techweaversys.model.Document;
import com.techweaversys.repository.AdmissionRepository;
import com.techweaversys.repository.DocumentRepository;
import com.techweaversys.service.ExportService;

@Service
@Transactional
public class ExportServiceImpl implements ExportService {

	@Autowired
	private TemplateEngine templateEngine;

	@Autowired
	private Environment environment;

	@Autowired
	private AdmissionRepository admissionRepository;

	@Autowired
	private DocumentRepository documentRepository;

	/*
	 * @Value("${app.photo}") private String path=" ";
	 * 
	 * public String getPath() { return path; } public void setPath(String path) {
	 * this.path = path; }
	 */

	@Override
	public byte[] downloadPdfIdCardFront(Long id, HttpServletResponse response) {
		Admission admission = admissionRepository.getOne(id);

		String firstname = admission.getStudentsName();
		String fathersName = admission.getFathersName();
		String surName = admission.getSurName();
		String studentsName = surName +" "+ firstname;
		String path="http://localhost:9000/alrizwancloud/bb.jpg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=minioadmin%2F20200121%2F%2Fs3%2Faws4_request&X-Amz-Date=20200121T073727Z&X-Amz-Expires=432000&X-Amz-SignedHeaders=host&X-Amz-Signature=a6b3b9cbc626fffa12a06313e16c8a5e95b0f1b566d384be41b60dc33480ad54";
				
		if (admission.getDocument() != null) {
			for (Document doc : admission.getDocument()) { 
				if (doc.getId() != null) { 
				doc = documentRepository.getOne(doc.getId());
				path =doc.getPath();					
				}
			}
		}
//		String idurl = environment.getRequiredProperty(path);
		String idCover = environment.getRequiredProperty("idcardfront.print.image") + "idfront.png";
		String className = admission.getClassOffered().getClassName();
	
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		Context context = new Context();
		context.setVariable("header", idCover);
		context.setVariable("printDto", admission);
		context.setVariable("studentsName", studentsName);
		context.setVariable("fathersName", fathersName);
		context.setVariable("className", className);
		context.setVariable("photoUrl", path);
			
		String html = templateEngine.process("idcardfront", context);
		ITextRenderer renderer = new ITextRenderer();

		renderer.setDocumentFromString(html);
		renderer.layout();

		try {
			renderer.createPDF(bos, false);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		renderer.finishPDF();
		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "attachment; filename=" + "idFront_" + admission.getStudentRegNo() + ".pdf");
		try {
			response.getOutputStream().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bos.toByteArray();
	}
		
	@Override
	public byte[] downloadPdfIdCardBack(Long id, HttpServletResponse response) {

		Admission admission = admissionRepository.getOne(id);
		Calendar dob = admission.getDateOfBirth();
		String contactNo = admission.getContactNo();
		
		String academicYear = "2020-2021";
		List<Address> address = admission.getAddress();

		String idBack = environment.getRequiredProperty("idcardfront.print.image") + "idbackDesign.png";
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		Context context = new Context();
		context.setVariable("header", idBack);
		context.setVariable("dob", dob);
		context.setVariable("contactNo", contactNo);
		context.setVariable("academicYear", academicYear);
//		context.setVariable("address", address);

		String html = templateEngine.process("idcardback", context);
		ITextRenderer renderer = new ITextRenderer();

		renderer.setDocumentFromString(html);
		renderer.layout();

		try {
			renderer.createPDF(bos, false);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		renderer.finishPDF();
		response.setContentType("application/pdf");
		try {
			response.getOutputStream().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bos.toByteArray();

	}

	@Override
	public byte[] downloadPdfBonoFide(Long id, HttpServletResponse response) {
		Admission admission = admissionRepository.getOne(id);
		
		String bonafideheader = environment.getRequiredProperty("bonafideheader.print.image") + "bfheaderSchool.png";
		String className = admission.getClassOffered().getClassName();

		DateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
		String bonoFideDate = dateFormat.format(admission.getCreated().getTime());
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		Context context = new Context();

		context.setVariable("bonafideheader", bonafideheader);
		context.setVariable("date", bonoFideDate);	

		String html = templateEngine.process("bfschoolrecord", context);
		ITextRenderer renderer = new ITextRenderer();

		renderer.setDocumentFromString(html);
		renderer.layout();

		try {
			renderer.createPDF(bos, false);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		renderer.finishPDF();
		response.setContentType("application/pdf");
//		response.setHeader("Content-Disposition", "attachment; filename=" + "bonafide_" + admission.getStudentRegNo() + ".pdf");
		try {
			response.getOutputStream().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bos.toByteArray();
	}

}
