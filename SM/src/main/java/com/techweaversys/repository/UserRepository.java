package com.techweaversys.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.transaction.annotation.Transactional;

import com.techweaversys.model.User;

@Transactional
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

	public Optional<User> findOneByUsername(String userName);

	public User findOneById(Long id);


	

}
