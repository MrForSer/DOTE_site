--DROP TABLE users;
CREATE TABLE users (id serial, login varchar(255), password varchar(255), firstName varchar (255), lastName varchar (255));

INSERT INTO users (id, login, password, firstName, lastName) VALUES (DEFAULT, 'admin', 'admin', 'Админ', 'Админов');
INSERT INTO users (id, login, password, firstName, lastName) VALUES (DEFAULT, '143166', '143166', 'Рандомный', 'Юзер');
INSERT INTO users (id, login, password, firstName, lastName) VALUES (DEFAULT, 'vasya', '12345', 'Василий', 'Пупкин');
INSERT INTO users (id, login, password, firstName, lastName) VALUES (DEFAULT, 'sasha', 'qwerty', 'Александр', 'Иванов');
INSERT INTO users (id, login, password, firstName, lastName) VALUES (DEFAULT, 'xxx', '123', 'Петр', 'Волков');

SELECT id, login, password, firstname, lastName FROM users;
SELECT * FROM users;

DELETE FROM users WHERE login is null;

SHOW SERVER_ENCODING;