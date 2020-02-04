CREATE TABLE IF NOT EXISTS sm_admission (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  created datetime NULL DEFAULT NULL,
  modified datetime NULL DEFAULT NULL,
  deleted tinyint(1) DEFAULT 0,

  sm_class_master_id bigint(20) DEFAULT NULL, 
  sm_school_type_id bigint(20) DEFAULT NULL, 
  sm_school_id bigint(20) DEFAULT NULL, 
  sm_caste_id bigint(20) DEFAULT NULL,
  sm_sub_caste_id bigint(20) DEFAULT NULL,
  sm_religion_id bigint(20) DEFAULT NULL,
  sm_occupation_id bigint(20) DEFAULT NULL,
  sm_payment_type_id bigint(20) DEFAULT NULL,
  sm_mother_tongue_id bigint(20) DEFAULT NULL,
  sm_nationality_id bigint(20) DEFAULT NULL,
  sm_society_id bigint(20) DEFAULT NULL, 
  
  uid_no varchar(100) NOT NULL,
  id_no varchar(100) NOT NULL,
 
  student_reg_no varchar(200) NOT NULL,
  date Date NOT NULL,
  year varchar(100) NOT NULL,
  sur_name varchar(100) DEFAULT NULL,
  students_name varchar(150) NOT NULL,
  fathers_name varchar(150) DEFAULT NULL,
  mothers_name varchar(150) DEFAULT NULL,
  guardians_name varchar(200) DEFAULT NULL,
  gender varchar(20) DEFAULT NULL,
  date_of_birth Date NULL DEFAULT NULL,
  date_of_birth_in_words varchar(300) DEFAULT NULL,
  place_of_birth varchar(100) DEFAULT NULL,
  income bigint(20) NOT NULL,
  contact_no varchar(100) DEFAULT NULL,
  identity_by_mark_or_aadhar_no varchar(300) DEFAULT NULL,
  status varchar(100) DEFAULT NULL,
  live_status varchar(100) DEFAULT NULL,
  
	
	PRIMARY KEY (id),
    KEY fk_admission__sm_class_master(sm_class_master_id),
    CONSTRAINT fk_admission__sm_class_master FOREIGN KEY (sm_class_master_id) REFERENCES sm_class_master(id),
    
    KEY fk_admission__sm_school_type(sm_school_type_id),
    CONSTRAINT fk_admission__school_type FOREIGN KEY (sm_school_type_id) REFERENCES sm_school_type(id),

    KEY fk_admission__sm_school(sm_school_id),
    CONSTRAINT fk_admission__schoool FOREIGN KEY (sm_school_id) REFERENCES sm_school(id),
    
    KEY fk_admission__sm_caste(sm_caste_id),
    CONSTRAINT fk_admission__sm_caste FOREIGN KEY (sm_caste_id) REFERENCES sm_caste(id),

    KEY fk_admission__sm_sub_caste(sm_sub_caste_id),
    CONSTRAINT fk_admission__sm_sub_caste FOREIGN KEY (sm_sub_caste_id) REFERENCES sm_sub_caste(id),
    
    KEY fk_admission__sm_religion(sm_religion_id),
    CONSTRAINT fk_admission__sm_religion FOREIGN KEY (sm_religion_id) REFERENCES sm_religion(id),
 
    KEY fk_admission__sm_occupation(sm_occupation_id),
    CONSTRAINT fk_admission__sm_occupation FOREIGN KEY (sm_occupation_id) REFERENCES sm_occupation(id),
    
    KEY fk_admission__sm_payment_type(sm_payment_type_id),
    CONSTRAINT fk_admission__sm_payment_type FOREIGN KEY (sm_payment_type_id) REFERENCES sm_payment_type(id),
    
    KEY fk_admission__sm_mother_tongue(sm_mother_tongue_id),
    CONSTRAINT fk_admission__sm_mother_tongue FOREIGN KEY (sm_mother_tongue_id) REFERENCES sm_mother_tongue(id),      

    KEY fk_admission__sm_nationality(sm_nationality_id),
    CONSTRAINT fk_admission__sm_nationality FOREIGN KEY (sm_nationality_id) REFERENCES sm_nationality(id),       

    KEY fk_admission__sm_society(sm_society_id),
    CONSTRAINT fk_admission__sm_society FOREIGN KEY (sm_society_id) REFERENCES sm_society(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_unicode_ci;
   
CREATE TABLE IF NOT EXISTS sm_admission_sm_document (  
  sm_document_id bigint(20) NOT NULL,
  sm_admission_id bigint(20) NOT NULL,

  PRIMARY KEY (sm_document_id),
  KEY fk_sm_admission_document__sm_document (sm_document_id),
  CONSTRAINT fk_sm_admission_document__sm_document FOREIGN KEY (sm_document_id) REFERENCES sm_document(id),

  KEY fk_sm_admission_document__sm_admission (sm_admission_id),
  CONSTRAINT fk_sm_admission_document__sm_admission FOREIGN KEY (sm_admission_id) REFERENCES sm_admission(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_unicode_ci;
   
CREATE TABLE IF NOT EXISTS sm_admission_sm_address (  
  sm_address_id bigint(20) NOT NULL,
  sm_admission_id bigint(20) NOT NULL,

  PRIMARY KEY (sm_address_id),
  KEY fk_sm_admission_address__sm_address (sm_address_id),
  CONSTRAINT fk_sm_admission_address__sm_address FOREIGN KEY (sm_address_id) REFERENCES sm_address (id),
  KEY fk_sm_admission_address__sm_admission (sm_admission_id),
  CONSTRAINT fk_sm_admission_address__sm_admission FOREIGN KEY (sm_admission_id) REFERENCES sm_admission(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_unicode_ci;
   
CREATE TABLE IF NOT EXISTS sm_stock (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  created datetime NULL DEFAULT NULL,
  modified datetime NULL DEFAULT NULL,
  deleted tinyint(1) DEFAULT 0,

  stock_qty double NULL DEFAULT NULL,  
  stock_in double NULL DEFAULT NULL,
  stock_out double NULL DEFAULT NULL,
  given_qty double NULL DEFAULT NULL,
  return_qty double NULL DEFAULT NULL,
  opening_qty double NULL DEFAULT NULL,
  book_id bigint(20) DEFAULT NULL, 
   
  PRIMARY KEY (id),
  KEY fk_sm_stock_sm_book___sm_book (book_id),
  CONSTRAINT fk_sm_stock_sm_book___sm_book FOREIGN KEY (book_id) REFERENCES sm_book (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_unicode_ci;

CREATE TABLE IF NOT EXISTS sm_debit_book (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  created datetime NULL DEFAULT NULL,
  modified datetime NULL DEFAULT NULL,
  deleted tinyint(1) DEFAULT 0,

  type varchar(100) DEFAULT NULL,
  admission_id bigint(20) DEFAULT NULL, 

  PRIMARY KEY (id),
  KEY fk_sm_debit_book__sm_admission (admission_id),
  CONSTRAINT fk_sm_debit_book__sm_admission FOREIGN KEY (admission_id) REFERENCES sm_admission(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_unicode_ci;

CREATE TABLE IF NOT EXISTS sm_debit_slave (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  created datetime NULL DEFAULT NULL,
  modified datetime NULL DEFAULT NULL,
  deleted tinyint(1) DEFAULT 0,

  qty double NULL DEFAULT NULL,
  given_qty double NULL DEFAULT NULL,
  return_qty double NULL DEFAULT NULL,
  from_date datetime NULL DEFAULT NULL,
  to_date datetime NULL DEFAULT NULL,
  book_id bigint(20) DEFAULT NULL,
  debit_book_id bigint(20) DEFAULT NULL,
  
  PRIMARY KEY (id),
  KEY fk_sm_debit_slave__sm_debit_book(debit_book_id),
  CONSTRAINT fk_sm_debit_slave__sm_debit_book FOREIGN KEY (debit_book_id) REFERENCES sm_debit_book(id),
  
  KEY fk_sm_debit_slave__sm_book(book_id),
  CONSTRAINT fk_sm_debit_slave__sm_book FOREIGN KEY (book_id) REFERENCES sm_book(id)   
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_unicode_ci;

CREATE TABLE IF NOT EXISTS sm_credit_book (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  created datetime NULL DEFAULT NULL,
  modified datetime NULL DEFAULT NULL,
  deleted tinyint(1) DEFAULT 0,

  type varchar(100) DEFAULT NULL,
  admission_id bigint(20) DEFAULT NULL, 

  PRIMARY KEY (id),
  KEY fk_sm_credit_book__sm_admission (admission_id),
  CONSTRAINT fk_sm_credit_book__sm_admission FOREIGN KEY (admission_id) REFERENCES sm_admission(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_unicode_ci;


CREATE TABLE IF NOT EXISTS sm_credit_slave (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  created datetime NULL DEFAULT NULL,
  modified datetime NULL DEFAULT NULL,
  deleted tinyint(1) DEFAULT 0,

  qty double NULL DEFAULT NULL,
  given_qty double NULL DEFAULT NULL,
  return_qty double NULL DEFAULT NULL,
  from_date datetime NULL DEFAULT NULL,
  to_date datetime NULL DEFAULT NULL,
  book_id bigint(20) DEFAULT NULL,
  credit_book_id bigint(20) DEFAULT NULL,
  
  PRIMARY KEY (id),
  KEY fk_sm_credit_slave__sm_book(book_id),
  CONSTRAINT fk_sm_credit_slave__sm_book FOREIGN KEY (book_id) REFERENCES sm_book(id)   
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_unicode_ci;

CREATE TABLE IF NOT EXISTS sm_stock_in_out (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  created datetime NULL DEFAULT NULL,
  modified datetime NULL DEFAULT NULL,
  deleted tinyint(1) DEFAULT 0,

  qty double NULL DEFAULT NULL,  
  stock_in double NULL DEFAULT NULL,
  stock_out double NULL DEFAULT NULL,
  type varchar(100) NULL DEFAULT NULL,
  reason varchar(100) NULL DEFAULT NULL,
  book_id bigint(20) DEFAULT NULL, 
   
  PRIMARY KEY (id),
  KEY fk_sm_stock_in_out_sm_book___sm_book (book_id),
  CONSTRAINT fk_sm_stock_in_out_sm_book___sm_book FOREIGN KEY (book_id) REFERENCES sm_book (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_unicode_ci;

CREATE TABLE IF NOT EXISTS sm_opening_stock (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  created datetime NULL DEFAULT NULL,
  modified datetime NULL DEFAULT NULL,
  deleted tinyint(1) DEFAULT 0,

  opening_date Date DEFAULT NULL,
  opening_qty double NULL DEFAULT NULL,
  book_id bigint(20) DEFAULT NULL, 
  
  PRIMARY KEY (id),
  KEY fk_sm_opening_stock_sm_book___sm_book (book_id),
  CONSTRAINT fk_sm_opening_stock_sm_book___sm_book FOREIGN KEY (book_id) REFERENCES sm_book (id)  
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_unicode_ci;

CREATE TABLE IF NOT EXISTS sm_account_fee (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  payment_type_id bigint(20) DEFAULT NULL,
  created datetime NULL DEFAULT NULL,
  sm_admission_id bigint(20) DEFAULT NULL,
  sm_class_master_id bigint(20) DEFAULT NULL,
  modified datetime NULL DEFAULT NULL,
  deleted tinyint(1) DEFAULT 0,
  fee bigint(20)  DEFAULT 0.0,
  paid bigint(20)  DEFAULT 0.0,
  balance bigint(20) DEFAULT 0.0,
  actual_paid  bigint(20)  DEFAULT NULL,
  PRIMARY KEY (id),
  
  KEY fk_sm_account_fee__sm_admission(sm_admission_id),
  CONSTRAINT fk_sm_account_fee__sm_admission FOREIGN KEY (sm_admission_id) REFERENCES sm_admission(id),

  KEY fk_sm_account_fee__sm_class_master(sm_class_master_id),
  CONSTRAINT fk_sm_account_fee__sm_class_master FOREIGN KEY (sm_class_master_id) REFERENCES sm_class_master(id),
    
  KEY fk_sm_account_fee__sm_sm_payment_type(payment_type_id),
  CONSTRAINT fk_sm_account_fee__sm_payment_type FOREIGN KEY (payment_type_id) REFERENCES sm_payment_type(id)  
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_unicode_ci;

CREATE TABLE IF NOT EXISTS sm_account_phone_section (
 id bigint(20) NOT NULL AUTO_INCREMENT,
 sm_admission_id bigint(20) DEFAULT NULL,
 created datetime NULL DEFAULT NULL,
 modified datetime NULL DEFAULT NULL,
 deleted tinyint(1) DEFAULT 0,
  
 remark varchar(100) DEFAULT NULL,
 remaning_balance bigint(20) DEFAULT  0.0,
 PRIMARY KEY (id),
  
 KEY sm_account_phone_section__sm_admission(sm_admission_id),
 CONSTRAINT fk_sm_account_phone_section__sm_admission FOREIGN KEY (sm_admission_id) REFERENCES sm_admission(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_unicode_ci;
  
 /*complinat_type table with map admission and compliant  */
CREATE TABLE IF NOT EXISTS sm_compliant_type (
 id bigint(20) NOT NULL AUTO_INCREMENT,
 compliant_id bigint(20)  DEFAULT NULL,
 admission_id bigint(20)  DEFAULT NULL,
 created datetime NULL DEFAULT NULL,
 modified datetime NULL DEFAULT NULL,
 deleted tinyint(1) DEFAULT 0,
 remark varchar(100) DEFAULT NULL,
 PRIMARY KEY (id),   
 KEY fk_sm_complant_type__sm_compliant(compliant_id),
 CONSTRAINT fk__sm_compliant_type__compliant FOREIGN key(compliant_id) REFERENCES sm_compliant(id),

 KEY fk_sm_compliant_type__sm_admission(admission_id),
 CONSTRAINT fk_sm_compliant_type__sm_admission FOREIGN KEY (admission_id) REFERENCES sm_admission(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_unicode_ci;
