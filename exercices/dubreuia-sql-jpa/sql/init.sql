SET @@global.time_zone = '+01:00';

CREATE TABLE students (
    id         INTEGER PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(128),
    last_name  VARCHAR(128) NOT NULL,
    birthdate  DATE         NOT NULL,
    note       DOUBLE
);

INSERT INTO students
VALUES (NULL, 'Donald', 'Trump', date('1946-05-31'), 0.0);

INSERT INTO students
VALUES (NULL, 'George', 'W. Bush', date('1946-08-05'), 10.0);

SELECT *
FROM students;
