package fr.devcoop.jee.tp8;

import java.util.List;

/**
 *
 * @author lforet
 */
public interface OpticalDiscDAO extends MediaDAO<DVD> {

    public List<DVD> findAllBetween(Long lowDuration, Long highDuration);
    
}
