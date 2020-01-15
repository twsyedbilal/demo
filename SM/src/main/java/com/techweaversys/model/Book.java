package com.techweaversys.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import com.techweaversys.generics.AbstractPersistable;

@Entity
@Table(name = "sm_book")
@Where(clause = "deleted=false")
public class Book extends AbstractPersistable {

	private static final long serialVersionUID = -3737484705140025282L;

	public Book() {

	}

	public Book(String bookName, String bookCode) {
		super();
		this.bookName = bookName;
		this.bookCode = bookCode;
	}

	@Column(name = "book_name", nullable = false)
	private String bookName;

	@Column(name = "book_code", nullable = false)
	private String bookCode;

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookCode() {
		return bookCode;
	}

	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}

	@Override
	public String toString() {
		return "Book [bookName=" + bookName + ", bookCode=" + bookCode + ", getBookName()=" + getBookName()
				+ ", getBookCode()=" + getBookCode() + ", getId()=" + getId() + ", isNew()=" + isNew()
				+ ", getDeleted()=" + getDeleted() + ", getCreated()=" + getCreated() + ", getModified()="
				+ getModified() + ", toString()=" + super.toString() + ", hashCode()=" + hashCode() + ", getClass()="
				+ getClass() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((bookCode == null) ? 0 : bookCode.hashCode());
		result = prime * result + ((bookName == null) ? 0 : bookName.hashCode());
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
		Book other = (Book) obj;
		if (bookCode == null) {
			if (other.bookCode != null)
				return false;
		} else if (!bookCode.equals(other.bookCode))
			return false;
		if (bookName == null) {
			if (other.bookName != null)
				return false;
		} else if (!bookName.equals(other.bookName))
			return false;
		return true;
	}
}
