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
@Table(name = "sm_account_fee")
@Where(clause = "deleted=false")
public class AcountFee extends AbstractPersistable {

	private static final long serialVersionUID = 5879291196798458449L;

	@Column(name = "fee")
	private double fee;

	@Column(name = "paid")
	private double paid;

	@Column(name = "balance")
	private double balance;

	@Column(name = "actual_paid")
	private double actualPaid;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "sm_admission_id")
	private Admission admission;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "sm_class_master_id")
	private ClassEntity classs;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "payment_type_id")
	private PaymentType paymentType;

	public PaymentType getPaymentType() {
		return paymentType;
	}

	public PaymentType getPaymentType(PaymentType b) {
		return paymentType;
	}

	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}

	public double getPaid() {
		return paid;
	}

	public void setPaid(double paid) {
		this.paid = paid;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getActualPaid() {
		return actualPaid;
	}

	public void setActualPaid(double actualPaid) {
		this.actualPaid = actualPaid;
	}

	public Admission getAdmission() {
		return admission;
	}

	public void setAdmission(Admission admission) {
		this.admission = admission;
	}

	public ClassEntity getClasss() {
		return classs;
	}

	public void setClasss(ClassEntity classs) {
		this.classs = classs;
	}

	public AcountFee(double fee, double paid, double balance, double actualPaid, Admission admission,
			ClassEntity classs) {
		super();
		this.fee = fee;
		this.paid = paid;
		this.balance = balance;
		this.actualPaid = actualPaid;
		this.admission = admission;
		this.classs = classs;
	}

	public AcountFee() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(actualPaid);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((admission == null) ? 0 : admission.hashCode());
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((classs == null) ? 0 : classs.hashCode());
		temp = Double.doubleToLongBits(fee);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(paid);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((paymentType == null) ? 0 : paymentType.hashCode());
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
		AcountFee other = (AcountFee) obj;
		if (Double.doubleToLongBits(actualPaid) != Double.doubleToLongBits(other.actualPaid))
			return false;
		if (admission == null) {
			if (other.admission != null)
				return false;
		} else if (!admission.equals(other.admission))
			return false;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		if (classs == null) {
			if (other.classs != null)
				return false;
		} else if (!classs.equals(other.classs))
			return false;
		if (Double.doubleToLongBits(fee) != Double.doubleToLongBits(other.fee))
			return false;
		if (Double.doubleToLongBits(paid) != Double.doubleToLongBits(other.paid))
			return false;
		if (paymentType == null) {
			if (other.paymentType != null)
				return false;
		} else if (!paymentType.equals(other.paymentType))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AccountFee [fee=" + fee + ", paid=" + paid + ", balance=" + balance + ", actualPaid=" + actualPaid
				+ ", admission=" + admission + ", classs=" + classs + ", getFee()=" + getFee() + ", getPaid()="
				+ getPaid() + ", getBalance()=" + getBalance() + ", getActualPaid()=" + getActualPaid()
				+ ", getAdmission()=" + getAdmission() + ", getClasss()=" + getClasss() + ", getId()=" + getId()
				+ ", isNew()=" + isNew() + ", getDeleted()=" + getDeleted() + ", getCreated()=" + getCreated()
				+ ", getModified()=" + getModified() + ", toString()=" + super.toString() + ", hashCode()=" + hashCode()
				+ ", getClass()=" + getClass() + "]";
	}

}
