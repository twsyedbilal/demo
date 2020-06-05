package com.techweaversys.service;

import org.springframework.http.ResponseEntity;

public interface CommonService {

	ResponseEntity<?> getCountryList();

	ResponseEntity<?> getStateList(Long countryId);

	ResponseEntity<?> getCityList(Long stateId);

	ResponseEntity<?> getCountryById(Long id);

	ResponseEntity<?> getStateById(Long id);

	ResponseEntity<?> getCityById(Long id);

	ResponseEntity<?> findAllState();
}
