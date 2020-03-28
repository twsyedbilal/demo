package com.techweaversys.service;

import org.springframework.http.ResponseEntity;

import com.techweaversys.dto.ExamDto;
import com.techweaversys.dto.ExameSpec;
import com.techweaversys.spec.ExamSpec;

public interface ExamService {

	ResponseEntity<?> saveData(ExamDto dto);

	ResponseEntity<?> getDataById(Long id);

	ResponseEntity<?> findAllData();

	ResponseEntity<?> DeletById(Long id);

	ResponseEntity<?> findAllwithpage(ExameSpec dto);

	ResponseEntity<?> getByclassId(Long id);

}
