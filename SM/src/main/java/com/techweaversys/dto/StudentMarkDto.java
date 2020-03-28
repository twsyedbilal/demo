package com.techweaversys.dto;

import java.util.List;

public class StudentMarkDto {

	private Long id;
	private Long classsid;
	private ClassDto classs;
	private Long examId;
	private Long subjectId;
	private List<MarkSlaveDto> slavedto;
	
	
	public ClassDto getClasss() {
		return classs;
	}
	public void setClasss(ClassDto classs) {
		this.classs = classs;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getExamId() {
		return examId;
	}
	public void setExamId(Long examId) {
		this.examId = examId;
	}
	public Long getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}
	public List<MarkSlaveDto> getSlavedto() {
		return slavedto;
	}
	public void setSlavedto(List<MarkSlaveDto> slavedto) {
		this.slavedto = slavedto;
	
	
	}
	public Long getClasssid() {
		return classsid;
	}
	public void setClasssid(Long classsid) {
		this.classsid = classsid;
	}
	
	
}
