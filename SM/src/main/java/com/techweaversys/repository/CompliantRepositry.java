package com.techweaversys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.techweaversys.model.Compliant;

@Repository
public interface CompliantRepositry  extends JpaRepository<Compliant, Long> ,JpaSpecificationExecutor<Compliant>{

}
