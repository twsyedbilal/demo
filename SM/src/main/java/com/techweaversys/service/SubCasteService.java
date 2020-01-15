package com.techweaversys.service;

import org.springframework.http.ResponseEntity;

import com.techweaversys.dto.SubCasteDto;
import com.techweaversys.dto.SubCasteSpecDto;

public interface SubCasteService {

	ResponseEntity<?> saveSubCaste(SubCasteDto subCasteDto);

	ResponseEntity<?> getByIdSubCaste(Long id);

	ResponseEntity<?> findAllSubCaste();

	ResponseEntity<?> deleteSubCasteById(Long id);

	ResponseEntity<?> findAllwithpage(SubCasteSpecDto dto);

}
