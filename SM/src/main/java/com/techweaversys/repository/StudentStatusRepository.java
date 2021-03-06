package com.techweaversys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.techweaversys.model.StudentStatus;

@Repository
public interface StudentStatusRepository extends JpaRepository<StudentStatus, Long>, JpaSpecificationExecutor<StudentStatus> {

}
