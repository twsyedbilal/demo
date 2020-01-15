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
import com.techweaversys.model.PaymentType;

public class AccountSpace implements Specification<AcountFee> {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1028815222472796552L;
	private String className;
	private String studentName;
	private String uidNo;
	private String idNo;
	private String registerNo;
	private String paymentName;

	public AccountSpace(String className, String studentName, String uidNo, String idNo, String registerNo,
			String paymentName) {
		super();
		this.className = className;
		this.studentName = studentName;
		this.uidNo = uidNo;
		this.idNo = idNo;
		this.registerNo = registerNo;
		this.paymentName = paymentName;
	}



	@Override
	public Predicate toPredicate(Root<AcountFee> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

		Predicate conjunction = cb.conjunction();
		
		if( StringUtils.isNotEmpty( this.className ) ) {
			Join<ClassEntity, AcountFee> r=root.join("classs",JoinType.LEFT);
			conjunction.getExpressions().add( cb.like( r.get("className") , "%" + this.className +"%" ) );
		}
		
		if( StringUtils.isNotEmpty( this.studentName ) ) {
			Join<Admission, AcountFee> r = root.join("admission", JoinType.LEFT);
			conjunction.getExpressions().add( cb.like( r.get("studentsName") , "%" + this.studentName +"%" ) );
		}
		
		if( StringUtils.isNotEmpty( this.uidNo ) ) {
			Join<Admission, AcountFee> r = root.join("admission", JoinType.LEFT);
			conjunction.getExpressions().add( cb.like( r.get("uidNo") , "%" + this.uidNo +"%" ) );
		}
		
		if( StringUtils.isNotEmpty( this.idNo ) ) {
			Join<Admission, AcountFee> r = root.join("admission", JoinType.LEFT);
			conjunction.getExpressions().add( cb.like( r.get("idNo") , "%" + this.idNo +"%" ) );
		}
		
		if( StringUtils.isNotEmpty( this.registerNo ) ) {
			Join<Admission, AcountFee> r = root.join("admission", JoinType.LEFT);
			conjunction.getExpressions().add( cb.like( r.get("studentRegNo") , "%" + this.registerNo +"%" ) );
		}
		if(StringUtils.isNotEmpty(this.paymentName)){
			Join<PaymentType, AcountFee> r = root.join("paymentType",JoinType.LEFT);
			conjunction.getExpressions().add( cb.like( r.get("paymentTypeName") , "%" + this.paymentName +"%" ) );
		}
		
		return conjunction;
	}

}
