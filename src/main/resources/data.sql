INSERT INTO room_category(name, description) VALUES
('STUDIO', '1 Queen-sized bed & 1 single mattress'), 
('DELUXE', '1 Queen-sized bed, patio chairs with open air patio'),
('PREMIER', '1 Queen-sized bed, arm chair'),
('TRIPLE', '1 Queen-sized bed & 1 single bed'),
('TWIN', '2 single-beds'),
('SUPERIOR', '1 Queen-sized bed');

INSERT INTO option(optionName, cost) VALUES
('WI-FI or LAN', '13'),
('Extra breakfast', '24'),
('Extra bed (B&B)', '15'),
('Dry Sauna', '8'),
('Steam Sauna', '10'),
('Jacuzzi', '11'),
('Special treat in room', '8');

INSERT INTO room(number, category, beds, price) VALUES
('1', '1', '1', '150'),
('2', '1', '1', '150'),
('3', '1', '1', '150'),
('4', '2', '1', '250'),
('5', '3', '1', '500'),
('6', '4', '1', '550'),
('7', '4', '1', '550'),
('8', '5', '2', '700'),
('9', '5', '2', '700'),
('10', '6', '1', '1000');