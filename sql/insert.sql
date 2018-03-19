INSERT INTO passport (passport_number)	VALUES ('yRxZM3wvWC');
INSERT INTO passport (passport_number)	VALUES ('s01BQfc8NJ');
INSERT INTO passport (passport_number)	VALUES ('9sNeXIQrIm');
INSERT INTO passport (passport_number)	VALUES ('xaA9mjllwR');
INSERT INTO passport (passport_number)  VALUES ('DKea3i3TlY');
INSERT INTO passport (passport_number)	VALUES ('15n2TXzCcs');
INSERT INTO passport (passport_number)	VALUES ('B2HuHx4tti');
INSERT INTO passport (passport_number)	VALUES ('EXkM1ijQTf');
INSERT INTO passport (passport_number)	VALUES ('P83W1LaoCH');
INSERT INTO passport (passport_number)	VALUES ('jsU4lO7anY');
INSERT INTO passport (passport_number)	VALUES ('WyfXHmtdaM');
INSERT INTO passport (passport_number)	VALUES ('LktwqSCQcm');

INSERT INTO person (first_name, last_name, passport_id)	VALUES ('Donald','Trump', 1);
INSERT INTO person (first_name, last_name, passport_id)	VALUES ('Tereza','Maj', 2);
INSERT INTO person (first_name, last_name, passport_id)	VALUES ('Emanuel','Makron', 3);
INSERT INTO person (first_name, last_name, passport_id)	VALUES ('Angela','Merkel', 4);
INSERT INTO person (first_name, last_name, passport_id)	VALUES ('Vladimir','Putin', 5);
INSERT INTO person (first_name, last_name, passport_id)	VALUES ('Alexander','Lukashenko', 6);
INSERT INTO person (first_name, last_name, passport_id)	VALUES ('Elvis','Presli', 7);
INSERT INTO person (first_name, last_name, passport_id)	VALUES ('Jon','Lenon', 8);
INSERT INTO person (first_name, last_name, passport_id)	VALUES ('Patrisia','Kaas', 9);
INSERT INTO person (first_name, last_name, passport_id)	VALUES ('Till','Lindemann', 10);
INSERT INTO person (first_name, last_name, passport_id)	VALUES ('Anna','Shurochkins', 11);
INSERT INTO person (first_name, last_name, passport_id)	VALUES ('Sergei','Michalock', 12);

INSERT INTO song (song_name,person_id) VALUES ('How Great Thou Art', 7);
INSERT INTO song (song_name,person_id) VALUES ('Stand by Me', 7);
INSERT INTO song (song_name,person_id) VALUES ('So High', 7);
INSERT INTO song (song_name,person_id) VALUES ('By nd By', 8);
INSERT INTO song (song_name,person_id) VALUES ('Mean Woman Blues', 9);
INSERT INTO song (song_name,person_id) VALUES ('Loving You', 10);
INSERT INTO song (song_name,person_id) VALUES ('True Love', 11);
INSERT INTO song (song_name,person_id) VALUES ('Party', 9);
INSERT INTO song (song_name,person_id) VALUES ('Help Me', 10);
INSERT INTO song (song_name,person_id) VALUES ('Its Midnigjt', 8);
INSERT INTO song (song_name,person_id) VALUES ('Au', 9);
INSERT INTO song (song_name,person_id) VALUES ('Ty Kinula', 8);
INSERT INTO song (song_name,person_id) VALUES ('V Platie Belom', 8);
INSERT INTO song (song_name,person_id) VALUES ('Pochemu Lubov Uchodit', 10);
INSERT INTO song (song_name,person_id) VALUES ('Kapital', 10);
INSERT INTO song (song_name,person_id) VALUES ('Ogonki', 11);
INSERT INTO song (song_name,person_id) VALUES ('Manifest', 12);
INSERT INTO song (song_name,person_id) VALUES ('Belarus Freedom', 12);
INSERT INTO song (song_name,person_id) VALUES ('Zorachki', 12);
INSERT INTO song (song_name,person_id) VALUES ('Rybka Zolotaya', 12);

INSERT INTO album (album_name,album_price) VALUES ('Rybka Zolotaya', 12);
INSERT INTO album (album_name,album_price) VALUES ('How Great Thou Art', 3);
INSERT INTO album (album_name,album_price) VALUES ('Loving You', 2);
INSERT INTO album (album_name,album_price) VALUES ('Promised Land', 6);
INSERT INTO album (album_name,album_price) VALUES ('Kapital', 1);
INSERT INTO album (album_name,album_price) VALUES ('Ty Kinula', 8);
INSERT INTO album (album_name,album_price) VALUES ('Manifest', 5);

INSERT INTO album_song (album_id,song_id) VALUES (1, 1);
INSERT INTO album_song (album_id,song_id) VALUES (1, 2);
INSERT INTO album_song (album_id,song_id) VALUES (1, 3);
INSERT INTO album_song (album_id,song_id) VALUES (1, 4);
INSERT INTO album_song (album_id,song_id) VALUES (2, 5);
INSERT INTO album_song (album_id,song_id) VALUES (2, 5);
INSERT INTO album_song (album_id,song_id) VALUES (2, 6);
INSERT INTO album_song (album_id,song_id) VALUES (3, 7);
INSERT INTO album_song (album_id,song_id) VALUES (3, 8);
INSERT INTO album_song (album_id,song_id) VALUES (3, 9);
INSERT INTO album_song (album_id,song_id) VALUES (4, 10);
INSERT INTO album_song (album_id,song_id) VALUES (4, 11);
INSERT INTO album_song (album_id,song_id) VALUES (4, 12);
INSERT INTO album_song (album_id,song_id) VALUES (4, 13);
INSERT INTO album_song (album_id,song_id) VALUES (5, 15);
INSERT INTO album_song (album_id,song_id) VALUES (5, 16);
INSERT INTO album_song (album_id,song_id) VALUES (5, 17);
INSERT INTO album_song (album_id,song_id) VALUES (6, 18);
INSERT INTO album_song (album_id,song_id) VALUES (6, 19);
INSERT INTO album_song (album_id,song_id) VALUES (6, 20);
INSERT INTO album_song (album_id,song_id) VALUES (1, 7);
INSERT INTO album_song (album_id,song_id) VALUES (2, 1);
INSERT INTO album_song (album_id,song_id) VALUES (3, 6);
INSERT INTO album_song (album_id,song_id) VALUES (4, 20);


INSERT INTO users(username,password,enabled)
VALUES ('denis','1234', true);
INSERT INTO users(username,password,enabled)
VALUES ('andrej','1234', true);

INSERT INTO user_roles (username, role)
VALUES ('denis', 'ROLE_USER');
INSERT INTO user_roles (username, role)
VALUES ('denis', 'ROLE_ADMIN');
INSERT INTO user_roles (username, role)
VALUES ('andrej', 'ROLE_USER');