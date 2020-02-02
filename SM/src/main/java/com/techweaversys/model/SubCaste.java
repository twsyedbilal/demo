package com.techweaversys.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import com.techweaversys.generics.AbstractPersistable;

@Entity
@Table(name = "sm_sub_caste")
@Where(clause = "deleted=false")
public class SubCaste extends AbstractPersistable {

	/**
	 * Name : Majid
	 */
	private static final long serialVersionUID = 445410939978111638L;

	@Column(name = "sub_caste_name",nullable = false)
	private String name;
	
	@Column(name = "sub_caste_code")
	private String code;

	public SubCaste() {
		super();
	}

	public SubCaste(String name, String code) {
		super();
		this.name = name;
		this.code = code;
	}

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
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
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
		SubCaste other = (SubCaste) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SubCaste [name=" + name + ", code=" + code + "]";
	}
	
}
