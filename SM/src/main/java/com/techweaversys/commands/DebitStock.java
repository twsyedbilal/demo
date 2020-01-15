package com.techweaversys.commands;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.techweaversys.dto.DebitSlaveDto;
import com.techweaversys.dto.LibraryStockDto;
import com.techweaversys.model.LibraryStock;
import com.techweaversys.repository.LibraryStockRepository;

@Component
@Transactional
public class DebitStock implements Client {

	@Autowired
	private LibraryStockRepository libraryStockRepository;

	@Override
	public void execute(List<LibraryStockDto> t) {

		for (LibraryStockDto s : t) {
			Optional<LibraryStock> stockop;
			stockop = libraryStockRepository.findOneByBookId(s.getBook().getId());
			if (stockop.isPresent()) {

				LibraryStock stock = libraryStockRepository.findByBookId(s.getBook().getId());
				DebitSlaveDto dsDto = new DebitSlaveDto();
				dsDto.setGivenQty(s.getGivenQty());
				dsDto.setReturnQty(s.getReturnQty());

				Double givenSet = s.getGivenQty();
				stock.setGivenQty(givenSet);				
				Double returnSet = s.getReturnQty();
				stock.setReturnQty(returnSet);

				Double sqty = stock.getStockQty();
				Double remainStock = ( sqty - givenSet ) + returnSet;

				stock.setStockQty(remainStock);
				stock.setStockIn(0);
				libraryStockRepository.save(stock);
				

			}
		}
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub

	}

}
