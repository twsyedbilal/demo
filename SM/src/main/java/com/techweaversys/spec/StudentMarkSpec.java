//package com.techweaversys.spec;
//
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Predicate;
//import javax.persistence.criteria.Root;
//
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.data.jpa.domain.Specification;
//
//import com.techweaversys.dto.SubjectMasterDto;
//import com.techweaversys.model.StudentMark;
//
//public class StudentMarkSpec implements Specification<StudentMark> {
//
//	private static final long serialVersionUID = -1740968398481075198L;
//
//	private String semester;
//	private String SubjectName;
//	private String subjectCode;
//	private String bookName;
//
//	public StudentMarkSpec(String semester, String subjectName, String subjectCode, String bookName) {
//		super();
//		this.semester = semester;
//		SubjectName = subjectName;
//		this.subjectCode = subjectCode;
//		this.bookName = bookName;
//	}
//
//	@Override
//	public Predicate toPredicate(Root<StudentMark> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
//
//		Predicate conjunction = cb.conjunction();
//		if (StringUtils.isNotEmpty(this.semester)) {
//			conjunction.getExpressions().add(cb.like(root.get("semester"), "%" + this.semester + "%"));
//		}
//
//		if (StringUtils.isNotEmpty(this.SubjectName)) {
//			conjunction.getExpressions().add(cb.like(root.get("SubjectName"), "%" + this.SubjectName + "%"));
//		}
//
//		if (StringUtils.isNotEmpty(this.subjectCode)) {
//			conjunction.getExpressions().add(cb.like(root.get("subjectCode"), "%" + this.subjectCode + "%"));
//		}
//		
//
//		if (StringUtils.isNotEmpty(this.bookName)) {
//			conjunction.getExpressions().add(cb.like(root.get("bookName"), "%" + this.bookName + "%"));
//		}
//
//		return conjunction;
//	
//	}
//}
