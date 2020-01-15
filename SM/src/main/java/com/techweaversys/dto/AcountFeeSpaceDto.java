package com.techweaversys.dto;

public class AcountFeeSpaceDto {

	private String classs;
	private String studentName;
	private String uidNo;
	private String idNo;
	private String registerNo;
	private String paymentType;
	private Integer page;
	private Integer size;

	public AcountFeeSpaceDto() {
		super();
	}

	public AcountFeeSpaceDto(String classs, String studentName, String uidNo, String idNo, String registerNo,
			String paymentType, Integer page, Integer size) {
		super();
		this.classs = classs;
		this.studentName = studentName;
		this.uidNo = uidNo;
		this.idNo = idNo;
		this.registerNo = registerNo;
		this.paymentType = paymentType;
		this.page = page;
		this.size = size;
	}

	public String getClasss() {
		return classs;
	}

	public void setClasss(String classs) {
		this.classs = classs;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getUidNo() {
		return uidNo;
	}

	public void setUidNo(String uidNo) {
		this.uidNo = uidNo;
	}

	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public String getRegisterNo() {
		return registerNo;
	}

	public void setRegisterNo(String registerNo) {
		this.registerNo = registerNo;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((classs == null) ? 0 : classs.hashCode());
		result = prime * result + ((idNo == null) ? 0 : idNo.hashCode());
		result = prime * result + ((page == null) ? 0 : page.hashCode());
		result = prime * result + ((paymentType == null) ? 0 : paymentType.hashCode());
		result = prime * result + ((registerNo == null) ? 0 : registerNo.hashCode());
		result = prime * result + ((size == null) ? 0 : size.hashCode());
		result = prime * result + ((studentName == null) ? 0 : studentName.hashCode());
		result = prime * result + ((uidNo == null) ? 0 : uidNo.hashCode());
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
		AcountFeeSpaceDto other = (AcountFeeSpaceDto) obj;
		if (classs == null) {
			if (other.classs != null)
				return false;
		} else if (!classs.equals(other.classs))
			return false;
		if (idNo == null) {
			if (other.idNo != null)
				return false;
		} else if (!idNo.equals(other.idNo))
			return false;
		if (page == null) {
			if (other.page != null)
				return false;
		} else if (!page.equals(other.page))
			return false;
		if (paymentType == null) {
			if (other.paymentType != null)
				return false;
		} else if (!paymentType.equals(other.paymentType))
			return false;
		if (registerNo == null) {
			if (other.registerNo != null)
				return false;
		} else if (!registerNo.equals(other.registerNo))
			return false;
		if (size == null) {
			if (other.size != null)
				return false;
		} else if (!size.equals(other.size))
			return false;
		if (studentName == null) {
			if (other.studentName != null)
				return false;
		} else if (!studentName.equals(other.studentName))
			return false;
		if (uidNo == null) {
			if (other.uidNo != null)
				return false;
		} else if (!uidNo.equals(other.uidNo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AcountFeeSpaceDto [classs=" + classs + ", studentName=" + studentName + ", uidNo=" + uidNo + ", idNo="
				+ idNo + ", registerNo=" + registerNo + ", paymentType=" + paymentType + ", page=" + page + ", size="
				+ size + "]";
	}

}