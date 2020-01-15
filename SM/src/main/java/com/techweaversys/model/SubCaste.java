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
	private String subCasteName;
	
	@Column(name = "sub_caste_code")
	private String subCastecode;

	public SubCaste() {
		super();
	}

	public SubCaste(String subCasteName, String subCastecode) {
		super();
		this.subCasteName = subCasteName;
		this.subCastecode = subCastecode;
	}

	public String getSubCasteName() {
		return subCasteName;
	}

	public void setSubCasteName(String subCasteName) {
		this.subCasteName = subCasteName;
	}

	public String getSubCastecode() {
		return subCastecode;
	}

	public void setSubCastecode(String subCastecode) {
		this.subCastecode = subCastecode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((subCasteName == null) ? 0 : subCasteName.hashCode());
		result = prime * result + ((subCastecode == null) ? 0 : subCastecode.hashCode());
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
		if (subCasteName == null) {
			if (other.subCasteName != null)
				return false;
		} else if (!subCasteName.equals(other.subCasteName))
			return false;
		if (subCastecode == null) {
			if (other.subCastecode != null)
				return false;
		} else if (!subCastecode.equals(other.subCastecode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SubCaste [subCasteName=" + subCasteName + ", subCastecode=" + subCastecode + "]";
	}
	
}
