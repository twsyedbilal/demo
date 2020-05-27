DROP PROCEDURE IF EXISTS add_column_in_class;
DELIMITER $$
CREATE PROCEDURE add_column_in_class()
BEGIN
	
	IF NOT EXISTS (SELECT * FROM information_schema.COLUMNS WHERE TABLE_SCHEMA=database() AND TABLE_NAME='sm_student_mark' and COLUMN_NAME='slavedto') THEN
			ALTER TABLE `sm_student_mark`
            ADD COLUMN `slavedto` BIGINT(20) default NULL,
			ADD KEY `fk_sm_student_mark__sm_mark_slave` (`slavedto`),
			ADD CONSTRAINT `FK_sm_address__sm_admission` FOREIGN KEY (`slavedto`)
			REFERENCES `sm_mark_slave`(`id`);
	END IF;
END $$
DELIMITER ;
CALL add_column_in_class();
DROP PROCEDURE add_column_in_class;