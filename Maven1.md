# Pre-requis #

  * Un JDK installé : http://www.oracle.com/technetwork/java/javase/downloads/index.html

  * Maven installé : http://maven.apache.org/download.html

  * Vérification de l'installation, `mvn -version` depuis une ligne de commande.

```
C:\Users\lforet>mvn -version
Apache Maven 3.0.4 (r1232337; 2012-01-17 09:44:56+0100)
Maven home: D:\software\apache-maven-3.0.4
Java version: 1.6.0_30, vendor: Sun Microsystems Inc.
Java home: C:\Program Files\Java\jdk1.6.0_30\jre
Default locale: fr_FR, platform encoding: Cp1252
OS name: "windows 7", version: "6.1", arch: "x86", family: "windows"
```

AGFA settings à utiliser :

```
<?xml version="1.0" encoding="UTF-8"?>

<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0" 
	  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0 
		http://maven.apache.org/xsd/settings-1.0.0.xsd">
	<proxies>
	    <proxy>
	      <host>proxy.ict</host>
	      <port>8080</port>
	    </proxy>
	</proxies>
        
        </settings>
        
```

# Exercice #

## Une simple application ##

  * Créer un projet Maven java à l'aide de l'archetype `maven-archetype-quickstart` :
    * groupe : fr.devcoop.maven
    * artifact : hello
    * version : 1.0-SNAPSHOT

rem : En plus du fichier `pom.xml` a été généré l'arborescence du projet, mais aussi la classe principale `App.java`.

  * Ecrire l'interface java suivante :
```
package fr.devcoop.maven.hello;

public interface HelloService {

        /**
	 * Méthode qui retourne "Coucou " concaténer avec le prénom passé en paramètre.
	 * 
	 * @param firstname
	 * @return "Coucou " + firstname
	 */
	public String hello(String name);
	
}
```

  * Implémenter cette interface dans le package `fr.devcoop.maven.hello.impl`.

  * Utiliser cette implémentation dans la classe principale `App.java`.

```
public class App {
    public static void main( String[] args ) {
    	HelloService service = new HelloServiceImpl();
        System.out.println(/*TODO*/));
    }
}
```

  * Configurer le plugin "jar" Maven, afin que l'artifact généré lors de la phase de packaging soit exécutable (http://maven.apache.org/shared/maven-archiver/examples/classpath.html)

  * Construire l'artifact `hello-1.0-SNAPSHOT.jar` :

```
$>mvn install
```

  * Exécuter l'application :

```
$>java -jar ex1-1.0-SNAPSHOT.jar
```

## Une application loggable ##

  * Ajouter un système de logging dans l'application, pour cela ajouter une nouvelle dépendance vers le système de log choisi, Log4J :

```
<dependency>
   <groupId>log4j</groupId>
   <artifactId>log4j</artifactId>
   <version>1.2.16</version>
</dependency>
```

  * Utiliser cette nouvelle librairie dans le code de l'application. Remplacer les System.out par l'usage d'un logger.
> Exemple :

```
Logger logger = Logger.getLogger(App.class);
logger.debug("ceci est une trace de debug");
logger.info("ceci est une trace d'info");
```


  * Ajouter un fichier log4j.properties dans src/main/resources :
```
# Root logger option
log4j.rootLogger=INFO, stdout
 
# Direct log messages to stdout
log4j.appender.stdout=org.apache.log4j.ConsoleAppender
log4j.appender.stdout.Target=System.out
log4j.appender.stdout.layout=org.apache.log4j.PatternLayout
log4j.appender.stdout.layout.ConversionPattern=%d{ABSOLUTE} %5p %c{1}:%L - %m%n
```

## Une application testable ##

  * Modifier le pom de telle manière à rajouter la dépendance de test :

```
<dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.10</version>
    <scope>test</scope>
</dependency>
```

  * Que signifie ici le scope test ?

  * Ecrire un test unitaire qui valide le comportement de notre implémentation d'`HelloService`.


## Une application web ##

  * Importer le projet SVN suivant : http://92.243.23.32/svn/agfa/trunk/lforet/helloWorldWebapp

  * Ecrire une servlet Hello world :

```
public class HelloWorldServlet extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
        PrintWriter out = response.getWriter();
        out.println("<p>Hello World!</p>");
        out.close();
    }
}
```


  * configurer le WEB-INF/web.xml
```
    <servlet>
        <servlet-class>TODO</servlet-class>
        <servlet-name>helloServlet</servlet-name>
    </servlet>
    <servlet-mapping>
        <servlet-name>hello</servlet-name>
        <url-pattern>/hello</url-pattern>
    </servlet-mapping>
```

  * exécuter et tester avec jetty :
```
mvn jetty:run
```
