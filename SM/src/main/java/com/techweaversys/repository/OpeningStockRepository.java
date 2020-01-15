package com.techweaversys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.techweaversys.model.OpeningStock;

@Repository
public interface OpeningStockRepository extends JpaRepository<OpeningStock, Long>, JpaSpecificationExecutor<OpeningStock> {

}
