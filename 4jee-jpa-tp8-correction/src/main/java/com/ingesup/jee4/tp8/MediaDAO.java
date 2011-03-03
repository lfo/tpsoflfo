package com.ingesup.jee4.tp8;

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
    public List<Media> findBy(String titlePrefix, List<Person> authors);
}
