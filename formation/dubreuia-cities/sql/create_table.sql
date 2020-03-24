CREATE TABLE country
(
    id       INTEGER PRIMARY KEY AUTO_INCREMENT,
    language VARCHAR(16)  NOT NULL,
    name     VARCHAR(512) NOT NULL UNIQUE
);

CREATE TABLE region
(
    id          INTEGER PRIMARY KEY AUTO_INCREMENT,
    name        VARCHAR(512) NOT NULL UNIQUE,
    country_id  INTEGER NOT NULL,
    FOREIGN KEY (country_id) REFERENCES country(id)
);

CREATE TABLE city
(
    id          INTEGER PRIMARY KEY AUTO_INCREMENT,
    name        VARCHAR(512) NOT NULL UNIQUE,
    region_id   INTEGER NOT NULL,
    FOREIGN KEY (region_id) REFERENCES region(id)
);
