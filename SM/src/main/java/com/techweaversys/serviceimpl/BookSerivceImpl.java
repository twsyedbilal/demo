package com.techweaversys.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.techweaversys.dto.BookDto;
import com.techweaversys.generics.Code;
import com.techweaversys.generics.Messages;
import com.techweaversys.generics.Response;
import com.techweaversys.model.Book;
import com.techweaversys.repository.BookRepository;
import com.techweaversys.service.BookService;

@Service
@Transactional
public class BookSerivceImpl implements BookService {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private BookRepository bookRepository;

	@Override
	public ResponseEntity<?> saveData(BookDto dto) {
		logger.info("Creating user: " + dto);
		Book bb = new Book();
		if (dto.getId() != null) {
			bb = bookRepository.getOne(dto.getId());
		}

		bb.setBookName(dto.getname());
		bb.setBookCode(dto.getcode());
		bookRepository.save(bb);

		return Response.build(Code.CREATED, Messages.USER_CREATED_MSG);
	}

	@Override
	public ResponseEntity<?> getDataById(@PathVariable Long id) {
		Optional<Book> bb = bookRepository.findById(id);
		return Response.build(Code.OK, bb);
	}

	@Override
	public ResponseEntity<?> findAllData() {
		List<Book> list = bookRepository.findAll();
		return Response.build(Code.OK, list);
	}

	@Override
	public ResponseEntity<?> DeletById(Long id) {
		Book bb = new Book();
		if (id != null) {
			bb = bookRepository.getOne(id);
			bb.setDeleted(true);
			bookRepository.save(bb);
		}

		return Response.build(Code.OK, Messages.DELETED);
	}

}