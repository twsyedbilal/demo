CREATE TABLE IF NOT EXISTS sm_exam (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  created datetime NULL DEFAULT NULL,
  modified datetime NULL DEFAULT NULL,
  deleted tinyint(1) DEFAULT 0,
  
  exam_name varchar(100) DEFAULT NULL,
  exam_start_date varchar(40) DEFAULT NULL,
  exam_end_date varchar(40) DEFAULT NULL,
  classs_id bigint(20) DEFAULT NULL,
  
  PRIMARY KEY (id),
  KEY fk_sm_exam__sm_class_master(classs_id),
  CONSTRAINT fk_sm_exam__sm_class_master FOREIGN key(classs_id) REFERENCES sm_class_master(id)
  
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_unicode_ci;

CREATE TABLE IF NOT EXISTS `sm_exam_slave` (
  `subject_id` bigint(20) NOT NULL,
  `id` bigint(20) NOT NULL,
  `exam_id` bigint(20) NOT NULL,
  `created` datetime DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
 
  KEY `fk_sm_exam_slave__sm_subject_master` (`subject_id`),
  CONSTRAINT `fk_sm_exam_slave__sm_subject_master` FOREIGN KEY (`subject_id`) REFERENCES `sm_subject_master` (`id`),
  
   KEY `fk_sm_exam_slave__sm_exam` (`exam_id`),
  CONSTRAINT `fk_sm_exam_slave__sm_exam` FOREIGN KEY (`exam_id`) REFERENCES `sm_exam` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;



CREATE TABLE IF NOT EXISTS `sm_student_mark` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created` datetime DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `exam_id` bigint(20) DEFAULT NULL,
  `subject_id` bigint(20) DEFAULT NULL,
  `classs_id` bigint(20) DEFAULT NULL,
 
  PRIMARY KEY (`id`),
  KEY `fk_sm_student_mark__sm_subject_master` (`subject_id`),
  KEY `fk_sm_student_mark__sm_class_master` (`classs_id`),
  KEY `fk_sm_student_mark__sm_exam` (`exam_id`),
 
  CONSTRAINT `fk_sm_student_mark__sm_class_master` FOREIGN KEY (`classs_id`) REFERENCES `sm_class_master` (`id`),
  CONSTRAINT `fk_sm_student_mark__sm_exam` FOREIGN KEY (`exam_id`) REFERENCES `sm_exam` (`id`),
  CONSTRAINT `fk_sm_student_mark__sm_subject_master` FOREIGN KEY (`subject_id`) REFERENCES `sm_subject_master` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


CREATE TABLE IF NOT EXISTS `sm_mark_slave` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `admission_id` bigint(20) DEFAULT NULL,
  `mark_id` bigint(20) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `mark` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `remark` varchar(40) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_sm_mark_slave__sm_admission` (`admission_id`),
  CONSTRAINT `fk_sm_mark_slave__sm_admission` FOREIGN KEY (`admission_id`) REFERENCES `sm_admission` (`id`),
  KEY `fk_sm_mark_slave__sm_student_markn` (`mark_id`),
  CONSTRAINT `fk_sm_mark_slave__sm_student_markn` FOREIGN KEY (`mark_id`) REFERENCES `sm_student_mark` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;



