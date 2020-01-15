package com.techweaversys.dto;

public class SocietyDto {

	private Long id;
	private String societyName;
	private String code;

	public SocietyDto() {
		super();
	}

	public SocietyDto(Long id, String societyName, String code) {
		super();
		this.id = id;
		this.societyName = societyName;
		this.code = code;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((societyName == null) ? 0 : societyName.hashCode());
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
		SocietyDto other = (SocietyDto) obj;
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
		if (societyName == null) {
			if (other.societyName != null)
				return false;
		} else if (!societyName.equals(other.societyName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SocietyDto [id=" + id + ", societyName=" + societyName + ", code=" + code + "]";
	}

}
