INSERT INTO chat.users (login, password) VALUES ('Ahmed', 'Lugano');
INSERT INTO chat.users (login, password) VALUES ('Diana', 'Sydney');
INSERT INTO chat.users (login, password) VALUES ('Trae', 'Barcellona');
INSERT INTO chat.users (login, password) VALUES ('Diego', 'Ciampino');
INSERT INTO chat.users (login, password) VALUES ('Larry', 'Parigi');

INSERT INTO chat.chatrooms (name, owner) VALUES 
	('Calcetto', 1),
	('Pizzata', 3),
	('Scazzottata', 2),
	('1v1', 4),
	('Partita', 5);

INSERT INTO chat.messages (authorID, roomID, text, date) VALUES
	(1, 1, 'bomboclat', NOW()),
	(2, 2, 'pizzetta ragazzacci?', NOW()),
	(3, 3, 'tutta roba regolare', NOW()),
	(4, 5, 'mareoooo', NOW()),
	(5, 4, 'ramoeeeeee', NOW());

INSERT INTO chat.users_chatrooms(userID, chatroomID) VALUES
	(1, 1),
	(2, 2),
	(3, 3),
	(4, 4),
	(5, 5);