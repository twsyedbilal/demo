package com.techweaversys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.techweaversys.model.ClassEntity;

@Repository
public interface ClassRepository extends  JpaRepository<ClassEntity, Long>,JpaSpecificationExecutor<ClassEntity> {

}
