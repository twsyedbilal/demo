package com.techweaversys.service;

import org.springframework.http.ResponseEntity;

import com.techweaversys.dto.PhoneSectionDto;
import com.techweaversys.dto.PhoneSectionSpaceDto;

public interface PhoneSectionService {

	ResponseEntity<?> saveData(PhoneSectionDto pdto);

	ResponseEntity<?> findAllData();

	ResponseEntity<?> getDataById(Long id);

	ResponseEntity<?> DeletById(Long id);

	ResponseEntity<?> findAllwithpage(PhoneSectionSpaceDto phoneSectionSpaceDto);

}
