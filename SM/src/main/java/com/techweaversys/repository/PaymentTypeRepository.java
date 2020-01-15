package com.techweaversys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.techweaversys.model.PaymentType;

@Repository
public interface PaymentTypeRepository extends JpaRepository<PaymentType, Long>, JpaSpecificationExecutor<PaymentType> {

}
