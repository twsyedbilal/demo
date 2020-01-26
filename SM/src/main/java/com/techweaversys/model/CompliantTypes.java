package com.techweaversys.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import com.techweaversys.generics.AbstractPersistable;

@Entity
@Table(name = "sm_compliant_type")
@Where(clause = "deleted =false")
public class CompliantTypes extends AbstractPersistable {

	private static final long serialVersionUID = 9160565679789075229L;
	private String name;
	private String code;

	public CompliantTypes() {
		super();
	}

	public CompliantTypes(String name, String code) {
		super();
		this.name = name;
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "Compliant [name=" + name + ", code=" + code + ", getName()=" + getName() + ", getCode()=" + getCode()
				+ ", getId()=" + getId() + ", isNew()=" + isNew() + ", getDeleted()=" + getDeleted() + ", getCreated()="
				+ getCreated() + ", getModified()=" + getModified() + ", toString()=" + super.toString()
				+ ", hashCode()=" + hashCode() + ", getClass()=" + getClass() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		CompliantTypes other = (CompliantTypes) obj;
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
		return true;
	}

}
