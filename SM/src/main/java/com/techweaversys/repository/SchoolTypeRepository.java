package com.techweaversys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.techweaversys.model.SchoolType;

@Repository
public interface SchoolTypeRepository extends JpaRepository<SchoolType,Long>,JpaSpecificationExecutor<SchoolType> {

}
