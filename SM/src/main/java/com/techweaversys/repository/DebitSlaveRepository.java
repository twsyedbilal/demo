package com.techweaversys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.techweaversys.model.DebitSlave;

@Repository
public interface DebitSlaveRepository extends JpaRepository<DebitSlave, Long>, JpaSpecificationExecutor<DebitSlave> {

	@Query(value = "SELECT sum(return_qty) FROM sm_debit_slave where book_id = ?1 and deleted=0", nativeQuery = true)
	double getSumByBookId(Long id);

	DebitSlave findByBookId(Long id);

}
