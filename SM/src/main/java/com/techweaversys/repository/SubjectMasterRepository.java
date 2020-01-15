package com.techweaversys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.techweaversys.model.SubjectMaster;

@Repository
public interface SubjectMasterRepository extends JpaRepository<SubjectMaster, Long>, JpaSpecificationExecutor<SubjectMaster> {

	List<SubjectMaster> findAllByClasssId(Long classid);
//	Page<SubjectMaster> findAll(SubjectMasterSpace subjectMasterSpace, PageRequest pg);
}