package com.techweaversys.spec;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import com.techweaversys.model.Role;
import com.techweaversys.model.User;

public class UserByroleSpec implements Specification<User> {


	private static final long serialVersionUID = 1L;

	private String name;
	private String username;
	private String role;

	
	public UserByroleSpec(String name, String username, String role) {
		super();
		this.name = name;
		this.username = username;
		this.role = role;
		
	}


	@Override
	public Predicate toPredicate(Root<User> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {

		Predicate conjunction = cb.conjunction();
		
		if( StringUtils.isNotEmpty( this.name ) ) {
			conjunction.getExpressions().add( cb.like( root.get("name") , "%" + this.name +"%" ) );
		}
		
		if( StringUtils.isNotEmpty( this.username ) ) {
			conjunction.getExpressions().add( cb.like( root.get("username") , "%" + this.username +"%" ) );
		}
		
		if( StringUtils.isNotEmpty( this.role ) ) {
			Join<User, Role> r = root.join("roles", JoinType.LEFT);
			conjunction.getExpressions().add( cb.like( r.get("role") , "%" + this.role +"%" ) );
		}
		
		return conjunction;
	}

}
