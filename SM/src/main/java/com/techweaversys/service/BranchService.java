package com.techweaversys.service;

import org.springframework.http.ResponseEntity;

import com.techweaversys.dto.BranchDto;
import com.techweaversys.dto.BranchSpacedto;


public interface BranchService {
	
	ResponseEntity<?> saveData(BranchDto dto);

	ResponseEntity<?> getDataById(Long id);

	ResponseEntity<?> findAllData();

	ResponseEntity<?> DeletById(Long id);


	ResponseEntity<?> findAllwithpage(BranchSpacedto dto);


}