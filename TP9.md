# TP9 EJB Premier pas #

## Énoncé ##

> Créer une couche métier utilisant des EJB stateless gérant les entités des TPs précédents.

### Solution 1 ###

> Au vu de la simplification apportée à nos DAOs par JPA, vous jugez que leur code est trop simpliste et revient à la responsabilité des EJBs à créer.

### Solution 2 ###

> Vous déléguez la responsabilité de la gestion de la persistance à vos DAO, et récupérer la gestion des transactions au niveau des EJBs à créer.

REM : préférez la solution 2!

## Environnement ##

Configuration des différents environnements. En effet, il est nécessaire de gérer les librairies contenant les APIs EJB pour compiler. Il faut aussi un environnement d'exécution des tests. Finalement, il faut packager l'application afin de la déployer dans un serveur d'application.

### Compilation ###

> Ajout de la dépendance glassfish et de son repository dans Maven :

```
 <repositories>
         ...
        <repository>
		<id>glassfish-maven-repository.dev.java.net</id>
		<name>GlassFish Maven Repository</name>
		<url>http://download.java.net/maven/glassfish</url>
	</repository>       
</repositories>
<dependencies>
	...
	<dependency>
		<groupId>org.glassfish.extras</groupId>
		<artifactId>glassfish-embedded-all</artifactId>
		<version>3.0</version>
	</dependency>
</dependencies>

```

### Un conteneur pour les tests ###

> Glassfish nous offre une API nous permettant de créer un container, il suffit de s'en servir dans nos tests.

```

    private static EJBContainer ec;
    private static Context ctx;

    @BeforeClass
    public static void initContainer() throws Exception {
        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put(EJBContainer.MODULES, new File("target/classes"));
         properties.put("org.glassfish.ejb.embedded.glassfish.installation.root",
                "./target/test-classes/glassfish");
        ec = EJBContainer.createEJBContainer(properties);
        ctx = ec.getContext();
    }

    @AfterClass
    public static void closeContainer() throws Exception {
        if (ec != null)
            ec.close();
    }

```

### Packaging ###

Il  s'agit ici d'un EJB et de son client, le packaging jar est donc suffisant. l'EJB sera reconnu par le container grâce aux annotations.
Néanmoins, la classe Main doit être connue, pour cela il faut configurer le plugin jar dans le POM:

```
<plugin>
	<groupId>org.apache.maven.plugins</groupId>
	<artifactId>maven-jar-plugin</artifactId>
	<configuration>
		<archive>
			<manifest>
				<mainClass>fr.devcoop.jee.tp9.Main</mainClass>
			</manifest>
		</archive>
	</configuration>
</plugin>
```


REM : Comme certains tests ne passent pas, il est possible de construire le jar sans passer les tests. Pour cela, il faut lancer Maven via Netbeans en évitant les tests : "Bouton droit projet 4jee-tp9>Custom>Goals" dans la fenêtre lancer le goal "install" et cocher la case "skip-tests".

Plus d'infos : http://docs.codehaus.org/display/MAVENUSER/Multi-modules+projects

### DEPRECATED Un conteneur de déploiement ###

Installation et exécution de Glassfish

  * Télécharger http://glassfish.java.net/downloads

  * Installer la configuration standard

  * Modifier la configuration des datasources dans le `path_to_glassfish3\glassfish\domains\domain1\config\domain.xml `

  * A modifier
```
    <jdbc-resource pool-name="H2Pool" jndi-name="jdbc/__default" />
```
  * A ajouter
```
    <jdbc-connection-pool is-isolation-level-guaranteed="false" name="H2Pool" 
    driver-classname="org.h2.Driver" res-type="java.sql.Driver">
      <property value="" name="Password" />
      <property value="sa" name="User" />
      <property value="jdbc:h2:tcp://localhost/~/test" name="URL" />
    </jdbc-connection-pool>

```

  * Ajouter la librairie `$Home\.m2\repository\com\h2database\h2\1.2.xxx\h2-1.2.xxx.jar`
dans `path_to_glassfish3\glassfish\domains\domain1\lib\ext`

  * Déployer l'application packagée

```
$Glassfish_home\bin\asadmin start-domain

$Glassfish_home\bin\asadmin ping-connection-pool H2Pool

$Glassfish_home\bin\asadmin deploy --force=true  \jee-tp9\target\jee-tp9-1.0-SNAPSHOT.jar

```

  * Tester avec le client à l'aide de l'Application Client Container

> En effet le client doit tourner dans un container afin que les EJB puissent y être injectés
```
$Glassfish_home\glassfish\bin\appclient -client  \jee-tp9\target\jee-tp9-1.0-SNAPSHOT.jar
```

  * Accéder à la console d'administration :http://localhost:4848. Naviguez et retrouvez l'EJB déployé faites une impression écran à rendre.

  * Plus d'information : http://glassfish.java.net/docs/3.1/quick-start-guide.pdf

# TP9 suite #

## EJB Statefull et Singleton ##

  * Ecrivez un EJB singleton proposant un service de prix (Random me suffit).

```
   @Singleton
   public class public PriceGenerator {
      public Double getPrice(String title) {
         // TODO
      }
   }
```

  * Ecrivez un EJB Statefull prenant en charge la gestion d'un panier. On peut rajouter autant de livre que nous voulons dans le panier.

La validation du panier consiste à calculer le prix (somme des prix obtenus par le singleton) et supprimer les livres provenant du panier de la base de données. Pour cela, utilisez ce Singleton dans le BookEJB pour le clacule du prix final.