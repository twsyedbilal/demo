package com.techweaversys.generics;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AbstractPersistableCM implements IEntity<Long>, Cloneable {
	
	private static final long serialVersionUID = 8654459599233909884L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "created_on", nullable = false)
	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar createdOn;
	
	@OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "created_by", nullable = false)
	@CreatedBy
	private String createdBy;
	
	@Column(name = "modified_on", nullable = false)
	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar modifiedOn;
	
	@OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "modified_by", nullable = false)
	@LastModifiedBy
	private String modifiedBy;
	
	@Column(name = "deleted", nullable = false)
	private Boolean deleted = false;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Calendar getCreatedOn() {
		return createdOn;
	}
	
	public void setCreatedOn(Calendar createdOn) {
		this.createdOn = createdOn;
	}
	
	public Calendar getModifiedOn() {
		return modifiedOn;
	}
	
	public void setModifiedOn(Calendar modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	
	
	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	@Transient
	@Override
	public boolean isNew() {
		return this.id == null;
	}
	
	@Override
	public String toString() {
		return String.format("Entity of type %s with rowID: %s", this.getClass().getName(), getId());
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) { return false; }
		if (this == obj) { return true; }
		if (!getClass().equals(obj.getClass())) { return false; }
		AbstractPersistableCM rhs = (AbstractPersistableCM) obj;
		return this.id == null ? false : this.id.equals(rhs.id);
	}
	
	@Override
	public int hashCode() {
		int hashCode = 17;
		hashCode += (this.id == null) ? 0 : this.id.hashCode() * 31;
		return hashCode;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
}

