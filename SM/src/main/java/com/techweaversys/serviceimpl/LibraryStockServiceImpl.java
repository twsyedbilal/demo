package com.techweaversys.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techweaversys.commands.RemoteControl;
import com.techweaversys.commands.StockInOutCommand;
import com.techweaversys.dto.BookDto;
import com.techweaversys.dto.LibraryStockDto;
import com.techweaversys.dto.StockInOutDto;
import com.techweaversys.generics.Code;
import com.techweaversys.generics.Messages;
import com.techweaversys.generics.Response;
import com.techweaversys.model.Book;
import com.techweaversys.model.LibraryStock;
import com.techweaversys.model.StockInOut;
import com.techweaversys.repository.BookRepository;
import com.techweaversys.repository.LibraryStockRepository;
import com.techweaversys.repository.StockInOutRepository;
import com.techweaversys.service.LibraryStockService;
import com.techweaversys.utility.Constants;

@Service
@Transactional
public class LibraryStockServiceImpl implements LibraryStockService {

	@Autowired
	private StockInOutRepository stockInOutRepository;

	@Autowired
	private StockInOutCommand stockInOutCommand;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private LibraryStockRepository libraryStockRepository;

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private RemoteControl remoteControl;

	
	@Override
	public ResponseEntity<?> adjustStock(StockInOutDto dto) {

		StockInOut sio = new StockInOut();

		if (dto.getId() != null) {
			sio = stockInOutRepository.getOne(dto.getId());
		}
		Book i = bookRepository.getOne(dto.getBook().getId());
		sio.setBook(i);

		List<LibraryStockDto> stock = new ArrayList<>();
		for (int j = 0; j < 1; j++) {
			LibraryStockDto stockdto = new LibraryStockDto();
			BookDto it = modelMapper.map(i, BookDto.class);
			if (StringUtils.isNotEmpty(dto.getType())) {

				if (dto.getType().equals(Constants.STOCKIN)) {
					sio.setStockin(dto.getStockin());
					sio.setQty(dto.getQty());
					sio.setType(dto.getType());
					stockdto.setStockIn(sio.getStockin());


				} else {
					sio.setStockout(dto.getStockout());
					sio.setQty(dto.getQty());
					sio.setType(dto.getType());
					stockdto.setStockOut(dto.getStockout());
				}
				stockdto.setBook(it);
			}
			stock.add(stockdto);
		}
		sio.setReason(dto.getReason());

		stockInOutRepository.save(sio);
		remoteControl.addstock(stockInOutCommand, stock);

		return Response.build(Code.CREATED, Messages.STOCK_UPDATED);

	}

	@Override
	public ResponseEntity<?> byBookId(Long id) {
		LibraryStock stock = libraryStockRepository.findByBookId(id);
		LibraryStockDto dto = modelMapper.map(stock, LibraryStockDto.class);
		return Response.build(Code.OK, dto);
	}

	@Override
	public ResponseEntity<?> byStockInOut(Long id) {
		StockInOut stock = stockInOutRepository.getOne(id);
		StockInOutDto dto = modelMapper.map(stock, StockInOutDto.class);
		return Response.build(Code.OK, dto);
	}

}
