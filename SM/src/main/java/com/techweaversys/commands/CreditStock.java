package com.techweaversys.commands;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.techweaversys.dto.LibraryStockDto;
import com.techweaversys.model.LibraryStock;
import com.techweaversys.repository.CreditSlaveRepository;
import com.techweaversys.repository.LibraryStockRepository;

@Component
@Transactional
public class CreditStock implements Client {

	@Autowired
	private LibraryStockRepository libraryStockRepository;

	@Autowired
	private CreditSlaveRepository creditSlaveRepository;

	@Override
	public void execute(List<LibraryStockDto> t) {

		for (LibraryStockDto s : t) {
			Optional<LibraryStock> stockop;
			stockop = libraryStockRepository.findOneByBookId(s.getBook().getId());
			if (stockop.isPresent()) {

				LibraryStock stock = libraryStockRepository.findByBookId(s.getBook().getId());

				Double stockTotalQty = stock.getStockQty();
				Double openingStock = stock.getOpeningQty();

				double creditQuantity = creditSlaveRepository.getSumReturnQtyByBookId(s.getBook().getId());
				Double stockIn = stock.getStockIn();
				Double finalGiven = stockTotalQty + openingStock + creditQuantity + stockIn;

				Double returnQty = stock.getReturnQty();

				Double debitQty = stock.getStockIn();
				Double stockOut = stock.getStockOut();
				Double finalReturn = returnQty + debitQty + stockOut;

				Double finalStock = finalGiven - finalReturn;
				stock.setStockQty(finalStock);
				stock.setReturnQty(returnQty);
				libraryStockRepository.save(stock);

			}
		}

	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub

	}

}
