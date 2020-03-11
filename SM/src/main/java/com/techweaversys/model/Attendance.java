package com.techweaversys.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.techweaversys.generics.AbstractPersistable;

@Entity
@Table(name = "sm_attendance")
@Where(clause = "deleted=false")
public class Attendance extends AbstractPersistable {

	private static final long serialVersionUID = 5321094935089067273L;

	@Column(name = "present", nullable = false)
	private Boolean present = false;

	@Column(name = "absent", nullable = false)
	private Boolean absent = false;

	@Column(name = "reason")
	private String reason;

	@Column(name = "types")
	private String types;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "classs_id")
	@JsonIgnore
	@NotFound(action = NotFoundAction.IGNORE)
	private ClassEntity classs;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "user_id")
	@JsonIgnore
	@NotFound(action = NotFoundAction.IGNORE)
	private User user;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "admission_id")
	@JsonIgnore
	@NotFound(action = NotFoundAction.IGNORE)
	private Admission admission;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "subject_id")
	@JsonIgnore
	@NotFound(action = NotFoundAction.IGNORE)
	private SubjectMaster subject;

	public Attendance() {
		super();
	}

	public Attendance(Boolean present, Boolean absent, String reason, String types, ClassEntity classs, User user,
			Admission admission, SubjectMaster subject) {
		super();
		this.present = present;
		this.absent = absent;
		this.reason = reason;
		this.types = types;
		this.classs = classs;
		this.user = user;
		this.admission = admission;
		this.subject = subject;
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

	public ClassEntity getClasss() {
		return classs;
	}

	public void setClasss(ClassEntity classs) {
		this.classs = classs;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Admission getAdmission() {
		return admission;
	}

	public void setAdmission(Admission admission) {
		this.admission = admission;
	}

	public SubjectMaster getSubject() {
		return subject;
	}

	public void setSubject(SubjectMaster subject) {
		this.subject = subject;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((absent == null) ? 0 : absent.hashCode());
		result = prime * result + ((admission == null) ? 0 : admission.hashCode());
		result = prime * result + ((classs == null) ? 0 : classs.hashCode());
		result = prime * result + ((present == null) ? 0 : present.hashCode());
		result = prime * result + ((reason == null) ? 0 : reason.hashCode());
		result = prime * result + ((types == null) ? 0 : types.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Attendance other = (Attendance) obj;
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
		if (types == null) {
			if (other.types != null)
				return false;
		} else if (!types.equals(other.types))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Attendance [present=" + present + ", absent=" + absent + ", reason=" + reason + ", types=" + types
				+ ", classs=" + classs + ", user=" + user + ", admission=" + admission + "]";
	}
}
