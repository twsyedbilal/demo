package com.techweaversys.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import com.techweaversys.generics.AbstractPersistable;

@Entity
@Table(name = "sm_payment_type")
@Where(clause = "deleted=false")
public class PaymentType extends AbstractPersistable {

	/**
	 * Name: MAJID
	 */
	private static final long serialVersionUID = -1669751946416320963L;

	@Column(name = "payment_type_name", nullable = false)
	private String paymentTypeName;

	@Column(name = "payment_type_code")
	private String paymentTypeCode;

	public PaymentType() {
		super();
	}

	public PaymentType(String paymentTypeName, String paymentTypeCode) {
		super();
		this.paymentTypeName = paymentTypeName;
		this.paymentTypeCode = paymentTypeCode;
	}

	public String getPaymentTypeName() {
		return paymentTypeName;
	}

	public void setPaymentTypeName(String paymentTypeName) {
		this.paymentTypeName = paymentTypeName;
	}

	public String getPaymentTypeCode() {
		return paymentTypeCode;
	}

	public void setPaymentTypeCode(String paymentTypeCode) {
		this.paymentTypeCode = paymentTypeCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((paymentTypeCode == null) ? 0 : paymentTypeCode.hashCode());
		result = prime * result + ((paymentTypeName == null) ? 0 : paymentTypeName.hashCode());
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
		PaymentType other = (PaymentType) obj;
		if (paymentTypeCode == null) {
			if (other.paymentTypeCode != null)
				return false;
		} else if (!paymentTypeCode.equals(other.paymentTypeCode))
			return false;
		if (paymentTypeName == null) {
			if (other.paymentTypeName != null)
				return false;
		} else if (!paymentTypeName.equals(other.paymentTypeName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PaymentType [paymentTypeName=" + paymentTypeName + ", paymentTypeCode=" + paymentTypeCode + "]";
	}

}
