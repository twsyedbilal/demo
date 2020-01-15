package com.techweaversys.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import com.techweaversys.generics.AbstractPersistable;

@Entity
@Table(name = "sm_country")
@Where(clause = "deleted=false")
public class Country extends AbstractPersistable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2877399532939501924L;

	public Country() {
		super();
	}

	public Country(String countryName) {
		super();
		this.countryName = countryName;
	}

	public Country(String countryName, String sortName, String phoneCode) {
		super();
		this.countryName = countryName;
		this.sortName = sortName;
		this.phoneCode = phoneCode;
	}

	@Column(name = "country_name", nullable = true)
	private String countryName;

	@Column(name = "sort_name")
	private String sortName;

	@Column(name = "phone_code")
	private String phoneCode;

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getSortName() {
		return sortName;
	}

	public void setSortName(String sortName) {
		this.sortName = sortName;
	}

	public String getPhoneCode() {
		return phoneCode;
	}

	public void setPhoneCode(String phoneCode) {
		this.phoneCode = phoneCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((countryName == null) ? 0 : countryName.hashCode());
		result = prime * result + ((phoneCode == null) ? 0 : phoneCode.hashCode());
		result = prime * result + ((sortName == null) ? 0 : sortName.hashCode());
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
		Country other = (Country) obj;
		if (countryName == null) {
			if (other.countryName != null)
				return false;
		} else if (!countryName.equals(other.countryName))
			return false;
		if (phoneCode == null) {
			if (other.phoneCode != null)
				return false;
		} else if (!phoneCode.equals(other.phoneCode))
			return false;
		if (sortName == null) {
			if (other.sortName != null)
				return false;
		} else if (!sortName.equals(other.sortName))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Country [countryName=" + countryName + ", sortName=" + sortName + ", phoneCode=" + phoneCode + "]";
	}

}
