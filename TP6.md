# TP6 #

Instruction concernant le TP6

Dans les entités,
  * créer :
    * la classe abstraite `Media`
    * la classe `Book` qui hérite de `Media`
    * la classe `DVD` qui hérite de `Media`, et a un nouvel attribut `duration`
  * modifier :
    * la classe `Person` qui possède des `Media` plutôt que des `Book`

Le `BookDAO` devient `MediaDAO` et ajouter la méthode suivante :

```
DVD createDVD(String title, int duration, Person owner);
```

Valider le DAO par :
  * Un test créant deux DVDs et trois livres.
  * Validant la liste des médias possédés par chaque personne.
  * Validant pour chaque
    * livre la liste de ses auteurs
    * DVD sa durée.