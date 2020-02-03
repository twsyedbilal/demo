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
	private String name;

	@Column(name = "branccode", nullable = true)
	private String code;
	
	
	public BranchEntity() {
		super();
	}

	public BranchEntity(String name, String code) {
		super();
		this.name = name;
		this.code = code;
	}

	public String getcode () {
		return code;
	}

	public void setcode(String code) {
		this.code = code;
	}


	public static long getSerialversionuid() {
		  return serialVersionUID;
	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public String getBrancCode() {
		return code;
	}

	public void setBrancCode(String brancCode) {
		this.code = brancCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((code == null) ? 0 : code.hashCode());
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
		BranchEntity other = (BranchEntity) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
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
		return "BranchEntity [name=" + name + ", code=" + code + "]";
	}

}
