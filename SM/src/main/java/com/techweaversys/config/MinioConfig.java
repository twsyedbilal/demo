package com.techweaversys.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.minio.MinioClient;
import io.minio.errors.InvalidEndpointException;
import io.minio.errors.InvalidPortException;

@Configuration
public class MinioConfig {

	@Bean(name="minioClient")
	public MinioClient minioClient() throws InvalidEndpointException, InvalidPortException {

		return new MinioClient("http://localhost:9000","minioadmin", "minioadmin");
	}
}
