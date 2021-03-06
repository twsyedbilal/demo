package com.techweaversys.dto;

import java.util.Calendar;

public class ClassSpaceDto {

	
	
	
	private String className;
	private String code;
	private double fees;
	private  String classsCapacity;
	private Calendar classsStartingDate;
	private Calendar classsEndingDate;
	private  String classsLocation;
	private String  classsType;
	private Integer page;
	private Integer size;
	private Long id; 

	public Long getId() {
		return id; 
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ClassSpaceDto() {
		super();
	}

	public ClassSpaceDto(String className, String code, double fees, Integer page, Integer size) {
		super();
		this.className = className;
		this.code = code;
		this.fees = fees;
		this.page = page;
		this.size = size;
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
		result = prime * result + ((className == null) ? 0 : className.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		long temp;
		temp = Double.doubleToLongBits(fees);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((page == null) ? 0 : page.hashCode());
		result = prime * result + ((size == null) ? 0 : size.hashCode());
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
		ClassSpaceDto other = (ClassSpaceDto) obj;
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
		if (page == null) {
			if (other.page != null)
				return false;
		} else if (!page.equals(other.page))
			return false;
		if (size == null) {
			if (other.size != null)
				return false;
		} else if (!size.equals(other.size))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ClassSpaceDto [className=" + className + ", code=" + code + ", fees=" + fees + ", page=" + page
				+ ", size=" + size + "]";
	}

}
