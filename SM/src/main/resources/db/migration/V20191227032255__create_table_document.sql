CREATE TABLE sm_document (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  created datetime NULL DEFAULT NULL,
  modified datetime NULL DEFAULT NULL,
  deleted tinyint(1) DEFAULT 0,
  
  file_name varchar(255) NULL DEFAULT NULL,
  file_type varchar(100) NULL DEFAULT NULL,
  name varchar(255) NULL DEFAULT NULL,
  path varchar(512) NULL DEFAULT NULL,
  store varchar(10) NULL DEFAULT NULL,
  url varchar(200) NULL DEFAULT NULL,
  doc longblob,
  
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;