package com.techweaversys.serviceimpl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

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
import com.techweaversys.model.Caste;
import com.techweaversys.model.City;
import com.techweaversys.model.Compliant;
import com.techweaversys.model.Country;
import com.techweaversys.model.Document;
import com.techweaversys.model.MotherTongueEntity;
import com.techweaversys.model.NationalityEntity;
import com.techweaversys.model.Religion;
import com.techweaversys.model.State;
import com.techweaversys.repository.AddressRepository;
import com.techweaversys.repository.AdmissionRepository;
import com.techweaversys.repository.DocumentRepository;
import com.techweaversys.service.ExportService;
import com.techweaversys.utility.Constants;

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

	@Autowired
	private AddressRepository addressRepository;

	@Override
	public byte[] downloadPdfIdCardFront(Long id, HttpServletResponse response) {
		Admission admission = admissionRepository.getOne(id);

		String firstname = admission.getStudentsName();
		String fathersName = admission.getFathersName();
		String surName = admission.getSurName();
		String studentsName = surName + " " + firstname;
		String path = "http://localhost:9000/alrizwancloud/bb.jpg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=minioadmin%2F20200121%2F%2Fs3%2Faws4_request&X-Amz-Date=20200121T073727Z&X-Amz-Expires=432000&X-Amz-SignedHeaders=host&X-Amz-Signature=a6b3b9cbc626fffa12a06313e16c8a5e95b0f1b566d384be41b60dc33480ad54";

		if (admission.getDocument() != null) {
			for (Document doc : admission.getDocument()) {
				if (doc.getId() != null) {
					doc = documentRepository.getOne(doc.getId());
					path = doc.getPath();
				}
			}
		}

		String idCover = environment.getRequiredProperty("idcardfront.print.image") + "idfront.png";
		String className = admission.getClassOffered().getClassName();

		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		Context context = new Context();
		context.setVariable("header", idCover);
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
		response.setHeader("Content-Disposition",
				"attachment; filename=" + "idFront_" + admission.getStudentRegNo() + ".pdf");
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
		String contactNo = admission.getContactNo();
		String addressdetail = "";

		if (admission.getAddress() != null) {
			for (Address add : admission.getAddress()) {
				if (add.getId() != null) {
					add = addressRepository.getOne(add.getId());
					addressdetail = add.getDetailAddress();
				}
			}
		}

		Calendar birthdate = admission.getDateOfBirth();
		Date indate = birthdate.getTime();

		String dateString = null;
		SimpleDateFormat sdfr = new SimpleDateFormat("dd.MMM.yyyy");
		dateString = sdfr.format(indate);

		LocalDate now = LocalDate.now();
		int yearInt = now.getYear();
		String yearString = Integer.toString(yearInt);
		yearInt++;
		String academicYear = yearString + "-" + yearInt++;

		String idBack = environment.getRequiredProperty("idcardfront.print.image") + "idback.jpg";
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		Context context = new Context();
		context.setVariable("header", idBack);
		context.setVariable("dob", dateString);
		context.setVariable("contactNo", contactNo);
		context.setVariable("academicYear", academicYear);
		context.setVariable("address", addressdetail);

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
		response.setHeader("Content-Disposition",
				"attachment; filename=" + "idback_" + admission.getStudentRegNo() + ".pdf");
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

		Calendar birthdate = admission.getDateOfBirth();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMM yyyy");
		Date indate = birthdate.getTime();

		String dateString = null;
		SimpleDateFormat sdfr = new SimpleDateFormat("dd MMM yyyy");
		dateString = sdfr.format(indate);

		String firstname = admission.getStudentsName();
		String surName = admission.getSurName();
		String studentsName = surName + " " + firstname;
		String fatherName = admission.getFathersName();
		String birthinwords = admission.getDateOfBirthInWords();

		String path = "http://localhost:9000/alrizwancloud/bb.jpg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=minioadmin%2F20200121%2F%2Fs3%2Faws4_request&X-Amz-Date=20200121T073727Z&X-Amz-Expires=432000&X-Amz-SignedHeaders=host&X-Amz-Signature=a6b3b9cbc626fffa12a06313e16c8a5e95b0f1b566d384be41b60dc33480ad54";

		if (admission.getDocument() != null) {
			for (Document doc : admission.getDocument()) {
				if (doc.getId() != null) {
					doc = documentRepository.getOne(doc.getId());
					path = doc.getPath();
				}
			}
		}

		LocalDate now = LocalDate.now();
		String date = dtf.format(now);
		ByteArrayOutputStream bos = new ByteArrayOutputStream();

		Context context = new Context();
		context.setVariable("bonafideheader", bonafideheader);
		context.setVariable("date", date);
		context.setVariable("name", studentsName);
		context.setVariable("fatherName", fatherName);
		context.setVariable("className", className);
		context.setVariable("birthdate", dateString);
		context.setVariable("birthinwords", birthinwords);
		context.setVariable("path", path);

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
		response.setHeader("Content-Disposition",
				"attachment; filename=" + "bonafide_" + admission.getStudentsName() + ".pdf");
		try {
			response.getOutputStream().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bos.toByteArray();
	}

	@Override
	public byte[] downloadPdfBfByBirth(Long id, HttpServletResponse response) {
		Admission admission = admissionRepository.getOne(id);

		String bonafideheader = environment.getRequiredProperty("bonafideheader.print.image") + "bfheaderSchool.png";
		String className = admission.getClassOffered().getClassName();

		Calendar birthdate = admission.getDateOfBirth();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMM yyyy");
		Date indate = birthdate.getTime();

		String dateString = null;
		SimpleDateFormat sdfr = new SimpleDateFormat("dd MMM yyyy");
		dateString = sdfr.format(indate);

		String firstname = admission.getStudentsName();
		String surName = admission.getSurName();
		String studentsName = surName + " " + firstname;
		String fatherName = admission.getFathersName();
		String birthinwords = admission.getDateOfBirthInWords();

		String path = "http://localhost:9000/alrizwancloud/bb.jpg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=minioadmin%2F20200121%2F%2Fs3%2Faws4_request&X-Amz-Date=20200121T073727Z&X-Amz-Expires=432000&X-Amz-SignedHeaders=host&X-Amz-Signature=a6b3b9cbc626fffa12a06313e16c8a5e95b0f1b566d384be41b60dc33480ad54";

		if (admission.getDocument() != null) {
			for (Document doc : admission.getDocument()) {
				if (doc.getId() != null) {
					doc = documentRepository.getOne(doc.getId());
					path = doc.getPath();
				}
			}
		}

		LocalDate now = LocalDate.now();
		String date = dtf.format(now);
		ByteArrayOutputStream bos = new ByteArrayOutputStream();

		Context context = new Context();
		context.setVariable("bonafideheader", bonafideheader);
		context.setVariable("date", date);
		context.setVariable("name", studentsName);
		context.setVariable("fatherName", fatherName);
		context.setVariable("className", className);
		context.setVariable("birthdate", dateString);
		context.setVariable("birthinwords", birthinwords);
		context.setVariable("path", path);

		String html = templateEngine.process("bfbirth", context);
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
		response.setHeader("Content-Disposition",
				"attachment; filename=" + "bonafide_" + admission.getStudentsName() + ".pdf");
		try {
			response.getOutputStream().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bos.toByteArray();
	}

	@Override
	public byte[] downloadPdfBfByJr(Long id, HttpServletResponse response) {
		Admission admission = admissionRepository.getOne(id);

		String bonafideheader = environment.getRequiredProperty("bonafideheader.print.image") + "bfcollege.png";
		String className = admission.getClassOffered().getClassName();

		Calendar birthdate = admission.getDateOfBirth();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMM yyyy");
		Date indate = birthdate.getTime();

		String dateString = null;
		SimpleDateFormat sdfr = new SimpleDateFormat("dd MMM yyyy");
		dateString = sdfr.format(indate);

		String firstname = admission.getStudentsName();
		String surName = admission.getSurName();
		String studentsName = surName + " " + firstname;
		String fatherName = admission.getFathersName();
		String birthinwords = admission.getDateOfBirthInWords();
		String addNo = admission.getStudentRegNo();

		String path = "http://localhost:9000/alrizwancloud/bb.jpg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=minioadmin%2F20200121%2F%2Fs3%2Faws4_request&X-Amz-Date=20200121T073727Z&X-Amz-Expires=432000&X-Amz-SignedHeaders=host&X-Amz-Signature=a6b3b9cbc626fffa12a06313e16c8a5e95b0f1b566d384be41b60dc33480ad54";

		if (admission.getDocument() != null) {
			for (Document doc : admission.getDocument()) {
				if (doc.getId() != null) {
					doc = documentRepository.getOne(doc.getId());
					path = doc.getPath();
				}
			}
		}

		LocalDate now = LocalDate.now();
		String date = dtf.format(now);
		int yearInt = now.getYear();
		String yearString = Integer.toString(yearInt);
		yearInt++;
		String academicyear = yearString + "-" + yearInt++;

		ByteArrayOutputStream bos = new ByteArrayOutputStream();

		Context context = new Context();
		context.setVariable("bonafideheader", bonafideheader);
		context.setVariable("date", date);
		context.setVariable("name", studentsName);
		context.setVariable("fatherName", fatherName);
		context.setVariable("className", className);
		context.setVariable("birthdate", dateString);
		context.setVariable("birthinwords", birthinwords);
		context.setVariable("path", path);
		context.setVariable("academicyear", academicyear);
		context.setVariable("addNo", addNo);

		String html = templateEngine.process("bfcollege", context);
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
		response.setHeader("Content-Disposition",
				"attachment; filename=" + "bonafide_jr_" + admission.getStudentsName() + ".pdf");
		try {
			response.getOutputStream().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bos.toByteArray();
	}

	@Override
	public byte[] downloadPdfBfByAddScience(Long id, HttpServletResponse response) {
		Admission admission = admissionRepository.getOne(id);

		String bonafideheader = environment.getRequiredProperty("bonafideheader.print.image") + "science.png";
		String className = admission.getClassOffered().getClassName();

		Calendar birthdate = admission.getDateOfBirth();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMM yyyy");
		Date indate = birthdate.getTime();

		String dateString = null;
		SimpleDateFormat sdfr = new SimpleDateFormat("dd MMM yyyy");
		dateString = sdfr.format(indate);

		String firstname = admission.getStudentsName();
		String surName = admission.getSurName();
		String studentsName = surName + " " + firstname;
		String fatherName = admission.getFathersName();
		String birthinwords = admission.getDateOfBirthInWords();
		String addNo = admission.getStudentRegNo();

		String path = "http://localhost:9000/alrizwancloud/bb.jpg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=minioadmin%2F20200121%2F%2Fs3%2Faws4_request&X-Amz-Date=20200121T073727Z&X-Amz-Expires=432000&X-Amz-SignedHeaders=host&X-Amz-Signature=a6b3b9cbc626fffa12a06313e16c8a5e95b0f1b566d384be41b60dc33480ad54";

		if (admission.getDocument() != null) {
			for (Document doc : admission.getDocument()) {
				if (doc.getId() != null) {
					doc = documentRepository.getOne(doc.getId());
					path = doc.getPath();
				}
			}
		}

		LocalDate now = LocalDate.now();
		String date = dtf.format(now);
		int yearInt = now.getYear();
		String yearString = Integer.toString(yearInt);
		yearInt++;
		String academicyear = yearString + "-" + yearInt++;

		ByteArrayOutputStream bos = new ByteArrayOutputStream();

		Context context = new Context();
		context.setVariable("bonafideheader", bonafideheader);
		context.setVariable("date", date);
		context.setVariable("name", studentsName);
		context.setVariable("fatherName", fatherName);
		context.setVariable("className", className);
		context.setVariable("birthdate", dateString);
		context.setVariable("birthinwords", birthinwords);
		context.setVariable("path", path);
		context.setVariable("addNo", addNo);
		context.setVariable("academicyear", academicyear);

		String html = templateEngine.process("bfscience", context);
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
		response.setHeader("Content-Disposition",
				"attachment; filename=" + "bonafide_science_" + admission.getStudentsName() + ".pdf");
		try {
			response.getOutputStream().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bos.toByteArray();

	}

	@Override
	public byte[] downloadPdfBfBySchoolRecord(Long id, HttpServletResponse response) {
		Admission admission = admissionRepository.getOne(id);

		String bonafideheader = environment.getRequiredProperty("bonafideheader.print.image") + "science.png";
		String className = admission.getClassOffered().getClassName();

		Calendar birthdate = admission.getDateOfBirth();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMM yyyy");
		Date indate = birthdate.getTime();

		String dateString = null;
		SimpleDateFormat sdfr = new SimpleDateFormat("dd MMM yyyy");
		dateString = sdfr.format(indate);

		String firstname = admission.getStudentsName();
		String surName = admission.getSurName();
		String studentsName = surName + " " + firstname;
		String fatherName = admission.getFathersName();
		String birthinwords = admission.getDateOfBirthInWords();
		String addNo = admission.getStudentRegNo();

		String path = "http://localhost:9000/alrizwancloud/bb.jpg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=minioadmin%2F20200121%2F%2Fs3%2Faws4_request&X-Amz-Date=20200121T073727Z&X-Amz-Expires=432000&X-Amz-SignedHeaders=host&X-Amz-Signature=a6b3b9cbc626fffa12a06313e16c8a5e95b0f1b566d384be41b60dc33480ad54";

		if (admission.getDocument() != null) {
			for (Document doc : admission.getDocument()) {
				if (doc.getId() != null) {
					doc = documentRepository.getOne(doc.getId());
					path = doc.getPath();
				}
			}
		}

		LocalDate now = LocalDate.now();
		String date = dtf.format(now);
		int yearInt = now.getYear();
		String yearString = Integer.toString(yearInt);
		yearInt++;
		String academicyear = yearString + "-" + yearInt++;

		ByteArrayOutputStream bos = new ByteArrayOutputStream();

		Context context = new Context();
		context.setVariable("bonafideheader", bonafideheader);
		context.setVariable("date", date);
		context.setVariable("name", studentsName);
		context.setVariable("fatherName", fatherName);
		context.setVariable("className", className);
		context.setVariable("birthdate", dateString);
		context.setVariable("birthinwords", birthinwords);
		context.setVariable("path", path);
		context.setVariable("addNo", addNo);
		context.setVariable("academicyear", academicyear);

		String html = templateEngine.process("bfc5", context);
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
		response.setHeader("Content-Disposition",
				"attachment; filename=" + "bonafide_science_" + admission.getStudentsName() + ".pdf");
		try {
			response.getOutputStream().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bos.toByteArray();
	}

	@Override
	public byte[] downloadPdfBfBySchoolWas(Long id, HttpServletResponse response) {
		Admission admission = admissionRepository.getOne(id);

		String bonafideheader = environment.getRequiredProperty("bonafideheader.print.image") + "science.png";
		String className = admission.getClassOffered().getClassName();

		Calendar birthdate = admission.getDateOfBirth();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMM yyyy");
		Date indate = birthdate.getTime();

		String dateString = null;
		SimpleDateFormat sdfr = new SimpleDateFormat("dd MMM yyyy");
		dateString = sdfr.format(indate);

		String firstname = admission.getStudentsName();
		String surName = admission.getSurName();
		String studentsName = surName + " " + firstname;
		String fatherName = admission.getFathersName();
		String birthinwords = admission.getDateOfBirthInWords();

		String path = "http://localhost:9000/alrizwancloud/bb.jpg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=minioadmin%2F20200121%2F%2Fs3%2Faws4_request&X-Amz-Date=20200121T073727Z&X-Amz-Expires=432000&X-Amz-SignedHeaders=host&X-Amz-Signature=a6b3b9cbc626fffa12a06313e16c8a5e95b0f1b566d384be41b60dc33480ad54";

		if (admission.getDocument() != null) {
			for (Document doc : admission.getDocument()) {
				if (doc.getId() != null) {
					doc = documentRepository.getOne(doc.getId());
					path = doc.getPath();
				}
			}
		}

		LocalDate now = LocalDate.now();
		String date = dtf.format(now);
		int yearInt = now.getYear();
		String yearString = Integer.toString(yearInt);
		yearInt++;
		String academicyear = yearString + "-" + yearInt++;

		ByteArrayOutputStream bos = new ByteArrayOutputStream();

		Context context = new Context();
		context.setVariable("bonafideheader", bonafideheader);
		context.setVariable("date", date);
		context.setVariable("name", studentsName);
		context.setVariable("fatherName", fatherName);
		context.setVariable("className", className);
		context.setVariable("birthdate", dateString);
		context.setVariable("birthinwords", birthinwords);
		context.setVariable("path", path);
		context.setVariable("academicyear", academicyear);

		String html = templateEngine.process("bf7", context);
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
		response.setHeader("Content-Disposition",
				"attachment; filename=" + "bonafide_was_" + admission.getStudentsName() + ".pdf");
		try {
			response.getOutputStream().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bos.toByteArray();
	}

	@Override
	public byte[] downloadPdfBfByScience(Long id, HttpServletResponse response) {
		Admission admission = admissionRepository.getOne(id);

		String bonafideheader = environment.getRequiredProperty("bonafideheader.print.image") + "science.png";
		String className = admission.getClassOffered().getClassName();

		Calendar birthdate = admission.getDateOfBirth();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMM yyyy");
		Date indate = birthdate.getTime();

		String dateString = null;
		SimpleDateFormat sdfr = new SimpleDateFormat("dd MMM yyyy");
		dateString = sdfr.format(indate);

		String firstname = admission.getStudentsName();
		String surName = admission.getSurName();
		String studentsName = surName + " " + firstname;
		String fatherName = admission.getFathersName();
		String birthinwords = admission.getDateOfBirthInWords();

		String path = "http://localhost:9000/alrizwancloud/bb.jpg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=minioadmin%2F20200121%2F%2Fs3%2Faws4_request&X-Amz-Date=20200121T073727Z&X-Amz-Expires=432000&X-Amz-SignedHeaders=host&X-Amz-Signature=a6b3b9cbc626fffa12a06313e16c8a5e95b0f1b566d384be41b60dc33480ad54";

		if (admission.getDocument() != null) {
			for (Document doc : admission.getDocument()) {
				if (doc.getId() != null) {
					doc = documentRepository.getOne(doc.getId());
					path = doc.getPath();
				}
			}
		}

		LocalDate now = LocalDate.now();
		String date = dtf.format(now);
		int yearInt = now.getYear();
		String yearString = Integer.toString(yearInt);
		yearInt++;
		String academicyear = yearString + "-" + yearInt++;

		ByteArrayOutputStream bos = new ByteArrayOutputStream();

		Context context = new Context();
		context.setVariable("bonafideheader", bonafideheader);
		context.setVariable("date", date);
		context.setVariable("name", studentsName);
		context.setVariable("fatherName", fatherName);
		context.setVariable("className", className);
		context.setVariable("birthdate", dateString);
		context.setVariable("birthinwords", birthinwords);
		context.setVariable("path", path);
		context.setVariable("academicyear", academicyear);

		String html = templateEngine.process("bf6", context);
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
		response.setHeader("Content-Disposition",
				"attachment; filename=" + "bonafide_science_" + admission.getStudentsName() + ".pdf");
		try {
			response.getOutputStream().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bos.toByteArray();
	}
	
	@Override
	public byte[] downloadPdfPrimaryTc(Long id, HttpServletResponse response) {
		Admission admission = admissionRepository.getOne(id);

		String s = admission.getStudentsName();
		String m = admission.getMothersName();
		String f = admission.getFathersName();
		String studentid = admission.getIdNo();
		Caste caste = admission.getCaste();
		String idno = admission.getIdNo();
		Religion religion = admission.getReligion();
		String placeofbirth = admission.getPlaceOfBirth();
		NationalityEntity nationality = admission.getNationality();
		String dateofbirthinwords = admission.getDateOfBirthInWords();
		Class<? extends Admission> classs = admission.getClass();
		String rgno = admission.getStudentRegNo();
		Long uidno = admission.getUidNo();
		 String placeofbirths=admission.getPlaceOfBirth();
		Calendar dateofadmission = admission.getDate();
		MotherTongueEntity mother_tongue = admission.getMotherTongue();

		Country country = new Country();
		String c = country.getCountryName();

		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		Context context = new Context();
		context.setVariable("placeOfBirth", placeofbirths);
		context.setVariable("studentRegNo", rgno);
		context.setVariable("studentsName", s);
		context.setVariable("mothersName", m);
		context.setVariable("fathersName", m);
		context.setVariable("fathersName", m);
		context.setVariable("casteName", caste);
		context.setVariable("idNo", idno);
		context.setVariable("religion", religion);
		context.setVariable("nationality", nationality);
		context.setVariable("dateOfBirthInWords", dateofbirthinwords);
		context.setVariable("name", mother_tongue);
		context.setVariable("uidNo", uidno);
		context.setVariable("countryName", c);

		context.setVariable("date", dateofadmission);

		context.setVariable("fathersName", m);
		context.setVariable("casteName", caste);
		context.setVariable("idNo", idno);

		String html = templateEngine.process("primary_school_tc", context);
		String htmll = templateEngine.process("high_school", context);

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
		// response.setHeader("Content-Disposition", "attachment; filename=" +
		// "SaleOrder_" + sqt.getOrderno() + ".pdf");
		try {
			response.getOutputStream().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bos.toByteArray();
	}

	@Override
	public byte[] downloadPdfHighSchoolTc(Long id, HttpServletResponse response) {
		Admission admission = admissionRepository.getOne(id);

		String s = admission.getStudentsName();
		String m = admission.getMothersName();
		String f = admission.getFathersName();
		String studentid = admission.getIdNo();
		Caste caste = admission.getCaste();
		String idno = admission.getIdNo();
		Religion religion = admission.getReligion();
		String placeofbirth = admission.getPlaceOfBirth();
		NationalityEntity nationality = admission.getNationality();
		String dateofbirthinwords = admission.getDateOfBirthInWords();
		Class<? extends Admission> classs = admission.getClass();
		String rgno = admission.getStudentRegNo();
		Long uidno = admission.getUidNo();

		Calendar dateofadmission = admission.getDate();
		MotherTongueEntity mother_tongue = admission.getMotherTongue();

		Country country = new Country();
		String c = country.getCountryName();

		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		Context context = new Context();
		context.setVariable("studentRegNo", rgno);
		context.setVariable("studentsName", s);
		context.setVariable("mothersName", m);
		context.setVariable("fathersName", m);
		context.setVariable("fathersName", m);
		context.setVariable("casteName", caste);
		context.setVariable("idNo", idno);
		context.setVariable("religion", religion);
		context.setVariable("nationality", nationality);
		context.setVariable("dateOfBirthInWords", dateofbirthinwords);
		context.setVariable("name", mother_tongue);
		context.setVariable("uidNo", uidno);
		context.setVariable("countryName", c);

		context.setVariable("date", dateofadmission);

		context.setVariable("fathersName", m);
		context.setVariable("casteName", caste);
		context.setVariable("idNo", idno);
	//	context.setVariable("m1",Constants.tchighschoolM);

		String html = templateEngine.process("high_school", context);

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
		// response.setHeader("Content-Disposition", "attachment; filename=" +
		// "SaleOrder_" + sqt.getOrderno() + ".pdf");
		try {
			response.getOutputStream().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bos.toByteArray();
	}

	@Override
	public byte[] downloadPdfJrCollegeTc(Long id, HttpServletResponse response) {
		Admission admission = admissionRepository.getOne(id);

		String s = admission.getStudentsName();
		String m = admission.getMothersName();
		String f = admission.getFathersName();
		String studentid = admission.getIdNo();
		Caste caste = admission.getCaste();
		String idno = admission.getIdNo();
		Religion religion = admission.getReligion();
		String placeofbirth = admission.getPlaceOfBirth();
		NationalityEntity nationality = admission.getNationality();
		String dateofbirthinwords = admission.getDateOfBirthInWords();
		Class<? extends Admission> classs = admission.getClass();
		String rgno = admission.getStudentRegNo();
		Long uidno = admission.getUidNo();
		  String placeofb=admission.getPlaceOfBirth();
		Calendar dateofadmission = admission.getDate();
		MotherTongueEntity mother_tongue = admission.getMotherTongue();
		
		Address ad=new Address();
      City city=   ad.getCity();
      
    
        State state= ad.getState();
        Country country=ad.getCountry();
        Compliant Compliant=new Compliant();
         String remark= Compliant.getRemark();
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		Context context = new Context();
		context.setVariable("city", city);
		context.setVariable("satate", state);
		context.setVariable("country", country);
		context.setVariable("remark", remark);
		
		context.setVariable("placeOfBirth", placeofb);
		context.setVariable("studentRegNo", rgno);
		context.setVariable("studentsName", s);
		context.setVariable("mothersName", m);
		context.setVariable("fathersName", m);
		context.setVariable("fathersName", m);
		context.setVariable("casteName", caste);
		context.setVariable("idNo", idno);
		context.setVariable("religion", religion);
		context.setVariable("nationality", nationality);
		context.setVariable("dateOfBirthInWords", dateofbirthinwords);
		context.setVariable("name", mother_tongue);
		context.setVariable("uidNo", uidno);
		

		context.setVariable("date", dateofadmission);

		context.setVariable("fathersName", m);
		context.setVariable("casteName", caste);
		context.setVariable("idNo", idno);
		
		String html = templateEngine.process("jr_college_tc", context);

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
		// response.setHeader("Content-Disposition", "attachment; filename=" +
		// "SaleOrder_" + sqt.getOrderno() + ".pdf");
		try {
			response.getOutputStream().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bos.toByteArray();
	}

	@Override
	public byte[] downloadPdfNilgamutara(Long id, HttpServletResponse response) {
		Admission admission = admissionRepository.getOne(id);

		String s = admission.getStudentsName();
		String m = admission.getMothersName();
		String f = admission.getFathersName();
		String studentid = admission.getIdNo();
		Caste caste = admission.getCaste();
		String idno = admission.getIdNo();
		Religion religion = admission.getReligion();
		String placeofbirth = admission.getPlaceOfBirth();
		NationalityEntity nationality = admission.getNationality();
		String dateofbirthinwords = admission.getDateOfBirthInWords();
		Class<? extends Admission> classs = admission.getClass();
		String rgno = admission.getStudentRegNo();
		Long uidno = admission.getUidNo();

		Calendar dateofadmission = admission.getDate();
		MotherTongueEntity mother_tongue = admission.getMotherTongue();

		Country country = new Country();
		String c = country.getCountryName();

		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		Context context = new Context();
		context.setVariable("studentRegNo", rgno);
		context.setVariable("studentsName", s);
		context.setVariable("mothersName", m);
		context.setVariable("fathersName", m);
		context.setVariable("fathersName", m);
		context.setVariable("casteName", caste);
		context.setVariable("idNo", idno);
		context.setVariable("religion", religion);
		context.setVariable("nationality", nationality);
		context.setVariable("dateOfBirthInWords", dateofbirthinwords);
		context.setVariable("name", mother_tongue);
		context.setVariable("uidNo", uidno);
		context.setVariable("countryName", c);

		context.setVariable("date", dateofadmission);

		context.setVariable("fathersName", m);
		context.setVariable("casteName", caste);
		context.setVariable("idNo", idno);
	//	context.setVariable("m1",Constants.tchighschoolM);

		String html = templateEngine.process("NilgamUtarapdf", context);

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
		// response.setHeader("Content-Disposition", "attachment; filename=" +
		// "SaleOrder_" + sqt.getOrderno() + ".pdf");
		try {
			response.getOutputStream().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bos.toByteArray();
	}
	}



