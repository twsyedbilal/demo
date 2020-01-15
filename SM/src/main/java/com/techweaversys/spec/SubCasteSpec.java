package com.techweaversys.spec;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import com.techweaversys.model.SubCaste;

public class SubCasteSpec  implements Specification<SubCaste> {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String subCasteName;
	private String subCasteCode;

	
	
	public SubCasteSpec(String subCasteName, String subCasteCode) {
		super();
		this.subCasteName = subCasteName;
		this.subCasteCode = subCasteCode;
	}



	@Override
	public Predicate toPredicate(Root<SubCaste> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		Predicate conjunction = cb.conjunction();
		if (StringUtils.isNotEmpty(this.subCasteName)) {
			conjunction.getExpressions().add(cb.like(root.get("subCasteName"), "%" + this.subCasteName + "%"));
		}
		if (StringUtils.isNotEmpty(this.subCasteCode)) {
			conjunction.getExpressions().add(cb.like(root.get("subCasteCode"), "%" + this.subCasteCode + "%"));
		}
		return conjunction;
	} 

}
