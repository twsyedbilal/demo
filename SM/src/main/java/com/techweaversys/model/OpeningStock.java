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
	private double OpeningQty;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "book_id")
	@JsonIgnore
	@NotFound(action = NotFoundAction.IGNORE)
	private Book Book;

	public OpeningStock() {
		super();
	}

	public OpeningStock(Calendar openingDate, double openingQty, com.techweaversys.model.Book book) {
		super();
		this.openingDate = openingDate;
		OpeningQty = openingQty;
		Book = book;
	}

	public Calendar getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(Calendar openingDate) {
		this.openingDate = openingDate;
	}

	public double getOpeningQty() {
		return OpeningQty;
	}

	public void setOpeningQty(double openingQty) {
		OpeningQty = openingQty;
	}

	public Book getBook() {
		return Book;
	}

	public void setBook(Book book) {
		Book = book;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((Book == null) ? 0 : Book.hashCode());
		long temp;
		temp = Double.doubleToLongBits(OpeningQty);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((openingDate == null) ? 0 : openingDate.hashCode());
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
		if (Book == null) {
			if (other.Book != null)
				return false;
		} else if (!Book.equals(other.Book))
			return false;
		if (Double.doubleToLongBits(OpeningQty) != Double.doubleToLongBits(other.OpeningQty))
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
		return "OpeningStock [openingDate=" + openingDate + ", OpeningQty=" + OpeningQty + ", Book=" + Book + "]";
	}

}
