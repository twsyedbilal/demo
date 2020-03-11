package com.techweaversys.model;

import java.util.Calendar;

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
@Table(name = "sm_opening_stock")
@Where(clause = "deleted=false")
public class OpeningStock extends AbstractPersistable {

	private static final long serialVersionUID = 4647420651456921420L;

	@Column(name = "opening_date", nullable = true)
	private Calendar openingDate;

	@Column(name = "opening_qty", nullable = true)
	private double openingQty;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "book_id")
	@JsonIgnore
	@NotFound(action = NotFoundAction.IGNORE)
	private Book book;

	public OpeningStock() {
		super();
	}

	public OpeningStock(Calendar openingDate, double openingQty, Book book) {
		super();
		this.openingDate = openingDate;
		this.openingQty = openingQty;
		this.book = book;
	}

	public Calendar getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(Calendar openingDate) {
		this.openingDate = openingDate;
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
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		OpeningStock other = (OpeningStock) obj;
		if (book == null) {
			if (other.book != null)
				return false;
		} else if (!book.equals(other.book))
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
		return "OpeningStock [openingDate=" + openingDate + ", openingQty=" + openingQty + ", book=" + book + "]";
	}

}
