package com.techweaversys.spec;

import java.util.Calendar;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
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

	private String studentsName;
	private String studentRegNo;
	private Long uidNo;
	private String idNo;
	private String year;
	private String date;
	private String classOffered;

	public AdmissionSpec(String studentsName, Long long1, String string, String idNo, Calendar calendar, ClassEntity classEntity,
			String classOffered) {
	}
	
	@Override
	public Predicate toPredicate(Root<Admission> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		Predicate conjunction = cb.conjunction();
		if (StringUtils.isNotEmpty(this.studentRegNo)) {
			conjunction.getExpressions().add(cb.like(root.get("studentRegNo"), "%" + this.studentRegNo + "%"));
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
		if (StringUtils.isNotEmpty(this.date)) {
			conjunction.getExpressions().add(cb.like(root.get("date"), "%" + this.date + "%"));
		}
		if (StringUtils.isNotEmpty(this.classOffered)) {
			conjunction.getExpressions().add(cb.like(root.get("classOffered"), "%" + this.classOffered + "%"));
		}
		if (this.uidNo != null && this.uidNo > 0) {
			conjunction.getExpressions().add(cb.like(root.get("uidNo"), "%" + this.uidNo + "%"));
		}
		return conjunction;
	}


}
