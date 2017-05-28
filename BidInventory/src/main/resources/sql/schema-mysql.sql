CREATE TABLE IF NOT EXISTS `auction_engine`.`auction_item` (
  `item_id` VARCHAR(45)  NOT NULL,
  `item_name` VARCHAR(45) NOT NULL,
  `item_discription` VARCHAR(45) NOT NULL,
  `minimum_bid` INT NOT NULL,
  `bid_end_time` DATETIME NOT NULL,
  `auction_status` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`item_id`))
ENGINE = InnoDB;



CREATE TABLE IF NOT EXISTS `auction_engine`.`bid_history` (
  `trans_id` VARCHAR(45)  NOT NULL,
  `item_id` VARCHAR(45) NOT NULL,
  `user_id` INT NOT NULL,
  `bid_value` INT NOT NULL,
  `bid_time` DATETIME NOT NULL,
   PRIMARY KEY (`trans_id`),
  FOREIGN KEY (`item_id`) REFERENCES `auction_engine`.`auction_item`(`item_id`))
ENGINE = InnoDB;