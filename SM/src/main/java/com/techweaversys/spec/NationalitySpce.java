package com.techweaversys.spec;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import com.techweaversys.model.CompliantTypes;
import com.techweaversys.model.NationalityEntity;

public class NationalitySpce implements Specification<NationalityEntity> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2940080952337693141L;

	private String name;
	private String code;

	public NationalitySpce(String name, String code) {
		super();
		this.name = name;
		this.code = code;
	}

	@Override
	public Predicate toPredicate(Root<NationalityEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

		Predicate conjuction = cb.conjunction();

		if (StringUtils.isNotEmpty(this.name)) {
			conjuction.getExpressions().add(cb.like(root.get("name"), "%" + this.name + "%"));

		}
		if (StringUtils.isNotEmpty(this.code)) {
			conjuction.getExpressions().add(cb.like(root.get("code"), "%" + this.code + "%"));

		}
		return conjuction;
	}

}
