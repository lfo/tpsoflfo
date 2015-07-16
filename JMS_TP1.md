# Énoncé #

Pour ce TP nous allons utiliser ActiveMQ. ActiveMQ est serveur open source de gestion de message.

  1. Pour l'installer : http://activemq.apache.org/getting-started.html
> > Pour Windows :
    * Télécharger http://activemq.apache.org/download.html
    * Dézipper
  1. Créer une file de message :
    * Lancer $ACTIVEMQ\_HOME/bin/activemq.bat (pour Windows)
    * Dans l'interface d'administration http://localhost:8161/admin créer une queue "jms-tp1".
  1. Exécuter le producer ainsi que le consumer du projet jee-jms-tp1. Que s'est il passé ?
  1. Transformer la Queue en un Topic ainsi que le projet jee-jms-tp1 en conséquence exécuter de nouveau et expliquer la différence.