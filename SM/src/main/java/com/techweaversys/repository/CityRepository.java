package com.techweaversys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.techweaversys.model.City;

@Repository
public interface CityRepository extends JpaSpecificationExecutor<City>, JpaRepository<City, Long> {

	List<City> findAllByStateId(Long stateId);

}
