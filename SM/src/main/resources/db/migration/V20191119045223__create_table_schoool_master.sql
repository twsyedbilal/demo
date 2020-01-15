CREATE TABLE IF NOT EXISTS sm_school_type (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  created datetime NULL DEFAULT NULL,
  modified datetime NULL DEFAULT NULL,
  deleted tinyint(1) DEFAULT 0,
  
  school_type_name varchar(100) DEFAULT NULL UNIQUE,
  code varchar(40) DEFAULT NULL,  
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_unicode_ci;

CREATE TABLE IF NOT EXISTS sm_school (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  branch_id bigint(20) DEFAULT NULL,
  sm_school_type_id bigint(20) DEFAULT NULL,
  created datetime NULL DEFAULT NULL,
  modified datetime NULL DEFAULT NULL,
  deleted tinyint(1) DEFAULT 0,
  
  school_name varchar(100) DEFAULT NULL UNIQUE,
  school_code varchar(100) DEFAULT NULL ,
  school_address varchar(100) DEFAULT NULL,

    PRIMARY KEY (id),
    KEY fk_school__branch(branch_id),
    CONSTRAINT fk_school__branch FOREIGN KEY (branch_id) REFERENCES branch(id),
    
	KEY fk_school__sm_school_type(sm_school_type_id),
    CONSTRAINT fk_school__sm_school_type FOREIGN KEY (sm_school_type_id) REFERENCES sm_school_type(id)
    
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_unicode_ci;