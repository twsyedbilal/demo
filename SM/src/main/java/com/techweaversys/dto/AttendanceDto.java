package com.techweaversys.dto;

public class AttendanceDto {

	private Long id;
	private Boolean present = false;
	private Boolean absent = false;
	private String reason;
	private String types;
	private UserDto userdto;
	private ClassDto classs;
	private AdmissionDto admission;
	private SubjectMasterDto subject;

	public AttendanceDto(Long id, Boolean present, Boolean absent, String reason, String types, UserDto userdto,
			ClassDto classs, AdmissionDto admission, SubjectMasterDto subject) {
		super();
		this.id = id;
		this.present = present;
		this.absent = absent;
		this.reason = reason;
		this.types = types;
		this.userdto = userdto;
		this.classs = classs;
		this.admission = admission;
		this.subject = subject;
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

	/*
	 * public ClassDto getClassdto() { return classdto; }
	 * 
	 * public void setClassdto(ClassDto classdto) { this.classdto = classdto; }
	 */
	public AdmissionDto getAdmission() {
		return admission;
	}

	public void setAdmission(AdmissionDto admission) {
		this.admission = admission;
	}

	public SubjectMasterDto getSubjectdto() {
		return subject;
	}

	public void setSubjectdto(SubjectMasterDto subject) {
		this.subject = subject;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((absent == null) ? 0 : absent.hashCode());
		result = prime * result + ((admission == null) ? 0 : admission.hashCode());
		result = prime * result + ((classs == null) ? 0 : classs.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((present == null) ? 0 : present.hashCode());
		result = prime * result + ((reason == null) ? 0 : reason.hashCode());
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
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
		if (admission == null) {
			if (other.admission != null)
				return false;
		} else if (!admission.equals(other.admission))
			return false;
		if (classs == null) {
			if (other.classs != null)
				return false;
		} else if (!classs.equals(other.classs))
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
		if (subject == null) {
			if (other.subject != null)
				return false;
		} else if (!subject.equals(other.subject))
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

	public ClassDto getClasss() {
		return classs;
	}

	public void setClasss(ClassDto classs) {
		this.classs = classs;
	}

	@Override
	public String toString() {
		return "AttendanceDto [id=" + id + ", present=" + present + ", absent=" + absent + ", reason=" + reason
				+ ", types=" + types + ", userdto=" + userdto + ", classs=" + classs + ", admission="
				+ admission + ", subject=" + subject + "]";
	}

}
