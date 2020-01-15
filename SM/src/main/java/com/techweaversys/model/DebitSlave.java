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
@Table(name = "sm_debit_slave")
@Where(clause = "deleted=false")
public class DebitSlave extends AbstractPersistable {

	private static final long serialVersionUID = 1279383047807857311L;

	@Column(name = "qty")
	private double qty;

	@Column(name = "given_qty")
	private double givenQty;

	@Column(name = "return_qty")
	private double returnQty;

	@Column(name = "from_date")
	private Calendar fromDate;

	@Column(name = "to_date")
	private Calendar toDate;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "book_id")
	@JsonIgnore
	@NotFound(action = NotFoundAction.IGNORE)
	private Book Book;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	@JoinColumn(name="debit_book_id")
	@JsonIgnore	
	@NotFound(action = NotFoundAction.IGNORE)
	private DebitBook debitBook;
	
	
	public DebitSlave() {
		super();
	}

	public DebitSlave(double qty, double givenQty, double returnQty, Calendar fromDate, Calendar toDate,
			com.techweaversys.model.Book book, DebitBook debitBook) {
		super();
		this.qty = qty;
		this.givenQty = givenQty;
		this.returnQty = returnQty;
		this.fromDate = fromDate;
		this.toDate = toDate;
		Book = book;
		this.debitBook = debitBook;
	}

	public DebitBook getDebitBook() {
		return debitBook;
	}

	public void setDebitBook(DebitBook debitBook) {
		this.debitBook = debitBook;
	}

	public Book getBook() {
		return Book;
	}

	public void setBook(Book book) {
		Book = book;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((Book == null) ? 0 : Book.hashCode());
		result = prime * result + ((debitBook == null) ? 0 : debitBook.hashCode());
		result = prime * result + ((fromDate == null) ? 0 : fromDate.hashCode());
		long temp;
		temp = Double.doubleToLongBits(givenQty);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		DebitSlave other = (DebitSlave) obj;
		if (Book == null) {
			if (other.Book != null)
				return false;
		} else if (!Book.equals(other.Book))
			return false;
		if (debitBook == null) {
			if (other.debitBook != null)
				return false;
		} else if (!debitBook.equals(other.debitBook))
			return false;
		if (fromDate == null) {
			if (other.fromDate != null)
				return false;
		} else if (!fromDate.equals(other.fromDate))
			return false;
		if (Double.doubleToLongBits(givenQty) != Double.doubleToLongBits(other.givenQty))
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
		return "DebitSlave [qty=" + qty + ", givenQty=" + givenQty + ", returnQty=" + returnQty + ", fromDate="
				+ fromDate + ", toDate=" + toDate + ", Book=" + Book + ", debitBook=" + debitBook + "]";
	}
	
}
