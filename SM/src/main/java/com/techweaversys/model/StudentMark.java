package com.techweaversys.model;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
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
@Table(name = "sm_student_mark")
@Where(clause = "deleted=false")
public class StudentMark extends AbstractPersistable {

	/**
	 *  
	 */
	private static final long serialVersionUID = -6193166926421979748L;

	@ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	@JoinColumn(name = "classs_id")
	@JsonIgnore
	@NotFound(action = NotFoundAction.IGNORE)
	private ClassEntity classs;

    @ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "exam_id")
	@JsonIgnore
	@NotFound(action = NotFoundAction.IGNORE)
	private ExamMaster examMaster;

	
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "subject_id")
	@JsonIgnore
	@NotFound(action = NotFoundAction.IGNORE)
	private SubjectMaster subjectMaster;

	@OneToMany(mappedBy = "studentMark", fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JsonIgnore
	private List<MarksSlave> marksSlaves;

	public ClassEntity getClasss() {
		return classs;
	}

	public void setClasss(ClassEntity classs) {
		this.classs = classs;
	}

	public ExamMaster getExamMaster() {
		return examMaster;
	}

	public void setExamMaster(ExamMaster examMaster) {
		this.examMaster = examMaster;
	}

	public SubjectMaster getSubjectMaster() {
		return subjectMaster;
	}

	public void setSubjectMaster(SubjectMaster subjectMaster) {
		this.subjectMaster = subjectMaster;
	}

	public List<MarksSlave> getMarksSlaves() {
		return marksSlaves;
	}

	public void setMarksSlaves(List<MarksSlave> marksSlaves) {
		this.marksSlaves = marksSlaves;
	}

	@Override
	public String toString() {
		return "StudentMark [classs=" + classs + ", examMaster=" + examMaster + ", subjectMaster=" + subjectMaster
				+ ", marksSlaves=" + marksSlaves + ", getClasss()=" + getClasss() + ", getExamMaster()="
				+ getExamMaster() + ", getSubjectMaster()=" + getSubjectMaster() + ", getMarksSlaves()="
				+ getMarksSlaves() + ", getId()=" + getId() + ", isNew()=" + isNew() + ", getDeleted()=" + getDeleted()
				+ ", getCreated()=" + getCreated() + ", getModified()=" + getModified() + ", toString()="
				+ super.toString() + ", hashCode()=" + hashCode() + ", getClass()=" + getClass() + "]";
	}

	public StudentMark() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return super.getId();
	}

	@Override
	public void setId(Long id) {
		// TODO Auto-generated method stub
		super.setId(id);
	}

	@Override
	public boolean isNew() {
		// TODO Auto-generated method stub
		return super.isNew();
	}

	@Override
	public Boolean getDeleted() {
		// TODO Auto-generated method stub
		return super.getDeleted();
	}

	@Override
	public void setDeleted(Boolean deleted) {
		// TODO Auto-generated method stub
		super.setDeleted(deleted);
	}

	@Override
	public Calendar getCreated() {
		// TODO Auto-generated method stub
		return super.getCreated();
	}

	@Override
	public void setCreated(Calendar created) {
		// TODO Auto-generated method stub
		super.setCreated(created);
	}

	@Override
	public Calendar getModified() {
		// TODO Auto-generated method stub
		return super.getModified();
	}

	@Override
	public void setModified(Calendar modified) {
		// TODO Auto-generated method stub
		super.setModified(modified);
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}
	

}
