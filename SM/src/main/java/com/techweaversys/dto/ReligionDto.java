package com.techweaversys.dto;

public class ReligionDto {
	
	private Long id;
	private String religionName;
	private String religionCode;

	
	public ReligionDto() {
		super();
	}
	public ReligionDto(Long id, String religionName, String religionCode) {
		super();
		this.id = id;
		this.religionName = religionName;
		this.religionCode = religionCode;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getReligionName() {
		return religionName;
	}
	public void setReligionName(String religionName) {
		this.religionName = religionName;
	}
	public String getReligionCode() {
		return religionCode;
	}
	public void setReligionCode(String religionCode) {
		this.religionCode = religionCode;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((religionCode == null) ? 0 : religionCode.hashCode());
		result = prime * result + ((religionName == null) ? 0 : religionName.hashCode());
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
		ReligionDto other = (ReligionDto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (religionCode == null) {
			if (other.religionCode != null)
				return false;
		} else if (!religionCode.equals(other.religionCode))
			return false;
		if (religionName == null) {
			if (other.religionName != null)
				return false;
		} else if (!religionName.equals(other.religionName))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ReligionDto [id=" + id + ", religionName=" + religionName + ", religionCode=" + religionCode + "]";
	}

	
}
