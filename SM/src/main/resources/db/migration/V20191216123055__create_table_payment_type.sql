CREATE TABLE IF NOT EXISTS sm_payment_type (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  created datetime NULL DEFAULT NULL,
  modified datetime NULL DEFAULT NULL,
  deleted tinyint(1) DEFAULT 0,
  
  payment_type_name varchar(200) DEFAULT NULL UNIQUE,
  payment_type_code varchar(100) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_unicode_ci;
