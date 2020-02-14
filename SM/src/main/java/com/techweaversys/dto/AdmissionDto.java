package com.techweaversys.dto;

import java.util.Calendar;
import java.util.List;

public class AdmissionDto {

	private Long id;
	private Long uidNo;
	private String idNo;
	private String studentRegNo;
	private String year;
	private Calendar date;
	private String surName;
	private String studentsName;
	private String fathersName;
	private String mothersName;
	private String guardiansName;
	private String gender;
	private Calendar dateOfBirth;
	private String dateOfBirthInWords;
	private String placeOfBirth;
	private Long income;
	private String contactNo;
	private String status;
	private String liveStatus;
	private String identityByMarkOrAadharNo;
	private Long classId;
	private Long schoolId;
	private Long schoolTypeId;
	private Long religionId;
	private Long castId;
	private Long subCastId;
	private Long occupationId;
	private Long societyId;
	private Long nationalityId;
	private Long mothertongId;
	private List<AddressDto> address;
	private AcountFeeDto accountFees;
	private List<DocumentDto> document;
	private Integer profileId;
	
	public AdmissionDto() {
		super();
	}

	public AdmissionDto(Long id, Long uidNo, String idNo, String studentRegNo, String year, Calendar date,
			String surName, String studentsName, String fathersName, String mothersName, String guardiansName,
			String gender, Calendar dateOfBirth, String dateOfBirthInWords, String placeOfBirth, Long income,
			String contactNo, String status, String liveStatus, String identityByMarkOrAadharNo, Long classId,
			Long schoolId, Long schoolTypeId, Long religionId, Long castId, Long subCastId, Long occupationId,
			Long societyId, Long nationalityId, Long mothertongId, List<AddressDto> address, AcountFeeDto accountFees,Integer profileId) {
		super();
		this.id = id;
		this.uidNo = uidNo;
		this.idNo = idNo;
		this.studentRegNo = studentRegNo;
		this.year = year;
		this.date = date;
		this.surName = surName;
		this.studentsName = studentsName;
		this.fathersName = fathersName;
		this.mothersName = mothersName;
		this.guardiansName = guardiansName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.dateOfBirthInWords = dateOfBirthInWords;
		this.placeOfBirth = placeOfBirth;
		this.income = income;
		this.contactNo = contactNo;
		this.status = status;
		this.liveStatus = liveStatus;
		this.identityByMarkOrAadharNo = identityByMarkOrAadharNo;
		this.classId = classId;
		this.schoolId = schoolId;
		this.schoolTypeId = schoolTypeId;
		this.religionId = religionId;
		this.castId = castId;
		this.subCastId = subCastId;
		this.occupationId = occupationId;
		this.societyId = societyId;
		this.nationalityId = nationalityId;
		this.mothertongId = mothertongId;
		this.address = address;
		this.accountFees = accountFees;
	}

	public AdmissionDto(String studentRegNo, String year, Calendar date, String studentsName, String gender,
			Calendar dateOfBirth, String dateOfBirthInWords, Long income, String contactNo) {
		super();
		this.studentRegNo = studentRegNo;
		this.year = year;
		this.date = date;
		this.studentsName = studentsName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.dateOfBirthInWords = dateOfBirthInWords;
		this.income = income;
		this.contactNo = contactNo;
	}

	public AcountFeeDto getAccountFees() {
		return accountFees;
	}

	public void setAccountFees(AcountFeeDto accountFees) {
		this.accountFees = accountFees;
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

	public String getStudentRegNo() {
		return studentRegNo;
	}

	public void setStudentRegNo(String studentRegNo) {
		this.studentRegNo = studentRegNo;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public String getIdentityByMarkOrAadharNo() {
		return identityByMarkOrAadharNo;
	}

	public void setIdentityByMarkOrAadharNo(String identityByMarkOrAadharNo) {
		this.identityByMarkOrAadharNo = identityByMarkOrAadharNo;
	}

	public Long getClassId() {
		return classId;
	}

	public void setClassId(Long classId) {
		this.classId = classId;
	}

	public Long getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(Long schoolId) {
		this.schoolId = schoolId;
	}

	public Long getSchoolTypeId() {
		return schoolTypeId;
	}

	public void setSchoolTypeId(Long schoolTypeId) {
		this.schoolTypeId = schoolTypeId;
	}

	public Long getReligionId() {
		return religionId;
	}

	public void setReligionId(Long religionId) {
		this.religionId = religionId;
	}

	public Long getCastId() {
		return castId;
	}

	public void setCastId(Long castId) {
		this.castId = castId;
	}

	public Long getSubCastId() {
		return subCastId;
	}

	public void setSubCastId(Long subCastId) {
		this.subCastId = subCastId;
	}

	public Long getOccupationId() {
		return occupationId;
	}

	public void setOccupationId(Long occupationId) {
		this.occupationId = occupationId;
	}

	public Long getSocietyId() {
		return societyId;
	}

	public void setSocietyId(Long societyId) {
		this.societyId = societyId;
	}

	public Long getNationalityId() {
		return nationalityId;
	}

	public void setNationalityId(Long nationalityId) {
		this.nationalityId = nationalityId;
	}

	public Long getMothertongId() {
		return mothertongId;
	}

	public void setMothertongId(Long mothertongId) {
		this.mothertongId = mothertongId;
	}

	public List<AddressDto> getAddress() {
		return address;
	}

	public void setAddress(List<AddressDto> address) {
		this.address = address;
	}
	public List<DocumentDto> getDocument() {
		return document;
	}

	public void setDocument(List<DocumentDto> document) {
		this.document = document;
	}

	public Integer getProfileId() {
		return profileId;
	}

	public void setProfileId(Integer profileId) {
		this.profileId = profileId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountFees == null) ? 0 : accountFees.hashCode());
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((castId == null) ? 0 : castId.hashCode());
		result = prime * result + ((classId == null) ? 0 : classId.hashCode());
		result = prime * result + ((contactNo == null) ? 0 : contactNo.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + ((dateOfBirthInWords == null) ? 0 : dateOfBirthInWords.hashCode());
		result = prime * result + ((document == null) ? 0 : document.hashCode());
		result = prime * result + ((fathersName == null) ? 0 : fathersName.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((guardiansName == null) ? 0 : guardiansName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idNo == null) ? 0 : idNo.hashCode());
		result = prime * result + ((identityByMarkOrAadharNo == null) ? 0 : identityByMarkOrAadharNo.hashCode());
		result = prime * result + ((income == null) ? 0 : income.hashCode());
		result = prime * result + ((liveStatus == null) ? 0 : liveStatus.hashCode());
		result = prime * result + ((mothersName == null) ? 0 : mothersName.hashCode());
		result = prime * result + ((mothertongId == null) ? 0 : mothertongId.hashCode());
		result = prime * result + ((nationalityId == null) ? 0 : nationalityId.hashCode());
		result = prime * result + ((occupationId == null) ? 0 : occupationId.hashCode());
		result = prime * result + ((placeOfBirth == null) ? 0 : placeOfBirth.hashCode());
		result = prime * result + ((profileId == null) ? 0 : profileId.hashCode());
		result = prime * result + ((religionId == null) ? 0 : religionId.hashCode());
		result = prime * result + ((schoolId == null) ? 0 : schoolId.hashCode());
		result = prime * result + ((schoolTypeId == null) ? 0 : schoolTypeId.hashCode());
		result = prime * result + ((societyId == null) ? 0 : societyId.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((studentRegNo == null) ? 0 : studentRegNo.hashCode());
		result = prime * result + ((studentsName == null) ? 0 : studentsName.hashCode());
		result = prime * result + ((subCastId == null) ? 0 : subCastId.hashCode());
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
		AdmissionDto other = (AdmissionDto) obj;
		if (accountFees == null) {
			if (other.accountFees != null)
				return false;
		} else if (!accountFees.equals(other.accountFees))
			return false;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (castId == null) {
			if (other.castId != null)
				return false;
		} else if (!castId.equals(other.castId))
			return false;
		if (classId == null) {
			if (other.classId != null)
				return false;
		} else if (!classId.equals(other.classId))
			return false;
		if (contactNo == null) {
			if (other.contactNo != null)
				return false;
		} else if (!contactNo.equals(other.contactNo))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		if (dateOfBirthInWords == null) {
			if (other.dateOfBirthInWords != null)
				return false;
		} else if (!dateOfBirthInWords.equals(other.dateOfBirthInWords))
			return false;
		if (document == null) {
			if (other.document != null)
				return false;
		} else if (!document.equals(other.document))
			return false;
		if (fathersName == null) {
			if (other.fathersName != null)
				return false;
		} else if (!fathersName.equals(other.fathersName))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (guardiansName == null) {
			if (other.guardiansName != null)
				return false;
		} else if (!guardiansName.equals(other.guardiansName))
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
		if (identityByMarkOrAadharNo == null) {
			if (other.identityByMarkOrAadharNo != null)
				return false;
		} else if (!identityByMarkOrAadharNo.equals(other.identityByMarkOrAadharNo))
			return false;
		if (income == null) {
			if (other.income != null)
				return false;
		} else if (!income.equals(other.income))
			return false;
		if (liveStatus == null) {
			if (other.liveStatus != null)
				return false;
		} else if (!liveStatus.equals(other.liveStatus))
			return false;
		if (mothersName == null) {
			if (other.mothersName != null)
				return false;
		} else if (!mothersName.equals(other.mothersName))
			return false;
		if (mothertongId == null) {
			if (other.mothertongId != null)
				return false;
		} else if (!mothertongId.equals(other.mothertongId))
			return false;
		if (nationalityId == null) {
			if (other.nationalityId != null)
				return false;
		} else if (!nationalityId.equals(other.nationalityId))
			return false;
		if (occupationId == null) {
			if (other.occupationId != null)
				return false;
		} else if (!occupationId.equals(other.occupationId))
			return false;
		if (placeOfBirth == null) {
			if (other.placeOfBirth != null)
				return false;
		} else if (!placeOfBirth.equals(other.placeOfBirth))
			return false;
		if (profileId == null) {
			if (other.profileId != null)
				return false;
		} else if (!profileId.equals(other.profileId))
			return false;
		if (religionId == null) {
			if (other.religionId != null)
				return false;
		} else if (!religionId.equals(other.religionId))
			return false;
		if (schoolId == null) {
			if (other.schoolId != null)
				return false;
		} else if (!schoolId.equals(other.schoolId))
			return false;
		if (schoolTypeId == null) {
			if (other.schoolTypeId != null)
				return false;
		} else if (!schoolTypeId.equals(other.schoolTypeId))
			return false;
		if (societyId == null) {
			if (other.societyId != null)
				return false;
		} else if (!societyId.equals(other.societyId))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (studentRegNo == null) {
			if (other.studentRegNo != null)
				return false;
		} else if (!studentRegNo.equals(other.studentRegNo))
			return false;
		if (studentsName == null) {
			if (other.studentsName != null)
				return false;
		} else if (!studentsName.equals(other.studentsName))
			return false;
		if (subCastId == null) {
			if (other.subCastId != null)
				return false;
		} else if (!subCastId.equals(other.subCastId))
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
		return "AdmissionDto [id=" + id + ", uidNo=" + uidNo + ", idNo=" + idNo + ", studentRegNo=" + studentRegNo
				+ ", year=" + year + ", date=" + date + ", surName=" + surName + ", studentsName=" + studentsName
				+ ", fathersName=" + fathersName + ", mothersName=" + mothersName + ", guardiansName=" + guardiansName
				+ ", gender=" + gender + ", dateOfBirth=" + dateOfBirth + ", dateOfBirthInWords=" + dateOfBirthInWords
				+ ", placeOfBirth=" + placeOfBirth + ", income=" + income + ", contactNo=" + contactNo + ", status="
				+ status + ", liveStatus=" + liveStatus + ", identityByMarkOrAadharNo=" + identityByMarkOrAadharNo
				+ ", classId=" + classId + ", schoolId=" + schoolId + ", schoolTypeId=" + schoolTypeId + ", religionId="
				+ religionId + ", castId=" + castId + ", subCastId=" + subCastId + ", occupationId=" + occupationId
				+ ", societyId=" + societyId + ", nationalityId=" + nationalityId + ", mothertongId=" + mothertongId
				+ ", address=" + address + ", accountFees=" + accountFees + ", document=" + document + ", profileId="
				+ profileId + "]";
	}

}
