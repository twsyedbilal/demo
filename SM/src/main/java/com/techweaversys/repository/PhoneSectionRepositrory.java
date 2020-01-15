package com.techweaversys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.techweaversys.model.PhoneSection;

@Repository
public interface PhoneSectionRepositrory  extends JpaRepository<PhoneSection, Long> , JpaSpecificationExecutor<PhoneSection>{

}
