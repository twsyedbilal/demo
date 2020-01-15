package com.techweaversys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.techweaversys.model.Occupation;

public interface OccupationRepository extends JpaRepository<Occupation, Long>, JpaSpecificationExecutor<Occupation> {

}
