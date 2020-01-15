package com.techweaversys.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.techweaversys.dto.BucketOut;

public interface DocumentBucketService {

	BucketOut uploadFile(MultipartFile file);

	String deleteFileFromS3Bucket(String fileUrl);

	ResponseEntity<?> deleteFile(Long id);

	BucketOut uploadFileTest(MultipartFile file);
    
}
