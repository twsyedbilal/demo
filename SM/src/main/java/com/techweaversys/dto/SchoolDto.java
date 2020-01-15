package com.techweaversys.dto;

public class SchoolDto {

	private Long id;
	private String schoolName;
	private String schoolCode;
	private String schoolAddress;
	private BranchDto branch;
	private Long schoolTypeId;

	public SchoolDto() {
		super();
	}

	public SchoolDto(Long id, String schoolName, String schoolCode, String schoolAddress, BranchDto branch,
			Long schoolTypeId) {
		super();
		this.id = id;
		this.schoolName = schoolName;
		this.schoolCode = schoolCode;
		this.schoolAddress = schoolAddress;
		this.branch = branch;
		this.schoolTypeId = schoolTypeId;
	}

	public Long getSchoolTypeId() {
		return schoolTypeId;
	}

	public void setSchoolTypeId(Long schoolTypeId) {
		this.schoolTypeId = schoolTypeId;
	}

	public BranchDto getBranch() {
		return branch;
	}

	public void setBranch(BranchDto branch) {
		this.branch = branch;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((branch == null) ? 0 : branch.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((schoolAddress == null) ? 0 : schoolAddress.hashCode());
		result = prime * result + ((schoolCode == null) ? 0 : schoolCode.hashCode());
		result = prime * result + ((schoolName == null) ? 0 : schoolName.hashCode());
		result = prime * result + ((schoolTypeId == null) ? 0 : schoolTypeId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SchoolDto other = (SchoolDto) obj;
		if (branch == null) {
			if (other.branch != null)
				return false;
		} else if (!branch.equals(other.branch))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
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
		if (schoolTypeId == null) {
			if (other.schoolTypeId != null)
				return false;
		} else if (!schoolTypeId.equals(other.schoolTypeId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SchoolDto [id=" + id + ", schoolName=" + schoolName + ", schoolCode=" + schoolCode + ", schoolAddress="
				+ schoolAddress + ", branch=" + branch + ", getBranch()=" + getBranch() + ", getId()=" + getId()
				+ ", getSchoolName()=" + getSchoolName() + ", getSchoolCode()=" + getSchoolCode()
				+ ", getSchoolAddress()=" + getSchoolAddress() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

}