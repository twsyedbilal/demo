DROP PROCEDURE IF EXISTS add_column_in_class;

DELIMITER $$

CREATE PROCEDURE add_column_in_class()

BEGIN
	
	IF NOT EXISTS (SELECT * FROM information_schema.COLUMNS WHERE TABLE_SCHEMA=database() AND TABLE_NAME='sm_class_master' and COLUMN_NAME='class_capacity') THEN
			alter table sm_class_master ADD class_capacity varchar(200) NULL default NULL;
	END IF;
	
	
	IF NOT EXISTS (SELECT * FROM information_schema.COLUMNS WHERE TABLE_SCHEMA=database() AND TABLE_NAME='sm_class_master' and COLUMN_NAME='class_starting_date') THEN
			alter table sm_class_master ADD class_starting_date datetime NULL default NULL;
	END IF;
	
	
	IF NOT EXISTS (SELECT * FROM information_schema.COLUMNS WHERE TABLE_SCHEMA=database() AND TABLE_NAME='sm_class_master' and COLUMN_NAME='class_ending_date') THEN
			alter table sm_class_master ADD class_ending_date datetime NULL default NULL;
	END IF;
	
	
	IF NOT EXISTS (SELECT * FROM information_schema.COLUMNS WHERE TABLE_SCHEMA=database() AND TABLE_NAME='sm_class_master' and COLUMN_NAME='class_location') THEN
			alter table sm_class_master ADD class_location varchar(200) NULL default NULL;
	END IF;
	
	IF NOT EXISTS (SELECT * FROM information_schema.COLUMNS WHERE TABLE_SCHEMA=database() AND TABLE_NAME='sm_class_master' and COLUMN_NAME='class_type') THEN
			alter table sm_class_master ADD class_type varchar(200) NULL default NULL;
	END IF;
	
	
	IF NOT EXISTS (SELECT * FROM information_schema.COLUMNS WHERE TABLE_SCHEMA=database() AND TABLE_NAME='sm_class_master' and COLUMN_NAME='user_id') THEN
			ALTER TABLE `sm_class_master` 
            ADD COLUMN `user_id` BIGINT(20) default NULL, 
			ADD KEY `FK_sm_class_master_TABLE_user_id` (`user_id`),
			ADD CONSTRAINT `FK_sm_class_master_TABLE_user_id` FOREIGN KEY (`user_id`) 
			REFERENCES `user`(`id`); 
	END IF;
	
	
	
END $$

DELIMITER ;

CALL add_column_in_class();

DROP PROCEDURE add_column_in_class;
