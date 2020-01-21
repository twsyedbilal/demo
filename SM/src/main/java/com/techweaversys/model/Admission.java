package com.techweaversys.model;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.techweaversys.enums.StatusType;
import com.techweaversys.generics.AbstractPersistable;

@Entity
@Table(name = "sm_admission")
@Where(clause = "deleted=false")
public class Admission extends AbstractPersistable {

	/**
	 * NAME: MAJID
	 * 
	 */
	private static final long serialVersionUID = 4753775683412222205L;

	public Admission() {
		super();
	}

	public Admission(String studentRegNo, String year, Calendar date, String studentsName, Calendar dateOfBirth,
			String dateOfBirthInWords, String gender, Long income, String contactNo) {
		super();
		this.studentRegNo = studentRegNo;
		this.year = year;
		this.date = date;
		this.studentsName = studentsName;
		this.dateOfBirth = dateOfBirth;
		this.dateOfBirthInWords = dateOfBirthInWords;
		this.gender = gender;
		this.income = income;
		this.contactNo = contactNo;
	}

	public Admission(String studentRegNo, Long uidNo, String idNo, String year, Calendar date, String surName,
			String studentsName, String fathersName, String mothersName, String guardiansName, String status,
			String liveStatus, Calendar dateOfBirth, String dateOfBirthInWords, String placeOfBirth, String gender,
			Long income, String contactNo, String identityByMarkOrAadharNo, List<Address> address,
			ClassEntity classOffered, SchoolType schoolType, SchoolEntityy school, Caste caste, Religion religion,
			SubCaste subCaste, PaymentType paymentType, Occupation occupation, MotherTongueEntity motherTongue,
			NationalityEntity nationality, SocietyEntity society) {
		super();
		this.studentRegNo = studentRegNo;
		this.uidNo = uidNo;
		this.idNo = idNo;
		this.year = year;
		this.date = date;
		this.surName = surName;
		this.studentsName = studentsName;
		this.fathersName = fathersName;
		this.mothersName = mothersName;
		this.guardiansName = guardiansName;
		this.status = status;
		this.liveStatus = liveStatus;
		this.dateOfBirth = dateOfBirth;
		this.dateOfBirthInWords = dateOfBirthInWords;
		this.placeOfBirth = placeOfBirth;
		this.gender = gender;
		this.income = income;
		this.contactNo = contactNo;
		this.identityByMarkOrAadharNo = identityByMarkOrAadharNo;
		this.address = address;
		this.classOffered = classOffered;
		this.schoolType = schoolType;
		this.school = school;
		this.caste = caste;
		this.religion = religion;
		this.subCaste = subCaste;
		this.paymentType = paymentType;
		this.occupation = occupation;
		this.motherTongue = motherTongue;
		this.nationality = nationality;
		this.society = society;
	}

	@Column(name = "student_reg_no", nullable = false)
	private String studentRegNo;

	@Column(name = "uid_no", unique = true)
	private Long uidNo;

	@Column(name = "id_no", unique = true)
	private String idNo;

	@Column(name = "year", nullable = false)
	private String year;

	@Column(name = "date", nullable = false)
	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar date;

	@Column(name = "sur_name")
	private String surName;

	@Column(name = "students_name", nullable = false)
	private String studentsName;

	@Column(name = "fathers_name")
	private String fathersName;

	@Column(name = "mothers_name")
	private String mothersName;

	@Column(name = "guardians_name")
	private String guardiansName;

	@Column(name = "status")
	private String status = StatusType.Active.getValue();

	@Column(name = "live_status")
	private String liveStatus;

	@Column(name = "date_of_birth", nullable = false)
	private Calendar dateOfBirth;

	@Column(name = "date_of_birth_in_words", nullable = false)
	private String dateOfBirthInWords;

	@Column(name = "place_of_birth")
	private String placeOfBirth;

	@Column(name = "gender", nullable = false)
	private String gender;

	@Column(name = "income", nullable = false)
	private Long income;

	@Column(name = "contact_no", nullable = false)
	private String contactNo;

	@Column(name = "identity_by_mark_or_aadhar_no")
	private String identityByMarkOrAadharNo;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(
			name = "sm_admission_sm_address", 
			joinColumns = @JoinColumn(name = "sm_admission_id"), 
			inverseJoinColumns = @JoinColumn(name = "sm_address_id")
			  )
	@JsonIgnore
	private List<Address> address;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "sm_admission_sm_document", 
	joinColumns = @JoinColumn(name = "sm_admission_id"),
	inverseJoinColumns = @JoinColumn(name = "sm_document_id"))
	@JsonIgnore
	private List<Document> document;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "sm_class_master_id")
	private ClassEntity classOffered;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "sm_school_type_id")
	private SchoolType schoolType;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "sm_school_id")
	private SchoolEntityy school;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "sm_caste_id")
	private Caste caste;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "sm_religion_id")
	private Religion religion;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "sm_sub_caste_id")
	private SubCaste subCaste;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "sm_payment_type_id")
	private PaymentType paymentType;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "sm_occupation_id")
	private Occupation occupation;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "sm_mother_tongue_id")
	private MotherTongueEntity motherTongue;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "sm_nationality_id")
	private NationalityEntity nationality;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "sm_society_id")
	private SocietyEntity society;
	
	public List<Document> getDocument() {
		return document;
	}

	public void setDocument(List<Document> document) {
		this.document = document;
	}

	public SocietyEntity getSociety() {
		return society;
	}

	public void setSociety(SocietyEntity society) {
		this.society = society;
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

	public NationalityEntity getNationality() {
		return nationality;
	}

	public void setNationality(NationalityEntity nationality) {
		this.nationality = nationality;
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

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public ClassEntity getClassOffered() {
		return classOffered;
	}

	public void setClassOffered(ClassEntity classOffered) {
		this.classOffered = classOffered;
	}

	public SchoolType getSchoolType() {
		return schoolType;
	}

	public void setSchoolType(SchoolType schoolType) {
		this.schoolType = schoolType;
	}

	public SchoolEntityy getSchool() {
		return school;
	}

	public void setSchool(SchoolEntityy school) {
		this.school = school;
	}

	public Caste getCaste() {
		return caste;
	}

	public void setCaste(Caste caste) {
		this.caste = caste;
	}

	public Religion getReligion() {
		return religion;
	}

	public void setReligion(Religion religion) {
		this.religion = religion;
	}

	public SubCaste getSubCaste() {
		return subCaste;
	}

	public void setSubCaste(SubCaste subCaste) {
		this.subCaste = subCaste;
	}

	public PaymentType getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}

	public Occupation getOccupation() {
		return occupation;
	}

	public void setOccupation(Occupation occupation) {
		this.occupation = occupation;
	}

	public MotherTongueEntity getMotherTongue() {
		return motherTongue;
	}

	public void setMotherTongue(MotherTongueEntity motherTongue) {
		this.motherTongue = motherTongue;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((caste == null) ? 0 : caste.hashCode());
		result = prime * result + ((classOffered == null) ? 0 : classOffered.hashCode());
		result = prime * result + ((contactNo == null) ? 0 : contactNo.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + ((dateOfBirthInWords == null) ? 0 : dateOfBirthInWords.hashCode());
		result = prime * result + ((fathersName == null) ? 0 : fathersName.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((guardiansName == null) ? 0 : guardiansName.hashCode());
		result = prime * result + ((idNo == null) ? 0 : idNo.hashCode());
		result = prime * result + ((identityByMarkOrAadharNo == null) ? 0 : identityByMarkOrAadharNo.hashCode());
		result = prime * result + ((income == null) ? 0 : income.hashCode());
		result = prime * result + ((liveStatus == null) ? 0 : liveStatus.hashCode());
		result = prime * result + ((motherTongue == null) ? 0 : motherTongue.hashCode());
		result = prime * result + ((mothersName == null) ? 0 : mothersName.hashCode());
		result = prime * result + ((nationality == null) ? 0 : nationality.hashCode());
		result = prime * result + ((occupation == null) ? 0 : occupation.hashCode());
		result = prime * result + ((paymentType == null) ? 0 : paymentType.hashCode());
		result = prime * result + ((placeOfBirth == null) ? 0 : placeOfBirth.hashCode());
		result = prime * result + ((religion == null) ? 0 : religion.hashCode());
		result = prime * result + ((school == null) ? 0 : school.hashCode());
		result = prime * result + ((schoolType == null) ? 0 : schoolType.hashCode());
		result = prime * result + ((society == null) ? 0 : society.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((studentRegNo == null) ? 0 : studentRegNo.hashCode());
		result = prime * result + ((studentsName == null) ? 0 : studentsName.hashCode());
		result = prime * result + ((subCaste == null) ? 0 : subCaste.hashCode());
		result = prime * result + ((surName == null) ? 0 : surName.hashCode());
		result = prime * result + ((uidNo == null) ? 0 : uidNo.hashCode());
		result = prime * result + ((year == null) ? 0 : year.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Admission other = (Admission) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (caste == null) {
			if (other.caste != null)
				return false;
		} else if (!caste.equals(other.caste))
			return false;
		if (classOffered == null) {
			if (other.classOffered != null)
				return false;
		} else if (!classOffered.equals(other.classOffered))
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
		if (motherTongue == null) {
			if (other.motherTongue != null)
				return false;
		} else if (!motherTongue.equals(other.motherTongue))
			return false;
		if (mothersName == null) {
			if (other.mothersName != null)
				return false;
		} else if (!mothersName.equals(other.mothersName))
			return false;
		if (nationality == null) {
			if (other.nationality != null)
				return false;
		} else if (!nationality.equals(other.nationality))
			return false;
		if (occupation == null) {
			if (other.occupation != null)
				return false;
		} else if (!occupation.equals(other.occupation))
			return false;
		if (paymentType == null) {
			if (other.paymentType != null)
				return false;
		} else if (!paymentType.equals(other.paymentType))
			return false;
		if (placeOfBirth == null) {
			if (other.placeOfBirth != null)
				return false;
		} else if (!placeOfBirth.equals(other.placeOfBirth))
			return false;
		if (religion == null) {
			if (other.religion != null)
				return false;
		} else if (!religion.equals(other.religion))
			return false;
		if (school == null) {
			if (other.school != null)
				return false;
		} else if (!school.equals(other.school))
			return false;
		if (schoolType == null) {
			if (other.schoolType != null)
				return false;
		} else if (!schoolType.equals(other.schoolType))
			return false;
		if (society == null) {
			if (other.society != null)
				return false;
		} else if (!society.equals(other.society))
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
		if (subCaste == null) {
			if (other.subCaste != null)
				return false;
		} else if (!subCaste.equals(other.subCaste))
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
		return "Admission [studentRegNo=" + studentRegNo + ", uidNo=" + uidNo + ", idNo=" + idNo + ", year=" + year
				+ ", date=" + date + ", surName=" + surName + ", studentsName=" + studentsName + ", fathersName="
				+ fathersName + ", mothersName=" + mothersName + ", guardiansName=" + guardiansName + ", status="
				+ status + ", liveStatus=" + liveStatus + ", dateOfBirth=" + dateOfBirth + ", dateOfBirthInWords="
				+ dateOfBirthInWords + ", placeOfBirth=" + placeOfBirth + ", gender=" + gender + ", income=" + income
				+ ", contactNo=" + contactNo + ", identityByMarkOrAadharNo=" + identityByMarkOrAadharNo + ", address="
				+ address + ", classOffered=" + classOffered + ", schoolType=" + schoolType + ", school=" + school
				+ ", caste=" + caste + ", religion=" + religion + ", subCaste=" + subCaste + ", paymentType="
				+ paymentType + ", occupation=" + occupation + ", motherTongue=" + motherTongue + ", nationality="
				+ nationality + ", society=" + society + "]";
	}

	
}