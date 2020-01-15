package com.techweaversys.service;

import org.springframework.http.ResponseEntity;

public interface CommonService {

	ResponseEntity<?> getCountryList();

	ResponseEntity<?> getStateList(Long countryId);

	ResponseEntity<?> getCityList(Long stateId);

}
