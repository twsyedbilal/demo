package com.techweaversys.dto;

import java.util.Calendar;

import com.techweaversys.enums.StatusType;

public class AdmissionListDto {

	private Long id;
	private String studentRegNo;
	private Long uidNo;
	private String idNo;
	private String year;
	private Calendar date;
	private String surName;
	private String studentsName;
	private String fathersName;
	private String mothersName;
	private String guardiansName;
	private String status = StatusType.Active.getValue();
	private String liveStatus;
	private Calendar dateOfBirth;
	private String dateOfBirthInWords;
	private String placeOfBirth;
	private String gender;
	private Long income;
	private String contactNo;
	private String identityByMarkOrAadharNo;
	private Integer profileId;
	private String classOffered;
	private String school;
	private String schoolType;
	private String religion;
	private String caste;
	private String subCaste;
	private String occupation;
	private String society;
	private String nationality;
	private String motherTongue;
	private String address;
	private String document;
	private String rollNo;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStudentRegNo() {
		return studentRegNo;
	}
	public void setStudentRegNo(String studentRegNo) {
		this.studentRegNo = studentRegNo;
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
	public Calendar getDate() {
		return date;
	}
	public void setDate(Calendar date) {
		this.date = date;
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
	public String getFathersName() {
		return fathersName;
	}
	public void setFathersName(String fathersName) {
		this.fathersName = fathersName;
	}
	public String getMothersName() {
		return mothersName;
	}
	public void setMothersName(String mothersName) {
		this.mothersName = mothersName;
	}
	public String getGuardiansName() {
		return guardiansName;
	}
	public void setGuardiansName(String guardiansName) {
		this.guardiansName = guardiansName;
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
	public Calendar getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Calendar dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getDateOfBirthInWords() {
		return dateOfBirthInWords;
	}
	public void setDateOfBirthInWords(String dateOfBirthInWords) {
		this.dateOfBirthInWords = dateOfBirthInWords;
	}
	public String getPlaceOfBirth() {
		return placeOfBirth;
	}
	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Long getIncome() {
		return income;
	}
	public void setIncome(Long income) {
		this.income = income;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getIdentityByMarkOrAadharNo() {
		return identityByMarkOrAadharNo;
	}
	public void setIdentityByMarkOrAadharNo(String identityByMarkOrAadharNo) {
		this.identityByMarkOrAadharNo = identityByMarkOrAadharNo;
	}
	public Integer getProfileId() {
		return profileId;
	}
	public void setProfileId(Integer profileId) {
		this.profileId = profileId;
	}
	public String getClassOffered() {
		return classOffered;
	}
	public void setClassOffered(String classOffered) {
		this.classOffered = classOffered;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getSchoolType() {
		return schoolType;
	}
	public void setSchoolType(String schoolType) {
		this.schoolType = schoolType;
	}
	public String getReligion() {
		return religion;
	}
	public void setReligion(String religion) {
		this.religion = religion;
	}
	public String getCaste() {
		return caste;
	}
	public void setCaste(String caste) {
		this.caste = caste;
	}
	public String getSubCaste() {
		return subCaste;
	}
	public void setSubCaste(String subCaste) {
		this.subCaste = subCaste;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getSociety() {
		return society;
	}
	public void setSociety(String society) {
		this.society = society;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getMotherTongue() {
		return motherTongue;
	}
	public void setMotherTongue(String motherTongue) {
		this.motherTongue = motherTongue;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDocument() {
		return document;
	}
	public void setDocument(String document) {
		this.document = document;
	}
	public String getRollNo() {
		return rollNo;
	}
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}
	@Override
	public String toString() {
		return "AdmissionListDto [id=" + id + ", studentRegNo=" + studentRegNo + ", uidNo=" + uidNo + ", idNo=" + idNo
				+ ", year=" + year + ", date=" + date + ", surName=" + surName + ", studentsName=" + studentsName
				+ ", fathersName=" + fathersName + ", mothersName=" + mothersName + ", guardiansName=" + guardiansName
				+ ", status=" + status + ", liveStatus=" + liveStatus + ", dateOfBirth=" + dateOfBirth
				+ ", dateOfBirthInWords=" + dateOfBirthInWords + ", placeOfBirth=" + placeOfBirth + ", gender=" + gender
				+ ", income=" + income + ", contactNo=" + contactNo + ", identityByMarkOrAadharNo="
				+ identityByMarkOrAadharNo + ", profileId=" + profileId + ", classOffered=" + classOffered + ", school="
				+ school + ", schoolType=" + schoolType + ", religion=" + religion + ", caste=" + caste + ", subCaste="
				+ subCaste + ", occupation=" + occupation + ", society=" + society + ", nationality=" + nationality
				+ ", motherTongue=" + motherTongue + ", address=" + address + ", document=" + document + ", rollNo="
				+ rollNo + "]";
	}

}
