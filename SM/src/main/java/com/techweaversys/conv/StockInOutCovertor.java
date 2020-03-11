package com.techweaversys.conv;

import java.util.function.Function;

import com.techweaversys.dto.BookDto;
import com.techweaversys.dto.StockInOutDto;
import com.techweaversys.model.StockInOut;

public class StockInOutCovertor implements Function<StockInOut, StockInOutDto> {

	@Override
	public StockInOutDto apply(StockInOut i) {
		StockInOutDto dto = new StockInOutDto();
		dto.setId(i.getId());
		dto.setQty(i.getQty());
		dto.setReason(i.getReason());
		dto.setStockin(i.getStockin());
		dto.setStockout(i.getStockout());
		dto.setType(i.getType());
		dto.setBookId(i.getBook().getId());
		if(i.getBook()!=null && i.getBook().getId()!=null) {
			BookDto it = new BookDto();
			it.setcode(i.getBook().getcode());
			it.setId(i.getBook().getId());
			it.setname(i.getBook().getname());
			dto.setBook(it);
		}
		return dto;
	}

}
