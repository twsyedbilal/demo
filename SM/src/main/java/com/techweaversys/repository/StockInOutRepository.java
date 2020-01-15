package com.techweaversys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.techweaversys.model.StockInOut;

@Repository
public interface StockInOutRepository extends JpaRepository<StockInOut, Long>, JpaSpecificationExecutor<StockInOut> {

	@Query(value = "SELECT sum(stock_in) FROM sm_stock_in_out where book_id = ?1 and deleted=0", nativeQuery = true)
	double getSumofStockInByBookId(Long id);

	@Query(value = "SELECT sum(stock_out) FROM sm_stock_in_out where book_id = ?1 and deleted=0", nativeQuery = true)
	double getSumofStockOutByBookId(Long id);

}
