package com.techweaversys.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techweaversys.dto.AttendanceDto;
import com.techweaversys.dto.AttendanceSpaceDto;
import com.techweaversys.service.AttendanceService;

@RestController
@RequestMapping("/rest/api/attendance/")
public class AttendanceController {

	@Autowired
	private AttendanceService attendanceService;

	@PostMapping(value = "create")
	public ResponseEntity<?> create(@RequestBody AttendanceDto dto) {
		return attendanceService.create(dto);

	}

	@GetMapping(value = "getbyid/{id}")
	public ResponseEntity<?> getDataById(@PathVariable Long id) {
		return attendanceService.getDataById(id);

	}

	@GetMapping(value = "findall")
	public ResponseEntity<?> findAlData() {
		return attendanceService.findAllData();

	}

	@GetMapping(value = "deletebyid/{id}")
	public ResponseEntity<?> DeletById(@PathVariable Long id) {
		return attendanceService.DeletById(id);

	}

	@PostMapping(value = "findAllwithpage")
	public ResponseEntity<?> findAllwithpage(@RequestBody AttendanceSpaceDto dto) {
		return attendanceService.findAllwithpage(dto);

	}

	@GetMapping(value = "getclassbyid/{id}")
	public ResponseEntity<?> findByClassId(@PathVariable Long id) {
		return attendanceService.findByClassId(id);

	}

	@GetMapping(value = "getbyadmissionid/{id}")
	public ResponseEntity<?> findByAdmissionId(@PathVariable Long id) {
		return attendanceService.findByAdmissionId(id);

	}

	@GetMapping(value = "getbydate/{date}")
	public ResponseEntity<?> findByDate(@PathVariable Calendar date) {
		return attendanceService.findByDate(date);

	}

	@PostMapping(value = "createlist")
	public List<ResponseEntity<?>> saveMultipleRecord(@RequestBody List<AttendanceDto> attendanceDtoList) {
		List<ResponseEntity<?>> saveM = null;
		saveM = new ArrayList<ResponseEntity<?>>();
		for (AttendanceDto attendanceDto : attendanceDtoList) {
			ResponseEntity<?> res = attendanceService.create(attendanceDto);
			saveM.add(res);
		}
		return saveM;
	}
}
