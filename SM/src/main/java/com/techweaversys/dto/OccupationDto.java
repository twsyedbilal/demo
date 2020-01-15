package com.techweaversys.dto;

public class OccupationDto {
	private Long id;
	private String occupationName;
	private String occupationCode;

	public OccupationDto() {
		super();
	}

	public OccupationDto(Long id, String occupationName, String occupationCode) {
		super();
		this.id = id;
		this.occupationName = occupationName;
		this.occupationCode = occupationCode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOccupationName() {
		return occupationName;
	}

	public void setOccupationName(String occupationName) {
		this.occupationName = occupationName;
	}

	public String getOccupationCode() {
		return occupationCode;
	}

	public void setOccupationCode(String occupationCode) {
		this.occupationCode = occupationCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((occupationCode == null) ? 0 : occupationCode.hashCode());
		result = prime * result + ((occupationName == null) ? 0 : occupationName.hashCode());
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
		OccupationDto other = (OccupationDto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (occupationCode == null) {
			if (other.occupationCode != null)
				return false;
		} else if (!occupationCode.equals(other.occupationCode))
			return false;
		if (occupationName == null) {
			if (other.occupationName != null)
				return false;
		} else if (!occupationName.equals(other.occupationName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OccupationDto [id=" + id + ", occupationName=" + occupationName + ", occupationCode=" + occupationCode
				+ "]";
	}

}
