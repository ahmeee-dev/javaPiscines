CREATE SCHEMA IF NOT EXISTS Chat;

CREATE TABLE Chat.users (
	id SERIAL PRIMARY KEY,
	login TEXT UNIQUE,
	password TEXT,
	created_rooms INT[],
	socializing_rooms INT[]
);

CREATE TABLE Chat.chatrooms (
	id SERIAL PRIMARY KEY,
	name TEXT,
	owner INT Chat.users(id),
	messages TEXT[]
);

CREATE TABLE Chat.messages (
	id SERIAL PRIMARY KEY,
	author TEXT,
	room INT,
	text TEXT,
	date TEXT 
)
