package com.techweaversys.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.techweaversys.dto.BucketOut;
import com.techweaversys.generics.Code;
import com.techweaversys.generics.Response;
import com.techweaversys.model.Document;
import com.techweaversys.repository.DocumentRepository;
import com.techweaversys.service.DocumentBucketService;

@Service
public class DocumentBucketServiceImpl implements DocumentBucketService {

	@Autowired
	private MinioC amazonClient;
	
	@Autowired
	private DocumentRepository documentBucketRepository;	

	@Override
	public BucketOut uploadFile(MultipartFile file) {	
		String path = amazonClient.uploadFile(file);	
		Document documentBucket = new Document();		
		documentBucket.setPath(path);
		documentBucket.setFileName(file.getOriginalFilename());
		documentBucket.setFileType(file.getContentType());
		documentBucket.setName(file.getName());
		documentBucket.setStore("Databse");
		documentBucketRepository.save(documentBucket);
		BucketOut out = new BucketOut();
		out.setRowId(documentBucket.getId());
		out.setPath(documentBucket.getPath());
		out.setFileType(documentBucket.getFileType());
		return out;
	}

	@Override
	public String deleteFileFromS3Bucket(String fileUrl) {
		String message = "";
		Boolean isDelete = amazonClient.deleteFileFromS3Bucket(fileUrl);
		 if(isDelete){
			 message = "UPLOADED";
		 } else {
			 message = "DELETED";
		 }
		return message;
	}

	@Override
	public ResponseEntity<?> deleteFile(Long id) {
		try{
			Document docBucket = documentBucketRepository.getOne(id);			
			Boolean isDelete = amazonClient.deleteFileFromS3Bucket(docBucket.getPath());
			if(isDelete){
			    docBucket.setDeleted(true);
			    documentBucketRepository.save(docBucket);
			    return Response.build(Code.OK, "SUCESS");
			}			
		} catch(Throwable e){
			e.printStackTrace();
		}				
		return Response.build(Code.BAD_GATEWAY, "");
	}

	@Autowired
	private MinioImpl minio;

	@Override
	public BucketOut uploadFileTest(MultipartFile file) {
		String path = minio.uploadFile(file);		
		Document docbuc = new Document();	
		docbuc.setPath(path);
		documentBucketRepository.save(docbuc);
		BucketOut bucketOut = new BucketOut();
		bucketOut.setRowId(docbuc.getId());
		bucketOut.setPath(docbuc.getPath());
		bucketOut.setFileType(docbuc.getFileType());
		return bucketOut;
	}

}
