package com.techweaversys.conv;

import com.google.common.base.Function;
import com.techweaversys.dto.BookDto;
import com.techweaversys.model.Book;

public class BookDtoConvertor implements Function<Book, BookDto> {

	@Override
	public BookDto apply(Book bb) {
		BookDto b=new BookDto();
		
		b.setname(bb.getBookName());
		b.setcode(bb.getBookCode());
		b.setId(bb.getId());
		return b;
	}

	
	
}
