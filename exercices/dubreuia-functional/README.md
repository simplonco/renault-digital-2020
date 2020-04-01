# Programmation fonctionnelle (Functional Programming)

## Références

[Functional Programming - Introduction](https://www.tutorialspoint.com/functional_programming/functional_programming_introduction.htm)

"Functional programming languages are specially designed to handle symbolic computation and list processing applications. Functional programming is based on mathematical functions. Some of the popular functional programming languages include: Lisp, Python, Erlang, Haskell, Clojure, etc."

| Functional Programming | OOP |
| --- | --- |
| Uses Immutable data | Uses Mutable data |
| Follows Declarative Programming Model | Follows Imperative Programming Model |
| Focus is on: "What you are doing" | Focus is on "How you are doing" |
| Supports Parallel Programming | Not suitable for Parallel Programming |
| Its functions have no-side effects | Its methods can produce serious side effects |
| Flow Control is done using function calls & function calls with recursion | Flow control is done using loops and conditional statements |
| It uses "Recursion" concept to iterate Collection Data | It uses "Loop" concept to iterate Collection Data |
| Execution order of statements is not so important | Execution order of statements is very important |
| Supports both "Abstraction over Data" and "Abstraction over Behavior" | Supports only "Abstraction over Data" |

## Exercices introduction

Le code écrit en impératif vous est donné, vous devez le réécrire en fonctionnel. Nous n'avez PAS le droit aux boucles (`for`, `while`, etc.), ni aux structures de condition (`if`, `switch`, etc.). Chaque exercice vous suggère une function pour y arriver et présente sa documentation.

Les concepts entre Java et JavaScript sont très similaires. Avant de commencer lisez sur les lambdas (Java) et les arrow function (JavaScript) :

- https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html
- https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Functions/Arrow_functions

La liste des exercices à faire :

- **Java :** [Exercice0.java](./src/main/java/Exercice0.java)  |  **JavaScript :** [Exercice0.html](./src/main/javascript/Exercice0.html) 
- **Java :** [Exercice1.java](./src/main/java/Exercice1.java)  |  **JavaScript :** [Exercice1.html](./src/main/javascript/Exercice1.html) 
- **Java :** [Exercice2.java](./src/main/java/Exercice2.java)  |  **JavaScript :** [Exercice2.html](./src/main/javascript/Exercice2.html) 
- **Java :** [Exercice3.java](./src/main/java/Exercice3.java)  |  **JavaScript :** [Exercice3.html](./src/main/javascript/Exercice3.html) 
- **Java :** [Exercice4.java](./src/main/java/Exercice4.java)  |  (pas en JavaScript)
- **Java :** [Exercice5.java](./src/main/java/Exercice5.java)  |  (pas en JavaScript)
- **Java :** [Exercice6.java](./src/main/java/Exercice6.java)  |  **JavaScript :** [Exercice6.html](./src/main/javascript/Exercice6.html) 
- **Java :** [Exercice7.java](./src/main/java/Exercice7.java)  |  **JavaScript :** [Exercice7.html](./src/main/javascript/Exercice7.html) 
- **Java :** [Exercice8.java](./src/main/java/Exercice8.java)  |  **JavaScript :** [Exercice8.html](./src/main/javascript/Exercice8.html) 

## Application projet

Nous allons appliquer ces notions à l'application "Cities", en transformant le code écrit grâce au Stream API :

- Application [Cities](../../formation/dubreuia-cities) :
    - Supprimer la boucle : `com.renault.controllers.CityController.getCitiesForRegion`
    - Supprimer la boucle : `com.renault.controllers.CountryController.getCountries`
    - Supprimer la boucle : `com.renault.controllers.LanguageController.getLanguages`
    - Supprimer la boucle : `com.renault.controllers.RegionController.getRegionsForCountry`
    - Supprimer la boucle : `com.renault.services.CityServiceImpl.deleteCity`
    - Supprimer la condition : `com.renault.services.RegionServiceImpl.saveCountryRegion`
    - Supprimer la condition : `com.renault.services.RegionServiceImpl.saveCountryRegionWithTransaction`
    - Supprimer la boucle : `com.renault.services.UserServiceImpl.unfollowCityAndSave`
