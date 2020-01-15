package com.techweaversys.serviceimpl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.xmlpull.v1.XmlPullParserException;

import io.minio.MinioClient;
import io.minio.errors.ErrorResponseException;
import io.minio.errors.InsufficientDataException;
import io.minio.errors.InternalException;
import io.minio.errors.InvalidArgumentException;
import io.minio.errors.InvalidBucketNameException;
import io.minio.errors.InvalidEndpointException;
import io.minio.errors.InvalidPortException;
import io.minio.errors.NoResponseException;
import io.minio.errors.RegionConflictException;

@Service
public class MinioImpl {
	
	private MinioClient s3client;

	@Value("${spring.minio.url}")
	private String endpointUrl;
	@Value("${spring.minio.bucket}")
	private String bucketName;
	@Value("${spring.minio.access-key}")
	private String accessKey;
	@Value("${spring.minio.secret-key}")
	private String secretKey;

	@PostConstruct
	private void initializeAmazon() throws InvalidEndpointException, InvalidPortException {
		this.s3client = new MinioClient(endpointUrl, accessKey, secretKey);
	}

	public String uploadFile(MultipartFile multipartFile) {
		String fileUrl = "";
		try {
			File file = convertMultiPartToFile(multipartFile);

			String fileName = generateFileName(multipartFile);
			fileUrl = endpointUrl + "/" + bucketName + "/" + fileName;
			uploadFileTos3bucket(fileName, multipartFile);
			file.delete();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fileUrl;
	}
	private File convertMultiPartToFile(MultipartFile file) throws IOException {
		File convFile = new File(file.getOriginalFilename());
		FileOutputStream fos = new FileOutputStream(convFile);
		fos.write(file.getBytes());
		fos.close();
		return convFile;
	}

	private String generateFileName(MultipartFile multiPart) {
		return new Date().getTime() + "-" + multiPart.getOriginalFilename().replace(" ", "_");
	}

	@SuppressWarnings("deprecation")
	private void uploadFileTos3bucket(String fileName, MultipartFile file) throws RegionConflictException {
		try {
			
			if(!s3client.bucketExists("alrizwancloud")) {
				s3client.makeBucket("alrizwancloud");
            }
			s3client.putObject("alrizwancloud", file.getOriginalFilename(), file.getInputStream(), file.getContentType());			
			System.out.println("uploaded into miniocloud");
		} catch (InvalidKeyException | InvalidBucketNameException | NoSuchAlgorithmException | NoResponseException
				| ErrorResponseException | InternalException | InvalidArgumentException | InsufficientDataException
				| IOException | XmlPullParserException e) {
			e.printStackTrace();
		}
	}

}
