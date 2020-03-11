package com.techweaversys.serviceimpl;

import java.io.IOException;
import java.util.Calendar;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.techweaversys.dto.DocumentDto;
import com.techweaversys.generics.Code;
import com.techweaversys.generics.Messages;
import com.techweaversys.generics.Response;
import com.techweaversys.generics.Utils;
import com.techweaversys.model.Document;
import com.techweaversys.repository.DocumentRepository;
import com.techweaversys.service.DocumentService;

@Service
@Transactional
public class DocumentServiceImpl implements DocumentService {

	@Autowired
	private DocumentRepository documentRepository;

	@Autowired
	private ModelMapper modelMapper;

	/*
	 * //@Autowired(required = true) // private MinioClient minioClient;
	 * 
	 * @Override public ResponseEntity<?> testMinio(MultipartFile file) throws
	 * IOException {
	 * 
	 * byte[] doc = file.getBytes();
	 * 
	 * Document document = new Document(); try { MinioClient minioClient = new
	 * MinioClient("http://localhost:9000","minioadmin", "minioadmin");
	 * 
	 * document.setName(file.getName());
	 * document.setFileName(file.getOriginalFilename());
	 * document.setFileType(file.getContentType());
	 * 
	 * boolean isExist = minioClient.bucketExists("alrizwancloud"); if(isExist) {
	 * System.out.println("Bucket already exists."); } else {
	 * minioClient.makeBucket("alrizwancloud"); }
	 * 
	 * String filename = file.getOriginalFilename(); // Upload the zip file to the
	 * bucket with putObject // minioClient.putObject("asiatrip","asiaphotos.zip",
	 * "/home/user/Photos/asiaphotos.zip"); minioClient.putObject("alrizwancloud",
	 * "doc","filename"); System.out.println(minioClient); } catch (Exception e) {
	 * 
	 * } documentRepository.save(document); DocumentDto dto = modelMapper.map(doc,
	 * DocumentDto.class); return Response.build(Code.CREATED,
	 * Messages.DOCUMENT_UPLOADED, dto); }
	 */

	@Override
	public ResponseEntity<?> upload(MultipartFile file) throws IOException {
		byte[] bytes = file.getBytes();
		Document doc = new Document();
		doc.setName(file.getName());
		doc.setDoc(bytes);
		doc.setFileName(file.getOriginalFilename());
		doc.setFileType(file.getContentType());
		doc.setStore("Database");
		doc.setUrl("http:");
		documentRepository.save(doc);
		DocumentDto dto = modelMapper.map(doc, DocumentDto.class);
		return Response.build(Code.CREATED, Messages.DOCUMENT_UPLOADED, dto);
	}

	@Override
	public ResponseEntity<byte[]> getImageData(Long id) throws Exception {
		Document doc = documentRepository.getOne(id);
		if (Utils.isNotEmpty(doc.getFileType()) && (doc.getFileType().equals(MediaType.IMAGE_JPEG_VALUE)
				|| doc.getFileType().equals(MediaType.IMAGE_PNG_VALUE))) {
			HttpHeaders headers = new HttpHeaders();
			headers.setLastModified(Calendar.getInstance().getTime().getTime());
			headers.setCacheControl("no-cache");
			headers.setContentType(MediaType.IMAGE_JPEG);
		    return new ResponseEntity<byte[]>(doc.getDoc(), headers, HttpStatus.OK);
		}
		return null;
	}

	@Override
	public ResponseEntity<byte[]> getPdfData(Long id) throws Exception {
		Document doc = documentRepository.getOne(id);
		if (Utils.isNotEmpty(doc.getFileType()) && (doc.getFileType().equals(MediaType.APPLICATION_PDF_VALUE))) {
			HttpHeaders headers = new HttpHeaders();
			headers.setLastModified(Calendar.getInstance().getTime().getTime());
			headers.setCacheControl("no-cache");
			headers.setContentType(MediaType.APPLICATION_PDF);
		    return new ResponseEntity<byte[]>(doc.getDoc(), headers, HttpStatus.OK);
		}
		return null;
	}

	@Override
	public ResponseEntity<?> getDocumentData(Long id) throws Exception {
		Document doc = documentRepository.getOne(id);
		if (doc == null) {
			return new ResponseEntity<>("{}", HttpStatus.NOT_FOUND);
		}

		// Generate the http headers with the file properties
		HttpHeaders headers = new HttpHeaders();
		headers.add("content-disposition", "attachment; filename=" + doc.getFileName());
		headers.setLastModified(Calendar.getInstance().getTime().getTime());
		headers.setCacheControl("no-cache");
		// Split the mimeType into primary and sub types
		String primaryType, subType;
		try {
			primaryType = doc.getFileType().split("/")[0];
			subType = doc.getFileType().split("/")[1];
		} catch (IndexOutOfBoundsException | NullPointerException ex) {
			return new ResponseEntity<>("{}", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		headers.setContentType(new MediaType(primaryType, subType));

		return new ResponseEntity<>(doc.getDoc(), headers, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> deletefile(Long id) {
		Document doc = documentRepository.getOne(id);
		if (doc == null) {
			return Response.build(Code.OK, Messages.NOT_FOUND);
		} else {
			doc.setDeleted(true);
			documentRepository.save(doc);
			return Response.build(Code.OK, Messages.DOCUMENT_DELETED);
		}
	}

}
