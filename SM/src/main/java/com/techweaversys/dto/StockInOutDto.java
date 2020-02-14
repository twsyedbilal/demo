package com.techweaversys.dto;

public class StockInOutDto {

	private Long id;	
	private String type;
	private double qty;
	private double stockin;
	private double stockout;
	private String reason;
	private Long bookId;
	public StockInOutDto() {
		super();
	}
	public StockInOutDto(Long id, String type, double qty, double stockin, double stockout, String reason,
			Long bookId) {
		super();
		this.id = id;
		this.type = type;
		this.qty = qty;
		this.stockin = stockin;
		this.stockout = stockout;
		this.reason = reason;
		this.bookId = bookId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Long getBookId() {
		return bookId;
	}
	public void setBooId(Long bookId) {
		this.bookId = bookId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookId == null) ? 0 : bookId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StockInOutDto other = (StockInOutDto) obj;
		if (bookId == null) {
			if (other.bookId != null)
				return false;
		} else if (!bookId.equals(other.bookId))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
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
		return "StockInOutDto [id=" + id + ", type=" + type + ", qty=" + qty + ", stockin=" + stockin + ", stockout="
				+ stockout + ", reason=" + reason + ", bookId=" + bookId + "]";
	}
}
