package com.techweaversys.dto;

public class SchoolSpaceDto {

	private String schoolName;
	private String schoolCode;
	private String schoolAddress;
	private Integer page;
	private Integer size;

	public SchoolSpaceDto() {
		super();
	}

	public SchoolSpaceDto(String schoolName, String schoolCode, String schoolAddress, Integer page, Integer size) {
		super();
		this.schoolName = schoolName;
		this.schoolCode = schoolCode;
		this.schoolAddress = schoolAddress;
		this.page = page;
		this.size = size;
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

	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;

	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((page == null) ? 0 : page.hashCode());
		result = prime * result + ((schoolAddress == null) ? 0 : schoolAddress.hashCode());
		result = prime * result + ((schoolCode == null) ? 0 : schoolCode.hashCode());
		result = prime * result + ((schoolName == null) ? 0 : schoolName.hashCode());
		result = prime * result + ((size == null) ? 0 : size.hashCode());
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
		SchoolSpaceDto other = (SchoolSpaceDto) obj;
		if (page == null) {
			if (other.page != null)
				return false;
		} else if (!page.equals(other.page))
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
		if (size == null) {
			if (other.size != null)
				return false;
		} else if (!size.equals(other.size))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SchoolSpaceDto [schoolName=" + schoolName + ", schoolCode=" + schoolCode + ", schoolAddress="
				+ schoolAddress + ", page=" + page + ", size=" + size + "]";
	}

}
