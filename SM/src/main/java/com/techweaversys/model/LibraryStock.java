package com.techweaversys.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.techweaversys.generics.AbstractPersistable;

@Entity
@Table(name = "sm_stock")
@Where(clause = "deleted=false")
public class LibraryStock extends AbstractPersistable {

	private static final long serialVersionUID = 8205701543714605103L;

	@Column(name = "stock_qty")
	private double stockQty;

	@Column(name = "stock_in")
	private double stockIn;

	@Column(name = "stock_out")
	private double stockOut;

	@Column(name = "given_qty")
	private double givenQty;

	@Column(name = "return_qty")
	private double returnQty;

	@Column(name = "opening_qty")
	private double openingQty;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "book_id")
	@JsonIgnore
	@NotFound(action = NotFoundAction.IGNORE)
	private Book book;

	public LibraryStock() {
		super();
	}

	public LibraryStock(double stockQty, double stockIn, double stockOut, double givenQty, double returnQty,
			double openingQty, Book book) {
		super();
		this.stockQty = stockQty;
		this.stockIn = stockIn;
		this.stockOut = stockOut;
		this.givenQty = givenQty;
		this.returnQty = returnQty;
		this.openingQty = openingQty;
		this.book = book;
	}

	public double getStockQty() {
		return stockQty;
	}

	public void setStockQty(double stockQty) {
		this.stockQty = stockQty;
	}

	public double getStockIn() {
		return stockIn;
	}

	public void setStockIn(double stockIn) {
		this.stockIn = stockIn;
	}

	public double getStockOut() {
		return stockOut;
	}

	public void setStockOut(double stockOut) {
		this.stockOut = stockOut;
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

	public double getOpeningQty() {
		return openingQty;
	}

	public void setOpeningQty(double openingQty) {
		this.openingQty = openingQty;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((book == null) ? 0 : book.hashCode());
		long temp;
		temp = Double.doubleToLongBits(givenQty);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(openingQty);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(returnQty);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(stockIn);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(stockOut);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(stockQty);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		LibraryStock other = (LibraryStock) obj;
		if (book == null) {
			if (other.book != null)
				return false;
		} else if (!book.equals(other.book))
			return false;
		if (Double.doubleToLongBits(givenQty) != Double.doubleToLongBits(other.givenQty))
			return false;
		if (Double.doubleToLongBits(openingQty) != Double.doubleToLongBits(other.openingQty))
			return false;
		if (Double.doubleToLongBits(returnQty) != Double.doubleToLongBits(other.returnQty))
			return false;
		if (Double.doubleToLongBits(stockIn) != Double.doubleToLongBits(other.stockIn))
			return false;
		if (Double.doubleToLongBits(stockOut) != Double.doubleToLongBits(other.stockOut))
			return false;
		if (Double.doubleToLongBits(stockQty) != Double.doubleToLongBits(other.stockQty))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LibraryStock [stockQty=" + stockQty + ", stockIn=" + stockIn + ", stockOut=" + stockOut + ", givenQty="
				+ givenQty + ", returnQty=" + returnQty + ", openingQty=" + openingQty + ", book=" + book + "]";
	}

}
