package com.techweaversys.dto;

public class AcountFeeDto {

	private Long id;
	private double fee;
	private double paid;
	private double balance;
	private double actualPaid;
	private ClassDto classs;
	private AdmissionDto admission;
	private PaymentTypeDto paymentType;

	public AcountFeeDto() {
		super();
	}

	public AcountFeeDto(Long id, double fee, double paid, double balance, double actualPaid, ClassDto classs,
			AdmissionDto admission, PaymentTypeDto paymentType) {
		super();
		this.id = id;
		this.fee = fee;
		this.paid = paid;
		this.balance = balance;
		this.actualPaid = actualPaid;
		this.classs = classs;
		this.admission = admission;
		this.paymentType = paymentType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public ClassDto getClasss() {
		return classs;
	}

	public void setClasss(ClassDto classs) {
		this.classs = classs;
	}

	public AdmissionDto getAdmission() {
		return admission;
	}

	public void setAdmission(AdmissionDto admission) {
		this.admission = admission;
	}

	public PaymentTypeDto getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(PaymentTypeDto paymentType) {
		this.paymentType = paymentType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(actualPaid);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((admission == null) ? 0 : admission.hashCode());
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((classs == null) ? 0 : classs.hashCode());
		temp = Double.doubleToLongBits(fee);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		temp = Double.doubleToLongBits(paid);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((paymentType == null) ? 0 : paymentType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AcountFeeDto other = (AcountFeeDto) obj;
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
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
		return "AcountFeeDto [id=" + id + ", fee=" + fee + ", paid=" + paid + ", balance=" + balance + ", actualPaid="
				+ actualPaid + ", classs=" + classs + ", admission=" + admission + ", paymentType=" + paymentType + "]";
	}

}