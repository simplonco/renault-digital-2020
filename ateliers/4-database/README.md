# Workshop 4 : Ajouter une base de donnée

## Créer une base de donnée

- Installer Postgresql : https://www.postgresql.org/download/
- Lors de l'installation, choisir un mot de passe pour l'utilisateur postgres
- Créer la base de donnée pour votre application (ex. "synthesizrs")
    - Dans un terminal : `psql -U postgres -W postgres` (si ça ne fonctionne pas, `sudo -u postgres psql postgres`)
    - Une fois dans postgres : `CREATE DATABASE synthesizrs;`

## Configurez votre application

### Spring Boot

- Dans "server-spring/src/main/resources/application.properties", ajouter (changer les valeurs pour votre projet) :
    ```properties
    spring.datasource.name=database
    spring.datasource.url=jdbc:postgresql://localhost:5432/synthesizrs
    spring.datasource.username=postgres
    spring.datasource.password=password
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQL95Dialect
    spring.jpa.properties.hibernate.hbm2ddl.auto=create-drop
    spring.jpa.generate-ddl=true
    logging.level.org.hibernate.SQL=DEBUG
    logging.level.org.hibernate.type.descriptor.sql.BasicBinder=TRACE
    ```
- Ouvrir un terminal dans "server-spring" : `.gradlew build`
    - Le test de base de donnée devrait passer
- Ouvrir un terminal dans "server-spring" : `.gradlew bootRun`
    - TODO

### Node.js

TODO
