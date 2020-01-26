package com.techweaversys.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.techweaversys.generics.AbstractPersistable;

@Entity
@Table(name = "sm_compliant")
@Where(clause = "deleted=false")
public class Compliant extends AbstractPersistable {

	private static final long serialVersionUID = -126777472266607524L;

	@Column(name = "remark")
	private String remark;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "sm_compliant__sm_document", 
	joinColumns = @JoinColumn(name = "sm_compliant_id"),
	inverseJoinColumns = @JoinColumn(name = "sm_document_id"))
	@JsonIgnore
	private List<Document> document;

	public List<Document> getDocument() {
		return document;
	}

	public void setDocument(List<Document> document) {
		this.document = document;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Compliant() {
		super();
	}

	public Compliant(String remark) {
		super();
		this.remark = remark;
	}

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "admission_id")
	private Admission admission;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "compliant_id")
	private CompliantTypes compliant;

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

	public CompliantTypes getCompliant() {
		return compliant;
	}

	public void setCompliant(CompliantTypes compliant) {
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
		Compliant other = (Compliant) obj;
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
