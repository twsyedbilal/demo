package com.techweaversys.service;

import org.springframework.http.ResponseEntity;

import com.techweaversys.dto.AttendanceDto;
import com.techweaversys.dto.AttendanceSpaceDto;

public interface AttendanceService {

	ResponseEntity<?> create(AttendanceDto dto);

	ResponseEntity<?> getDataById(Long id);

	ResponseEntity<?> findAllData();

	ResponseEntity<?> DeletById(Long id);

	ResponseEntity<?> findAllwithpage(AttendanceSpaceDto dto);

	ResponseEntity<?> findByClassId(Long id);
}
