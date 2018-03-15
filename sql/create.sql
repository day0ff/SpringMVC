CREATE TABLE album(
	album_id SERIAL PRIMARY KEY,
	album_name VARCHAR(100) NOT NULL,
	album_price INT CHECK (album_price > 0)
	);
CREATE TABLE passport(
	passport_id SERIAL PRIMARY KEY,
	passport_number VARCHAR(100) NOT NULL
	);
CREATE TABLE person(
	person_id SERIAL PRIMARY KEY, 
	last_name VARCHAR(100) NOT NULL,
	first_name VARCHAR(100) NOT NULL,
	passport_id INT REFERENCES passport(passport_id)
	);
CREATE TABLE song(
	song_id SERIAL PRIMARY KEY,
	song_name VARCHAR(100) NOT NULL,
	person_id INT REFERENCES person(person_id)
	);
CREATE TABLE album_song(
	album_id INT REFERENCES album(album_id),
	song_id INT REFERENCES song(song_id)
	);

--Security
CREATE  TABLE users (
  username VARCHAR(45) NOT NULL PRIMARY KEY ,
  password VARCHAR(45) NOT NULL ,
  enabled BOOLEAN NOT NULL DEFAULT true
);
CREATE TABLE user_roles (
  	user_role_id SERIAL PRIMARY KEY,
  	username varchar(45) NOT NULL REFERENCES users (username),
  	role varchar(45) NOT NULL,
	CONSTRAINT uni_username_role UNIQUE (role,username)
	);

INSERT INTO users(username,password,enabled)
VALUES ('denis','1234', true);
INSERT INTO users(username,password,enabled)
VALUES ('alex','1234', true);

INSERT INTO user_roles (username, role)
VALUES ('denis', 'ROLE_USER');
INSERT INTO user_roles (username, role)
VALUES ('denis', 'ROLE_ADMIN');
INSERT INTO user_roles (username, role)
VALUES ('alex', 'ROLE_USER');