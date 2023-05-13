create schema my_pay;

CREATE TABLE one_time_password (
  id VARCHAR(255) NOT NULL,
   otp_identifier VARCHAR(255) NULL,
   code VARCHAR(255) NULL,
   created_date_time datetime NULL,
   expired_date_time datetime NULL,
   otp_status VARCHAR(255) NULL,
	otp_type VARCHAR(45) NULL,
   CONSTRAINT pk_onetimepassword PRIMARY KEY (id)
);

CREATE TABLE user (
  id VARCHAR(255) NOT NULL,
   phone_no VARCHAR(255) NULL,
   first_name VARCHAR(255) NULL,
   last_name VARCHAR(255) NULL,
   dob date NULL,
   registered_date_time datetime NULL,
   deleted BIT(1) NULL,
   CONSTRAINT pk_user PRIMARY KEY (id)
);

CREATE TABLE user_authentication (
  id VARCHAR(255) NOT NULL,
   password VARCHAR(255) NULL,
   user_id VARCHAR(255) NULL,
   CONSTRAINT pk_userauthentication PRIMARY KEY (id)
);

ALTER TABLE user_authentication ADD CONSTRAINT FK_USERAUTHENTICATION_ON_USER FOREIGN KEY (user_id) REFERENCES user (id);

CREATE TABLE merchant (
  id VARCHAR(255) NOT NULL,
   name VARCHAR(255) NULL,
   CONSTRAINT pk_merchant PRIMARY KEY (id)
);

INSERT INTO `my_pay`.`merchant` (`id`, `name`) VALUES ('3d3c6748-ec20-4a3a-a9a3-3bcb32a74be1', 'Nick Nack');
INSERT INTO `my_pay`.`merchant` (`id`, `name`) VALUES ('84df75d4-4c4f-4e43-a7e4-0a35643e721e', 'Odel');
CREATE TABLE shop (
  id VARCHAR(255) NOT NULL,
   name VARCHAR(255) NULL,
   merchant_id VARCHAR(255) NULL,
   CONSTRAINT pk_shop PRIMARY KEY (id)
);

ALTER TABLE shop ADD CONSTRAINT FK_SHOP_ON_MERCHANT FOREIGN KEY (merchant_id) REFERENCES merchant (id);

INSERT INTO `my_pay`.`shop` (`id`, `name`, `merchant_id`) VALUES ('2097ce0c-d88e-4bea-8c7d-1d2b58b3f3b3', 'Colombo', '3d3c6748-ec20-4a3a-a9a3-3bcb32a74be1');
INSERT INTO `my_pay`.`shop` (`id`, `name`, `merchant_id`) VALUES ('9f478b54-7d28-4c22-9b24-72b1de7b9681', 'Colombo', '84df75d4-4c4f-4e43-a7e4-0a35643e721e');
INSERT INTO `my_pay`.`shop` (`id`, `name`, `merchant_id`) VALUES ('5479a9b9-b1f3-404e-8f04-51126d3ec6b8', 'Kandy', '84df75d4-4c4f-4e43-a7e4-0a35643e721e');

CREATE TABLE counter (
  id VARCHAR(255) NOT NULL,
   name VARCHAR(255) NULL,
   shop_id VARCHAR(255) NULL,
   CONSTRAINT pk_counter PRIMARY KEY (id)
);

ALTER TABLE counter ADD CONSTRAINT FK_COUNTER_ON_SHOP FOREIGN KEY (shop_id) REFERENCES shop (id);

INSERT INTO `my_pay`.`counter` (`id`, `name`, `shop_id`) VALUES ('b5e9d9e2-2d3d-44b3-8e7b-04fa94ec761f', 'counter 1', '2097ce0c-d88e-4bea-8c7d-1d2b58b3f3b3');
INSERT INTO `my_pay`.`counter` (`id`, `name`, `shop_id`) VALUES ('6c9c6dcb-58c2-4a2b-a2ab-09b0a6c14e50', 'counter 2', '2097ce0c-d88e-4bea-8c7d-1d2b58b3f3b3');
INSERT INTO `my_pay`.`counter` (`id`, `name`, `shop_id`) VALUES ('2799b76f-72de-4a22-bc69-59ebf56efb09', 'counter 1', '5479a9b9-b1f3-404e-8f04-51126d3ec6b8');
INSERT INTO `my_pay`.`counter` (`id`, `name`, `shop_id`) VALUES ('0af2a71a-7f78-4c4e-a927-bb87e23d1671', 'counter 2', '5479a9b9-b1f3-404e-8f04-51126d3ec6b8');
INSERT INTO `my_pay`.`counter` (`id`, `name`, `shop_id`) VALUES ('4d4f4cc4-8914-4e33-a07f-0a930b1e990e', 'counter 1', '9f478b54-7d28-4c22-9b24-72b1de7b9681');
INSERT INTO `my_pay`.`counter` (`id`, `name`, `shop_id`) VALUES ('c231a509-28d1-4c2f-b8e6-47cf88b1f2f2', 'counter 2', '9f478b54-7d28-4c22-9b24-72b1de7b9681');

CREATE TABLE card (
  id VARCHAR(255) NOT NULL,
   user_id VARCHAR(255) NULL,
   card_name VARCHAR(255) NULL,
   card_no VARCHAR(255) NULL,
   cvv VARCHAR(255) NULL,
   expires date NULL,
   card_type VARCHAR(255) NULL,
   CONSTRAINT pk_card PRIMARY KEY (id)
);

ALTER TABLE card ADD CONSTRAINT FK_CARD_ON_USER FOREIGN KEY (user_id) REFERENCES user (id);

CREATE TABLE payment (
  id VARCHAR(255) NOT NULL,
   user_id VARCHAR(255) NULL,
   card_id VARCHAR(255) NULL,
   counter_id VARCHAR(255) NULL,
   amount DECIMAL NULL,
   payment_status VARCHAR(255) NULL,
   CONSTRAINT pk_payment PRIMARY KEY (id)
);

ALTER TABLE payment ADD CONSTRAINT FK_PAYMENT_ON_CARD FOREIGN KEY (card_id) REFERENCES card (id);

ALTER TABLE payment ADD CONSTRAINT FK_PAYMENT_ON_COUNTER FOREIGN KEY (counter_id) REFERENCES counter (id);

ALTER TABLE payment ADD CONSTRAINT FK_PAYMENT_ON_USER FOREIGN KEY (user_id) REFERENCES user (id);

INSERT INTO `merchant` VALUES ('3d3c6748-ec20-4a3a-a9a3-3bcb32a74be1','Nick Nack'),('84df75d4-4c4f-4e43-a7e4-0a35643e721e','Odel');
INSERT INTO `counter` VALUES ('0af2a71a-7f78-4c4e-a927-bb87e23d1671','counter 2','5479a9b9-b1f3-404e-8f04-51126d3ec6b8'),('2799b76f-72de-4a22-bc69-59ebf56efb09','counter 1','5479a9b9-b1f3-404e-8f04-51126d3ec6b8'),('4d4f4cc4-8914-4e33-a07f-0a930b1e990e','counter 1','9f478b54-7d28-4c22-9b24-72b1de7b9681'),('6c9c6dcb-58c2-4a2b-a2ab-09b0a6c14e50','counter 2','2097ce0c-d88e-4bea-8c7d-1d2b58b3f3b3'),('b5e9d9e2-2d3d-44b3-8e7b-04fa94ec761f','counter 1','2097ce0c-d88e-4bea-8c7d-1d2b58b3f3b3'),('c231a509-28d1-4c2f-b8e6-47cf88b1f2f2','counter 2','9f478b54-7d28-4c22-9b24-72b1de7b9681');
INSERT INTO `shop` VALUES ('2097ce0c-d88e-4bea-8c7d-1d2b58b3f3b3','Colombo','3d3c6748-ec20-4a3a-a9a3-3bcb32a74be1'),('5479a9b9-b1f3-404e-8f04-51126d3ec6b8','Kandy','84df75d4-4c4f-4e43-a7e4-0a35643e721e'),('9f478b54-7d28-4c22-9b24-72b1de7b9681','Colombo','84df75d4-4c4f-4e43-a7e4-0a35643e721e');
