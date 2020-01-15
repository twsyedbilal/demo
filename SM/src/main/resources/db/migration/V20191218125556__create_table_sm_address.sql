CREATE TABLE IF NOT EXISTS sm_country (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  created datetime NULL DEFAULT NULL,
  modified datetime NULL DEFAULT NULL,
  deleted tinyint(1) DEFAULT 0,
  
  country_name varchar(200) NOT NULL,
  sort_name varchar(200) NOT NULL,
  phone_code varchar(200) NOT NULL,
  primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_unicode_ci;

CREATE TABLE IF NOT EXISTS sm_state (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  created datetime NULL DEFAULT NULL,
  modified datetime NULL DEFAULT NULL,
  deleted tinyint(1) DEFAULT 0,
  
  state_name varchar(200) NOT NULL,
  sm_country_id bigint(20) DEFAULT NULL,
  primary key(id),
  KEY fk_sm_state__sm_country(sm_country_id),
  CONSTRAINT fk_sm_state__sm_country FOREIGN KEY (sm_country_id) REFERENCES sm_country(id)  
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_unicode_ci;


CREATE TABLE IF NOT EXISTS sm_city (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  created datetime NULL DEFAULT NULL,
  modified datetime NULL DEFAULT NULL,
  deleted tinyint(1) DEFAULT 0,
  city_name varchar(200) NOT NULL,
  sm_state_id bigint(20) DEFAULT NULL,
  primary key(id),
  KEY fk_sm_city__sm_state(sm_state_id),
  CONSTRAINT fk_sm_city__sm_statey FOREIGN KEY (sm_state_id) REFERENCES sm_state(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_unicode_ci;

CREATE TABLE IF NOT EXISTS sm_address (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  created datetime NULL DEFAULT NULL,
  modified datetime NULL DEFAULT NULL,
  deleted tinyint(1) DEFAULT 0,

  pin_code bigint(100)  NOT NULL,
  detail_address TEXT NOT NULL,
  sm_city_id bigint(20) DEFAULT NULL,
  sm_state_id bigint(20) DEFAULT NULL,
  sm_country_id bigint(20) DEFAULT NULL,

  primary key(id),
  KEY fk_sm_address__sm_city(sm_city_id),
  CONSTRAINT fk_sm_address__sm_city FOREIGN KEY (sm_city_id) REFERENCES sm_city(id),
  
  KEY fk_sm_address__sm_state(sm_state_id),
  CONSTRAINT fk_sm_address__sm_state FOREIGN KEY (sm_state_id) REFERENCES sm_state(id), 
  
  KEY fk_sm_address__sm_country(sm_country_id),
  CONSTRAINT fk_sm_address__sm_country FOREIGN KEY (sm_country_id) REFERENCES sm_country(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_unicode_ci;