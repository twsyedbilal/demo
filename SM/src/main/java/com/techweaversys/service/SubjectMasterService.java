package com.techweaversys.service;

import org.springframework.http.ResponseEntity;

import com.techweaversys.dto.SubjectMasterDto;
import com.techweaversys.dto.SubjectMasterSpaceDto;

public interface SubjectMasterService {

	ResponseEntity<?> create(SubjectMasterDto dto);

	ResponseEntity<?> getById(Long id);

	//ResponseEntity<?> findAllData();

	ResponseEntity<?> deletedById(Long id);

	ResponseEntity<?> getSubjectByClass(Long classid);

	ResponseEntity<?> findAllwithpage(SubjectMasterSpaceDto dto);
}
