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
@Table(name ="sm_city")
@Where(clause = "deleted=false")
public class City extends AbstractPersistable {
	private static final long serialVersionUID = -8667731991640624887L;

	@Column(name ="city_name", nullable = true)
	private String citynName;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sm_state_id")
	private State state;

	public City() {
		super();
	}

	public City(String citynName, State state) {
		super();
		this.citynName = citynName;
		this.state = state;
	}


	public String getCitynName() {
		return citynName;
	}

	public void setCitynName(String citynName) {
		this.citynName = citynName;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((citynName == null) ? 0 : citynName.hashCode());
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
		City other = (City) obj;
		if (citynName == null) {
			if (other.citynName != null)
				return false;
		} else if (!citynName.equals(other.citynName))
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
		return "City [citynName=" + citynName + ", state=" + state + "]";
	}

}
