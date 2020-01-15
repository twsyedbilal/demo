package com.techweaversys.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.techweaversys.commands.OpeningStockCommand;
import com.techweaversys.dto.BookDto;
import com.techweaversys.dto.LibraryStockDto;
import com.techweaversys.dto.OpeningStockDto;
import com.techweaversys.generics.Code;
import com.techweaversys.generics.Messages;
import com.techweaversys.generics.Response;
import com.techweaversys.model.Book;
import com.techweaversys.model.OpeningStock;
import com.techweaversys.repository.BookRepository;
import com.techweaversys.repository.OpeningStockRepository;
import com.techweaversys.service.OpeningStockService;
import com.techweaversys.utility.Constants;

@Service
@Transactional
public class OpeningStockServiceImpl implements OpeningStockService {

	@Autowired
	private OpeningStockRepository openingStockRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private OpeningStockCommand openingStockCommand;

	@Autowired
	private BookRepository bookRepository;

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public ResponseEntity<?> addOpeningStock(OpeningStockDto dto) {

		OpeningStock openingStock = new OpeningStock();

		if (dto.getId() != null) {
			openingStock = openingStockRepository.getOne(dto.getId());
		}
		Book book = bookRepository.getOne(dto.getBookid());
		openingStock.setBook(book);

		List<LibraryStockDto> stock = new ArrayList<>();
		LibraryStockDto stockdto = new LibraryStockDto();
		BookDto bookDto = modelMapper.map(book, BookDto.class);

		openingStock.setOpeningDate(dto.getOpeningDate());
		openingStock.setOpeningQty(dto.getOpeningQty());

		stockdto.setOpeningQty(dto.getOpeningQty());
		stockdto.setBook(bookDto);

		stock.add(stockdto);

		openingStockRepository.save(openingStock);
		openingStockCommand.execute(stock);
		return Response.build(Code.CREATED, Messages.OPENING_STOCK_CREATED);
	}

	@Override
	public ResponseEntity<?> getOpeningStock(Long id) {
		logger.info("Fetch Opening Stock  !");
		OpeningStock openingStock = openingStockRepository.getOne(id);
		OpeningStockDto dto = modelMapper.map(openingStock, OpeningStockDto.class);
		return Response.build(Code.OK, dto);
	}

	@Override
	public ResponseEntity<?> softDeletedOpenigStock(Long id) {
		logger.info("Soft delete Opening Stock !");
		OpeningStock openingStock = new OpeningStock();
		openingStock.setDeleted(Constants.SOFT_DELETE);
		openingStockRepository.save(openingStock);
		return Response.build(Code.OK, Messages.OPENING_STOCK_DELETED);
	}

}
