-- DB: salary
CREATE TABLE users
(
    id        serial primary key,
    login     varchar(255) unique,
    password  varchar(255),
    firstName varchar(255),
    lastName  varchar(255),
    role      varchar(5) CHECK (role IN ('admin', 'user'))
);
INSERT INTO users (id, login, password, firstName, lastName, role)
VALUES (DEFAULT, 'admin', 'admin', 'Александр', 'Петров', 'admin');
INSERT INTO users (id, login, password, firstName, lastName, role)
VALUES (DEFAULT, 'user', 'user', 'Иван', 'Иванов', 'user');

-- DROP TABLE users;
-- SELECT * FROM users;

DROP TABLE employees;
CREATE TABLE employees
(
    id         serial primary key,
    lastName   varchar(255),
    department varchar(255),
    salary     integer,
    rank       integer,
    profession varchar(255)
);
INSERT INTO employees (id, lastName, department, salary, rank, profession)
VALUES (DEFAULT, 'Коновалов', 'Цех 1', 45000, 4, 'Механик');
INSERT INTO employees (id, lastName, department, salary, rank, profession)
VALUES (DEFAULT, 'Сидоров', 'Цех 2', 40000, 3, 'Электрик');
INSERT INTO employees (id, lastName, department, salary, rank, profession)
VALUES (DEFAULT, 'Волков', 'Цех 1', 44000, 4, 'Оператор ЧПУ');
INSERT INTO employees (id, lastName, department, salary, rank, profession)
VALUES (DEFAULT, 'Стариненко', 'Цех 2', 50000, 5, 'Начальникц цеха');
INSERT INTO employees (id, lastName, department, salary, rank, profession)
VALUES (DEFAULT, 'Абрамов', 'Цех 3', 50000, 1, 'Стажер');

-- SELECT * FROM employees;
SELECT *
FROM employees;