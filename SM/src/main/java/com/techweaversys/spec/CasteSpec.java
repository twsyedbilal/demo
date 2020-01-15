package com.techweaversys.spec;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import com.techweaversys.model.Caste;

public class CasteSpec  implements Specification<Caste> {
	private static final long serialVersionUID = 1L;

	private String casteName;
	private String casteCode;

	public CasteSpec() {
		super();
	}

	public CasteSpec(String casteName, String casteCode) {
		super();
		this.casteName = casteName;
		this.casteCode = casteCode;
	}


	@Override
	public Predicate toPredicate(Root<Caste> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		Predicate conjunction = cb.conjunction();
		if (StringUtils.isNotEmpty(this.casteName)) {
			conjunction.getExpressions().add(cb.like(root.get("casteName"), "%" + this.casteName + "%"));
		}
		if (StringUtils.isNotEmpty(this.casteCode)) {
			conjunction.getExpressions().add(cb.like(root.get("casteCode"), "%" + this.casteCode + "%"));
		}
		return conjunction;
	} 

}
