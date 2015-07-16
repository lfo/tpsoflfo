#Implémenter un DAO avec JPA

# Énoncé #

Implémenter le DAO du TP sur JDBC avec JPA.


# Instructions #

  * Ajouter/Vérifier que les dépendances maven suivantes soient présentes dans le projet :
    * org.eclipse.persistence:javax.persistence
    * org.eclipse.persistence:eclipselink
> > Rem : Les versions de ces dépendances ont été définies dans le POM parent.

  * Créer le persistence unit dans `src/main/resources/META-INF` (http://www.h2database.com/html/tutorial.html#using_eclipselink)

  * Modifier la classe Person pour lui ajouter les bonnes annotations.

  * Réimplémenter le DAO utilisant un `EntityManager`.

  * Modifier/Créer la classe de test. L'`EntityManagerFactory` et l'`EntityManager` seront créés avant l'exécution de la classe de tests (`@BeforeClass`)


## Pour aller plus loin ##

  * Créer une entité adresse (numero, rue, codePostal, ville)
  * Permettre l'ajout d'adresses à une personne
  * Lister dans la console les adresses d'une personne.