package com.techweaversys.dto;

public class SubjectMasterDto {

	private Long id;
	private String subjectName;
	private String semester;
	private String subjectCode;
	private ClassDto classs;

	public SubjectMasterDto() {
		super();
	}

	public SubjectMasterDto(Long id, String subjectName, String semester, String subjectCode, ClassDto classs) {
		super();
		this.id = id;
		this.subjectName = subjectName;
		this.semester = semester;
		this.subjectCode = subjectCode;
		this.classs = classs;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public ClassDto getClasss() {
		return classs;
	}

	public void setClasss(ClassDto classs) {
		this.classs = classs;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((classs == null) ? 0 : classs.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((semester == null) ? 0 : semester.hashCode());
		result = prime * result + ((subjectCode == null) ? 0 : subjectCode.hashCode());
		result = prime * result + ((subjectName == null) ? 0 : subjectName.hashCode());
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
		SubjectMasterDto other = (SubjectMasterDto) obj;
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
		if (semester == null) {
			if (other.semester != null)
				return false;
		} else if (!semester.equals(other.semester))
			return false;
		if (subjectCode == null) {
			if (other.subjectCode != null)
				return false;
		} else if (!subjectCode.equals(other.subjectCode))
			return false;
		if (subjectName == null) {
			if (other.subjectName != null)
				return false;
		} else if (!subjectName.equals(other.subjectName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SubjectMasterDto [id=" + id + ", subjectName=" + subjectName + ", semester=" + semester
				+ ", subjectCode=" + subjectCode + ", classs=" + classs + "]";
	}

}
