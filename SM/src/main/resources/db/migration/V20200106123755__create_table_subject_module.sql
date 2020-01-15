CREATE TABLE IF NOT EXISTS sm_subject_master(
  id bigint(20) NOT NULL AUTO_INCREMENT,
  classs_id bigint(20) DEFAULT NULL,
  created datetime NULL DEFAULT NULL,
  modified datetime NULL DEFAULT NULL,
  deleted tinyint(1) DEFAULT 0,
  
  subject_name varchar(100) DEFAULT NULL,
  subject_code varchar(100) DEFAULT NULL,
  semester varchar(100) DEFAULT NULL,
  PRIMARY KEY (id),
  
  KEY fk_sm_subject_master__sm_class_master(classs_id),
  CONSTRAINT fk_sm_subject_master__sm_class_master FOREIGN key(classs_id) REFERENCES sm_class_master(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_unicode_ci;