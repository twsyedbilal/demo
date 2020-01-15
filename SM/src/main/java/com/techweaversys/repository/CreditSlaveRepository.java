package com.techweaversys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.techweaversys.model.CreditSlave;

@Repository
public interface CreditSlaveRepository extends JpaRepository<CreditSlave, Long>, JpaSpecificationExecutor<CreditSlave> {

	@Query(value = "SELECT sum(return_qty) FROM sm_credit_slave where book_id = ?1 and deleted=0", nativeQuery = true)
	double getSumReturnQtyByBookId(Long id);

}
