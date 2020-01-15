package com.techweaversys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.techweaversys.model.Document;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long>, JpaSpecificationExecutor<Document> {


}
