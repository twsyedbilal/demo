package com.techweaversys.service;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import org.xmlpull.v1.XmlPullParserException;

import io.minio.errors.ErrorResponseException;
import io.minio.errors.InsufficientDataException;
import io.minio.errors.InternalException;
import io.minio.errors.InvalidArgumentException;
import io.minio.errors.InvalidBucketNameException;
import io.minio.errors.NoResponseException;

public interface DocumentService {

	public ResponseEntity<?> upload(MultipartFile file) throws IOException;

	public ResponseEntity<byte[]> getImageData(Long id) throws Exception;

	public ResponseEntity<byte[]> getPdfData(Long id) throws Exception;

	public ResponseEntity<?> getDocumentData(Long id) throws Exception;

	public ResponseEntity<?> deletefile(Long id);

	public ResponseEntity<?> testMinio(MultipartFile file) throws InvalidKeyException, InvalidBucketNameException, NoSuchAlgorithmException, InsufficientDataException, NoResponseException, ErrorResponseException, InternalException, InvalidArgumentException, IOException, XmlPullParserException;
}
