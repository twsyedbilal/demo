DROP PROCEDURE IF EXISTS add_column_in_class;
DELIMITER $$
CREATE PROCEDURE add_column_in_class()
BEGIN
	IF NOT EXISTS (SELECT * FROM information_schema.COLUMNS WHERE TABLE_SCHEMA=database() AND TABLE_NAME='user' and COLUMN_NAME='gender') THEN
			alter table user ADD gender varchar(200) NULL default NULL;
	END IF;
	IF NOT EXISTS (SELECT * FROM information_schema.COLUMNS WHERE TABLE_SCHEMA=database() AND TABLE_NAME='user' and COLUMN_NAME='blood_group') THEN
			alter table user ADD blood_group varchar(200) NULL default NULL;
	END IF;
	IF NOT EXISTS (SELECT * FROM information_schema.COLUMNS WHERE TABLE_SCHEMA=database() AND TABLE_NAME='user' and COLUMN_NAME='date_of_birth') THEN
			alter table user ADD date_of_birth Date NULL default NULL;
	END IF;
	IF NOT EXISTS (SELECT * FROM information_schema.COLUMNS WHERE TABLE_SCHEMA=database() AND TABLE_NAME='user' and COLUMN_NAME='qualification') THEN
			alter table user ADD qualification varchar(200) NULL default NULL;
	END IF;
	IF NOT EXISTS (SELECT * FROM information_schema.COLUMNS WHERE TABLE_SCHEMA=database() AND TABLE_NAME='user' and COLUMN_NAME='address') THEN
			alter table user ADD address TEXT NULL default NULL;
	END IF;
	IF NOT EXISTS (SELECT * FROM information_schema.COLUMNS WHERE TABLE_SCHEMA=database() AND TABLE_NAME='user' and COLUMN_NAME='city') THEN
			alter table user ADD city varchar(200) NULL default NULL;
	END IF;
	IF NOT EXISTS (SELECT * FROM information_schema.COLUMNS WHERE TABLE_SCHEMA=database() AND TABLE_NAME='user' and COLUMN_NAME='state') THEN
			alter table user ADD state varchar(200) NULL default NULL;
	END IF;
END $$
DELIMITER ;
CALL add_column_in_class();
DROP PROCEDURE add_column_in_class;