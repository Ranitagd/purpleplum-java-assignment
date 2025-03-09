CREATE SCHEMA `pupleplum_customer` ;

CREATE TABLE `pupleplum_customer`.`customer_master` (
  `customer_id` INT NOT NULL AUTO_INCREMENT,
  `customer_name` VARCHAR(45) NOT NULL,
  `customer_address1` VARCHAR(45) NOT NULL,
  `customer_address2` VARCHAR(45) NULL,
  `customer_city` VARCHAR(45) NULL,
  `customer_state` VARCHAR(45) NOT NULL,
  `customer_country` VARCHAR(45) NOT NULL,
  `customer_mobile` VARCHAR(45) NOT NULL,
  `customer_identifier` VARCHAR(45) NOT NULL,
  `customer_identifier_number` VARCHAR(45) NOT NULL,
  `customer_email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`customer_id`),
  UNIQUE INDEX `customer_identifier_number_UNIQUE` (`customer_identifier_number` ASC) VISIBLE,
  UNIQUE INDEX `customer_mobile_UNIQUE` (`customer_mobile` ASC) VISIBLE,
  UNIQUE INDEX `cutomer_email_UNIQUE` (`cutomer_email` ASC) VISIBLE);


-- Insert Query 1
INSERT INTO `pupleplum_customer`.`customer_master` 
(`customer_name`, `customer_address1`, `customer_address2`, `cutomer_city`, `customer_state`, `customer_country`, `customer_mobile`, `customer_identifier`, `customer_identifier_number`, `cutomer_email`)
VALUES 
('John Doe', '123 Elm Street', 'Apt 4B', 'Springfield', 'IL', 'USA', '555-1234', 'ID12345', '987654321', 'john.doe@example.com');

-- Insert Query 2
INSERT INTO `pupleplum_customer`.`customer_master` 
(`customer_name`, `customer_address1`, `customer_address2`, `cutomer_city`, `customer_state`, `customer_country`, `customer_mobile`, `customer_identifier`, `customer_identifier_number`, `cutomer_email`)
VALUES 
('Jane Smith', '456 Oak Avenue', NULL, 'Chicago', 'IL', 'USA', '555-5678', 'ID67890', '123456789', 'jane.smith@example.com');

-- Insert Query 3
INSERT INTO `pupleplum_customer`.`customer_master` 
(`customer_name`, `customer_address1`, `customer_address2`, `cutomer_city`, `customer_state`, `customer_country`, `customer_mobile`, `customer_identifier`, `customer_identifier_number`, `cutomer_email`)
VALUES 
('Alice Johnson', '789 Pine Road', 'Suite 200', 'Los Angeles', 'CA', 'USA', '555-8765', 'ID24680', '112233445', 'alice.johnson@example.com');

-- Insert Query 4
INSERT INTO `pupleplum_customer`.`customer_master` 
(`customer_name`, `customer_address1`, `customer_address2`, `cutomer_city`, `customer_state`, `customer_country`, `customer_mobile`, `customer_identifier`, `customer_identifier_number`, `cutomer_email`)
VALUES 
('Bob Brown', '101 Maple Street', NULL, 'New York', 'NY', 'USA', '555-4321', 'ID13579', '223344556', 'bob.brown@example.com');
