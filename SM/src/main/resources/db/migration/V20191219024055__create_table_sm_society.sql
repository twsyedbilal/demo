CREATE TABLE IF NOT EXISTS sm_society (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  created datetime NULL DEFAULT NULL,
  modified datetime NULL DEFAULT NULL,
  deleted tinyint(1) DEFAULT 0,
 society_name varchar(100) DEFAULT NULL,
  code varchar(40) DEFAULT NULL,
  PRIMARY KEY (id)
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_unicode_ci;
