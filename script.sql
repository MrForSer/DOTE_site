-- DB: salary
CREATE TABLE users (id serial, login varchar(255), password varchar(255), firstName varchar (255), lastName varchar (255), role varchar(5) CHECK (role IN ('admin', 'user')));
INSERT INTO users (id, login, password, firstName, lastName, role) VALUES (DEFAULT, 'admin', 'admin', 'Александр', 'Петров', 'admin');
INSERT INTO users (id, login, password, firstName, lastName, role) VALUES (DEFAULT, 'user', 'user', 'Иван', 'Иванов', 'user');

SELECT *
FROM users;

CREATE TABLE employees
(
    id         serial,
    lastName   varchar(255),
    department varchar(255),
    salary     integer,
    rank       integer
);
INSERT INTO employees (id, lastName, department, salary, rank)
VALUES (DEFAULT, 'Коновалов', 'Цех 1', 45000, 4);
INSERT INTO employees (id, lastName, department, salary, rank)
VALUES (DEFAULT, 'Сидоров', 'Цех 1', 40000, 3);
INSERT INTO employees (id, lastName, department, salary, rank)
VALUES (DEFAULT, 'Волков', 'Цех 1', 44000, 4);
INSERT INTO employees (id, lastName, department, salary, rank)
VALUES (DEFAULT, 'Стариненко', 'Цех 1', 50000, 5);

SELECT *
FROM employees;
DELETE
FROM employees;
SELECT *
FROM users;
DELETE
FROM users
WHERE id = 8;