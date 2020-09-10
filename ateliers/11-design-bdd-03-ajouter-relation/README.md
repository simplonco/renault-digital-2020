# Workshop 11 - Design BDD 03 - Ajouter une relation

Le but de ce workshop c'est de faire le design du frontend pour une relation many-to-one. Rappel du workshop précédent, [Workshop 10 - Design BDD 02 - Filtrer par utilisateur](10-design-bdd-02-filtrer-par-utilisateur) :
 
- Plusieurs synthetiseurs font partis d'une même marque (ManyToOne)
- Une marque a plusieurs synthétiseurs (OneToMany)

![Synthesizrs - Entity relation diagram](./synthesizrs_entity_relation_diagram.svg)

Les cardinalités sont importantes, elle définissent si la relation est optionnelle :

- Côté "many" :
    - **"0..n"** : La relation est optionnelle (exemple : une marque peut exister mais n'avoir aucun modèle)
    - **"1..n"** : La relation est obligatoire (exemple : une commande doit avoir au moins 1 item)
- Côté "one" :
    - **"0"** : La relation est optionnelle (exemple : un utilisateur peut avoir une adresse)
    - **"1"** : La relation est obligatoire (exemple : un synthé doit avoir une marque)

## Page front 1 : Création de la marque

La marque doit être créée avant (le synthétiseur a un lien vers la marque).

TODO

## Page front 2 : Création du synthé

Le synthé référence la marque, il doit avoir une liste de sélection de la marque.

TODO
