package com.techweaversys.spec;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import com.techweaversys.model.Book;

public class BookSpec  implements Specification<Book> {

	private static final long serialVersionUID = 1L;

	private String bookName;
	private String bookCode;

	public BookSpec(String bookName, String bookCode) {
		super();
		this.bookName = bookName;
		this.bookCode = bookCode;
	}

	@Override
	public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {

		Predicate conjunction = cb.conjunction();
		if (StringUtils.isNotEmpty(this.bookCode)) {
			conjunction.getExpressions().add(cb.like(root.get("bookCode"), "%" + this.bookCode + "%"));
		}
		if (StringUtils.isNotEmpty(this.bookName)) {
			conjunction.getExpressions().add(cb.like(root.get("bookName"), "%" + this.bookName + "%"));
		}

		return conjunction;
	}
}