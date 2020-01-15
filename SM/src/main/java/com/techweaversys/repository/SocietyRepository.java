package com.techweaversys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.techweaversys.model.SocietyEntity;

public interface SocietyRepository extends JpaRepository<SocietyEntity, Long>, JpaSpecificationExecutor<SocietyEntity> {

}
