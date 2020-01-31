# SQL et JPA

## SQL

Installer [sqlite3](https://sqlite.org/download.html) (`sudo apt-get install sqlite3 libsqlite3-dev`).

- [https://www.sqlite.org/datatype3.html](https://www.sqlite.org/datatype3.html)
- `.databases`
- `.tables regex`
- `.schema regex`

### Création table, contenu et recherche

- Créer une nouvelle table `CREATE TABLE students (id int, first_name varchar(128), last_name varchar(128));`
- Ajouter du contenu
    - `INSERT INTO students VALUES (1, "Alexandre", "DuBreuil");`
    - `INSERT INTO students VALUES (1, "Alexandre", "DuBreuil");`
    - `INSERT INTO students VALUES (2, NULL, "DuBreuil");`
- Rechercher du contenu
    - `SELECT * FROM students;`
    - `SELECT * FROM students WHERE id = 1;`
    - `SELECT * FROM students WHERE id = 2;`
    - `SELECT * FROM students WHERE first_name IS NULL;`
- Compter le nombre d'éléments `SELECT count(*) FROM students;`
- Supprimer une table `DROP TABLE students`

### Ajout de contraintes

- Créer table avec contraintes `CREATE TABLE students (id INT PRIMARY KEY, first_name VARCHAR(128), last_name VARCHAR(128) NOT NULL);`
- Ajouter du contenu
    - `INSERT INTO students VALUES (1, "Alexandre", "DuBreuil");`
    - `INSERT INTO students VALUES (1, "Alexandre", "DuBreuil");`
    - `Error: UNIQUE constraint failed: students.id`
    - `INSERT INTO students VALUES (2, "Alexandre", NULL);`
    - `Error: NOT NULL constraint failed: students.last_name`
- Supprimer une table `DROP TABLE students`

### Types de donnes et modification

- Créer table `CREATE TABLE students (id INT PRIMARY KEY, first_name VARCHAR(128), last_name VARCHAR(128) NOT NULL, birthdate DATE NOT NULL, note DOUBLE);`
- Ajouter du contenu
    - `INSERT INTO students VALUES (1, "Alexandre", "DuBreuil", date("1987-11-32"), NULL);`
- Modifier du contenu
    - `UPDATE students SET note = 16.8 WHERE id = 1;`
- Supprimer du contenu
    - `DELETE FROM students WHERE id = 1;`

### Connecteur

https://www.sqlitetutorial.net/sqlite-java/sqlite-jdbc-driver/

## JPA

## Outline

- first on sql (base)
    - https://sqlite.org/download.html
    - https://www.sqlitetutorial.net/sqlite-java/sqlite-jdbc-driver/
- root tutorial: https://github.com/RameshMF/JPA-Tutorial
    - first example: https://www.javaguides.net/2018/12/jpa-architecture.html
    - connector: https://www.javaguides.net/2018/12/jpa-obtaining-jpa-database-connection.html
    - crud: https://www.javaguides.net/2018/12/different-ways-to-retrieve-jpa-entity-objects-from-database.html
    - crud: https://www.javaguides.net/2018/12/different-ways-to-update-jpa-entity-objects-into-database.html
    - crud: https://www.javaguides.net/2018/12/jpa-crud-example.html

## Datatypes
