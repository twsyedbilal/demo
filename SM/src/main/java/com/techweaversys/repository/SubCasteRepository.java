package com.techweaversys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.techweaversys.model.SubCaste;

public interface SubCasteRepository extends JpaRepository<SubCaste, Long>, JpaSpecificationExecutor<SubCaste> {

}
