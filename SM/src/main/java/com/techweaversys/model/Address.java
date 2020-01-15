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
@Table(name = "sm_address")
@Where(clause = "deleted=false")
public class Address extends AbstractPersistable {

	/**
	 * Name : MAJID
	 */

	private static final long serialVersionUID = -4755475150336448167L;

	public Address() {
		super();
	}

	public Address(Long pinCode, String detailAddress, City city, State state, Country country) {
		super();
		this.pinCode = pinCode;
		this.detailAddress = detailAddress;
		this.city = city;
		this.state = state;
		this.country = country;
	}

	@Column(name = "pin_code")
	private Long pinCode;

	@Column(name = "detail_address", nullable = false)
	private String detailAddress;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "sm_city_id", nullable = false)
	private City city;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "sm_state_id", nullable = false)
	private State state;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "sm_country_id", nullable = false)
	private Country country;

	public Long getPinCode() {
		return pinCode;
	}

	public void setPinCode(Long pinCode) {
		this.pinCode = pinCode;
	}

	public String getDetailAddress() {
		return detailAddress;
	}

	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((detailAddress == null) ? 0 : detailAddress.hashCode());
		result = prime * result + ((pinCode == null) ? 0 : pinCode.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
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
		Address other = (Address) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (detailAddress == null) {
			if (other.detailAddress != null)
				return false;
		} else if (!detailAddress.equals(other.detailAddress))
			return false;
		if (pinCode == null) {
			if (other.pinCode != null)
				return false;
		} else if (!pinCode.equals(other.pinCode))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Address [pinCode=" + pinCode + ", detailAddress=" + detailAddress + ", city=" + city + ", state="
				+ state + ", country=" + country + "]";
	}

}