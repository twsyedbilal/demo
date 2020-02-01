package com.techweaversys.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import com.techweaversys.generics.AbstractPersistable;

@Entity
@Table(name = "sm_log")
@Where(clause = "deleted=false")
public class Log extends AbstractPersistable{

	private static final long serialVersionUID = -4594914035417378975L;

	public Log() {
		super();
	}
	
	public Log(String name, String message, String logInfo, Admission admission) {
		super();
		this.name = name;
		this.message = message;
		this.logInfo = logInfo;
		this.admission = admission;
	}

	@Column(name = "name")
	private String name;
	
	@Column(name = "message")
	private String message;
	
	@Column(name = "log_info")
	private String logInfo;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "admission_id")
	private Admission admission;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getLogInfo() {
		return logInfo;
	}

	public void setLogInfo(String logInfo) {
		this.logInfo = logInfo;
	}

	public Admission getAdmission() {
		return admission;
	}

	public void setAdmission(Admission admission) {
		this.admission = admission;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((admission == null) ? 0 : admission.hashCode());
		result = prime * result + ((logInfo == null) ? 0 : logInfo.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Log other = (Log) obj;
		if (admission == null) {
			if (other.admission != null)
				return false;
		} else if (!admission.equals(other.admission))
			return false;
		if (logInfo == null) {
			if (other.logInfo != null)
				return false;
		} else if (!logInfo.equals(other.logInfo))
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Log [name=" + name + ", message=" + message + ", logInfo=" + logInfo + ", admission=" + admission + "]";
	}
}
