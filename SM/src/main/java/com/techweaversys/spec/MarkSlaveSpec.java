package com.techweaversys.spec;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import com.techweaversys.model.MarksSlave;


public class MarkSlaveSpec implements Specification<MarksSlave> {

	private static final long serialVersionUID = 1L;

	private String mark;
	private String remark;

	

	public MarkSlaveSpec(String mark, String remark) {
		super();
		this.mark = mark;
		this.remark = remark;
	}



	@Override
	public Predicate toPredicate(Root<MarksSlave> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		Predicate conjunction = criteriaBuilder.conjunction();

		if (StringUtils.isEmpty(this.remark)) {
			conjunction.getExpressions().add(criteriaBuilder.like(root.get("remark"), "%" + this.remark + "%"));

		}
		if (StringUtils.isNotEmpty(this.mark)) {
			conjunction.getExpressions().add(criteriaBuilder.like(root.get("mark"), "%" + this.mark + "%"));
		}

		return conjunction;
	}
}
