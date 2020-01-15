package com.techweaversys.dto;

import java.util.Calendar;

public class OpeningStockDto {

	private Long id;
	private double OpeningQty;
	private Calendar openingDate;
	private Long bookid;

	public OpeningStockDto() {
		super();
	}

	public OpeningStockDto(Long id, double openingQty, Calendar openingDate, Long bookid) {
		super();
		this.id = id;
		OpeningQty = openingQty;
		this.openingDate = openingDate;
		this.bookid = bookid;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getOpeningQty() {
		return OpeningQty;
	}

	public void setOpeningQty(double openingQty) {
		OpeningQty = openingQty;
	}

	public Calendar getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(Calendar openingDate) {
		this.openingDate = openingDate;
	}

	public Long getBookid() {
		return bookid;
	}

	public void setBookid(Long bookid) {
		this.bookid = bookid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(OpeningQty);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((bookid == null) ? 0 : bookid.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((openingDate == null) ? 0 : openingDate.hashCode());
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
		if (Double.doubleToLongBits(OpeningQty) != Double.doubleToLongBits(other.OpeningQty))
			return false;
		if (bookid == null) {
			if (other.bookid != null)
				return false;
		} else if (!bookid.equals(other.bookid))
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
		return true;
	}

	@Override
	public String toString() {
		return "OpeningStockDto [id=" + id + ", OpeningQty=" + OpeningQty + ", openingDate=" + openingDate + ", bookid="
				+ bookid + "]";
	}
}
