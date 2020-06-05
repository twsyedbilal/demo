package com.techweaversys.dto;

import java.util.Calendar;

import com.techweaversys.model.ClassEntity;

public class AdmissionSpecDto {

	private Long id;
	private Long uidNo;
	private String idNo;
	private String year;
	private String surName;
	private String studentsName;
	private Calendar date;
	private Integer page;
	private Integer size;
	private ClassEntity classOffered;
	private String status;
	private String liveStatus;
	private String address;
	private String studentRegNo;
	
	public AdmissionSpecDto() {
		super();
	}

	public AdmissionSpecDto(Long id, Long uidNo, String idNo, String year, String surName, String studentsName,
			Calendar date, Integer page, Integer size, ClassEntity classOffered, String status, String liveStatus,
			String address, String studentRegNo) {
		super();
		this.id = id;
		this.uidNo = uidNo;
		this.idNo = idNo;
		this.year = year;
		this.surName = surName;
		this.studentsName = studentsName;
		this.date = date;
		this.page = page;
		this.size = size;
		this.classOffered = classOffered;
		this.status = status;
		this.liveStatus = liveStatus;
		this.address = address;
		this.studentRegNo = studentRegNo;
	}


	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUidNo() {
		return uidNo;
	}

	public void setUidNo(Long uidNo) {
		this.uidNo = uidNo;
	}

	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public String getStudentsName() {
		return studentsName;
	}

	public void setStudentsName(String studentsName) {
		this.studentsName = studentsName;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
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

	public ClassEntity getClassOffered() {
		return classOffered;
	}

	public void setClassOffered(ClassEntity classOffered) {
		this.classOffered = classOffered;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLiveStatus() {
		return liveStatus;
	}

	public void setLiveStatus(String liveStatus) {
		this.liveStatus = liveStatus;
	}

	public String getStudentRegNo() {
		return studentRegNo;
	}

	public void setStudentRegNo(String studentRegNo) {
		this.studentRegNo = studentRegNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((classOffered == null) ? 0 : classOffered.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idNo == null) ? 0 : idNo.hashCode());
		result = prime * result + ((liveStatus == null) ? 0 : liveStatus.hashCode());
		result = prime * result + ((page == null) ? 0 : page.hashCode());
		result = prime * result + ((size == null) ? 0 : size.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((studentsName == null) ? 0 : studentsName.hashCode());
		result = prime * result + ((surName == null) ? 0 : surName.hashCode());
		result = prime * result + ((uidNo == null) ? 0 : uidNo.hashCode());
		result = prime * result + ((year == null) ? 0 : year.hashCode());
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
		AdmissionSpecDto other = (AdmissionSpecDto) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (classOffered == null) {
			if (other.classOffered != null)
				return false;
		} else if (!classOffered.equals(other.classOffered))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idNo == null) {
			if (other.idNo != null)
				return false;
		} else if (!idNo.equals(other.idNo))
			return false;
		if (liveStatus == null) {
			if (other.liveStatus != null)
				return false;
		} else if (!liveStatus.equals(other.liveStatus))
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
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (studentsName == null) {
			if (other.studentsName != null)
				return false;
		} else if (!studentsName.equals(other.studentsName))
			return false;
		if (surName == null) {
			if (other.surName != null)
				return false;
		} else if (!surName.equals(other.surName))
			return false;
		if (uidNo == null) {
			if (other.uidNo != null)
				return false;
		} else if (!uidNo.equals(other.uidNo))
			return false;
		if (year == null) {
			if (other.year != null)
				return false;
		} else if (!year.equals(other.year))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AdmissionSpecDto [id=" + id + ", uidNo=" + uidNo + ", idNo=" + idNo + ", year=" + year + ", surName="
				+ surName + ", studentsName=" + studentsName + ", date=" + date + ", page=" + page + ", size=" + size
				+ ", classOffered=" + classOffered + ", status=" + status + ", liveStatus=" + liveStatus + ", address="
				+ address + ", studentRegNo=" + studentRegNo + "]";
	}



}
