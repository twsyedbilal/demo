package com.techweaversys.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
public class StudentMarkDto {

	private Long id;
	private Long classs;
	//private ClassDto classs;
	private Long examMaster;
	private Long subjectMaster;
	@JsonProperty("collection")
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
	private List<MarkSlaveDto> slavedto;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getClasss() {
		return classs;
	}
	public void setClasss(Long classs) {
		this.classs = classs;
	}
	
	public Long getSubjectMaster() {
		return subjectMaster;
	}
	public void setSubjectMaster(Long subjectMaster) {
		this.subjectMaster = subjectMaster;
	}
	public List<MarkSlaveDto> getSlavedto() {
		return slavedto;
	}
	public void setSlavedto(List<MarkSlaveDto> slavedto) {
		this.slavedto = slavedto;
	}
	public Long getExamMaster() {
		return examMaster;
	}
	public void setExamMaster(Long examMaster) {
		this.examMaster = examMaster;
	}
	
	
	
}
