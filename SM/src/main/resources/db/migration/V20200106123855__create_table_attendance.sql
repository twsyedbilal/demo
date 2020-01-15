CREATE TABLE IF NOT EXISTS sm_attendance(
  id bigint(20) NOT NULL AUTO_INCREMENT,
  classs_id bigint(20) DEFAULT NULL,

  subject_id bigint(20) DEFAULT NULL,
  admission_id  bigint(20) DEFAULT NULL,
  
  user_id bigint(20) DEFAULT NULL,
  created datetime NULL DEFAULT NULL,
  modified datetime NULL DEFAULT NULL,
  deleted tinyint(1) DEFAULT 0,
  absent tinyint(1) DEFAULT 0,
  present tinyint(1) DEFAULT 0,
  reason varchar(100) DEFAULT null,
  types varchar(100) DEFAULT null,
 
  PRIMARY KEY (id),
  KEY fk_sm_attendance__sm_class_master(classs_id),
  CONSTRAINT fk_sm_attendance__sm_class_master FOREIGN key(classs_id) REFERENCES sm_class_master(id),
   
  KEY fk_sm_attendance__sm_subject_master(subject_id),
  CONSTRAINT fk_sm_attendance__sm_subject_master FOREIGN key(subject_id) REFERENCES sm_subject_master(id),

 
  KEY fk_sm_attendance__sm_admission(admission_id),
  CONSTRAINT fk_sm_attendance__sm_admission FOREIGN key(admission_id) REFERENCES sm_admission(id),
   
  KEY fk_sm_attendance__user(user_id),
  CONSTRAINT fk_sm_attendance__user FOREIGN key(user_id) REFERENCES user(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_unicode_ci;