package com.techweaversys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.techweaversys.model.SchoolEntityy;

@Repository
public interface SchoolRepositriy extends 
          JpaRepository<SchoolEntityy, Long>, JpaSpecificationExecutor<SchoolEntityy> {

}
