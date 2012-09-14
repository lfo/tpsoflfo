package fr.devcoop.jee.tp1;

import java.sql.SQLException;

/**
 *
 * @author lforet
 */
public class H2Server {
    
    public static void main(String[] args) throws SQLException {
        org.h2.tools.Console.main(args);
    }
    
}
