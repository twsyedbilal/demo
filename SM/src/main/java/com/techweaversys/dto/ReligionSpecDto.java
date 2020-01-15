package com.techweaversys.dto;

public class ReligionSpecDto {

	private Long id;
	private Integer page;
	private Integer size;
	private String religionName;
	private String religionCode;

	public ReligionSpecDto() {
		super();
	}

	public ReligionSpecDto(Long id, Integer page, Integer size, String religionName, String religionCode) {
		super();
		this.id = id;
		this.page = page;
		this.size = size;
		this.religionName = religionName;
		this.religionCode = religionCode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		result = prime * result + ((page == null) ? 0 : page.hashCode());
		result = prime * result + ((religionCode == null) ? 0 : religionCode.hashCode());
		result = prime * result + ((religionName == null) ? 0 : religionName.hashCode());
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
		ReligionSpecDto other = (ReligionSpecDto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (page == null) {
			if (other.page != null)
				return false;
		} else if (!page.equals(other.page))
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
		if (size == null) {
			if (other.size != null)
				return false;
		} else if (!size.equals(other.size))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ReligionSpecDto [id=" + id + ", page=" + page + ", size=" + size + ", religionName=" + religionName
				+ ", religionCode=" + religionCode + "]";
	}

}
