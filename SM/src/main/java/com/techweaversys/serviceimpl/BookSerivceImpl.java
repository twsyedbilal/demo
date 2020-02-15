package com.techweaversys.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.techweaversys.conv.BookDtoConvertor;
import com.techweaversys.dto.BookDto;
import com.techweaversys.dto.BookSpaceDto;
import com.techweaversys.dto.PageDto;
import com.techweaversys.generics.AppConstants;
import com.techweaversys.generics.Code;
import com.techweaversys.generics.Messages;
import com.techweaversys.generics.Response;
import com.techweaversys.model.Book;
import com.techweaversys.repository.BookRepository;
import com.techweaversys.service.BookService;
import com.techweaversys.spec.BookSpec;

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

		bb.setname(dto.getname());
		bb.setcode(dto.getcode());
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

	@Override
	public ResponseEntity<?> findAllwithpage(BookSpaceDto dto) {
		logger.info("Showing list of book", dto);
		PageRequest pg = PageRequest.of(dto.getPage() - 1, dto.getSize(), Direction.DESC, AppConstants.MODIFIED);
		Page<Book> book = bookRepository.findAll(new BookSpec(dto.getname(),dto.getcode()), pg);
		List<BookDto> list = book.stream().map( new BookDtoConvertor() ).collect( Collectors.toList() );
		PageDto pageDto = new PageDto(list, book.getTotalElements());
		return Response.build(Code.OK, pageDto);
	}

	@Override
	public ResponseEntity<?> findbynamecode(String code) {
		logger.info("Showing list of book");
		List<Book> book = bookRepository.findAll(new BookSpec(code,code));
		List<BookDto> list = book.stream().map( new BookDtoConvertor() ).collect( Collectors.toList() );
		return Response.build(Code.OK, list);
	}
}