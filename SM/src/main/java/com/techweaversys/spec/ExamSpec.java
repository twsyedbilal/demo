package com.techweaversys.spec;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import com.techweaversys.model.CompliantTypes;
import com.techweaversys.model.ExamMaster;

public class ExamSpec implements Specification<ExamMaster> {

	private String examName;
	private String examEndDate;
	private String examStartDate;

	public ExamSpec() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ExamSpec(String examName, String examEndDate, String examStartDate) {
		super();
		this.examName = examName;
		this.examEndDate = examEndDate;
		this.examStartDate = examStartDate;
	}

	@Override
	public Predicate toPredicate(Root<ExamMaster> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

		Predicate conjuction = cb.conjunction();

		if (StringUtils.isNotEmpty(this.examName)) {
			conjuction.getExpressions().add(cb.like(root.get("examName"), "%" + this.examName + "%"));

		}
		if (StringUtils.isNotEmpty(this.examEndDate)) {
			conjuction.getExpressions().add(cb.like(root.get("examEndDate"), "%" + this.examEndDate + "%"));

		}

		if (StringUtils.isNotEmpty(this.examStartDate)) {
			conjuction.getExpressions().add(cb.like(root.get("examStartDate"), "%" + this.examStartDate + "%"));

		}
		return conjuction;
	}

}
