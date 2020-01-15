package com.techweaversys.dto;

import java.util.Calendar;

public class CreditSlaveDto {

	private Long id;
	private double qty;
	private double givenQty;
	private double returnQty;
	private Calendar fromDate;
	private Calendar toDate;
	private Long bookId;
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
	public Long getBookId() {
		return bookId;
	}
	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	
}
