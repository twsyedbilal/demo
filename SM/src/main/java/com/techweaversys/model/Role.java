package com.techweaversys.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.techweaversys.generics.AbstractPersistable;

/*
 * Application Role
 */

@Entity
@Table(name = "role")
public class Role extends AbstractPersistable {

	private static final long serialVersionUID = 4387423200199009010L;
	
	@Column(name = "role", nullable = false)
	private String role;
	
	public Role() {
		super();
	}
	public Role(String role) {
		super();
		this.role = role;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((role == null) ? 0 : role.hashCode());
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
		Role other = (Role) obj;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Role [role=" + role + "]";
	}
	
}
