package com.techweaversys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.techweaversys.model.Caste;

public interface CasteRepository extends JpaRepository<Caste, Long>, JpaSpecificationExecutor<Caste> {

}
