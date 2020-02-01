CREATE TABLE IF NOT EXISTS student_status (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  created datetime NULL DEFAULT NULL,
  modified datetime NULL DEFAULT NULL,
  deleted tinyint(1) DEFAULT 0,
  	
  	admission_id bigint(20) DEFAULT NULL,
	status varchar(100) DEFAULT NULL,
  
  	PRIMARY KEY (id),
    KEY fk_student_status__sm_admission(admission_id),
    CONSTRAINT fk_student_status__sm_admission FOREIGN KEY (admission_id) REFERENCES sm_admission(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_unicode_ci;
    
  
  
