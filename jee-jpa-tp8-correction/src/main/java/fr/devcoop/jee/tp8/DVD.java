package fr.devcoop.jee.tp8;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;

/**
 *
 * @author lfo
 */
@Entity
@DiscriminatorValue("D")
@NamedQuery(name="allDVDs", query="select d from DVD d")
public class DVD extends Media implements Serializable {

    public DVD() {
    }

    public DVD(String title) {
        super(title);
    }

    public DVD(long duration) {
        this.duration2 = duration;
    }

    public DVD(String title, long duration) {
        super(title);
        this.duration2 = duration;
    }

    
    private long duration2;

    public long getDuration2() {
        return duration2;
    }

    public void setDuration2(long duration2) {
        this.duration2 = duration2;
    }

    
    
}
