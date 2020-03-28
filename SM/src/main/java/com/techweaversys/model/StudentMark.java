package com.techweaversys.model;

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

}
