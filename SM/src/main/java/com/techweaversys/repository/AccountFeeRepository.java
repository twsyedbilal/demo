package com.techweaversys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.techweaversys.model.AcountFee;


@Repository
public interface AccountFeeRepository extends JpaRepository<AcountFee, Long>,JpaSpecificationExecutor<AcountFee>{

}
