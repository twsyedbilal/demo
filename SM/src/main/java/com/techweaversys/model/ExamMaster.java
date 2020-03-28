package com.techweaversys.model;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.techweaversys.generics.AbstractPersistable;


@Entity
@Table(name="sm_exam")
@Where(clause = "deleted=false")
public class ExamMaster extends  AbstractPersistable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3502138615807786731L;

	@Column(name="exam_name")
	private String examName;
	
	@Column(name="exam_start_date")
	private Calendar examStartDate;
	
	@Column(name="exam_end_date")
	private Calendar examEndDate;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "classs_id")
	@JsonIgnore
	@NotFound(action = NotFoundAction.IGNORE)
	private ClassEntity classs;
	
	
	@OneToMany(mappedBy = "examMaster", fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JsonIgnore
	private List<ExamSlave> examSlave;


	public String getExamName() {
		return examName;
	}


	public void setExamName(String examName) {
		this.examName = examName;
	}


	public Calendar getExamStartDate() {
		return examStartDate;
	}


	public void setExamStartDate(Calendar examStartDate) {
		this.examStartDate = examStartDate;
	}


	public Calendar getExamEndDate() {
		return examEndDate;
	}


	public void setExamEndDate(Calendar examEndDate) {
		this.examEndDate = examEndDate;
	}


	public ClassEntity getClasssEntity() {
		return classs;
	}


	public void setClasssEntity(ClassEntity classsEntity) {
		this.classs = classsEntity;
	}


	public List<ExamSlave> getExamSlave() {
		return examSlave;
	}


	public void setExamSlave(List<ExamSlave> examSlave) {
		this.examSlave = examSlave;
	}
	
		
}
