package com.techweaversys.dto;

public class SchoolTypeDto {

	private Long id;
	private String schoolTypeName;
	private String code;

	public SchoolTypeDto() {
		super();
	}

	public SchoolTypeDto(Long id, String schoolTypeName, String code) {
		super();
		this.id = id;
		this.schoolTypeName = schoolTypeName;
		this.code = code;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSchoolTypeName() {
		return schoolTypeName;
	}

	public void setSchoolTypeName(String schoolTypeName) {
		this.schoolTypeName = schoolTypeName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((schoolTypeName == null) ? 0 : schoolTypeName.hashCode());
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
		SchoolTypeDto other = (SchoolTypeDto) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
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
		return "SchoolTypeDto [id=" + id + ", schoolTypeName=" + schoolTypeName + ", code=" + code + "]";
	}

}
