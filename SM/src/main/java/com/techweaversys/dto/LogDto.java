package com.techweaversys.dto;

public class LogDto {

	private Long id;
	private String name;
	private String message;
	private String logInfo;
	private Long admissionId;

	public LogDto() {
		super();
	}

	public LogDto(Long id, String name, String message, String logInfo, Long admissionId) {
		super();
		this.id = id;
		this.name = name;
		this.message = message;
		this.logInfo = logInfo;
		this.admissionId = admissionId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Long getAdmissionId() {
		return admissionId;
	}

	public void setAdmissionId(Long admissionId) {
		this.admissionId = admissionId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((admissionId == null) ? 0 : admissionId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((logInfo == null) ? 0 : logInfo.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		LogDto other = (LogDto) obj;
		if (admissionId == null) {
			if (other.admissionId != null)
				return false;
		} else if (!admissionId.equals(other.admissionId))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
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
		return "LogDto [id=" + id + ", name=" + name + ", message=" + message + ", logInfo=" + logInfo
				+ ", admissionId=" + admissionId + "]";
	}
}
