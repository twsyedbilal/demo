package com.techweaversys.conv;

import com.google.common.base.Function;
import com.techweaversys.dto.BookDto;
import com.techweaversys.dto.OpeningStockDto;
import com.techweaversys.model.OpeningStock;

public class OpeningStockConv implements Function<OpeningStock, OpeningStockDto>{

	/*
	 * @Autowired private ModelMapper modelMapper;
	 */
	
	@Override
	public OpeningStockDto apply(OpeningStock i) {
		OpeningStockDto dto =new OpeningStockDto();
		dto.setId(i.getId());
		dto.setOpeningDate(i.getOpeningDate());
		dto.setOpeningQty(i.getOpeningQty());
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
