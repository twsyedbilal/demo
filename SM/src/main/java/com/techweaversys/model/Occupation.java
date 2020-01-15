package com.techweaversys.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import com.techweaversys.generics.AbstractPersistable;

@Entity
@Table(name = "sm_occupation")
@Where(clause = "deleted=false")
public class Occupation extends AbstractPersistable{

	/**
	 * Name: MAJID
	 */
	private static final long serialVersionUID = -3097611508839667446L;

	@Column(name = "occupation_name",nullable = false)
	private String occupationName;
	
	@Column(name = "occupation_code")
	private String occupationCode;

	public Occupation() {
		super();
	}

	public Occupation(String occupationName, String occupationCode) {
		super();
		this.occupationName = occupationName;
		this.occupationCode = occupationCode;
	}

	public String getOccupationName() {
		return occupationName;
	}

	public void setOccupationName(String occupationName) {
		this.occupationName = occupationName;
	}

	public String getOccupationCode() {
		return occupationCode;
	}

	public void setOccupationCode(String occupationCode) {
		this.occupationCode = occupationCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((occupationCode == null) ? 0 : occupationCode.hashCode());
		result = prime * result + ((occupationName == null) ? 0 : occupationName.hashCode());
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
		Occupation other = (Occupation) obj;
		if (occupationCode == null) {
			if (other.occupationCode != null)
				return false;
		} else if (!occupationCode.equals(other.occupationCode))
			return false;
		if (occupationName == null) {
			if (other.occupationName != null)
				return false;
		} else if (!occupationName.equals(other.occupationName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Occupation [occupationName=" + occupationName + ", occupationCode=" + occupationCode + "]";
	}	
}
