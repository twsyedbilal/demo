package com.techweaversys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.techweaversys.model.CompliantTypes;

@Repository
public interface CompliantTypesRepositry  extends JpaRepository<CompliantTypes, Long> ,JpaSpecificationExecutor<CompliantTypes>{

}
