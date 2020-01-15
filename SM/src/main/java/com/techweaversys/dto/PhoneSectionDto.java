package com.techweaversys.dto;

public class PhoneSectionDto {

	private Long id;
	private String remark;
	private double remainingBalance;
	private AdmissionDto admission;

	public PhoneSectionDto() {
		super();
	}

	public PhoneSectionDto(Long id, String remark, double remainingBalance, AdmissionDto admission) {
		super();
		this.id = id;
		this.remark = remark;
		this.remainingBalance = remainingBalance;
		this.admission = admission;
	}

	public AdmissionDto getAdmission() {
		return admission;
	}

	public void setAdmission(AdmissionDto admission) {
		this.admission = admission;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((admission == null) ? 0 : admission.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhoneSectionDto other = (PhoneSectionDto) obj;
		if (admission == null) {
			if (other.admission != null)
				return false;
		} else if (!admission.equals(other.admission))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
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
		return "PhoneSectionDto [id=" + id + ", remark=" + remark + ", remainingBalance=" + remainingBalance
				+ ", admission=" + admission + "]";
	}

}
