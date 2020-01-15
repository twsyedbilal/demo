package com.techweaversys.spec;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import com.techweaversys.model.Occupation;

public class OccupationSpec implements Specification<Occupation> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -862698912483233403L;
	private String occupationName;
	private String occupationCode;

	public OccupationSpec(String occupationName, String occupationCode) {
		super();
		this.occupationName = occupationName;
		this.occupationCode = occupationCode;
	}

	@Override
	public Predicate toPredicate(Root<Occupation> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		Predicate conjunction = cb.conjunction();
		if (StringUtils.isNotEmpty(this.occupationName)) {
			conjunction.getExpressions().add(cb.like(root.get("occupationName"), "%" + this.occupationName + "%"));
		}
		if (StringUtils.isNotEmpty(this.occupationCode)) {
			conjunction.getExpressions().add(cb.like(root.get("occupationCode"), "%" + this.occupationCode + "%"));
		}
		return conjunction;
	}

}
