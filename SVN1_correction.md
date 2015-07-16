# Correction SVN #

  * Créer l'espace de travail

```
$>mkdir lforet
$>svn import lforet https://tpsoflfo.googlecode.com/svn/trunk/20120621/lforet -m "import initial"

Committed revision 201.

$>svn checkout https://tpsoflfo.googlecode.com/svn/trunk/20120621/lforet
Checked out revision 201.
```

  * Ajouter un fichier

```
$>cd lforet
$\lforet>edit readme.txt
$\lforet>svn add readme.txt
A         readme.txt

$\lforet>svn commit -m "ajout readme.txt"
Adding         readme.txt
Transmitting file data .
Committed revision 202.
```

```
$\lforet>edit readme.txt
$\lforet>svn status readme.txt
M       readme.txt

$\lforet>svn commit -m "modification readme.txt"
Sending        readme.txt
Transmitting file data .
Committed revision 207.
```

  * Récupérer l'historique

```
D:\tmp\lforet>svn log readme.txt
------------------------------------------------------------------------
r207 | laurent.foret@gmail.com | 2012-06-21 12:34:49 +0200 (jeu., 21 juin 2012) | 1 line

modification readme.txt
------------------------------------------------------------------------
r202 | laurent.foret@gmail.com | 2012-06-21 11:45:25 +0200 (jeu., 21 juin 2012) | 1 line

ajout readme.txt
------------------------------------------------------------------------
```

  * Analyser les différences

```
$\lforet>svn diff readme.txt -r r202:r207
Index: readme.txt
===================================================================
--- readme.txt  (revision 202)
+++ readme.txt  (revision 207)
@@ -1 +1,2 @@
 lforet
+ajout d une deuxieme ligne
```

  * Créer un tag

```
D:\tmp\lforet>svn copy https://tpsoflfo.googlecode.com/svn/trunk/20120621/lforet https://tpsoflfo.googlecode.com/svn/tags/lforet-1.0 -m "Tag de la version 1.0"

Committed revision 209.

D:\tmp\lforet>
```