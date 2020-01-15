package com.techweaversys.dto;

public class CasteSpecDto {

	private Long id;
	private String casteName;
	private String casteCode;
	private Integer page;
	private Integer size;

	public CasteSpecDto() {
		super();
	}

	public CasteSpecDto(Long id, String casteName, String casteCode, Integer page, Integer size) {
		super();
		this.id = id;
		this.casteName = casteName;
		this.casteCode = casteCode;
		this.page = page;
		this.size = size;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCasteName() {
		return casteName;
	}

	public void setCasteName(String casteName) {
		this.casteName = casteName;
	}

	public String getCasteCode() {
		return casteCode;
	}

	public void setCasteCode(String casteCode) {
		this.casteCode = casteCode;
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
		result = prime * result + ((casteCode == null) ? 0 : casteCode.hashCode());
		result = prime * result + ((casteName == null) ? 0 : casteName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((page == null) ? 0 : page.hashCode());
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
		CasteSpecDto other = (CasteSpecDto) obj;
		if (casteCode == null) {
			if (other.casteCode != null)
				return false;
		} else if (!casteCode.equals(other.casteCode))
			return false;
		if (casteName == null) {
			if (other.casteName != null)
				return false;
		} else if (!casteName.equals(other.casteName))
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
		if (size == null) {
			if (other.size != null)
				return false;
		} else if (!size.equals(other.size))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CasteSpecDto [id=" + id + ", casteName=" + casteName + ", casteCode=" + casteCode + ", page=" + page
				+ ", size=" + size + "]";
	}

}
