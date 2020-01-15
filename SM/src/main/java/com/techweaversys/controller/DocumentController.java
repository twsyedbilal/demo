package com.techweaversys.controller;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.xmlpull.v1.XmlPullParserException;

import com.techweaversys.service.DocumentService;

import io.minio.errors.ErrorResponseException;
import io.minio.errors.InsufficientDataException;
import io.minio.errors.InternalException;
import io.minio.errors.InvalidArgumentException;
import io.minio.errors.InvalidBucketNameException;
import io.minio.errors.NoResponseException;

@RestController
@RequestMapping("/rest/api/document")
public class DocumentController {

	@Autowired
	private DocumentService documentService;

	@PostMapping("test")
	public ResponseEntity<?> testMinio(@RequestParam(value = "file") MultipartFile file) throws InvalidKeyException,
			InvalidBucketNameException, NoSuchAlgorithmException, InsufficientDataException, NoResponseException,
			ErrorResponseException, InternalException, InvalidArgumentException, IOException, XmlPullParserException {
		return documentService.testMinio(file);
	}

	@PostMapping("/upload")
	public ResponseEntity<?> upload(@RequestParam(value = "file") MultipartFile file) throws IOException {
		return documentService.upload(file);
	}

	@GetMapping("/image/{id}")
	public ResponseEntity<byte[]> getImageData(@PathVariable Long id) throws Exception {
		return documentService.getImageData(id);
	}

	@GetMapping("/pdf/{id}")
	public ResponseEntity<byte[]> getPdfData(@PathVariable Long id) throws Exception {
		return documentService.getPdfData(id);
	}

	@GetMapping("/docs/{id}")
	public ResponseEntity<?> getDocumentData(@PathVariable Long id) throws Exception {
		return documentService.getDocumentData(id);
	}

	@GetMapping("/delete/{id}")
	public ResponseEntity<?> deletefile(@PathVariable Long id) throws Exception {
		return documentService.deletefile(id);
	}
}
