 package com.techweaversys.spec;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import com.techweaversys.model.AcountFee;
import com.techweaversys.model.Admission;
import com.techweaversys.model.ClassEntity;
import com.techweaversys.model.PhoneSection;

public class PhoneSectionSpec implements Specification<PhoneSection> {

	/**
	 * gk khan
	 */
	private static final long serialVersionUID = 7957979185661885329L;
	private String remark;
	private Double remainingBalance;

	private String className;
	private String studentName;
	private String uidNo;
	private String idNo;
	public PhoneSectionSpec(String remark, Double remainingBalance) {
		super();
		this.remark = remark;
		this.remainingBalance = remainingBalance;
	}

	@Override
	public Predicate toPredicate(Root<PhoneSection> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

		Predicate conjunction = cb.conjunction();
		
		if(StringUtils.isNotEmpty(this.remark)){
			conjunction .getExpressions().add(cb.like(root.get("remark"),"%"+ this.remark  +"%"));
		}
		
		if(this.remainingBalance!=null && this.remainingBalance > 0){
			conjunction .getExpressions().add(cb.like(root.get("remainingBalance"),"%"+ this.remainingBalance  +"%"));
		}
		if( StringUtils.isNotEmpty( this.className )) {
			Join<ClassEntity, AcountFee> r = root.join("classOffered", JoinType.LEFT);
			conjunction.getExpressions().add( cb.like( r.get("className") , "%" + this.className +"%" ) );
		}
		
		if(StringUtils.isNotEmpty(this.studentName)){
			Join<ClassEntity,AcountFee> r=root.join("classOffered",JoinType.LEFT);
			conjunction.getExpressions().add(cb.like(r.get("studentName"),"%" +this.studentName +"%")); }
			
			if(StringUtils.isNotEmpty(this.uidNo)){
				Join<Admission, AcountFee>  r=root.join("admission",JoinType.LEFT);
				conjunction.getExpressions().add(cb.like(r.get("uidNo"),"%" +this.uidNo +"%")); }
			
			
			if(StringUtils.isNotEmpty(this.idNo)){
				Join<Admission, AcountFee>  r=root.join("admission",JoinType.LEFT);
				conjunction.getExpressions().add(cb.like(r.get("idNo"),"%" +this.idNo +"%")); }
			
		
		
		return conjunction;
	}

}
