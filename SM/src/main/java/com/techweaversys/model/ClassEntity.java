package com.techweaversys.model;

import java.util.Calendar;

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
@Table(name="sm_class_master")
@Where(clause = "deleted=false")
public class ClassEntity   extends AbstractPersistable{
	
	private static final long serialVersionUID = 4869638572659268902L;

	
	@Column(name="class_name",nullable=false)
	private  String className;

	@Column(name="code",nullable=false)
	private   String code;

	@Column(name="fees",nullable=false)
	private double fees;

	@Column(name="class_capacity")
	private String classsCapacity;
	
	
	@Column(name="class_starting_date")
	private Calendar classsStartingDate;
	
	
	@Column(name="class_ending_date")
	private Calendar classsEndingDate;
	
	
	@Column(name="class_location")
	private  String classsLocation;
	
	@Column(name="class_type")
	private String  classsType;
	

	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="user_id")
	private User user;

	
	
	public String getClasssCapacity() {
		return classsCapacity;
	}
	public void setClasssCapacity(String classsCapacity) {
		this.classsCapacity = classsCapacity;
	}
	public Calendar getClasssStartingDate() {
		return classsStartingDate;
	}
	public void setClasssStartingDate(Calendar classsStartingDate) {
		this.classsStartingDate = classsStartingDate;
	}
	public Calendar getClasssEndingDate() {
		return classsEndingDate;
	}
	public void setClasssEndingDate(Calendar classsEndingDate) {
		this.classsEndingDate = classsEndingDate;
	}
	public String getClasssLocation() {
		return classsLocation;
	}
	public void setClasssLocation(String classsLocation) {
		this.classsLocation = classsLocation;
	}
	public String getClasssType() {
		return classsType;
	}
	public void setClasssType(String classsType) {
		this.classsType = classsType;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public ClassEntity() {
		super();
	}
	public ClassEntity(String className, String code, double fees) {
		super();
		this.className = className;
		this.code = code;
		this.fees = fees;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public double getFees() {
		return fees;
	}
	public void setFees(double fees) {
		this.fees = fees;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((className == null) ? 0 : className.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		long temp;
		temp = Double.doubleToLongBits(fees);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		ClassEntity other = (ClassEntity) obj;
		if (className == null) {
			if (other.className != null)
				return false;
		} else if (!className.equals(other.className))
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (Double.doubleToLongBits(fees) != Double.doubleToLongBits(other.fees))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ClassEntity [className=" + className + ", code=" + code + ", fees=" + fees + "]";
	}
	public ClassEntity(String className, String code, double fees, String classsCapacity, Calendar classsStartingDate,
			Calendar classsEndingDate, String classsLocation, String classsType, User user) {
		super();
		this.className = className;
		this.code = code;
		this.fees = fees;
		this.classsCapacity = classsCapacity;
		this.classsStartingDate = classsStartingDate;
		this.classsEndingDate = classsEndingDate;
		this.classsLocation = classsLocation;
		this.classsType = classsType;
		this.user = user;
	}

}
