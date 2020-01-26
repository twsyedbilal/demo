package com.techweaversys.spec;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import com.techweaversys.model.Compliant;

public class ComplianteSpce implements Specification<Compliant> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1579849636558686595L;

	private String remark;

	public ComplianteSpce(String remark) {
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
	public Predicate toPredicate(Root<Compliant> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

		Predicate con = cb.conjunction();

		if (StringUtils.isNotEmpty(this.remark)) {
			con.getExpressions().add(cb.like(root.get("remark"), "%" + this.remark + "%"));

		}
		return con;
	}

}
