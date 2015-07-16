#SVN

# Pré-requis #

  * client SVN collabnet installé
  * Droit d’écriture sur un repository #REPOS\_SVN#


# Énoncé #

Travailler et "historiser" dans son coin :

  * Créer un répertoire localement correspondant à votre login, c'est à dire ayant pour nom la première lettre du prénom et le nom complet accolé en minuscule.

> Exemple : "Laurent Forêt" devient "lforet".

  * Importer (`svn import`) dans `#REPOS_SVN#/login` ce répertoire.
  * Récupérer (`svn checkout`) du dépot ce répertoire permettant par la même de récupérer les metadata `.svn`.

  * Ajouter (`svn add`) un fichier `readme.txt` à ce répertoire puis propager (svn commit) le dans le repository SVN.


  * Modifier ce fichier et vérifier le status (`svn status`)
  * Propager les modifications (`svn commit`)dans le repository SVN.

  * Vérifier l'historique du fichier (`svn log`).
  * Vérifier le différentiel entre les deux révisions (svn diff).

  * Créer un tag dans #REPOS\_SVN#/tags (`svn copy`) correspondant au nom du répertoire suffixé par un numéro de version. Exemple : "lforet-1.0"

Travailler avec votre voisin :

  * Récupérer (svn checkout) localement le travail de votre voisin de droite.
  * Modifier son fichier `readme.txt` et propager (svn commit) le dans le repository SVN.
  * Attendre et Récupérer (svn update) les modifications de votre voisin de gauche. Gérer les éventuels conflits.