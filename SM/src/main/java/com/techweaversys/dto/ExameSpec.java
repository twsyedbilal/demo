package com.techweaversys.dto;

import com.techweaversys.model.SubjectMaster;

public class ExameSpec {

	private String examName;
	private String examEndtDate;
	private String examStarttDate;
	private Integer page;
	private Integer size;
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ExameSpec() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getExamName() {
		return examName;
	}

	public void setExamName(String examName) {
		this.examName = examName;
	}

	public String getExamEndtDate() {
		return examEndtDate;
	}

	public void setExamEndtDate(String examEndtDate) {
		this.examEndtDate = examEndtDate;
	}

	public String getExamStarttDate() {
		return examStarttDate;
	}

	public void setExamStarttDate(String examStarttDate) {
		this.examStarttDate = examStarttDate;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "ExameSpec [examName=" + examName + ", examEndtDate=" + examEndtDate + ", examStarttDate="
				+ examStarttDate + ", page=" + page + ", size=" + size + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

}
