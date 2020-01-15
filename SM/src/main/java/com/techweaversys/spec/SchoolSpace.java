package com.techweaversys.spec;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import com.techweaversys.model.SchoolEntityy;

public class SchoolSpace implements Specification<SchoolEntityy> {

	private static final long serialVersionUID = 1L;

	private String schoolName;
	private String schoolCode;
	private String schoolAddress;

	public SchoolSpace(String schoolName, String schoolCode, String schoolAddress) {
		super();
		this.schoolName = schoolName;
		this.schoolCode = schoolCode;
		this.schoolAddress = schoolAddress;
	}

	@Override
	public Predicate toPredicate(Root<SchoolEntityy> root, CriteriaQuery<?> cy, CriteriaBuilder cb) {
		Predicate conjunction = cb.conjunction();
		if (StringUtils.isNotEmpty(this.schoolName)) {
			conjunction.getExpressions().add(cb.like(root.get("schoolName"), "%" + this.schoolName + "%"));
		}

		if (StringUtils.isNotEmpty(this.schoolCode)) {
			conjunction.getExpressions().add(cb.like(root.get("schoolCode"), "%" + this.schoolCode + "%"));
		}
		if (StringUtils.isNotEmpty(this.schoolAddress)) {
			conjunction.getExpressions().add(cb.like(root.get("schoolAddress"), "%" + this.schoolAddress + "%"));
		}
		return conjunction;
	}
}
