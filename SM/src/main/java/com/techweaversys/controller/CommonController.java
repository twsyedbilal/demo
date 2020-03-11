package com.techweaversys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techweaversys.service.CommonService;

@RestController
@RequestMapping("rest/api/")
public class CommonController {

	@Autowired
	private CommonService commonService;

	@GetMapping(value = "country")
	public ResponseEntity<?> listCountry() {
		return commonService.getCountryList();
	}

	@GetMapping(value = "state/{countryId}")
	public ResponseEntity<?> listStates(@PathVariable Long countryId) {
		return commonService.getStateList(countryId);
	}

	@GetMapping(value = "city/{stateId}")
	public ResponseEntity<?> listCity(@PathVariable Long stateId) {
		return commonService.getCityList(stateId);
	}

	@GetMapping(value = "getcountry/{id}")
	public ResponseEntity<?> getCountryById(@PathVariable Long id) {
		return commonService.getCountryById(id);
	}

	@GetMapping(value = "getstate/{id}")
	public ResponseEntity<?> getStateById(@PathVariable Long id) {
		return commonService.getStateById(id);
	}

	@GetMapping(value = "getcity/{id}")
	public ResponseEntity<?> getCityById(@PathVariable Long id) {
		return commonService.getCityById(id);
	}

}
