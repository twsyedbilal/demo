package com.techweaversys.dto;

public class SocietySpaceDto {

	private String societyName;
	private String code;
	private Integer page;
	private Integer size;

	public SocietySpaceDto() {
		super();
	}

	public SocietySpaceDto(String societyName, String code, Integer page, Integer size) {
		super();
		this.societyName = societyName;
		this.code = code;
		this.page = page;
		this.size = size;
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
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((page == null) ? 0 : page.hashCode());
		result = prime * result + ((size == null) ? 0 : size.hashCode());
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
		SocietySpaceDto other = (SocietySpaceDto) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (page == null) {
			if (other.page != null)
				return false;
		} else if (!page.equals(other.page))
			return false;
		if (size == null) {
			if (other.size != null)
				return false;
		} else if (!size.equals(other.size))
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
		return "SocietySpaceDto [societyName=" + societyName + ", code=" + code + ", page=" + page + ", size=" + size
				+ "]";
	}

}
