# Semaine 03 - 29/30/31 janvier

## Plan

- Feuille émargement
- Retour sur [semaine passé](../semaine02) (30 minutes)
    - Git: tag, branch, merge, pull, push
    - Java: objets, List, main, jar, File, Path
- Mob programming sur [Java Servlet](../../exercices/eugenp-javax-servlets) (120 minutes)
    - Revoir le packaging jar (dépendances)
    - Revoir le packaging war (déploiement tomcat)
- Mercredi: mob programming sur [Java Servlet (cars)](../../exercices/dubreuia-cars) (240 minutes)
    - Voir [contenu](#contenu)

## Contenu

- Théorie
    - Model / View / Controller (MVC)
    - Point d'entrée: controlleur (sur un URL, par example "renault.com/path")
    - Le controlleur récupère des information sur le modèle
    - Le controlleur forward sur la vue en passant les informations
    - Définition d'un URL : domaine.com/path?param=valeur
    - Définition du header Content-Type (text/html, application/json)
    - Définition du format war (web application) et contenu
    - Usage de tomcat (serveur application pour war)
    - Revue du protocole HTTP (headers, body)
    - Revue des méthodes HTTP (GET, POST, etc.)
    - Revue des status code HTTP (200, 400, etc.)
- Java Servlet (partie Java EE)
    - Utilisation de l'annotation pour définir un servlet: `@WebServlet`
    - Définiion d'un chemin ("path", "route") qui correspond à une servlet: `@WebServlet(value = "/")`
    - Récupération de paramètres "query": `request.getParameter`
    - Récupération de header (ex: Content-Type): `request.getHeader`
    - Ajout d'attributs sur la requête avec: `request.setAttribute`
    - Redirection vers vue (jsp): `RequestDispatcher#forward`
- Java Servlet (partie JavaServerPages - JSP)
    - Utilisation de variable Java: `${variable}`
    - Utilisation de scriptlet Java: `<% java %>>`
    - Utilisation de expression Java: `<%= java %>>`
- JavaScript (ajax)
    - Utilsation de l'API `fetch`
