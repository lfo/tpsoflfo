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
 * @author lforet
 */
public class PersonApp {

    public static void main(String... args) throws IOException, SQLException {
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

        Connection connection = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword);
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("select * from person order by firstname asc");

        while (resultSet.next()) {
            Integer id = resultSet.getInt("ID");
            String firstName = resultSet.getString(2);
            String lastName = resultSet.getString(3);
            System.out.println(String.format("%s %s", firstName, lastName));
        }
        ResultSetMetaData metaData = resultSet.getMetaData();
        System.out.println(String.format("Nombre de colonne de ma requete %s", metaData.getColumnCount()));
        resultSet.close();
        statement.close();
        connection.close();
    }
}
