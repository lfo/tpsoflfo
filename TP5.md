#TP5 "Mapper" des relations avec JPA

# Énoncé #

Gérer les livres écrits et possédés par une
personne :
  * Une personne possède 0 à n livres
  * Une personne écrit 0 à n livres
  * Un livre est écrit par 1 à n auteur
  * Un livre est possédé par 1 personne


# Instructions #

  * Ecrire l'entité Book avec la propriété title, et les attributs correspondants aux associations.
  * Ecrire une interface BookDAO avec les méthodes suivantes :
```
   Book persistBook(Book book);
   Book updateBook(Book book);
   List<Book> findBookByTitle(String titlePrefix);
   Person getOwner(Book book);
   List<Person> getAuthors(Book book);
```

  * Ecrire un test validant le fonctionnement du `BookDAO`
  * Ecrire l'implémentation de ce DAO.

## Scénario de test ##

Les tests valident le scénario suivant :
  1. Pierre Dupont et Paul Durand sont co-auteurs du livre "La foire aux asticots".
  1. Jacques Smith Possède les livres :
    * "La foire aux asticots"
    * "La Pelouse"
    * "Puisque les oiseaux meurent"
  1. Pierre Dupont est aussi l'écrivain de :
    * "Le Monte-charge"
    * "L'horrible Monsieur Smith"