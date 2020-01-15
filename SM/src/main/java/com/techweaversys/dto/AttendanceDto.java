package com.techweaversys.dto;

public class AttendanceDto {

	private Long id;
	private Boolean present = false;
	private Boolean absent = false;
	private String reason;
	private String types;
	private UserDto userdto;
	private ClassDto classdto;
	private AdmissionDto admissiondto;
	private SubjectMasterDto subjectdto;

	public AttendanceDto(Long id, Boolean present, Boolean absent, String reason, String types, UserDto userdto,
			ClassDto classdto, AdmissionDto admissiondto, SubjectMasterDto subjectdto) {
		super();
		this.id = id;
		this.present = present;
		this.absent = absent;
		this.reason = reason;
		this.types = types;
		this.userdto = userdto;
		this.classdto = classdto;
		this.admissiondto = admissiondto;
		this.subjectdto = subjectdto;
	}

	public AttendanceDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getPresent() {
		return present;
	}

	public void setPresent(Boolean present) {
		this.present = present;
	}

	public Boolean getAbsent() {
		return absent;
	}

	public void setAbsent(Boolean absent) {
		this.absent = absent;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getTypes() {
		return types;
	}

	public void setTypes(String types) {
		this.types = types;
	}

	public UserDto getUserdto() {
		return userdto;
	}

	public void setUserdto(UserDto userdto) {
		this.userdto = userdto;
	}

	public ClassDto getClassdto() {
		return classdto;
	}

	public void setClassdto(ClassDto classdto) {
		this.classdto = classdto;
	}

	public AdmissionDto getAdmissiondto() {
		return admissiondto;
	}

	public void setAdmissiondto(AdmissionDto admissiondto) {
		this.admissiondto = admissiondto;
	}

	public SubjectMasterDto getSubjectdto() {
		return subjectdto;
	}

	public void setSubjectdto(SubjectMasterDto subjectdto) {
		this.subjectdto = subjectdto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((absent == null) ? 0 : absent.hashCode());
		result = prime * result + ((admissiondto == null) ? 0 : admissiondto.hashCode());
		result = prime * result + ((classdto == null) ? 0 : classdto.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((present == null) ? 0 : present.hashCode());
		result = prime * result + ((reason == null) ? 0 : reason.hashCode());
		result = prime * result + ((subjectdto == null) ? 0 : subjectdto.hashCode());
		result = prime * result + ((types == null) ? 0 : types.hashCode());
		result = prime * result + ((userdto == null) ? 0 : userdto.hashCode());
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
		AttendanceDto other = (AttendanceDto) obj;
		if (absent == null) {
			if (other.absent != null)
				return false;
		} else if (!absent.equals(other.absent))
			return false;
		if (admissiondto == null) {
			if (other.admissiondto != null)
				return false;
		} else if (!admissiondto.equals(other.admissiondto))
			return false;
		if (classdto == null) {
			if (other.classdto != null)
				return false;
		} else if (!classdto.equals(other.classdto))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (present == null) {
			if (other.present != null)
				return false;
		} else if (!present.equals(other.present))
			return false;
		if (reason == null) {
			if (other.reason != null)
				return false;
		} else if (!reason.equals(other.reason))
			return false;
		if (subjectdto == null) {
			if (other.subjectdto != null)
				return false;
		} else if (!subjectdto.equals(other.subjectdto))
			return false;
		if (types == null) {
			if (other.types != null)
				return false;
		} else if (!types.equals(other.types))
			return false;
		if (userdto == null) {
			if (other.userdto != null)
				return false;
		} else if (!userdto.equals(other.userdto))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AttendanceDto [id=" + id + ", present=" + present + ", absent=" + absent + ", reason=" + reason
				+ ", types=" + types + ", userdto=" + userdto + ", classdto=" + classdto + ", admissiondto="
				+ admissiondto + ", subjectdto=" + subjectdto + "]";
	}

}
