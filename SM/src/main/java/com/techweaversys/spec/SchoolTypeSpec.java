package com.techweaversys.spec;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import com.techweaversys.model.SchoolEntityy;
import com.techweaversys.model.SchoolType;

public class SchoolTypeSpec implements Specification<SchoolType> {

	private static final long serialVersionUID = 1L;

	private String schoolTypeName;
	private String code;

	public SchoolTypeSpec(String schoolTypeName, String code) {
		super();

		this.schoolTypeName = schoolTypeName;
		this.code = code;
	}

	@Override
	public Predicate toPredicate(Root<SchoolType> root, CriteriaQuery<?> cy, CriteriaBuilder cb) {
		Predicate conjunction = cb.conjunction();

		if (StringUtils.isNotEmpty(this.schoolTypeName)) {
			conjunction.getExpressions().add(cb.like(root.get("schoolTypeName"), "%" + this.schoolTypeName + "%"));
		}

		if (StringUtils.isNotEmpty(this.code)) {
			conjunction.getExpressions().add(cb.like(root.get("code"), "%" + this.code + "%"));
		}

		return conjunction;
	}
}
