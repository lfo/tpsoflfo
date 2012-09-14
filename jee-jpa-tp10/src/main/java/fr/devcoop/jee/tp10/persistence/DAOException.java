package fr.devcoop.jee.tp10.persistence;

/**
 *
 * @author lforet
 */
public class DAOException extends Exception {

    public DAOException(Throwable cause) {
        super(cause);
    }

    public DAOException(String message, Throwable cause) {
        super(message, cause);
    }

    public DAOException(String message) {
        super(message);
    }

    public DAOException() {
    }

    
    
}
