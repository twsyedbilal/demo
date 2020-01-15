
package com.techweaversys.model;

//	package com.techweaversys.model;

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
@Table(name = "sm_school")
@Where(clause = "deleted=false")
public class SchoolEntityy extends AbstractPersistable {

	private static final long serialVersionUID = 4869638572659268902L;

	@Column(name = "school_name", unique = true, nullable = false)
	private String schoolName;

	@Column(name = "school_code", nullable = true)
	private String schoolCode;

	@Column(name = "school_address", nullable = true)
	private String schoolAddress;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "branch_id")
	private BranchEntity branch;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "sm_school_type_id")
	private SchoolType schoolType;

	public SchoolEntityy() {
		super();
	}

	public SchoolEntityy(String schoolName, String schoolCode, String schoolAddress, BranchEntity branch,
			SchoolType schoolType) {
		super();
		this.schoolName = schoolName;
		this.schoolCode = schoolCode;
		this.schoolAddress = schoolAddress;
		this.branch = branch;
		this.schoolType = schoolType;
	}

	public SchoolType getSchoolType() {
		return schoolType;
	}

	public void setSchoolType(SchoolType schoolType) {
		this.schoolType = schoolType;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getSchoolCode() {
		return schoolCode;
	}

	public void setSchoolCode(String schoolCode) {
		this.schoolCode = schoolCode;
	}

	public String getSchoolAddress() {
		return schoolAddress;
	}

	public void setSchoolAddress(String schoolAddress) {
		this.schoolAddress = schoolAddress;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public BranchEntity getBranch() {
		return branch;
	}

	public void setBranch(BranchEntity branch) {
		this.branch = branch;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((branch == null) ? 0 : branch.hashCode());
		result = prime * result + ((schoolAddress == null) ? 0 : schoolAddress.hashCode());
		result = prime * result + ((schoolCode == null) ? 0 : schoolCode.hashCode());
		result = prime * result + ((schoolName == null) ? 0 : schoolName.hashCode());
		result = prime * result + ((schoolType == null) ? 0 : schoolType.hashCode());
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
		SchoolEntityy other = (SchoolEntityy) obj;
		if (branch == null) {
			if (other.branch != null)
				return false;
		} else if (!branch.equals(other.branch))
			return false;
		if (schoolAddress == null) {
			if (other.schoolAddress != null)
				return false;
		} else if (!schoolAddress.equals(other.schoolAddress))
			return false;
		if (schoolCode == null) {
			if (other.schoolCode != null)
				return false;
		} else if (!schoolCode.equals(other.schoolCode))
			return false;
		if (schoolName == null) {
			if (other.schoolName != null)
				return false;
		} else if (!schoolName.equals(other.schoolName))
			return false;
		if (schoolType == null) {
			if (other.schoolType != null)
				return false;
		} else if (!schoolType.equals(other.schoolType))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SchoolEntityy [schoolName=" + schoolName + ", schoolCode=" + schoolCode + ", schoolAddress="
				+ schoolAddress + ", branch=" + branch + ", schoolType=" + schoolType + "]";
	}

}
