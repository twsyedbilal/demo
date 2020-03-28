package com.techweaversys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.techweaversys.model.ExamMaster;

@Repository
public interface ExamRepository extends  JpaRepository<ExamMaster, Long>, JpaSpecificationExecutor<ExamMaster> {

	ExamMaster findByClasssId(Long id);


	

}
