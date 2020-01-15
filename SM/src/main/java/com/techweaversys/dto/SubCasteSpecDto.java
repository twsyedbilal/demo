package com.techweaversys.dto;

public class SubCasteSpecDto {

	private Long id;
	private String subCasteName;
	private String subCasteCode;
	private Integer page;
	private Integer size;

	public SubCasteSpecDto() {
		super();
	}

	public SubCasteSpecDto(Long id, String subCasteName, String subCasteCode, Integer page, Integer size) {
		super();
		this.id = id;
		this.subCasteName = subCasteName;
		this.subCasteCode = subCasteCode;
		this.page = page;
		this.size = size;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSubCasteName() {
		return subCasteName;
	}

	public void setSubCasteName(String subCasteName) {
		this.subCasteName = subCasteName;
	}

	public String getSubCasteCode() {
		return subCasteCode;
	}

	public void setSubCasteCode(String subCasteCode) {
		this.subCasteCode = subCasteCode;
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
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((page == null) ? 0 : page.hashCode());
		result = prime * result + ((size == null) ? 0 : size.hashCode());
		result = prime * result + ((subCasteCode == null) ? 0 : subCasteCode.hashCode());
		result = prime * result + ((subCasteName == null) ? 0 : subCasteName.hashCode());
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
		SubCasteSpecDto other = (SubCasteSpecDto) obj;
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
		if (size == null) {
			if (other.size != null)
				return false;
		} else if (!size.equals(other.size))
			return false;
		if (subCasteCode == null) {
			if (other.subCasteCode != null)
				return false;
		} else if (!subCasteCode.equals(other.subCasteCode))
			return false;
		if (subCasteName == null) {
			if (other.subCasteName != null)
				return false;
		} else if (!subCasteName.equals(other.subCasteName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SubCasteSpecDto [id=" + id + ", subCasteName=" + subCasteName + ", subCasteCode=" + subCasteCode
				+ ", page=" + page + ", size=" + size + "]";
	}

}
