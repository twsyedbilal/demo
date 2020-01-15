package com.techweaversys.dto;

public class SubCasteDto {
	private Long id;
	private String subCasteName;
	private String subCasteCode;

	public SubCasteDto() {
		super();
	}

	public SubCasteDto(Long id, String subCasteName, String subCasteCode) {
		super();
		this.id = id;
		this.subCasteName = subCasteName;
		this.subCasteCode = subCasteCode;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		SubCasteDto other = (SubCasteDto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
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
		return "SubCasteDto [id=" + id + ", subCasteName=" + subCasteName + ", subCasteCode=" + subCasteCode + "]";
	}

}
