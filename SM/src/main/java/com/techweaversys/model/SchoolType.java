package com.techweaversys.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import com.techweaversys.generics.AbstractPersistable;

@Entity
@Table(name = "sm_school_type")
@Where(clause = "deleted=false")
public class SchoolType extends AbstractPersistable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -487815098284380440L;

	@Column(name = "school_type_name")
	private String schoolTypeName;

	@Column(name = "code")
	private String code;

	public SchoolType() {
		super();
	}

	public SchoolType(String schoolTypeName, String code) {
		super();
		this.schoolTypeName = schoolTypeName;
		this.code = code;
	}

	public String getSchoolTypeName() {
		return schoolTypeName;
	}

	public void setSchoolTypeName(String schoolTypeName) {
		this.schoolTypeName = schoolTypeName;
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
		result = prime * result + ((schoolTypeName == null) ? 0 : schoolTypeName.hashCode());
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
		SchoolType other = (SchoolType) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (schoolTypeName == null) {
			if (other.schoolTypeName != null)
				return false;
		} else if (!schoolTypeName.equals(other.schoolTypeName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SchoolType [schoolTypeName=" + schoolTypeName + ", code=" + code + "]";
	}

}
