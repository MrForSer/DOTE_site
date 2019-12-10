SELECT * FROM users;
DROP TABLE users;
CREATE TABLE users (id serial, login varchar(255), password varchar(255), firstName varchar (255), lastname varchar (255));

INSERT INTO users (id, login, password, firstName, lastname) VALUES (DEFAULT, 'admin', 'admin', 'Админ', 'Админов');
INSERT INTO users (id, login, password, firstName, lastname) VALUES (DEFAULT, '143166', '143166', 'Рандомный', 'Юзер');
INSERT INTO users (id, login, password, firstName, lastname) VALUES (DEFAULT, 'vasya', '12345', 'Василий', 'Пупкин');
INSERT INTO users (id, login, password, firstName, lastname) VALUES (DEFAULT, 'sasha', 'qwerty', 'Александр', 'Иванов');
INSERT INTO users (id, login, password, firstName, lastname) VALUES (DEFAULT, 'xxx', '123', 'Петр', 'Волков');

SELECT id, login, password, firstname, lastname FROM users;

DELETE FROM users WHERE login is null;