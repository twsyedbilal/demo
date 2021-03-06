package com.techweaversys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.techweaversys.model.CompliantType;

@Repository
public interface CompliantTypeRepository extends JpaRepository<CompliantType, Long>, JpaSpecificationExecutor<CompliantType> {

}
