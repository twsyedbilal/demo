DROP PROCEDURE IF EXISTS add_column_in_class;

DELIMITER $$

CREATE PROCEDURE add_column_in_class()

BEGIN
	
	IF NOT EXISTS (SELECT * FROM information_schema.COLUMNS WHERE TABLE_SCHEMA=database() AND TABLE_NAME='sm_subject_master' and COLUMN_NAME='book_name') THEN
			alter table sm_subject_master ADD book_name varchar(200) NULL default NULL;
	END IF;
	
	
	
	IF NOT EXISTS (SELECT * FROM information_schema.COLUMNS WHERE TABLE_SCHEMA=database() AND TABLE_NAME='sm_subject_master' and COLUMN_NAME='user_id') THEN
			ALTER TABLE `sm_subject_master` 
            ADD COLUMN `user_id` BIGINT(20) default NULL, 
			ADD KEY `FK_sm_subject_master__user` (`user_id`),
			ADD CONSTRAINT `FK_sm_subject_master__user` FOREIGN KEY (`user_id`) 
			REFERENCES `user`(`id`); 
	END IF;
	
	
END $$

DELIMITER ;

CALL add_column_in_class();

DROP PROCEDURE add_column_in_class;
