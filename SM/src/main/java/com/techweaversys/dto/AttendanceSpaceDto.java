package com.techweaversys.dto;

public class AttendanceSpaceDto {

	private Boolean present = false;
	private Boolean absent = false;
	private String reason;
	private String types;
	private Integer page;
	private Integer size;

	public AttendanceSpaceDto(Boolean present, Boolean absent, String reason, String types, Integer page,
			Integer size) {
		super();
		this.present = present;
		this.absent = absent;
		this.reason = reason;
		this.types = types;
		this.page = page;
		this.size = size;
	}

	public AttendanceSpaceDto() {
		super();
		// TODO Auto-generated constructor stub
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

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((absent == null) ? 0 : absent.hashCode());
		result = prime * result + ((page == null) ? 0 : page.hashCode());
		result = prime * result + ((present == null) ? 0 : present.hashCode());
		result = prime * result + ((reason == null) ? 0 : reason.hashCode());
		result = prime * result + ((size == null) ? 0 : size.hashCode());
		result = prime * result + ((types == null) ? 0 : types.hashCode());
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
		AttendanceSpaceDto other = (AttendanceSpaceDto) obj;
		if (absent == null) {
			if (other.absent != null)
				return false;
		} else if (!absent.equals(other.absent))
			return false;
		if (page == null) {
			if (other.page != null)
				return false;
		} else if (!page.equals(other.page))
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
		if (size == null) {
			if (other.size != null)
				return false;
		} else if (!size.equals(other.size))
			return false;
		if (types == null) {
			if (other.types != null)
				return false;
		} else if (!types.equals(other.types))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AttendanceSpaceDto [present=" + present + ", absent=" + absent + ", reason=" + reason + ", types="
				+ types + ", page=" + page + ", size=" + size + "]";
	}

}
