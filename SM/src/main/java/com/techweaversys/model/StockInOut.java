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
@Table(name = "sm_stock_in_out")
@Where(clause = "deleted=false")
public class StockInOut extends AbstractPersistable {

	private static final long serialVersionUID = 382850641508234817L;

	@Column(name = "type", nullable = true)
	private String type;

	@Column(name = "qty", nullable = true)
	private double qty;

	@Column(name = "stock_in", nullable = true)
	private double stockin;

	@Column(name = "stock_out", nullable = true)
	private double stockout;

	@Column(name = "reason", nullable = true)
	private String reason;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "book_id")
	@JsonIgnore
	@NotFound(action = NotFoundAction.IGNORE)
	private Book book;

	public StockInOut() {
		super();
	}

	public StockInOut(String type, double qty, double stockin, double stockout, String reason, Book book) {
		super();
		this.type = type;
		this.qty = qty;
		this.stockin = stockin;
		this.stockout = stockout;
		this.reason = reason;
		this.book = book;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getQty() {
		return qty;
	}

	public void setQty(double qty) {
		this.qty = qty;
	}

	public double getStockin() {
		return stockin;
	}

	public void setStockin(double stockin) {
		this.stockin = stockin;
	}

	public double getStockout() {
		return stockout;
	}

	public void setStockout(double stockout) {
		this.stockout = stockout;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
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
		temp = Double.doubleToLongBits(qty);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((reason == null) ? 0 : reason.hashCode());
		temp = Double.doubleToLongBits(stockin);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(stockout);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		StockInOut other = (StockInOut) obj;
		if (book == null) {
			if (other.book != null)
				return false;
		} else if (!book.equals(other.book))
			return false;
		if (Double.doubleToLongBits(qty) != Double.doubleToLongBits(other.qty))
			return false;
		if (reason == null) {
			if (other.reason != null)
				return false;
		} else if (!reason.equals(other.reason))
			return false;
		if (Double.doubleToLongBits(stockin) != Double.doubleToLongBits(other.stockin))
			return false;
		if (Double.doubleToLongBits(stockout) != Double.doubleToLongBits(other.stockout))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "StockInOut [type=" + type + ", qty=" + qty + ", stockin=" + stockin + ", stockout=" + stockout
				+ ", reason=" + reason + ", book=" + book + "]";
	}
	
}
