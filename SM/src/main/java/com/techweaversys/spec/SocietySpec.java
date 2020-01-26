package com.techweaversys.spec;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import com.techweaversys.model.CompliantTypes;
import com.techweaversys.model.SocietyEntity;

public class SocietySpec implements Specification<SocietyEntity> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2940080952337693141L;

	private String societyName;
	private String code;

	public SocietySpec(String societyName, String code) {
		super();
		this.societyName = societyName;
		this.code = code;
	}

	@Override
	public Predicate toPredicate(Root<SocietyEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

		Predicate conjuction = cb.conjunction();

		if (StringUtils.isNotEmpty(this.societyName)) {
			conjuction.getExpressions().add(cb.like(root.get("societyName"), "%" + this.societyName + "%"));

		}
		if (StringUtils.isNotEmpty(this.code)) {
			conjuction.getExpressions().add(cb.like(root.get("code"), "%" + this.code + "%"));

		}
		return conjuction;
	}

}
