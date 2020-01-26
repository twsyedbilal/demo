package com.techweaversys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.techweaversys.model.Caste;


@Repository
public interface CasteRepository extends JpaRepository<Caste, Long>, JpaSpecificationExecutor<Caste> {

}
