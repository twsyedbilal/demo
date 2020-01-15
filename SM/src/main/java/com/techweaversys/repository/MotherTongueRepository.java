package com.techweaversys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.techweaversys.model.MotherTongueEntity;

public interface MotherTongueRepository extends JpaSpecificationExecutor<MotherTongueEntity>, JpaRepository<MotherTongueEntity,Long> {

}
