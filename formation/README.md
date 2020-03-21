# Formation

### Formation back-end (Alex)

- spring web
    - context web : https://www.baeldung.com/spring-web-contexts
- hibernate / jpa
    - TODO add @enumerated
    - @NotNull vs @Column(nullable) : https://www.baeldung.com/hibernate-notnull-vs-nullable
    - TODO spring.jpa.hibernate.ddl-auto=create-drop
    - persistance context : https://www.baeldung.com/jpa-hibernate-persistence-context
        - TODO entity manager : root manager
        - TODO entity manager : isDirty
        - TODO transaction scope vs extended scope
        - TODO transaction scope : all component share same ctx
        - TODO make example on that : https://github.com/eugenp/tutorials/tree/master/persistence-modules/hibernate5-2
        - TODO session factory / save / refresh / flush / contains / dirty
        - TODO refresh : reread, usefull for a clear
    - unidirectionnal mapping : https://docs.oracle.com/cd/E19798-01/821-1841/bnbqk/index.html
    - bidirectionnal mapping : https://docs.oracle.com/cd/E19798-01/821-1841/bnbqj/index.html
    - one-to-one : https://www.baeldung.com/jpa-one-to-one
        - owning side : object, referencing side : object
        - @JoinColumn : owning side only
        - join table can be used
    - one-to-many : https://www.baeldung.com/hibernate-one-to-many
        - owning side : list, referencing side : object
        - owning side on the many side with mappedBy
        - owning side on the one side with @JoinColumn
        - owning side : https://www.baeldung.com/jpa-joincolumn-vs-mappedby
        - lazy eager : https://www.baeldung.com/hibernate-lazy-eager-loading
        - TODO use transactions
    - many-to-many : https://www.baeldung.com/jpa-many-to-many
        - also : https://www.baeldung.com/hibernate-many-to-many
        - owning side : list, referencing side : list
        - join table with an attribute
            - https://www.baeldung.com/jpa-many-to-many#many-to-many-using-a-composite-key
            - https://www.baeldung.com/jpa-many-to-many#many-to-many-with-a-new-entity
            - new entity way simpler
        - step 1 : fave city, step 2 : fave city with rating
    - fetchmode : https://www.baeldung.com/hibernate-fetchmode
        - TODO select vs batch size
        - TODO join fetch (eager only)
        - https://www.baeldung.com/hibernate-fetchmode#fetchmode-vs-fetchtype
    - cascading : https://www.baeldung.com/jpa-cascade-types
        - TODO

### Formation front-end (Sami)

- [Formation module es3 5](https://github.com/VirtuoWorks/formation-module-es3-5)
- [Formation module es2018 typescript](https://github.com/VirtuoWorks/formation-module-es2018-typescript)
- [TP systemes unix](https://github.com/VirtuoWorks/tp-systemes-unix)

### Formation back-end (Frank)

- [VAT - Implémenter un calcul sans TVA et arrondir un double (frank)](./exercices/frank-vat)
- [Lego - Imprimer une brique de Lego dans la console (frank)](./exercices/frank-lego)
- [Cowboy - Duel entre Lucky LUKE et Joe DALTON (frank)](./exercices/frank-cowboy)
- [Frank-readresolve / people](https://github.com/Frank-readresolve/people/)
