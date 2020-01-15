package com.techweaversys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.techweaversys.model.Religion;

public interface ReligionRepository extends JpaRepository<Religion, Long>, JpaSpecificationExecutor<Religion> {

}
