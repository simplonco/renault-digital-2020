# Semaine 04 - 03/04/05 février

## Plan

- Feuille émargement
- Retour sur [semaine passé](../semaine03) (30 minutes)
- Groupe: Mob programming sur [JPA et SQL](../../exercices/dubreuia-sql-jpa) (120 minutes)
- Mercredi: mob programming sur [Java Servlet (cars)](../../exercices/dubreuia-cars) (240 minutes)

## Contenu

- Retours sur SQL
    - Utilisation de sqlite3
    - Rappel sur le `CREATE TABLE` et les types `INT`, `VARCHAR`
    - Rappel sur le `INSERT`
    - Rappel sur le `SELECT` avec `WHERE`
    - Rappel sur les contraines `PRIMARY KEY`, `UNIQUE`, `NOT NULL`
    - Rappel sur le `UPDATE`
    - Rappel sur le `DELETE`
- Utilisation de JDBC pour accéder à la base en Java
    - Récupération de la connexion `DriverManager#getConnection`
    - Fermeture de la connexion avec try-with-resources
    - Récupération du prepared statement `Connection#prepareStatement`
    - Execution du prepared statement pour select `PreparedStatement#executeQuery`
    - Execution du prepared statement pour insert ou update `PreparedStatement#executeUpdate`
    - Récupération de la prochaine row `ResultSet#next`
    - Récupération de la colonne `ResultSet#getString`
    - Utilisation du SQL avec paramètres "SELECT * FROM table WHERE col = ?"
    - Ajout des paramètres `PreparedStatement#setString`
- Utilisation de docker pour démarrer une base mysql
    - Rappels généraux sur docker et les conteneurs
    - Utilisation de Mysql
    - Exécution de docker avec `docker run`
    - Connexion au docker avec un autre docker, intellij, ou java

