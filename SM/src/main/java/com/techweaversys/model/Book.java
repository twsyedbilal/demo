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

	public Book(String name, String code) {
		super();
		this.name = name;
		this.code = code;
	}

	@Column(name = "book_name", nullable = false)
	private String name;

	@Column(name = "book_code", nullable = false)
	private String code;

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public String getcode() {
		return code;
	}

	public void setcode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "Book [name=" + name + ", code=" + code + ", getname()=" + getname()
				+ ", getcode()=" + getcode() + ", getId()=" + getId() + ", isNew()=" + isNew()
				+ ", getDeleted()=" + getDeleted() + ", getCreated()=" + getCreated() + ", getModified()="
				+ getModified() + ", toString()=" + super.toString() + ", hashCode()=" + hashCode() + ", getClass()="
				+ getClass() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
