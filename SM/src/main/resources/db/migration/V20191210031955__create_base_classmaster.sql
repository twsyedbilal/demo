CREATE TABLE IF NOT EXISTS sm_class_master (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  created datetime NULL DEFAULT NULL,
  modified datetime NULL DEFAULT NULL,
  deleted tinyint(1) DEFAULT 0,
  
  class_name varchar(40) DEFAULT NULL UNIQUE,
  code varchar(40) DEFAULT NULL,
  fees varchar(50) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_unicode_ci;

