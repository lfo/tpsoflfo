package fr.devcoop.jee.tp1;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 *

DROP TABLE IF EXISTS PERSON;
CREATE TABLE PERSON(ID INT PRIMARY KEY, FIRSTNAME VARCHAR(255), LASTNAME VARCHAR(255));
INSERT INTO PERSON VALUES(1, 'Paul', 'Dupont');
INSERT INTO PERSON VALUES(2, 'Jacques', 'Perrin');
SELECT * FROM PERSON ORDER BY ID;

 * @author lforet
 */
public class PersonApp {

    public static void main(String... args) throws IOException {

        InputStream input = ((Class) PersonApp.class).getClassLoader().getResourceAsStream("jdbc.properties");
        Properties properties = new Properties();
        properties.load(input);
        String jdbcDriver = (String) properties.get("jdbc.driver");
        String jdbcUrl = (String) properties.get("jdbc.url");
        String jdbcUser = (String) properties.get("jdbc.username");
        String jdbcPassword = (String) properties.get("jdbc.password");


        try {
            Class.forName(jdbcDriver);
        } catch (ClassNotFoundException ex) {
            System.out.println("Vous n'avez pas votre driver dans le classpath.");
        }

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword);
            statement = connection.createStatement();

            resultSet = statement.executeQuery("select * from person order by firstname asc");

            while (resultSet.next()) {
                //            Integer id = resultSet.getInt("ID");
                String firstName = resultSet.getString("FIRSTNAME");
                String lastName = resultSet.getString("LASTNAME");
                System.out.println(String.format("%s %s", firstName, lastName));
            }
            ResultSetMetaData metaData = resultSet.getMetaData();
            System.out.println(String.format("Nombre de colonne de ma requete %s", metaData.getColumnCount()));
          
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException ex) {
                    // DO not care
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    // Do not care
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    // do not care
                }
            }

        }
    }
}
