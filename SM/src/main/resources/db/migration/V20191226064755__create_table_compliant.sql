
create  table if not exists sm_compliant (
 id bigint(20) NOT NULL AUTO_INCREMENT,
  created datetime NULL DEFAULT NULL,
  modified datetime NULL DEFAULT NULL,
  deleted tinyint(1) DEFAULT 0,
  name varchar(100) DEFAULT NULL, 
  code varchar(50) DEFAULT NULL, 
   PRIMARY KEY (id)
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_unicode_ci;
