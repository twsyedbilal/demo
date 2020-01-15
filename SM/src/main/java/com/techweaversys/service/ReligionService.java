package com.techweaversys.service;

import org.springframework.http.ResponseEntity;

import com.techweaversys.dto.ReligionDto;
import com.techweaversys.dto.ReligionSpecDto;

public interface ReligionService {

	ResponseEntity<?> saveReligion(ReligionDto religionDto);

	ResponseEntity<?> getByIdReligion(Long id);

	ResponseEntity<?> findAllReligion();

	ResponseEntity<?> deletReligionById(Long id);

	ResponseEntity<?> findAllwithpage(ReligionSpecDto dto);

}
