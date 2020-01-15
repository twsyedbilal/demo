package com.techweaversys.service;

import org.springframework.http.ResponseEntity;
import com.techweaversys.dto.DebitBookDto;

public interface DebitCreditService {

	ResponseEntity<?> create(DebitBookDto adDto);

	ResponseEntity<?> deleteById(Long id);

	ResponseEntity<?> getByIdDebit(Long id);

	ResponseEntity<?> getByIdCredit(Long id);

	ResponseEntity<?> findAlDebitBook();

	ResponseEntity<?> findAlCreditBook();

}
