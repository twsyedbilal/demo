package com.techweaversys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.techweaversys.model.MarksSlave;

@Repository
public interface MarkSlaveRepository extends JpaRepository<MarksSlave, Long>, JpaSpecificationExecutor<MarksSlave> {
}
