package com.techweaversys.dto;

import java.util.List;

public class CompliantDto {

	private Long id;
	private String remark;
	private Long admissionId;
	private Long complianttypeid;
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
	public Long getAdmissionId() {
		return admissionId;
	}
	public void setAdmissionId(Long admissionId) {
		this.admissionId = admissionId;
	}
	public Long getComplianttypeid() {
		return complianttypeid;
	}
	public void setComplianttypeid(Long complianttypeid) {
		this.complianttypeid = complianttypeid;
	}
	public List<DocumentDto> getDocumentdtolist() {
		return documentdtolist;
	}
	public void setDocumentdtolist(List<DocumentDto> documentdtolist) {
		this.documentdtolist = documentdtolist;
	}
	@Override
	public String toString() {
		return "CompliantDto [id=" + id + ", remark=" + remark + ", admissionId=" + admissionId + ", complianttypeid="
				+ complianttypeid + ", documentdtolist=" + documentdtolist + "]";
	}
	
	
}
