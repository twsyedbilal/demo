package com.techweaversys.spec;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import com.techweaversys.model.Attendance;

public class AttendanceSpace implements Specification<Attendance> {

	private static final long serialVersionUID = -7190766605922946715L;

	private boolean present;
	private boolean absent;
	private String reason;
	private String types;

	public AttendanceSpace() {
		super();
	}

	public boolean isPresent() {
		return present;
	}

	public void setPresent(boolean present) {
		this.present = present;
	}

	public boolean isAbsent() {
		return absent;
	}

	public void setAbsent(boolean absent) {
		this.absent = absent;
	}

	public AttendanceSpace(boolean present, boolean absent, String reason, String types) {
		super();
		this.present = present;
		this.absent = absent;
		this.reason = reason;
		this.types = types;
	}

	@Override
	public Predicate toPredicate(Root<Attendance> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

		Predicate con = cb.conjunction();

		if (StringUtils.isNotEmpty(this.reason)) {
			con.getExpressions().add(cb.like(root.get("reason"), "%" + this.reason + "%"));
		}

		if (StringUtils.isNotEmpty(this.types)) {
			con.getExpressions().add(cb.like(root.get("types"), "%" + this.types + "%"));
		}
		return con;
	}
}
