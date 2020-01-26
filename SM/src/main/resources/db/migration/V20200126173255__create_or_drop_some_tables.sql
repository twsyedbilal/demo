drop table sm_compliant_type;
drop table sm_compliant;

/*create table  complinat_type */
create  table if not exists sm_compliant_type (
 id bigint(20) NOT NULL AUTO_INCREMENT,
  created datetime NULL DEFAULT NULL,
  modified datetime NULL DEFAULT NULL,
  deleted tinyint(1) DEFAULT 0,
  name varchar(100) DEFAULT NULL, 
  code varchar(50) DEFAULT NULL, 
   PRIMARY KEY (id)
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_unicode_ci;


 /*complinat table with map admission and compliant_type */
CREATE TABLE IF NOT EXISTS sm_compliant (
 id bigint(20) NOT NULL AUTO_INCREMENT,
 compliant_id bigint(20)  DEFAULT NULL,
 admission_id bigint(20)  DEFAULT NULL,
 created datetime NULL DEFAULT NULL,
 modified datetime NULL DEFAULT NULL,
 deleted tinyint(1) DEFAULT 0,
 remark varchar(100) DEFAULT NULL,
 PRIMARY KEY (id),   
 KEY fk_sm_complant_type__sm_compliant(compliant_id),
 CONSTRAINT fk__sm_compliant_type__compliant FOREIGN key(compliant_id) REFERENCES sm_compliant_type(id),

 KEY fk_sm_compliant_type__sm_admission(admission_id),
 CONSTRAINT fk_sm_compliant_type__sm_admission FOREIGN KEY (admission_id) REFERENCES sm_admission(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_unicode_ci;

/* table mapping compliant with the doccuments */
CREATE TABLE IF NOT EXISTS sm_compliant__sm_document (  
  sm_document_id bigint(20) NOT NULL,
  sm_compliant_id bigint(20) NOT NULL,

  PRIMARY KEY (sm_document_id),
  KEY fk_sm_compliant__sm_document__sm_document (sm_document_id),
  CONSTRAINT fk_sm_compliant__sm_document__sm_document FOREIGN KEY (sm_document_id) REFERENCES sm_document(id),

  KEY fk_sm_compliant__sm_document__sm_complaliant (sm_compliant_id),
  CONSTRAINT fk_sm_compliant__sm_document__sm_compliant FOREIGN KEY (sm_compliant_id) REFERENCES sm_compliant(id)

  ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_unicode_ci;

