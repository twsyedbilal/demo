package com.techweaversys.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
public class MarkSlaveDto {
	
	private String mark;
	private String remark;
	private Long id;
	private Long admission;
	
	
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

	public Long getAdmission() {
		return admission;
	}

	public void setAdmission(Long admission) {
		this.admission = admission;
	}

	
}
