
package com.techweaversys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techweaversys.dto.DebitBookDto;
import com.techweaversys.service.DebitCreditService;

@RestController
@RequestMapping("/rest/api/debitcredit/")
public class DebitCreditController {

	@Autowired
	private DebitCreditService librayService;

	@PostMapping(value = "create")
	public ResponseEntity<?> create(@RequestBody DebitBookDto adDto) {
		return librayService.create(adDto);
	}

	@GetMapping(value = "getbyiddebit/{id}")
	public ResponseEntity<?> getByIdDebit(@PathVariable Long id) {
		return librayService.getByIdDebit(id);
	}

	@GetMapping(value = "getbyidcrebit/{id}")
	public ResponseEntity<?> getByIdCredit(@PathVariable Long id) {
		return librayService.getByIdCredit(id);
	}

	@GetMapping(value = "finddebitbook")
	public ResponseEntity<?> findAlDebitBook() {
		return librayService.findAlDebitBook();
	}

	@GetMapping(value = "findcreditbook")
	public ResponseEntity<?> findAlCreditBook() {
		return librayService.findAlCreditBook();
	}

	@GetMapping(value = "deletebyid/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id) {
		return librayService.deleteById(id);
	}
}
