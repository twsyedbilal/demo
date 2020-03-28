package com.techweaversys.dto;

import java.util.Calendar;

public class ClassDto {
	private String className;
	private String code;
	private double fees;
	private Long id;
	private Long userId;
	private  String classsCapacity;
	private Calendar classsStartingDate;
	private Calendar classsEndingDate;
	private  String classsLocation;
	private String  classsType;
	

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getClasssCapacity() {
		return classsCapacity;
	}

	public void setClasssCapacity(String classsCapacity) {
		this.classsCapacity = classsCapacity;
	}

	public Calendar getClasssStartingDate() {
		return classsStartingDate;
	}

	public void setClasssStartingDate(Calendar classsStartingDate) {
		this.classsStartingDate = classsStartingDate;
	}

	public Calendar getClasssEndingDate() {
		return classsEndingDate;
	}

	public void setClasssEndingDate(Calendar classsEndingDate) {
		this.classsEndingDate = classsEndingDate;
	}

	public String getClasssLocation() {
		return classsLocation;
	}

	public void setClasssLocation(String classsLocation) {
		this.classsLocation = classsLocation;
	}

	public String getClasssType() {
		return classsType;
	}

	public void setClasssType(String classsType) {
		this.classsType = classsType;
	}

	public ClassDto() {
		super();
	}

	public ClassDto(String className, String code, double fees, Long id) {
		super();
		this.className = className;
		this.code = code;
		this.fees = fees;
		this.id = id;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((className == null) ? 0 : className.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		long temp;
		temp = Double.doubleToLongBits(fees);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		ClassDto other = (ClassDto) obj;
		if (className == null) {
			if (other.className != null)
				return false;
		} else if (!className.equals(other.className))
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (Double.doubleToLongBits(fees) != Double.doubleToLongBits(other.fees))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ClassDto [className=" + className + ", code=" + code + ", fees=" + fees + ", id=" + id + "]";
	}

}
