package fr.devcoop.jee.tp1;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 *
 * @author lforet
 */
public class PersonAppJDK7 {

    public static void main(String... args) {

        Properties properties = new Properties();
        try (InputStream input = ((Class) PersonAppJDK7.class).getClassLoader().getResourceAsStream("jdbc.properties")) {

            properties.load(input);
        } catch (IOException ioex) {
            System.out.println(ioex.getMessage());
            System.exit(-1);
        }
        String jdbcDriver = (String) properties.get("jdbc.driver");
        String jdbcUrl = (String) properties.get("jdbc.url");
        String jdbcUser = (String) properties.get("jdbc.username");
        String jdbcPassword = (String) properties.get("jdbc.password");


        try {
            Class.forName(jdbcDriver);
        } catch (ClassNotFoundException ex) {
            System.out.println("Vous n'avez pas votre driver dans le classpath.");
        }


        try (Connection connection = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword)) {
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery("Select * from PERSON")) {
                    while (resultSet.next()) {
                        String firstName = resultSet.getString("FIRSTNAME");
                        String lastName = resultSet.getString("LASTNAME");
                        System.out.println(String.format("%s, %s", firstName, lastName));
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }



    }
}
