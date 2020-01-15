package com.techweaversys.spec;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import com.techweaversys.model.Religion;

public class ReligionSpec implements Specification<Religion> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1102809985234381429L;
	
	private String religionName;
	private String religionCode;
	
	
	
	public ReligionSpec(String religionName, String religionCode) {
		super();
		this.religionName = religionName;
		this.religionCode = religionCode;
	}

	@Override
	public Predicate toPredicate(Root<Religion> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		Predicate conjunction = cb.conjunction();
		if (StringUtils.isNotEmpty(this.religionName)) {
			conjunction.getExpressions().add(cb.like(root.get("religionName"), "%" + this.religionName + "%"));
		}
		if (StringUtils.isNotEmpty(this.religionCode)) {
			conjunction.getExpressions().add(cb.like(root.get("religionCode"), "%" + this.religionCode + "%"));
		}
		return conjunction;
	}

}
