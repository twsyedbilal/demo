package com.techweaversys.dto;

public class MarkSlaveDto {

	
	
	private String mark;
	private String remark;
	private Long id;
	private Long  admissionId;
	
	
	public MarkSlaveDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getMark() {
		return mark;
	}


	public void setMark(String mark) {
		this.mark = mark;
	}


	public String getRemark() {
		return remark;
	}


	public void setRemark(String remark) {
		this.remark = remark;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getAdmissionId() {
		return admissionId;
	}


	public void setAdmissionId(Long admissionId) {
		this.admissionId = admissionId;
	}


		
	
}
