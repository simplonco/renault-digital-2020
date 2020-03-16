# Angular

- `npm install -g @angular/cli@latest`
- `ng new people-front` (see dubreuia-spring-web TODO README)
- `cd people-front`
- `npm start` go to http://localhost:4200/ ou `ng serve`
- `ng generate class person`
- `ng generate service person`
- `ng generate component person-list`

## Exercice 2020-03-15

Pour chaque personne, ajouter une ville, et un bouton qui permet d'afficher la météo pour cette ville. La météo est
un composant à part, qui utilise les observables pour être notifié du changement de ville.

- Modifier le backend [dubreuia-spring-web](../../exercices/dubreuia-spring-web) pour ajouter un GET météo
    - Ajouter la ville à la personne
    - Le GET prend la ville et retourne un JSON avec les informations météo
    - Utliser le WeatherService qui est déjà écrit
- Ajouter le composant "weather" à l'application angular
    - Ajouter le nouveau composant au composant racine
    - Ajouter un service pour le nouveau composant météo
    - Le service météo doit utiliser un observable (PAS fetch) pour retourner le résultat
- Lier le composant "person list" avec le composant météo
    - Ajouter une service "data" qui contient un observable
    - Sur l'observable, faire un "subscribe" dans le composant météo
    - Sur l'observer, faire un "next" dans le composant "person list" lorsque le bouton est click
