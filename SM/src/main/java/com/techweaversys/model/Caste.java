package com.techweaversys.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import com.techweaversys.generics.AbstractPersistable;

@Entity
@Table(name = "sm_caste")
@Where(clause = "deleted=false")
public class Caste extends AbstractPersistable{
	
	/**
	 * Name: MAJID
	 */
	private static final long serialVersionUID = 4429910172787590649L;

	@Column(name = "caste_name",nullable = false)
	private String name;
	
	@Column(name = "caste_code")
	private String code;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "sm_sub_caste_id")
	private SubCaste subCaste;

	
	public Caste() {
		super();
	}

	public Caste(String name, String code, SubCaste subCaste) {
		super();
		this.name = name;
		this.code = code;
		this.subCaste = subCaste;
	}

	public SubCaste getSubCaste() {
		return subCaste;
	}

	public void setSubCaste(SubCaste subCaste) {
		this.subCaste = subCaste;
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
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((subCaste == null) ? 0 : subCaste.hashCode());
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
		Caste other = (Caste) obj;
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
		if (subCaste == null) {
			if (other.subCaste != null)
				return false;
		} else if (!subCaste.equals(other.subCaste))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Caste [name=" + name + ", code=" + code + ", subCaste=" + subCaste + "]";
	}

}
