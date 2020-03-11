package com.techweaversys.dto;

import java.util.Calendar;

public class OpeningStockDto {

	private Long id;
	private double openingQty;
	private Calendar openingDate;
	private BookDto book;

	public OpeningStockDto() {
		super();
	}

	public OpeningStockDto(Long id, double openingQty, Calendar openingDate, BookDto book) {
		super();
		this.id = id;
		this.openingQty = openingQty;
		this.openingDate = openingDate;
		this.book = book;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getOpeningQty() {
		return openingQty;
	}

	public void setOpeningQty(double openingQty) {
		this.openingQty = openingQty;
	}

	public Calendar getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(Calendar openingDate) {
		this.openingDate = openingDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((book == null) ? 0 : book.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((openingDate == null) ? 0 : openingDate.hashCode());
		long temp;
		temp = Double.doubleToLongBits(openingQty);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OpeningStockDto other = (OpeningStockDto) obj;
		if (book == null) {
			if (other.book != null)
				return false;
		} else if (!book.equals(other.book))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (openingDate == null) {
			if (other.openingDate != null)
				return false;
		} else if (!openingDate.equals(other.openingDate))
			return false;
		if (Double.doubleToLongBits(openingQty) != Double.doubleToLongBits(other.openingQty))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OpeningStockDto [id=" + id + ", openingQty=" + openingQty + ", openingDate=" + openingDate + ", book="
				+ book + "]";
	}

	public BookDto getBook() {
		return book;
	}

	public void setBook(BookDto book) {
		this.book = book;
	}

}
