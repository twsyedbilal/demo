package com.techweaversys.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import com.techweaversys.generics.AbstractPersistable;

@Entity
@Table(name = "branch")
@Where(clause = "deleted=false")
public class BranchEntity extends AbstractPersistable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4869638572659268902L;

	@Column(name = "branchname", unique = true, nullable = false)
	private String branchName;

	@Column(name = "branccode", nullable = true)
	private String branchCode;
	
	
	public BranchEntity() {
		super();
	}

	public BranchEntity(String branchName, String branchCode) {
		super();
		this.branchName = branchName;
		this.branchCode = branchCode;
	}

	public String getBranchCode () {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}


	public static long getSerialversionuid() {
		  return serialVersionUID;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getBrancCode() {
		return branchCode;
	}

	public void setBrancCode(String brancCode) {
		this.branchCode = brancCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((branchCode == null) ? 0 : branchCode.hashCode());
		result = prime * result + ((branchName == null) ? 0 : branchName.hashCode());
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
		BranchEntity other = (BranchEntity) obj;
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
		return true;
	}

	@Override
	public String toString() {
		return "BranchEntity [branchName=" + branchName + ", branchCode=" + branchCode + "]";
	}

}
