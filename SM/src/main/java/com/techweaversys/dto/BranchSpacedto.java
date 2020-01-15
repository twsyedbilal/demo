package com.techweaversys.dto;

public class BranchSpacedto {

	private String branchName;
	private String branchCode;
	private Integer page;
	private Integer size;

	public BranchSpacedto() {
		super();
	}

	public BranchSpacedto(String branchName, String branchCode, Integer page, Integer size) {
		super();
		this.branchName = branchName;
		this.branchCode = branchCode;
		this.page = page;
		this.size = size;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
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
		result = prime * result + ((branchCode == null) ? 0 : branchCode.hashCode());
		result = prime * result + ((branchName == null) ? 0 : branchName.hashCode());
		result = prime * result + ((page == null) ? 0 : page.hashCode());
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
		BranchSpacedto other = (BranchSpacedto) obj;
		if (branchCode == null) {
			if (other.branchCode != null)
				return false;
		} else if (!branchCode.equals(other.branchCode))
			return false;
		if (branchName == null) {
			if (other.branchName != null)
				return false;
		} else if (!branchName.equals(other.branchName))
			return false;
		if (page == null) {
			if (other.page != null)
				return false;
		} else if (!page.equals(other.page))
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
		return "BranchSpacedto [branchName=" + branchName + ", branchCode=" + branchCode + ", page=" + page + ", size="
				+ size + "]";
	}

}