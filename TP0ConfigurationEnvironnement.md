#Configuration de l'environnement des TPs

# Introduction #

> Pour l'ensemble des TPs nous allons utiliser tout d'abord un kit de développement Java, (JDK), mais aussi un environnement de développement intégré (IDE), et un outil de construction tel que Maven. Finalement, pour gérer l'ensemble de nos données nous utiliserons une base de données H2.

# Installation du JDK #

  * Télécharger le JDK :  http://www.oracle.com/technetwork/java/javase/downloads/index.html
  * Suivre les instructions d'installation.
  * Vérifier l'environnement d'exécution (JRE) :
```
$ java -version
java version "1.7.0_01"
Java(TM) SE Runtime Environment (build 1.7.0_01-b08)
Java HotSpot(TM) 64-Bit Server VM (build 21.1-b02, mixed mode)
```
  * Vérifier l'environnement de compilation (JDK) :
```
$ javac -version
javac 1.7.0_01
```
  * En cas de problème
    * Vérifier la variable d’environnement `JAVA_HOME`.
> > > Elle doit pointer vers le répertoire d’installation du JDK
    * Vérifier la variable d’environnement `PATH`
> > > Elle doit contenir %JAVA\_HOME%\bin

# Installation de Netbeans #

Netbeans est un IDE open-source d'Oracle. C'est l'outil de référence pour les développements JSE et JEE.

  * Télécharger la version JEE : http://netbeans.org/downloads
  * Suivre les instructions d'installation.

## Raccourcis claviers ##


> Voici quelques raccourcis claviers à connaître :
  * Auto compléter : `<ctl> + <spc>`
  * Fixer les imports : `<shft> + <ctl> + i`
  * Reformater : `<alt> + <shft> + f`
  * Insérer du code : `<alt> + <ins>`
  * Exécuter une classe : `<shft> + <F6>`
  * Exécuter un test : `<ctl> + <F6>`


# Installation de Maven #

> Maven est un outil de gestion de projet il est accessible ici : http://maven.apache.org/

> Nous utiliserons l'installation embedded de Netbeans de Maven. Il n'y a donc rien de particulier à faire.

Une petite présentation de Maven est accessible ici :
https://docs.google.com/present/edit?id=0AXzSbwztW7gyZGN2ODdyMmRfNjBkcDdxdGtkNg

# Installation de H2 #

H2 est un SGBDR Open-source disponible ici : http://h2database.com

Pour son installation, le plus simple est de déclarer la dépendance dans un projet Maven.
```
...
<dependency>
   <groupId>com.h2database</groupId>
   <artifactId>h2</artifactId>
   <version>1.3.163</version>
</dependency>
...
```

> Puis à la première construction du projet la dépendance sera résolue

Exécution :

```
java -jar %HOMEPATH%\.m2\repository\com\h2database\h2\1.3.163\h2-1.3.163.jar
```

## Récupération des sources ##

Dans Netbeans menu Team>Subversion>Checkout... :

> - https://tpsoflfo.googlecode.com/svn/branches/esarc-jee-2013