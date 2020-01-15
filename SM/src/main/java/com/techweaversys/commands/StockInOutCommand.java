package com.techweaversys.commands;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.techweaversys.dto.LibraryStockDto;
import com.techweaversys.model.Book;
import com.techweaversys.model.LibraryStock;
import com.techweaversys.repository.BookRepository;
import com.techweaversys.repository.LibraryStockRepository;
import com.techweaversys.repository.StockInOutRepository;

@Component
@Transactional
public class StockInOutCommand implements Client {

	@Autowired
	private LibraryStockRepository libraryStockRepository;

	@Autowired
	private StockInOutRepository stockInOutRepository;
	
	/*
	 * public void setStockInOutCommand(StockInOutRepository stockInOutRepository) {
	 * this.stockInOutRepository = stockInOutRepository; }
	 */

	@Autowired
	ModelMapper modelMapper;

	@Autowired
	private BookRepository bookRepository;

	@Override
	public void execute(List<LibraryStockDto> t) {

		for (LibraryStockDto s : t) {
			Optional<LibraryStock> stockop;
			stockop = libraryStockRepository.findOneByBookId(s.getBook().getId());
			if (stockop.isPresent()) {
				LibraryStock stock = libraryStockRepository.findByBookId(s.getBook().getId());
				stock.setStockOut(s.getStockOut());
				Double returnbook = stock.getReturnQty();
				Double stockinForIn = s.getStockIn();

				double stockIn = stockInOutRepository.getSumofStockInByBookId(s.getBook().getId());
				Double systemIn = returnbook + stockIn; 
				
				stock.setGivenQty(0);
				Double given = stock.getGivenQty();
				double stockOut = stockInOutRepository.getSumofStockOutByBookId(s.getBook().getId());
				Double systemOut = stockOut + given;

				Double finalStock = systemIn - systemOut;
				stock.setStockQty(finalStock);
				stock.setStockIn(stockinForIn);
				libraryStockRepository.save(stock);
			} else {
				LibraryStock stock = new LibraryStock();
				Book book = bookRepository.getOne(s.getBook().getId());
				stock.setBook(book);
				if (s.getStockIn() > 0) {
					stock.setStockIn(s.getStockIn());
					stock.setStockQty(s.getStockIn());
					stock.setStockOut(s.getStockOut());
				} else {
					stock.setStockOut(s.getStockOut());
					stock.setStockQty(s.getStockOut());
					stock.setStockIn(s.getStockIn());
				}
				libraryStockRepository.save(stock);
			}
		}

	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub

	}

}
