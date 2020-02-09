# Spring boot - Data

## Utilisation de JPA dans Spring

Référence : [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)

- Repository
    - Ajouter l'annotation `@Repository` à la classe `StudentRepository`
    - La classe doit étendre `JpaRepository<Student, Integer>`
- Application
    - Ajouter `@SpringBootApplication` sur la classe Application
    - Ajouter une méthode `main` contenant : `SpringApplication.run(Application.class, args);`
    - Ajouter la variable d'instance : `@Autowired StudentRepository repository;`
    - Ajouter une méthode avec la signature suivante : `@Bean public CommandLineRunner commandLineRunner() { }`
- SQL
    - Supprimer tous les éléments de la table
    - Ajouter Barack, Bush, etc.
    - Sélectionner tous les éléments de la table
    - Sélectionner les éléments avec le nom de famille "Obama"
