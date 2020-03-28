package com.techweaversys.dto;

import java.util.Calendar;
import java.util.List;

public class ExamDto {
	private String examName;
	private Calendar examEndDate;
	private Calendar examStartDate;
	private Long classs;
	private List<Long> subjectid;
	private Long id;
	private List<ExamSlaveDto> ExamSlaveDto;

	public List<ExamSlaveDto> getExamSlaveDto() {
		return ExamSlaveDto;
	}

	public void setExamSlaveDto(List<ExamSlaveDto> examSlaveDto) {
		ExamSlaveDto = examSlaveDto;
	}

	public String getExamName() {
		return examName;
	}

	public void setExamName(String examName) {
		this.examName = examName;
	}

	public Calendar getExamEndDate() {
		return examEndDate;
	}

	public void setExamEndDate(Calendar examEndDate) {
		this.examEndDate = examEndDate;
	}

	public Calendar getExamStartDate() {
		return examStartDate;
	}

	public void setExamStartDate(Calendar examStartDate) {
		this.examStartDate = examStartDate;
	}

	public Long getClasss() {
		return classs;
	}

	public void setClasss(Long classs) {
		this.classs = classs;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Long> getSubjectid() {
		return subjectid;
	}

	public void setSubjectid(List<Long> subjectid) {
		this.subjectid = subjectid;
	}

}
