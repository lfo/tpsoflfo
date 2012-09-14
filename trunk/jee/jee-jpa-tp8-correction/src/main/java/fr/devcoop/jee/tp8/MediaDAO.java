package fr.devcoop.jee.tp8;

import java.util.List;

/**
 *
 * @author lforet
 */
public interface MediaDAO<M> {

    public List<M> getAll() throws DAOException;
    
    public M persist(M media);

    public M update(M media);

    public List<M> findByTitle(String titlePrefix);
    
    /**
     * Recherche des m�dias ayant au moins deux auteurs. 
     * @return 
     */
    public List<M> findMediaWithAtLeast2Authors();

    /**
     * Recherche selon deux param�tres.
     * @param titlePrefix peut �tre nul, dans ce cas le filtre se fait sur les auteurs 
     * @param authors peut �tre nul ou vide, dans ce cas le filtre se fait sur le titre
     * @return liste de M�dia si les deux param�tre sont vides retournent tous les m�dias.
     */
    public List<Media> findBy(String titlePrefix, List<Person> authors);
}
