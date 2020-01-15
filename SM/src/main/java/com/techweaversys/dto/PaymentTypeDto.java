package com.techweaversys.dto;

public class PaymentTypeDto {
	
	private Long id;
	private String payementTypeName;
	private String payementTypeCode;

	public PaymentTypeDto() {
		super();
	}
	public PaymentTypeDto(Long id, String payementTypeName, String payementTypeCode) {
		super();
		this.id = id;
		this.payementTypeName = payementTypeName;
		this.payementTypeCode = payementTypeCode;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPayementTypeName() {
		return payementTypeName;
	}
	public void setPayementTypeName(String payementTypeName) {
		this.payementTypeName = payementTypeName;
	}
	public String getPayementTypeCode() {
		return payementTypeCode;
	}
	public void setPayementTypeCode(String payementTypeCode) {
		this.payementTypeCode = payementTypeCode;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((payementTypeCode == null) ? 0 : payementTypeCode.hashCode());
		result = prime * result + ((payementTypeName == null) ? 0 : payementTypeName.hashCode());
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
		PaymentTypeDto other = (PaymentTypeDto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (payementTypeCode == null) {
			if (other.payementTypeCode != null)
				return false;
		} else if (!payementTypeCode.equals(other.payementTypeCode))
			return false;
		if (payementTypeName == null) {
			if (other.payementTypeName != null)
				return false;
		} else if (!payementTypeName.equals(other.payementTypeName))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PaymentTypeDto [id=" + id + ", payementTypeName=" + payementTypeName + ", payementTypeCode="
				+ payementTypeCode + "]";
	}


}
