package com.techweaversys.dto;

public class PhoneSectionSpaceDto {

	private String remark;
	private Double remainingBalance;
	private Integer page;
	private Integer size;

	public PhoneSectionSpaceDto() {
		super();
	}

	public PhoneSectionSpaceDto(String remark, Double remainingBalance, Integer page, Integer size) {
		super();
		this.remark = remark;
		this.remainingBalance = remainingBalance;
		this.page = page;
		this.size = size;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	public Double getRemainingBalance() {
		return remainingBalance;
	}

	public void setRemainingBalance(Double remainingBalance) {
		this.remainingBalance = remainingBalance;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((page == null) ? 0 : page.hashCode());
		result = prime * result + ((remainingBalance == null) ? 0 : remainingBalance.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result + ((size == null) ? 0 : size.hashCode());
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
		PhoneSectionSpaceDto other = (PhoneSectionSpaceDto) obj;
		if (page == null) {
			if (other.page != null)
				return false;
		} else if (!page.equals(other.page))
			return false;
		if (remainingBalance == null) {
			if (other.remainingBalance != null)
				return false;
		} else if (!remainingBalance.equals(other.remainingBalance))
			return false;
		if (remark == null) {
			if (other.remark != null)
				return false;
		} else if (!remark.equals(other.remark))
			return false;
		if (size == null) {
			if (other.size != null)
				return false;
		} else if (!size.equals(other.size))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PhoneSectionSpaceDto [remark=" + remark + ", remainingBalance=" + remainingBalance + ", page=" + page
				+ ", size=" + size + "]";
	}

	
}
