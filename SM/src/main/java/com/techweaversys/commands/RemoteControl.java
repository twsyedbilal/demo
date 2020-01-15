package com.techweaversys.commands;

import java.util.List;

import org.springframework.stereotype.Component;

import com.techweaversys.dto.LibraryStockDto;

@Component
public class RemoteControl {

	public void addstock(Client commandBase, List<LibraryStockDto> t) {
		// this.commandBase=commandBase;
		commandBase.execute(t);
	}

	public void removestock(Client commandBase, List<LibraryStockDto> t) {
		// this.commandBase=commandBase;
		commandBase.execute(t);
	}

	public void undo() {
		// commandBase.undo();
	}

}
