package com.techweaversys.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import com.techweaversys.generics.AbstractPersistable;

@Entity
@Table(name = "sm_religion")
@Where(clause = "deleted=false")
public class Religion extends AbstractPersistable {
	
	/**
	 * Name : MAJID
	 */
	private static final long serialVersionUID = -2814189819281491404L;

	@Column(name = "religion_name",nullable = false)
	private String religionName;
	
	@Column(name = "religion_code")
	private String religionCode;

	public Religion() {
		super();
	}

	public Religion(String religionName, String religionCode) {
		super();
		this.religionName = religionName;
		this.religionCode = religionCode;
	}

	public String getReligionName() {
		return religionName;
	}

	public void setReligionName(String religionName) {
		this.religionName = religionName;
	}

	public String getReligionCode() {
		return religionCode;
	}

	public void setReligionCode(String religionCode) {
		this.religionCode = religionCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((religionCode == null) ? 0 : religionCode.hashCode());
		result = prime * result + ((religionName == null) ? 0 : religionName.hashCode());
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
		Religion other = (Religion) obj;
		if (religionCode == null) {
			if (other.religionCode != null)
				return false;
		} else if (!religionCode.equals(other.religionCode))
			return false;
		if (religionName == null) {
			if (other.religionName != null)
				return false;
		} else if (!religionName.equals(other.religionName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Religion [religionName=" + religionName + ", religionCode=" + religionCode + "]";
	}

}
