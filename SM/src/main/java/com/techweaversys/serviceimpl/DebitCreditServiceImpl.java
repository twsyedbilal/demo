package com.techweaversys.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techweaversys.commands.DebitStock;
import com.techweaversys.commands.RemoteControl;
import com.techweaversys.conv.DebitBookConverter;
import com.techweaversys.dto.BookDto;
import com.techweaversys.dto.DebitBookDto;
import com.techweaversys.dto.DebitSlaveDto;
import com.techweaversys.dto.LibraryStockDto;
import com.techweaversys.generics.Code;
import com.techweaversys.generics.Messages;
import com.techweaversys.generics.Response;
import com.techweaversys.model.Admission;
import com.techweaversys.model.Book;
import com.techweaversys.model.DebitBook;
import com.techweaversys.model.DebitSlave;
import com.techweaversys.repository.AdmissionRepository;
import com.techweaversys.repository.BookRepository;
import com.techweaversys.repository.DebitBookRepository;
import com.techweaversys.repository.DebitSlaveRepository;
import com.techweaversys.service.DebitCreditService;
import com.techweaversys.utility.Constants;

@Service
@Transactional
public class DebitCreditServiceImpl implements DebitCreditService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private DebitBookRepository debitBookRepository;

	@Autowired
	private AdmissionRepository admissionRepository;

	@Autowired
	private DebitSlaveRepository debitSlaveRepository;

//	@Autowired
//	private CreditBookRepository creditBookRepository;

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private RemoteControl remoteControl;

	@Autowired
	private DebitStock debitStock;

	@Override
	public ResponseEntity<?> create(DebitBookDto debitBookDto) {

		DebitBook debitBook = new DebitBook();
		if (debitBookDto.getId() != null) {
			debitBook = debitBookRepository.getOne(debitBookDto.getId());
		}
		if (debitBookDto.getAdmission().getId() != null || debitBookDto.getAdmission() !=null) {
			Admission ad = admissionRepository.getOne(debitBookDto.getAdmission().getId());
			debitBook.setAdmission(ad);
		}

		debitBook.setType(debitBookDto.getType());

		List<DebitSlave> dbs = new ArrayList<>();
		List<LibraryStockDto> stock = new ArrayList<>();
		if (debitBookDto.getDebitSlave() != null) {

			for (DebitSlaveDto i : debitBookDto.getDebitSlave()) {
				LibraryStockDto st = new LibraryStockDto();
				DebitSlave s = new DebitSlave();

				if (i.getId() != null) {
					s = debitSlaveRepository.getOne(i.getId());
				}
				if (i.getBook() != null || i.getBook().getId() !=null) {
					Book book = bookRepository.getOne(i.getBook().getId());
					s.setBook(book);
					BookDto it = modelMapper.map(book, BookDto.class);
					st.setBook(it);
				}

//				if (i.getBook().getId() != null) {
//					Book book = bookRepository.getOne(i.getBookId());
//					s.setBook(book);
//					Book book = bookRepository.getOne(i.getBook().getId());
//					s.setBook(book);
//					BookDto it = modelMapper.map(book, BookDto.class);
//					st.setBook(it);
//				}
//				if (debitBookDto.getType().equals(Constants.DEBIT) || debitBookDto.getType().equals(Constants.CREDIT)) {
//					st.setGivenQty(i.getGivenQty());
//					st.setReturnQty(i.getReturnQty());
//				}
//
//				s.setGivenQty(i.getGivenQty());
//				s.setReturnQty(i.getReturnQty());
//				s.setQty(i.getQty());
//				s.setFromDate(i.getFromDate());
//				s.setToDate(i.getToDate());
//				s.setDebitBook(debitBook);
//
				if (debitBookDto.getType().equals(Constants.DEBIT)) {

					s.setReturnQty(0);
					s.setGivenQty(i.getQty());
					s.setFromDate(i.getFromDate());
					s.setToDate(i.getToDate());
					s.setDebitBook(debitBook);
					st.setGivenQty(i.getQty());
					st.setReturnQty(0);
				} else {
					s.setReturnQty(i.getQty());
					s.setGivenQty(0);
					s.setFromDate(i.getFromDate());
					s.setToDate(i.getToDate());
					s.setDebitBook(debitBook);
					st.setReturnQty(i.getQty());
					st.setGivenQty(0);

				}

				dbs.add(s);

				stock.add(st);
			}
			debitBook.setDebitSlave(dbs);

			debitBookRepository.save(debitBook);
			remoteControl.addstock(debitStock, stock);
		}
		return Response.build(Code.CREATED, Messages.DEBIT_BOOK_CREATED);
	}

	@Override
	public ResponseEntity<?> byBookId(Long id) {
		DebitSlave db = debitSlaveRepository.findByBookId(id);
		DebitSlaveDto dto = modelMapper.map(db, DebitSlaveDto.class);
		return Response.build(Code.OK, dto);
	}

	@Override
	public ResponseEntity<?> deleteById(Long id) {

		DebitBook debitBook = new DebitBook();
		if (id != null) {
			debitBook = debitBookRepository.getOne(id);
			debitBook.setDeleted(true);
			debitBookRepository.save(debitBook);
		}
		return Response.build(Code.OK, Messages.DELETED);
	}

	@Override
	public ResponseEntity<?> findAll() {
		List<DebitBook> list = debitBookRepository.findAll();
		List<DebitBookDto> dto = list.stream().map(new DebitBookConverter()).collect(Collectors.toList());
		return Response.build(Code.OK, dto);
	}

	@Override
	public ResponseEntity<?> getDebitCreditById(Long id) {
		DebitBook debitBook = debitBookRepository.getOne(id);
		DebitBookDto dto = modelMapper.map(debitBook, DebitBookDto.class);
		return Response.build(Code.OK, dto);
	}

	/*
	 * @Override public ResponseEntity<?> getByIdDebit(Long id) { DebitBook s =
	 * debitBookRepository.getOne(id); DebitBookDto dto = modelMapper.map(s,
	 * DebitBookDto.class); return Response.build(Code.OK, dto); }
	 * 
	 * @Override public ResponseEntity<?> getByIdCredit(Long id) { CreditBook s =
	 * creditBookRepository.getOne(id); CreditBookDto dto = modelMapper.map(s,
	 * CreditBookDto.class); return Response.build(Code.OK, dto); }
	 */

	/*
	 * @Override public ResponseEntity<?> findAlDebitBook() { List<DebitBook> list =
	 * debitBookRepository.findAll(); return Response.build(Code.OK, list); }
	 * 
	 * @Override public ResponseEntity<?> findAlCreditBook() { List<CreditBook> list
	 * = creditBookRepository.findAll(); return Response.build(Code.OK, list); }
	 */

}
