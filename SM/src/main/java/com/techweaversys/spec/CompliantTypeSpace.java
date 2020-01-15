package com.techweaversys.spec;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import com.techweaversys.model.CompliantType;

public class CompliantTypeSpace implements Specification<CompliantType> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1579849636558686595L;

	private String remark;

	public CompliantTypeSpace(String remark) {
		super();
		this.remark = remark;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public Predicate toPredicate(Root<CompliantType> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

		Predicate con = cb.conjunction();

		if (StringUtils.isNotEmpty(this.remark)) {
			con.getExpressions().add(cb.like(root.get("remark"), "%" + this.remark + "%"));

		}
		return con;
	}

}
