package com.techweaversys.service;

import org.springframework.http.ResponseEntity;

import com.techweaversys.dto.OccupationDto;
import com.techweaversys.dto.OccupationSpecDto;

public interface OccupationService {

	ResponseEntity<?> saveOccupation(OccupationDto  occupationDto);

	ResponseEntity<?> getByIdOccupation(Long id);

	ResponseEntity<?> findAllOccupation();

	ResponseEntity<?> deleteOccupationById(Long id);

	ResponseEntity<?> findAllwithpage(OccupationSpecDto dto);

}
