CREATE TABLE IF NOT EXISTS sm_sub_caste (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  created datetime NULL DEFAULT NULL,
  modified datetime NULL DEFAULT NULL,
  deleted tinyint(1) DEFAULT 0,
  
  sub_caste_name varchar(200) DEFAULT NULL UNIQUE,
  sub_caste_code varchar(100) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_unicode_ci;


CREATE TABLE IF NOT EXISTS sm_caste (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  created datetime NULL DEFAULT NULL,
  modified datetime NULL DEFAULT NULL,
  deleted tinyint(1) DEFAULT 0,
  
  caste_name varchar(100) DEFAULT NULL UNIQUE,
  caste_code varchar(100) DEFAULT NULL,
  sm_sub_caste_id bigint(20) DEFAULT NULL,
  
  PRIMARY KEY (id),

  KEY fk_sm_caste__sm_sub_caste(sm_sub_caste_id),
  CONSTRAINT fk_sm_caste__sm_sub_caste FOREIGN KEY (sm_sub_caste_id) REFERENCES sm_sub_caste(id)
  
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_unicode_ci;

