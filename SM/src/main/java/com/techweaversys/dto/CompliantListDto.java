package com.techweaversys.dto;

import java.util.List;

public class CompliantListDto {
	private Long id;
	private String remark;
	private AdmissionDto admisiondto;
	private CompliantTypeDto complianttypedto;
	private List<DocumentDto> documentdtolist;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public AdmissionDto getAdmisiondto() {
		return admisiondto;
	}

	public void setAdmisiondto(AdmissionDto admisiondto) {
		this.admisiondto = admisiondto;
	}

	public CompliantTypeDto getComplianttypedto() {
		return complianttypedto;
	}

	public void setComplianttypedto(CompliantTypeDto complianttypedto) {
		this.complianttypedto = complianttypedto;
	}

	public List<DocumentDto> getDocumentdtolist() {
		return documentdtolist;
	}

	public void setDocumentdtolist(List<DocumentDto> documentdtolist) {
		this.documentdtolist = documentdtolist;
	}
}