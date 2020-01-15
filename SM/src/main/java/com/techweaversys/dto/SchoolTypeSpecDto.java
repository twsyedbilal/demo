package com.techweaversys.dto;

public class SchoolTypeSpecDto {

	private Long id;
	private String schoolTypeName;
	private String code;
	private Integer page;
	private Integer size;

	public SchoolTypeSpecDto() {
		super();
	}
	public SchoolTypeSpecDto(Long id, String schoolTypeName, String code, Integer page, Integer size) {
		super();
		this.id = id;
		this.schoolTypeName = schoolTypeName;
		this.code = code;
		this.page = page;
		this.size = size;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((page == null) ? 0 : page.hashCode());
		result = prime * result + ((schoolTypeName == null) ? 0 : schoolTypeName.hashCode());
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
		SchoolTypeSpecDto other = (SchoolTypeSpecDto) obj;
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
		if (page == null) {
			if (other.page != null)
				return false;
		} else if (!page.equals(other.page))
			return false;
		if (schoolTypeName == null) {
			if (other.schoolTypeName != null)
				return false;
		} else if (!schoolTypeName.equals(other.schoolTypeName))
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
		return "SchoolTypeSpecDto [id=" + id + ", schoolTypeName=" + schoolTypeName + ", code=" + code + ", page="
				+ page + ", size=" + size + "]";
	}

}
