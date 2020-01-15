package com.techweaversys.dto;

public class CasteDto {
	private Long id;
	private String casteName;
	private String casteCode;
	private SubCasteDto subCasteDto;

	public CasteDto() {
		super();
	}

	public CasteDto(Long id, String casteName, String casteCode, SubCasteDto subCasteDto) {
		super();
		this.id = id;
		this.casteName = casteName;
		this.casteCode = casteCode;
		this.subCasteDto = subCasteDto;
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

	public SubCasteDto getSubCasteDto() {
		return subCasteDto;
	}

	public void setSubCasteDto(SubCasteDto subCasteDto) {
		this.subCasteDto = subCasteDto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((casteCode == null) ? 0 : casteCode.hashCode());
		result = prime * result + ((casteName == null) ? 0 : casteName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((subCasteDto == null) ? 0 : subCasteDto.hashCode());
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
		CasteDto other = (CasteDto) obj;
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
		if (subCasteDto == null) {
			if (other.subCasteDto != null)
				return false;
		} else if (!subCasteDto.equals(other.subCasteDto))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CasteDto [id=" + id + ", casteName=" + casteName + ", casteCode=" + casteCode + ", subCasteDto="
				+ subCasteDto + "]";
	}

}
