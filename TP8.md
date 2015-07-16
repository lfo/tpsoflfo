# JPQL #

> Modifier les DAO du TP6 :

  * Ajouter une recherche de DVD par durée entre deux bornes :
```
  public interface OpticalDiscDAO extends MediaDAO<DVD> {

      public List<DVD> findAllBetween(Long lowDuration, Long highDuration);
    
  }
```

  * Dans MediaDAO ajouter les méthodes suivantes :
```

    /**
     * Recherche des médias ayant au moins deux auteurs. 
     * @return 
     */
    public List<M> findMediaWithAtLeast2Authors();

    /**
     * Recherche selon deux paramètres.
     * @param titlePrefix peut être nul, dans ce cas le filtre se fait sur les auteurs 
     * @param authors peut être nul ou vide, dans ce cas le filtre se fait sur le titre
     * @return liste de Média si les deux paramètre sont vides retournent tous les médias.
     */
    public List<M> findBy(String titlePrefix, List<Person> authors);
  
```

# API Criteria #

> Remplacer le code JPQL par l'api Criteria pour le BookDAO et PersonDAO et utiliser le méta-modèle afin de bénéficier d'un langage de requête complètement "Type safe".


# Configuration Maven #

> Pour qu'eclipselink puisse générer le métamodèle, il faut utiliser l'annotation processor du jdk. Afin de lancer cet annotation processor dans maven il faut utiliser un plugin maven et le configurer :

```
    <pluginRepositories>
        <pluginRepository>
            <id>maven-annotation-plugin</id>
            <url>http://maven-annotation-plugin.googlecode.com/svn/trunk/mavenrepo</url>
        </pluginRepository>
    </pluginRepositories>
    <build>
        <plugins>       
            <plugin>
                <groupId>org.bsc.maven</groupId>
                <artifactId>maven-processor-plugin</artifactId>
                <version>1.3.5</version>
                <executions>
                    <execution>
                        <id>process</id>
                        <goals>
                            <goal>process</goal>
                        </goals>
                        <phase>generate-sources</phase>
                        <configuration>
                            <compilerArguments>-Aeclipselink.persistencexml=src/main/resources/META-INF/persistence.xml</compilerArguments>
                            <processors>
                                <processor>org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor</processor>
                            </processors>
                        </configuration>
                    </execution>
                </executions>
            </plugin>
        </plugins>    
    </build>



```