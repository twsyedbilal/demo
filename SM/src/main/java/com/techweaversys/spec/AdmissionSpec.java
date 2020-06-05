package com.techweaversys.spec;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import com.techweaversys.model.Admission;
import com.techweaversys.model.ClassEntity;

public class AdmissionSpec implements Specification<Admission> {

	/**
	 * auther : MAJID
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long uidNo;
	private String idNo;
	private String year;
	private String surName;
	private String studentsName;
	private String date;
	private String className;
	private String status;
	private String liveStatus;
	private String address;
	private String studentRegNo;


	public AdmissionSpec(Long uidNo, String idNo, String year, String surName, String studentsName, String className,
			String status, String liveStatus, String studentRegNo) {
		super();
		this.uidNo = uidNo;
		this.idNo = idNo;
		this.year = year;
		this.surName = surName;
		this.studentsName = studentsName;
		this.className = className;
		this.status = status;
		this.liveStatus = liveStatus;
		this.studentRegNo = studentRegNo;
	}

	@Override
	public Predicate toPredicate(Root<Admission> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		Predicate conjunction = cb.conjunction();
		if (StringUtils.isNotEmpty(this.surName)) {
			conjunction.getExpressions().add(cb.like(root.get("surName"), "%" + this.surName + "%"));
		}
		if (StringUtils.isNotEmpty(this.studentsName)) {
			conjunction.getExpressions().add(cb.like(root.get("studentsName"), "%" + this.studentsName + "%"));
		}
		if (StringUtils.isNotEmpty(this.idNo)) {
			conjunction.getExpressions().add(cb.like(root.get("idNo"), "%" + this.idNo + "%"));
		}
		if (StringUtils.isNotEmpty(this.year)) {
			conjunction.getExpressions().add(cb.like(root.get("year"), "%" + this.year + "%"));
		}
//		if (this.date != null) {
//			conjunction.getExpressions().add(cb.like(root.get("date"), "%" + this.date + "%"));
//		}
		/*
		 * if (StringUtils.isNotEmpty(this.classOffered)) {
		 * conjunction.getExpressions().add(cb.like(root.get("classOffered"), "%" +
		 * this.classOffered + "%")); }
		 */
		if (this.uidNo != null && this.uidNo > 0) {
			conjunction.getExpressions().add(cb.like(root.get("uidNo"), "%" + this.uidNo + "%"));
		}

		if (StringUtils.isNotEmpty(this.className)) {
			Join<ClassEntity, Admission> r = root.join("classOffered", JoinType.LEFT);
			conjunction.getExpressions().add(cb.like(r.get("className"), "%" + this.className + "%"));
		}

//		if (StringUtils.isNotEmpty(this.code)) {
//			Join<ClassEntity, Admission> r = root.join("classOffered", JoinType.LEFT);
//			conjunction.getExpressions().add(cb.like(r.get("code"), "%" + this.code + "%"));
//		}
//		if (this.fees > 0 && this.fees != 0) {
//			Join<ClassEntity, Admission> r = root.join("classOffered", JoinType.LEFT);
//			conjunction.getExpressions().add(cb.like(r.get("fees"), "%" + this.fees + "%"));
//		}
		if (StringUtils.isNotEmpty(this.status)) {
			conjunction.getExpressions().add(cb.like(root.get("status"), "%" + this.status + "%"));
		}
		if (StringUtils.isNotEmpty(this.liveStatus)) {
			conjunction.getExpressions().add(cb.like(root.get("liveStatus"), "%" + this.liveStatus + "%"));
		}
//		if (StringUtils.isNotEmpty(this.address)) {
//			conjunction.getExpressions().add(cb.like(root.get("address"), "%" + this.address + "%"));
//		}
		if (StringUtils.isNotEmpty(this.studentRegNo)) {
			conjunction.getExpressions().add(cb.like(root.get("studentRegNo"), "%" + this.studentRegNo + "%"));
		}
		return conjunction;
	}

}
