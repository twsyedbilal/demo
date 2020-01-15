package com.techweaversys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.techweaversys.model.NationalityEntity;

public interface NationalityRepository extends JpaRepository<NationalityEntity, Long>, JpaSpecificationExecutor<NationalityEntity> {

}
