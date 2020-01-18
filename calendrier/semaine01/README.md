# Semaine 1 - 13/14/15 janvier

## Plan

- Revue de l'auto-évaluation (5 minutes)
- Revue du questionnaire (45 minutes)
- Kata en mob programming (90 minutes)
    1. Créer un ticket dans [Issues](https://github.com/simplonco/renault-digital-2020/issues) pour l'exercice choisi
    2. Créer votre branche de développement (`git checkout -b issue-12345-avec-description`)
    3. Faire l'exercice idéalement en mob programming
    4. Faire une [Pull Request](https://github.com/simplonco/renault-digital-2020/pulls) sur la branche de votre groupe ("master-groupe-1", "master-groupe-2", etc.)
    5. Faire la code review de la branche
    6. Merge de la branche sur la branche du groupe, fermer le ticket
- Feedback

## Contenu

- Récapitulatif du "Workflow d'un ticket" pour un dévelopeur
    - Priorisation du ticket (selon méthode Agile)
    - Récupération du ticket dans JIRA (et sur le tableau)
    - Relecture et vérification du ticket
        - Vérification du titre et description
        - Vérification du domaine métier et équipe
        - Vérification des "Definition Of Done (DOD)", à minima
            - Code review
            - Tests verts
            - Couverture des tests
            - Qualité du code
            - Déploiement OK
    - Création de la branche avec `git pull` et `git branch`
    - Écriture du code en TDD
    - Lorsque terminé `git push` et création Pull Request
    - Vérification de l'usine logicielle, Intégration Continue (IC / CI)
    - Vérification de la code review du TL
    - Validation par PO / BA / TL / archi
    - Mise à jour de JIRA et `git merge`
    - Déploiement de la feature en prod
- JUnit
    - Framework d'exécution de test de d'assertion
    - Équivalent JavaScript: Jest, Jasmin, Mocha, etc.
    - Utilisation d'annotations: `@Before` / `@Test`
    - Utilisation des assertions: `Assert.assertEquals()`
- Typage statique en java
    - Le type de la variable est fixée à l'instanciation
    - Different du typage dynamique JavaScript: le type de la variable peut changer
- Exceptions
    - Utilisation du `try / catch`: permet d'attraper une exception
    - Les exceptions "checked" doivent avoir un try / catch
    - Les exceptions "runtime" étendent `RuntimeException`
- Code Review
    - On relit ligne par ligne, charactère par char
    - On regarde: code style, algorithmie (est-ce compréhensible ?), tests
- Gradle / Maven
    - Gestion de la configuration du projet
    - Gestion des dépendances
    - Gestion de la compilation et l'exécution
    - Exécution de tâche de build
- Boucles
    - for index: `for (var i = 0; i < elements.size(); i++) { ... }`
    - foreach: `for (var element : elements) { ... }`
    - while: `while (condition) { ... }`
- Types primitif
    - `int` / `long` / `double` / `float` / `boolean` / `char`
    - Avec types objets associés (`Integer`, `Long`, etc.)
    - Le boxing change le type automatiquement: `int` -> `Integer`
- Classes
    - Rappel sur hiérarchie classe simple
    - Rappel sur interfaces (`implements`)
    - Rappel sur la surcharge (`extends`)
    - Introduction au polymorphisme

## Travail en groupe

- Question sur debug vs console.log (!)
- Question sur className attribut
- Question sur hoverin / hoverout 2 functions
- Question sur function(event) (!)
- Question sur title attribut (affectation variable) (!)
- Question sur retour implicite undefined (!)
- Question sur import projet eclipse
- Question sur async / await (callbacks)
- Question sur lego brick / refacto
- Question sur bash
- Question sur ps et ctrl-z
- Question sur parseInt

## Kahoot!

Questions (11) sur le contenu ici-haut (https://create.kahoot.it/details/4d903968-6370-4a54-9889-150de16e58ac).

- git, et autres VCS (x)
- syntaxes iteration java (x)
- if else java ( )
- oop ( )
- interface ( )
- fleur extends plante (x)
- types fleur plante affectation variable ( )
- typage statique (x)
- try catch checked exception (x)
- junit, jest, jasmine, etc. (x)
- tdd ( )
- sql ( )
- maven gradle, npm, grunt, babel, webpack (x)
- etapes prise ticket ( )
- code review (x)
- equals vs == (x)
- assert junit (x)
- @Test et @Disabled (x)

