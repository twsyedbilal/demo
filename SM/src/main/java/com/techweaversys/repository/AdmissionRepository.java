package com.techweaversys.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.techweaversys.model.Admission;

@Repository
@Transactional
public interface AdmissionRepository extends JpaRepository<Admission,Long>,JpaSpecificationExecutor<Admission> {

	Optional<Admission> findOneByUidNo(Long uidNo);


}