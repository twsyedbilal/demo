CREATE TABLE IF NOT EXISTS sm_book (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  created datetime NULL DEFAULT NULL,
  modified datetime NULL DEFAULT NULL,
  deleted tinyint(1) DEFAULT 0,
  book_name varchar(100) DEFAULT NULL,
  book_code varchar(40) DEFAULT NULL,
  PRIMARY KEY (id)
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_unicode_ci;
