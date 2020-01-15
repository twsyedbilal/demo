package com.techweaversys.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import com.techweaversys.generics.AbstractPersistable;


@Entity
@Table(name ="sm_state")
@Where(clause = "deleted=false")
public class State extends AbstractPersistable {

	private static final long serialVersionUID = 8718979245918561692L;

	
	public State() {
		super();
	}

	public State(String stateName, Country country) {
		super();
		this.stateName = stateName;
		this.country = country;
	}

	@Column(name = "state_name")
	private String stateName;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="sm_country_id")
	private Country country;

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
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
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((stateName == null) ? 0 : stateName.hashCode());
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
		State other = (State) obj;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (stateName == null) {
			if (other.stateName != null)
				return false;
		} else if (!stateName.equals(other.stateName))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "State [stateName=" + stateName + ", country=" + country + "]";
	}


	
}
