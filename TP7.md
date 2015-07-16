# TP7 : Instruction #

  * Affecter des opérations (méthodes de l'`EntityManager`) à chacune des flèches du pseudo diagramme d'état :

> ![![](http://tpsoflfo.googlecode.com/files/entitylifecycle.png)](http://tpsoflfo.googlecode.com/files/entitylifecycle.png)

> Il s'agit ici de faire correspondre un changement d'état (ex : managed --> detached) à une méthode de l'`EntityManager` (ex em.detach())

  * Améliorer la gestion des entités du TP 5 précédent. En effet, notre nouvelle maîtrise de l'`EntityManager` nous permet d'améliorer le code de nos DAOs. Par exemple :

```
    @Override
    public List<Person> getAuthors(Book book) {
        Query query = entityManager.createQuery("select p from Person p where p.writtenBooks = :book");
        query.setParameter("book", book);
        List<Person> persons = query.getResultList();
        return persons;
    } 
```

> Peut être remplacé par :

```
    @Override
    public List<Person> getAuthors(Book book) {
        Book managedBook = entityManager.find(Book.class , book.getId());        
        return managedBook.getAuthors();
    }
```

> En quoi, est-ce que cela peut être une meilleure solution ?

> Finalement, où pouvons nous encore apporter des modifications ?


  * Introduire une gestion de cache et la valider par un test unitaire. C'est à dire, faire en sorte que les entités soient gérés dans un cache, puis écrire un test permettant de validé qu'une instance d'une entité est dans ce cache.

