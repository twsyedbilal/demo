package com.techweaversys.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.techweaversys.model.LibraryStock;

@Repository
public interface LibraryStockRepository extends JpaRepository<LibraryStock, Long>, JpaSpecificationExecutor<LibraryStock> {

	Optional<LibraryStock> findOneByBookId(Long id);

	LibraryStock findByBookId(Long id);

}
