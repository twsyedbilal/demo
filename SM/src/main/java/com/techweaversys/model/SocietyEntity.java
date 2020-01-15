package com.techweaversys.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import com.techweaversys.generics.AbstractPersistable;

@Entity
@Table(name = "sm_society")
@Where(clause = "deleted=false")
public class SocietyEntity extends AbstractPersistable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1685500123079142613L;

	@Column(name = "society_name")
	private String societyName;

	@Column(name = "code")
	private String code;

	public SocietyEntity() {
		super();
	}

	public SocietyEntity(String societyName, String code) {
		super();
		this.societyName = societyName;
		this.code = code;
	}

	public String getSocietyName() {
		return societyName;
	}

	public void setSocietyName(String societyName) {
		this.societyName = societyName;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((societyName == null) ? 0 : societyName.hashCode());
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
		SocietyEntity other = (SocietyEntity) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (societyName == null) {
			if (other.societyName != null)
				return false;
		} else if (!societyName.equals(other.societyName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SocietyEntity [societyName=" + societyName + ", code=" + code + "]";
	}

}
