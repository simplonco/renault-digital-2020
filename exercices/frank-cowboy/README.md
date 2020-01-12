# Cowboy - Duel entre Lucky LUKE et Joe DALTON (frank)

- Taille t-shirt: L

## Objectifs

Lire un code (à trous) existant, quelques concepts fondamentaux de l’orienté objet. Implémenter un algorithme. Tout est dans la Javadoc des classes fournies (3) 😊 En récupérant les classes, faire attention aux noms de package. Ne rien modifier au code existant y compris les constructeurs, signatures et types de retour etc., seules les méthodes avec le commentaire `// To be implemented` doivent voir leur implémentation évoluer (le corps de la méthode uniquement). Exemples de sortie console, avec la même implémentation mais propriétés différentes pour chaque cowboy :

Before shooting:

```
{name=Lucky LUKE, energy=5, weapon={name=Colt 5, bullets=5, damages=2}, dead=false}
{name=Joe DALTON, energy=5, weapon={name=Colt 10, bullets=10, damages=1}, dead=false}
```

After shooting:

```
{name=Lucky LUKE, energy=4, weapon={name=Colt 5, bullets=2, damages=2}, dead=false}
{name=Joe DALTON, energy=0, weapon={name=Colt 10, bullets=9, damages=1}, dead=true}
```

Before shooting:

```
{name=Lucky LUKE, energy=7, weapon={name=Colt 5, bullets=5, damages=2}, dead=false}
{name=Joe DALTON, energy=8, weapon={name=Colt 7, bullets=7, damages=1}, dead=false}
```

After shooting:

```
{name=Lucky LUKE, energy=0, weapon={name=Colt 5, bullets=2, damages=2}, dead=true}
{name=Joe DALTON, energy=2, weapon={name=Colt 7, bullets=0, damages=1}, dead=false}
```
