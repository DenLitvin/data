CREATE TABLE `records` (
	`id` INT(5) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(200) NOT NULL,
	`type` VARCHAR(100) NOT NULL,
	PRIMARY KEY (`id`)
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB