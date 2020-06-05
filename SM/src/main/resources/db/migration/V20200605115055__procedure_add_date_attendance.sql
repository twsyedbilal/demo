DROP PROCEDURE IF EXISTS add_column_in_class;
DELIMITER $$
CREATE PROCEDURE add_column_in_class()
BEGIN
	IF NOT EXISTS (SELECT * FROM information_schema.COLUMNS WHERE TABLE_SCHEMA=database() AND TABLE_NAME='sm_attendance' and COLUMN_NAME='date') THEN
			alter table sm_attendance ADD date DATE NULL default NULL;
	END IF;
END $$
DELIMITER ;
CALL add_column_in_class();
DROP PROCEDURE add_column_in_class;