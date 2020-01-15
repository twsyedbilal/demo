package com.techweaversys.dto;

import java.util.List;

public class CreditBookDto {

	private Long id;
	private String type;	
	private Long admissionId;
	private List<CreditSlaveDto> creditSlave;
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
	public List<CreditSlaveDto> getCreditSlave() {
		return creditSlave;
	}
	public void setCreditSlave(List<CreditSlaveDto> creditSlave) {
		this.creditSlave = creditSlave;
	}
	
}
