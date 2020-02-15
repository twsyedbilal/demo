package com.techweaversys.dto;

public class LibraryStockDto {

	private Long id;
	private double stockQty;
	private double stockIn;
	private double stockOut;
	private double givenQty;
	private double returnQty;
	private double openingQty;
	private double qyt;
	private String type;
	private BookDto book;

	public LibraryStockDto() {
		super();
	}

	public LibraryStockDto(Long id, double stockQty, double stockIn, double stockOut, double givenQty, double returnQty,
			double openingQty, String type, BookDto book) {
		super();
		this.id = id;
		this.stockQty = stockQty;
		this.stockIn = stockIn;
		this.stockOut = stockOut;
		this.givenQty = givenQty;
		this.returnQty = returnQty;
		this.openingQty = openingQty;
		this.type = type;
		this.book = book;
	}

	public BookDto getBook() {
		return book;
	}

	public void setBook(BookDto book) {
		this.book = book;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((book == null) ? 0 : book.hashCode());
		long temp;
		temp = Double.doubleToLongBits(givenQty);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		LibraryStockDto other = (LibraryStockDto) obj;
		if (book == null) {
			if (other.book != null)
				return false;
		} else if (!book.equals(other.book))
			return false;
		if (Double.doubleToLongBits(givenQty) != Double.doubleToLongBits(other.givenQty))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
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
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LibraryStockDto [id=" + id + ", stockQty=" + stockQty + ", stockIn=" + stockIn + ", stockOut="
				+ stockOut + ", givenQty=" + givenQty + ", returnQty=" + returnQty + ", openingQty=" + openingQty
				+ ", type=" + type + ", book=" + book + "]";
	}

}
