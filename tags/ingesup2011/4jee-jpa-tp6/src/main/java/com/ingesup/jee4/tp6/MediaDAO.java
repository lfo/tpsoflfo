package com.ingesup.jee4.tp6;

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
      
}
