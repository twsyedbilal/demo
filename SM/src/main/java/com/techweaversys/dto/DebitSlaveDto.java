package com.techweaversys.dto;

import java.util.Calendar;

public class DebitSlaveDto {

	private Long id;
	private double qty;
	private double givenQty;
	private double returnQty;
	private Calendar fromDate;
	private Calendar toDate;
	private Long bookId;

	public DebitSlaveDto() {
		super();
	}

	public DebitSlaveDto(Long id, double qty, double givenQty, double returnQty, Calendar fromDate, Calendar toDate,
			Long bookId) {
		super();
		this.id = id;
		this.qty = qty;
		this.givenQty = givenQty;
		this.returnQty = returnQty;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.bookId = bookId;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getQty() {
		return qty;
	}

	public void setQty(double qty) {
		this.qty = qty;
	}

	public double getGivenQty() {
		return givenQty;
	}

	public void setGivenQty(double givenQty) {
		this.givenQty = givenQty;
	}

	public double getReturnQty() {
		return returnQty;
	}

	public void setReturnQty(double returnQty) {
		this.returnQty = returnQty;
	}

	public Calendar getFromDate() {
		return fromDate;
	}

	public void setFromDate(Calendar fromDate) {
		this.fromDate = fromDate;
	}

	public Calendar getToDate() {
		return toDate;
	}

	public void setToDate(Calendar toDate) {
		this.toDate = toDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookId == null) ? 0 : bookId.hashCode());
		result = prime * result + ((fromDate == null) ? 0 : fromDate.hashCode());
		long temp;
		temp = Double.doubleToLongBits(givenQty);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		temp = Double.doubleToLongBits(qty);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(returnQty);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((toDate == null) ? 0 : toDate.hashCode());
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
		DebitSlaveDto other = (DebitSlaveDto) obj;
		if (bookId == null) {
			if (other.bookId != null)
				return false;
		} else if (!bookId.equals(other.bookId))
			return false;
		if (fromDate == null) {
			if (other.fromDate != null)
				return false;
		} else if (!fromDate.equals(other.fromDate))
			return false;
		if (Double.doubleToLongBits(givenQty) != Double.doubleToLongBits(other.givenQty))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (Double.doubleToLongBits(qty) != Double.doubleToLongBits(other.qty))
			return false;
		if (Double.doubleToLongBits(returnQty) != Double.doubleToLongBits(other.returnQty))
			return false;
		if (toDate == null) {
			if (other.toDate != null)
				return false;
		} else if (!toDate.equals(other.toDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DebitSlaveDto [id=" + id + ", qty=" + qty + ", givenQty=" + givenQty + ", returnQty=" + returnQty
				+ ", fromDate=" + fromDate + ", toDate=" + toDate + ", bookId=" + bookId + "]";
	}

}
