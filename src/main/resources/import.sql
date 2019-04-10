INSERT INTO room_category(NAME, DESCRIPTION) VALUES ('STUDIO', '1 Queen-sized bed & 1 single mattress'); 
INSERT INTO room_category(NAME, DESCRIPTION) VALUES ('DELUXE', '1 Queen-sized bed, patio chairs with open air patio');
INSERT INTO room_category(NAME, DESCRIPTION) VALUES ('PREMIER', '1 Queen-sized bed, arm chair');
INSERT INTO room_category(NAME, DESCRIPTION) VALUES ('TRIPLE', '1 Queen-sized bed & 1 single bed');
INSERT INTO room_category(NAME, DESCRIPTION) VALUES ('TWIN', '2 single-beds');
INSERT INTO room_category(NAME, DESCRIPTION) VALUES ('SUPERIOR', '1 Queen-sized bed');

INSERT INTO option(OPTIONNAME, COST) VALUES ('WI-FI or LAN', '13');
INSERT INTO option(OPTIONNAME, COST) VALUES ('Extra breakfast', '24');
INSERT INTO option(OPTIONNAME, COST) VALUES ('Extra bed (B&B)', '15');
INSERT INTO option(OPTIONNAME, COST) VALUES ('Dry Sauna', '8');
INSERT INTO option(OPTIONNAME, COST) VALUES ('Steam Sauna', '10');
INSERT INTO option(OPTIONNAME, COST) VALUES ('Jacuzzi', '11');
INSERT INTO option(OPTIONNAME, COST) VALUES ('Special treat in room', '8');

INSERT INTO ROOM(NUMBER, CATEGORY_ID, BEDS, PRICE) VALUES ('1', '1', '1', '150');
INSERT INTO ROOM(NUMBER, CATEGORY_ID, BEDS, PRICE) VALUES ('2', '1', '1', '150');
INSERT INTO ROOM(NUMBER, CATEGORY_ID, BEDS, PRICE) VALUES ('3', '1', '1', '150');
INSERT INTO ROOM(NUMBER, CATEGORY_ID, BEDS, PRICE) VALUES ('4', '2', '1', '250');
INSERT INTO ROOM(NUMBER, CATEGORY_ID, BEDS, PRICE) VALUES ('5', '3', '1', '500');
INSERT INTO ROOM(NUMBER, CATEGORY_ID, BEDS, PRICE) VALUES ('6', '4', '1', '550');
INSERT INTO ROOM(NUMBER, CATEGORY_ID, BEDS, PRICE) VALUES ('7', '4', '1', '550');
INSERT INTO ROOM(NUMBER, CATEGORY_ID, BEDS, PRICE) VALUES ('8', '5', '2', '700');
INSERT INTO ROOM(NUMBER, CATEGORY_ID, BEDS, PRICE) VALUES ('9', '5', '2', '700');
INSERT INTO ROOM(NUMBER, CATEGORY_ID, BEDS, PRICE) VALUES ('10', '6', '1', '1000');

