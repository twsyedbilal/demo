package com.techweaversys.commands;

import java.util.List;

import com.techweaversys.dto.LibraryStockDto;

public interface Client {
	void execute(List<LibraryStockDto> t);
    void undo();
}
