package com.techweaversys.spec;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import com.techweaversys.model.ClassEntity;

public class ClassSpace implements Specification<ClassEntity> {

	private static final long serialVersionUID = 1L;

	private String className;
	private String code;
	private Double fees;

	public ClassSpace(String className, String code, Double fees) {
		super();
		this.className = className;
		this.code = code;
		this.fees = fees;
	}

	@Override
	public Predicate toPredicate(Root<ClassEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		Predicate conjunction = criteriaBuilder.conjunction();
		if (StringUtils.isEmpty(this.className)) {
			conjunction.getExpressions().add(criteriaBuilder.like(root.get("className"), "%" + this.className + "%"));

		}
		if (StringUtils.isNotEmpty(this.code)) {
			conjunction.getExpressions().add(criteriaBuilder.like(root.get("code"), "%" + this.code + "%"));
		}

		if (this.fees != null && this.fees > 0) {
			conjunction.getExpressions().add(criteriaBuilder.like(root.get("fees"), "%" + this.fees + "%"));

		}
		return conjunction;
	}
}
