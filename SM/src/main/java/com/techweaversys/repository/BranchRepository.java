package com.techweaversys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.techweaversys.model.BranchEntity;

@Repository
public interface BranchRepository  extends JpaRepository<BranchEntity, Long> ,JpaSpecificationExecutor<BranchEntity>{

}
