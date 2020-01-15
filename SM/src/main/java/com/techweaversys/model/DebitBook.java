package com.techweaversys.model;

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
@Table(name = "sm_debit_book")
@Where(clause = "deleted=false")
public class DebitBook extends AbstractPersistable {

	private static final long serialVersionUID = 7529664059854535548L;

	@OneToMany(mappedBy = "debitBook", fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JsonIgnore
	private List<DebitSlave> debitSlave;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "admission_id")
	@JsonIgnore
	@NotFound(action = NotFoundAction.IGNORE)
	private Admission admission;

	public DebitBook() {
		super();
	}

	public DebitBook(List<DebitSlave> debitSlave, Admission admission, String type) {
		super();
		this.debitSlave = debitSlave;
		this.admission = admission;
		this.type = type;
	}

	@Column(name = "type")
	private String type;

	public List<DebitSlave> getDebitSlave() {
		return debitSlave;
	}

	public void setDebitSlave(List<DebitSlave> debitSlave) {
		this.debitSlave = debitSlave;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Admission getAdmission() {
		return admission;
	}

	public void setAdmission(Admission admission) {
		this.admission = admission;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((admission == null) ? 0 : admission.hashCode());
		result = prime * result + ((debitSlave == null) ? 0 : debitSlave.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		DebitBook other = (DebitBook) obj;
		if (admission == null) {
			if (other.admission != null)
				return false;
		} else if (!admission.equals(other.admission))
			return false;
		if (debitSlave == null) {
			if (other.debitSlave != null)
				return false;
		} else if (!debitSlave.equals(other.debitSlave))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DebitBook [debitSlave=" + debitSlave + ", admission=" + admission + ", type=" + type + "]";
	}
}
