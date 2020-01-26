package com.techweaversys.spec;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import com.techweaversys.model.ClassEntity;
import com.techweaversys.model.MotherTongueEntity;

public class MotherTongueSpce implements Specification<MotherTongueEntity> {

	private static final long serialVersionUID = 1L;

	
	private String code;
	private String name;

	public MotherTongueSpce( String code, String name) {
		super();
		
		this.code = code;
		this.name = name;
	}

	@Override
	public Predicate toPredicate(Root<MotherTongueEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		Predicate conjunction = criteriaBuilder.conjunction();
		
		if (StringUtils.isEmpty(this.name)) {
			conjunction.getExpressions().add(criteriaBuilder.like(root.get("name"), "%" + this.name + "%"));

		}
		if (StringUtils.isNotEmpty(this.code)) {
			conjunction.getExpressions().add(criteriaBuilder.like(root.get("code"), "%" + this.code + "%"));
		}

		return conjunction;
	}
}
