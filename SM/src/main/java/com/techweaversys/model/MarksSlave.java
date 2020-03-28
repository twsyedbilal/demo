package com.techweaversys.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.techweaversys.generics.AbstractPersistable;

@Entity
@Table(name = "sm_mark_slave")
@Where(clause = "deleted=false")
public class MarksSlave extends AbstractPersistable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7894393158709346053L;

	@Column(name = "mark")
	private String mark;

	@Column(name = "remark")
	private String remark;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "mark_id")
	@JsonIgnore
	@NotFound(action = NotFoundAction.IGNORE)
	private StudentMark studentMark;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "admission_id")
	@JsonIgnore
	@NotFound(action = NotFoundAction.IGNORE)
	private Admission admission;

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

	public StudentMark getStudentMark() {
		return studentMark;
	}

	public void setStudentMark(StudentMark studentMark) {
		this.studentMark = studentMark;
	}

	public Admission getAdmission() {
		return admission;
	}

	public void setAdmission(Admission admission) {
		this.admission = admission;
	}

}
