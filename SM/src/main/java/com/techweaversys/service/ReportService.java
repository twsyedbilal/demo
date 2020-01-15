package com.techweaversys.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.techweaversys.dto.ReportSpaceDto;

@Service
public interface ReportService  {

	ResponseEntity<?> findAllwithpage(ReportSpaceDto reportDto);

}
