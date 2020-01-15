package com.techweaversys.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.techweaversys.generics.AbstractPersistable;

@Entity
@Table(name = "sm_account_phone_section")
public class PhoneSection extends AbstractPersistable {
	private static final long serialVersionUID = 4869638572659268902L;

	@Column(name = "remark")
	private String remark;

	@Column(name = "remaning_balance")
	private double remainingBalance;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "sm_admission_id")
	private Admission admission;

	public PhoneSection() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PhoneSection(String remark, double remainingBalance, Admission admission) {
		super();
		this.remark = remark;
		this.remainingBalance = remainingBalance;
		this.admission = admission;
	}

	public Admission getAdmission() {
		return admission;
	}

	public void setAdmission(Admission admission) {
		this.admission = admission;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public double getRemainingBalance() {
		return remainingBalance;
	}

	public void setRemainingBalance(double remainingBalance) {
		this.remainingBalance = remainingBalance;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((admission == null) ? 0 : admission.hashCode());
		long temp;
		temp = Double.doubleToLongBits(remainingBalance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		PhoneSection other = (PhoneSection) obj;
		if (admission == null) {
			if (other.admission != null)
				return false;
		} else if (!admission.equals(other.admission))
			return false;
		if (Double.doubleToLongBits(remainingBalance) != Double.doubleToLongBits(other.remainingBalance))
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
		return "PhoneSection [remark=" + remark + ", remainingBalance=" + remainingBalance + ", admission=" + admission
				+ "]";
	}

}
