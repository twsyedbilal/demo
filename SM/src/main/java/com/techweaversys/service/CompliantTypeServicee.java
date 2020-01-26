package com.techweaversys.service;

import org.springframework.http.ResponseEntity;

import com.techweaversys.dto.CompliantTypeDtobject;
import com.techweaversys.dto.CompliantTypespceDto;

public interface CompliantTypeServicee {

	ResponseEntity<?> createData(CompliantTypeDtobject compliantDto);

	ResponseEntity<?> findAllData();

	ResponseEntity<?> getDataById(Long id);

	ResponseEntity<?> DeletById(Long id);

	ResponseEntity<?> findAllwithpage(CompliantTypespceDto dto);

}
