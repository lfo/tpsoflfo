#Prerequis et outils utilisés durant les TPs

# Prerequis #

## Java ##

http://www.oracle.com/technetwork/java/javase/downloads/index.html

  * JRE (Java Runtime Environment)?
```
%> java –version
java version "1.8.0"
```
  * JDK (Java Development Kit)?
```
%> javac –version
javac 1.8.0
```

En cas de problème :

  * Vérifier la variable d’environnement `JAVA_HOME`. Elle doit pointer vers le répertoire d’installation du JDK
  * Vérifier la variable d’environnement PATH Elle doit contenir %JAVA\_HOME%\bin

## Netbeans ##

  * http://netbeans.org
  * IDE open-source de Oracle
  * Outil de référence pour les développements JSE et JEE.

  * Installation :
    * Téléchargement
    * Lancer le programme d'installation.
    * Suivre les instructions

Pour aller plus vite : http://www.oracle.com/technetwork/java/javase/downloads/jdk-netbeans-jsp-142931.html


# Obtenir les sources des TPs #

  * Aller dans Netbeans>Team>Subversion>Checkout :

  * Saisir l'URL du repository : https://tpsoflfo.googlecode.com/svn/branches/esarc-jse-2014

  * Choisir Open Project... et sélectionner "DISTRIB" (projet qui contiendra tous les modules des TPs)

  * Depuis le projet DISTRIB, ouvrir le module "distrib-prerequis"

# Obtenir les Corrections des TPs #

> À chaque fin de TP une correction est donnée, pour l'obtenir il vous suffit de faire un clic droit sur le projet parent DISTRIB et sélectionner "Subversion>Update" une fois la correction posée. Un nouveau module dans DISTRIB apparaitra.


