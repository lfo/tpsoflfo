#Mise en oeuvre du pattern DAO

# Énoncé TP2 DAO #

Ecrire un DAO (interface + implémentation) utilisant JDBC et fournissant les services suivants :
  * Liste des Person
  * Liste des Person dont le lastName commence par prefix
  * Ajout d’une Person
  * Modifier le lastName d’une Person
  * Supprimer une Person
![http://tpsoflfo.googlecode.com/files/TP2-ClassDiag.png](http://tpsoflfo.googlecode.com/files/TP2-ClassDiag.png)
# Instructions #

  * Créer l'interface fr.devcoop.jee.tp2.PersonDAO qui doit proposer les méthodes permettant de rendre les services demandés.

> Exemple :
```
   public List<Person> getPersons();
```

  * Créer l'objet métier (javabean) fr.devcoop.jee.tp2.Person
    * Surcharger sa méthode toString()
```
   public String toString() {
     return firstName + “ “ + lastName;
   }
```

  * Créer la classe fr.devcoop.tp2.PersonDAOImpl : cette classe implémente l'interface PersonDAO

  * Créer la table PERSON dans H2 en utilisant la web console.

> On pourra utiliser une colonne identity pour les identifiants uniques, Cf. http://h2database.com/html/datatypes.html#identity_type

  * Utiliser JDBC pour implémenter chacune des méthodes

> L'initialisation de la connexion pourra se faire dans le constructeur. Pour les méthodes de lecture, utiliser le ResultSet et créer un objet Person à chaque itération.

  * Utiliser cette implémentation dans la classe Client pour la tester.

## Pour aller plus loin ##

  * Utiliser un fichier properties pour initialiser la connexion.
  * Ajouter une gestion des exceptions.
  * Transformer la classe Main en une classe de test utilisant JUnit 4. Utiliser les assertions.
Ressources :
    * http://junit.sourceforge.net/doc/cookbook/cookbook.htm
    * http://netbeans.org/kb/docs/java/junit-intro.html