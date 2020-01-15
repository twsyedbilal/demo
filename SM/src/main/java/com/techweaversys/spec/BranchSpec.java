package com.techweaversys.spec;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import com.techweaversys.model.BranchEntity;

public class BranchSpec implements Specification<BranchEntity> {

	private static final long serialVersionUID = 1L;

	private String branchName;
	private String branchCode;

	public BranchSpec(String branchName, String branchCode) {
		super();
		this.branchName = branchName;
		this.branchCode = branchCode;
	}

	@Override
	public Predicate toPredicate(Root<BranchEntity> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {

		Predicate conjunction = cb.conjunction();
		if (StringUtils.isNotEmpty(this.branchName)) {
			conjunction.getExpressions().add(cb.like(root.get("branchName"), "%" + this.branchName + "%"));
		}

		if (StringUtils.isNotEmpty(this.branchCode)) {
			conjunction.getExpressions().add(cb.like(root.get("branchCode"), "%" + this.branchCode + "%"));
		}

		return conjunction;
	}

}
