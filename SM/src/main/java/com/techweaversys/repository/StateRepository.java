package com.techweaversys.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.techweaversys.model.State;
@Repository
public interface StateRepository extends JpaRepository<State, Long>,  JpaSpecificationExecutor<State> {

	public List<State> findAllByCountryId(Long countryId);
}
