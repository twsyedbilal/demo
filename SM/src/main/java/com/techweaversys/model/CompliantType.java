package com.techweaversys.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import com.techweaversys.generics.AbstractPersistable;

@Entity
@Table(name = "sm_compliant_type")
@Where(clause = "deleted=false")
public class CompliantType extends AbstractPersistable {

	private static final long serialVersionUID = -126777472266607524L;

	@Column(name = "remark")
	private String remark;

	public CompliantType() {
		super();
	}

	public CompliantType(String remark) {
		super();
		this.remark = remark;
	}

	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="admission_id")
	private Admission admission;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="compliant_id")
	private Compliant compliant;

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Admission getAdmission() {
		return admission;
	}

	public void setAdmission(Admission admission) {
		this.admission = admission;
	}

	public Compliant getCompliant() {
		return compliant;
	}

	public void setCompliant(Compliant compliant) {
		this.compliant = compliant;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((admission == null) ? 0 : admission.hashCode());
		result = prime * result + ((compliant == null) ? 0 : compliant.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompliantType other = (CompliantType) obj;
		if (admission == null) {
			if (other.admission != null)
				return false;
		} else if (!admission.equals(other.admission))
			return false;
		if (compliant == null) {
			if (other.compliant != null)
				return false;
		} else if (!compliant.equals(other.compliant))
			return false;
		if (remark == null) {
			if (other.remark != null)
				return false;
		} else if (!remark.equals(other.remark))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CompliantType [remark=" + remark + ", admission=" + admission + ", compliant=" + compliant + "]";
	}
}
