#Premier programme JDBC

# Enoncé TP1 JDBC #

Ecrire un programme permettant de lister les noms et prénoms des personnes contenues dans une table PERSON

# Instructions #

  * Créer un projet Maven avec Netbeans, ajouter la dépendance h2 :
```
<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
    <version>1.2.143</version>
</dependency>
```
  * Dans H2 en utilisant la console web
```
java -jar %HOMEPATH%\.m2\repository\com\h2database\h2\1.3.163\h2-1.3.163.jar
```
    * Créer la table PERSON(name, firstname)
    * Y insérer quelques lignes

  * Créer une classe fr.devcoop.jee.tp1.PersonApp
  * Ajouter une méthode main. Dans cette méthode Main :

  * Charger le driver JDBC de H2
  * Obtenir une Connection
  * Créer un Statement
  * Requêter, parcourir le résultat et afficher les noms et prénoms dans la console

  * Tester en exécutant la classe ‏

## Pour aller plus loin ##

  * Gérer les exceptions
  * Obtenir les informations de connexion (classe du driver, URL jdbc, ...) à partir d’un fichier de propriétés (cf. java.util.Properties)‏
  * Classer les personnes par nom ou par prénom en fonction d’un argument fourni au programme (orderby)
  * Récupérer les informations de la base (ResultSetMetadata)