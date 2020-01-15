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
@Table(name = "sm_credit_book")
@Where(clause = "deleted=false")
public class CreditBook extends AbstractPersistable {

	private static final long serialVersionUID = -2782238270090192080L;

	@OneToMany(mappedBy = "creditBook", fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JsonIgnore
	private List<CreditSlave> CreditSlave;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "admission_id")
	@JsonIgnore
	@NotFound(action = NotFoundAction.IGNORE)
	private Admission admission;

	@Column(name ="type")
	private String type;

	public CreditBook() {
		super();
	}
	public CreditBook(List<com.techweaversys.model.CreditSlave> creditSlave, Admission admission, String type) {
		super();
		CreditSlave = creditSlave;
		this.admission = admission;
		this.type = type;
	}

	public List<CreditSlave> getBookSlave() {
		return CreditSlave;
	}

	public void setBookSlave(List<CreditSlave> CreditSlave) {
		this.CreditSlave = CreditSlave;
	}

	public Admission getAdmission() {
		return admission;
	}

	public void setAdmission(Admission admission) {
		this.admission = admission;
	}

	public List<CreditSlave> getCreditSlave() {
		return CreditSlave;
	}

	public void setCreditSlave(List<CreditSlave> creditSlave) {
		CreditSlave = creditSlave;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((CreditSlave == null) ? 0 : CreditSlave.hashCode());
		result = prime * result + ((admission == null) ? 0 : admission.hashCode());
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
		CreditBook other = (CreditBook) obj;
		if (CreditSlave == null) {
			if (other.CreditSlave != null)
				return false;
		} else if (!CreditSlave.equals(other.CreditSlave))
			return false;
		if (admission == null) {
			if (other.admission != null)
				return false;
		} else if (!admission.equals(other.admission))
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
		return "CreditBook [CreditSlave=" + CreditSlave + ", admission=" + admission + ", type=" + type + "]";
	}
}
