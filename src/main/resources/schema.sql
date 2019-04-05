DROP TABLE IF EXISTS user;
CREATE TABLE user(
	id IDENTITY, 
	firstName VARCHAR(255), 
	lastName VARCHAR(255), 
	PRIMARY KEY (ID));

DROP TABLE IF EXISTS option;
CREATE TABLE option(
	id IDENTITY, 
	optionName VARCHAR(255), 
	cost BIGINT, 
	PRIMARY KEY (ID));	

DROP TABLE IF EXISTS booking_users;
CREATE TABLE booking_users(
	booking_id BIGINT,
	user_id BIGINT);

DROP TABLE IF EXISTS booking_options;
CREATE TABLE booking_options(
	booking_id BIGINT,
	option_id BIGINT);	

DROP TABLE IF EXISTS booking;
CREATE TABLE booking(
	id IDENTITY,
	roomId BIGINT,
	dateGenerated DATE,
	PRIMARY KEY (ID));

	
DROP TABLE IF EXISTS room_category;
CREATE TABLE room_category(
	id IDENTITY, 
	name VARCHAR(255), 
	description VARCHAR(255), 
	PRIMARY KEY (ID));

DROP TABLE IF EXISTS room;
CREATE TABLE room(
	id IDENTITY, 
	number VARCHAR(255), 
	category BIGINT, 
	beds INT,
	price BIGINT,
	PRIMARY KEY (ID));


