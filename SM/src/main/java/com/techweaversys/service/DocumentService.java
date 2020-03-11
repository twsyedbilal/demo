package com.techweaversys.service;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface DocumentService {

	public ResponseEntity<?> upload(MultipartFile file) throws IOException;

	public ResponseEntity<byte[]> getImageData(Long id) throws Exception;

	public ResponseEntity<byte[]> getPdfData(Long id) throws Exception;

	public ResponseEntity<?> getDocumentData(Long id) throws Exception;

	public ResponseEntity<?> deletefile(Long id);

}
