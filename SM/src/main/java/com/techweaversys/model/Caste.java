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
	private String casteName;
	
	@Column(name = "caste_code")
	private String casteCode;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "sm_sub_caste_id")
	private SubCaste subCaste;

	
	public Caste() {
		super();
	}

	public Caste(String casteName, String casteCode, SubCaste subCaste) {
		super();
		this.casteName = casteName;
		this.casteCode = casteCode;
		this.subCaste = subCaste;
	}

	public SubCaste getSubCaste() {
		return subCaste;
	}

	public void setSubCaste(SubCaste subCaste) {
		this.subCaste = subCaste;
	}

	public String getCasteName() {
		return casteName;
	}

	public void setCasteName(String casteName) {
		this.casteName = casteName;
	}

	public String getCasteCode() {
		return casteCode;
	}

	public void setCasteCode(String casteCode) {
		this.casteCode = casteCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((casteCode == null) ? 0 : casteCode.hashCode());
		result = prime * result + ((casteName == null) ? 0 : casteName.hashCode());
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
		if (casteCode == null) {
			if (other.casteCode != null)
				return false;
		} else if (!casteCode.equals(other.casteCode))
			return false;
		if (casteName == null) {
			if (other.casteName != null)
				return false;
		} else if (!casteName.equals(other.casteName))
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
		return "Caste [casteName=" + casteName + ", casteCode=" + casteCode + ", subCaste=" + subCaste + "]";
	}

}
