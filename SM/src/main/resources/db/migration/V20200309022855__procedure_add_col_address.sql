DROP PROCEDURE IF EXISTS add_column_in_class;
DELIMITER $$
CREATE PROCEDURE add_column_in_class()
BEGIN
	IF NOT EXISTS (SELECT * FROM information_schema.COLUMNS WHERE TABLE_SCHEMA=database() AND TABLE_NAME='sm_admission' and COLUMN_NAME='roll_no') THEN
			alter table sm_admission ADD roll_no varchar(200) NULL default NULL;
	END IF;
		IF NOT EXISTS (SELECT * FROM information_schema.COLUMNS WHERE TABLE_SCHEMA=database() AND TABLE_NAME='sm_admission' and COLUMN_NAME='sm_payment_type_id') THEN
			ALTER TABLE sm_admission DROP FOREIGN KEY sm_payment_type_id;	
	END IF;
	
	IF NOT EXISTS (SELECT * FROM information_schema.COLUMNS WHERE TABLE_SCHEMA=database() AND TABLE_NAME='sm_address' and COLUMN_NAME='admission_id') THEN
			ALTER TABLE `sm_address`
            ADD COLUMN `admission_id` BIGINT(20) default NULL,
			ADD KEY `FK_sm_address__sm_admission` (`admission_id`),
			ADD CONSTRAINT `FK_sm_address__sm_admission` FOREIGN KEY (`admission_id`)
			REFERENCES `sm_address`(`id`);
	END IF;
END $$
DELIMITER ;
CALL add_column_in_class();
DROP PROCEDURE add_column_in_class;