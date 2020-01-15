package com.techweaversys.service;

import org.springframework.http.ResponseEntity;

import com.techweaversys.dto.AcountFeeDto;
import com.techweaversys.dto.AcountFeeSpaceDto;

public interface AcountFeeService {

	ResponseEntity<?> saveData(AcountFeeDto dto);

	ResponseEntity<?> getDataById(Long id);

	ResponseEntity<?> findAllData();

	ResponseEntity<?> DeletById(Long id);

	ResponseEntity<?> findAllwithpage(AcountFeeSpaceDto dto);


}
