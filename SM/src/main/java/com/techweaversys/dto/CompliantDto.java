package com.techweaversys.dto;

import java.util.List;

import com.techweaversys.model.Admission;
import com.techweaversys.model.CompliantTypes;
import com.techweaversys.model.Document;

public class CompliantDto {

	private Long id;
	private String remark;
	private Admission admission;
	private CompliantTypes compliantdto;
	private List<Document> document;

	public CompliantDto(Long id, String remark, Admission admission, CompliantTypes compliantdto) {
		super();
		this.id = id;
		this.remark = remark;
		this.admission = admission;
		this.compliantdto = compliantdto;
	}

	public CompliantDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Document> getDocument() {
		return document;
	}

	public void setDocument(List<Document> document) {
		this.document = document;
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

	public Admission getAdmission() {
		return admission;
	}

	public void setAdmission(Admission admission) {
		this.admission = admission;
	}

	public CompliantTypes getCompliantdto() {
		return compliantdto;
	}

	public void setCompliantdto(CompliantTypes compliantdto) {
		this.compliantdto = compliantdto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((admission == null) ? 0 : admission.hashCode());
		result = prime * result + ((compliantdto == null) ? 0 : compliantdto.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		CompliantDto other = (CompliantDto) obj;
		if (admission == null) {
			if (other.admission != null)
				return false;
		} else if (!admission.equals(other.admission))
			return false;
		if (compliantdto == null) {
			if (other.compliantdto != null)
				return false;
		} else if (!compliantdto.equals(other.compliantdto))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
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
		return "CompliantTypeDto [id=" + id + ", remark=" + remark + ", admission=" + admission + ", compliantdto="
				+ compliantdto + "]";
	}

}
