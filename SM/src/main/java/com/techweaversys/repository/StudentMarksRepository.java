package com.techweaversys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


import com.techweaversys.model.StudentMark;

@Repository
public interface StudentMarksRepository  extends JpaSpecificationExecutor<StudentMark>, JpaRepository<StudentMark, Long> {

	StudentMark findByClasssId(Long id);

	
	


}
  