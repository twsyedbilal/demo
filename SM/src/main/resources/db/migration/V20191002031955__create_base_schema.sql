CREATE TABLE IF NOT EXISTS user (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  created datetime NULL DEFAULT NULL,
  modified datetime NULL DEFAULT NULL,
  deleted tinyint(1) DEFAULT 0,
  username varchar(40) DEFAULT NULL UNIQUE,
  password varchar(40) DEFAULT NULL,
  name varchar(50) DEFAULT NULL,
  email varchar(50) DEFAULT NULL,
  country_code varchar(5) DEFAULT NULL,
  mobile varchar(15) DEFAULT NULL,
  status varchar(40) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_unicode_ci;

CREATE TABLE IF NOT EXISTS role (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  created datetime NULL DEFAULT NULL,
  modified datetime NULL DEFAULT NULL,
  deleted tinyint(1) DEFAULT 0,
  role varchar(40) NOT NULL UNIQUE,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_unicode_ci;

CREATE TABLE IF NOT EXISTS user_role (
  user_id bigint(20) NOT NULL,  
  role_id bigint(20) NOT NULL,
  PRIMARY KEY (user_id, role_id),
  KEY fk_user_role__user (user_id),
  CONSTRAINT fk_user_role__user FOREIGN KEY (user_id) REFERENCES user (id),
  KEY fk_user_role__role (role_id),
  CONSTRAINT fk_user_role__role FOREIGN KEY (role_id) REFERENCES role (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_unicode_ci;


INSERT INTO role
(id, created, modified, deleted, role) VALUES (1, now(), now(), 0, 'ROLE_SA');

INSERT INTO role
(id, created, modified, deleted, role) VALUES (2, now(), now(), 0, 'ROLE_OPS');

INSERT INTO role
(id, created, modified, deleted, role) VALUES (3, now(), now(), 0, 'ROLE_ADMIN');

INSERT INTO role
(id, created, modified, deleted, role) VALUES (4, now(), now(), 0, 'ROLE_FINANCE');

INSERT INTO role
(id, created, modified, deleted, role) VALUES (5, now(), now(), 0, 'ROLE_SALE');

INSERT INTO role
(id, created, modified, deleted, role) VALUES (6, now(), now(), 0, 'ROLE_PURCHASE');

INSERT INTO role
(id, created, modified, deleted, role) VALUES (7, now(), now(), 0, 'ROLE_EMP');


INSERT INTO user (id, created, modified, deleted, username, password, name, email, country_code, mobile, status) VALUES
(1, now(), now(), 0, 'sysadmin', 'sysadmin', 'System Admin', 'sysadmin@techweaversystem.com', null, null, 'Active');

INSERT INTO user_role (user_id, role_id) VALUES
(1, 1);