package com.techweaversys.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.techweaversys.dto.BucketOut;
import com.techweaversys.service.DocumentBucketService;


@RestController
@RequestMapping("/rest/api/storage/")
public class BucketController {
    
    @Autowired
    private DocumentBucketService documentBucketService;

    @PostMapping("uploadFile")
    public BucketOut uploadFile(@RequestPart(value = "file") MultipartFile file) {
        return documentBucketService.uploadFile(file);
    }

    @DeleteMapping("deleteFile")
    public String deleteFile(@RequestPart(value = "url") String fileUrl) {
        return documentBucketService.deleteFileFromS3Bucket(fileUrl);
    }
    
    @GetMapping("delete/{id}")
    public ResponseEntity<?> deleteWithRowId(@PathVariable Long id){
    	return documentBucketService.deleteFile(id);
    }
    @PostMapping("uploadtest")
    public BucketOut uploadFileTest(@RequestPart(value = "file") MultipartFile file) {
        return documentBucketService.uploadFileTest(file);
    }

    
}