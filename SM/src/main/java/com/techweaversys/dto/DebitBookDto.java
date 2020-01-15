package com.techweaversys.dto;

import java.util.List;

public class DebitBookDto {
	
	private Long id;
	private String type;
	private Long admissionId;
	private List<DebitSlaveDto> debitSlave;

	public DebitBookDto() {
		super();
	}
	public DebitBookDto(Long id, String type, Long admissionId, List<DebitSlaveDto> debitSlave) {
		super();
		this.id = id;
		this.type = type;
		this.admissionId = admissionId;
		this.debitSlave = debitSlave;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Long getAdmissionId() {
		return admissionId;
	}
	public void setAdmissionId(Long admissionId) {
		this.admissionId = admissionId;
	}
	public List<DebitSlaveDto> getDebitSlave() {
		return debitSlave;
	}
	public void setDebitSlave(List<DebitSlaveDto> debitSlave) {
		this.debitSlave = debitSlave;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((admissionId == null) ? 0 : admissionId.hashCode());
		result = prime * result + ((debitSlave == null) ? 0 : debitSlave.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		DebitBookDto other = (DebitBookDto) obj;
		if (admissionId == null) {
			if (other.admissionId != null)
				return false;
		} else if (!admissionId.equals(other.admissionId))
			return false;
		if (debitSlave == null) {
			if (other.debitSlave != null)
				return false;
		} else if (!debitSlave.equals(other.debitSlave))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "DebitBookDto [id=" + id + ", type=" + type + ", admissionId=" + admissionId + ", debitSlave="
				+ debitSlave + "]";
	}
	
}
