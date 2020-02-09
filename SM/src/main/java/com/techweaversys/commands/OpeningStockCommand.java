package com.techweaversys.commands;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.techweaversys.dto.LibraryStockDto;
import com.techweaversys.dto.OpeningStockDto;
import com.techweaversys.model.LibraryStock;
import com.techweaversys.repository.LibraryStockRepository;

@Component
@Transactional
public class OpeningStockCommand implements Client {

	@Autowired
	private LibraryStockRepository libraryStockRepository;

	@Override
	public void execute(List<LibraryStockDto> t) {

		for (LibraryStockDto s : t) {
			Optional<LibraryStock> stockop;
			OpeningStockDto opDto = new OpeningStockDto();
			stockop = libraryStockRepository.findOneByBookId(s.getBook().getId());			
			if (stockop.isPresent()) {
				LibraryStock stock = libraryStockRepository.findByBookId(s.getBook().getId());
				opDto.setOpeningQty(s.getOpeningQty());
				stock.setOpeningQty(s.getOpeningQty());
				
				Double OpeningStock = s.getOpeningQty();
				Double availableStock = stock.getStockQty();				
				Double totalStock = OpeningStock + availableStock;				
				
				stock.setStockIn(0);
				stock.setStockOut(0);				
				stock.setReturnQty(0);
				stock.setStockQty(totalStock);
				stock.setOpeningQty(OpeningStock);
				libraryStockRepository.save(stock);
			}
		}

	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub

	}

}
