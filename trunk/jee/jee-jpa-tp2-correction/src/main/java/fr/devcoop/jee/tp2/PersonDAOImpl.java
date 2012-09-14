package fr.devcoop.jee.tp2;

import java.sql.Statement;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author lforet
 */
public class PersonDAOImpl implements PersonDAO {

    private Connection connection;

    public void create(String firstName, String lastName) throws DAOException {
        execute("INSERT INTO PERSON (firstName, lastName) values ('" + firstName + "','" + lastName + "')");
    }

    public void delete(Person person) throws DAOException {
        execute("DELETE FROM Person WHERE id = " + person.getId());
    }

    public List<Person> getAllPersons() throws DAOException {
        return find("SELECT * FROM Person ORDER BY id ASC");
    }

    public List<Person> findAllWithPrefixLastName(String prefixLastName) throws DAOException {
        return find("SELECT * FROM Person WHERE lastname like '" + prefixLastName + "%' ORDER BY id ASC");
    }

    public void updateLastName(Person person) throws DAOException {
        execute("UPDATE Person set Lastname = '" + person.getLastName() + "' WHERE id = " + person.getId());
    }

    public void close() throws DAOException {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException ex) {
            throw new DAOException(ex);
        }
    }

    private void initConnection() throws DAOException {
        try {
            InputStream input = this.getClass().getClassLoader().getResourceAsStream("jdbc.properties");
            Properties properties = new Properties();
            properties.load(input);
            String jdbcDriver = (String) properties.get("jdbc.driver");
            String jdbcUrl = (String) properties.get("jdbc.url");
            String jdbcUser = (String) properties.get("jdbc.username");
            String jdbcPassword = (String) properties.get("jdbc.password");
            Class.forName(jdbcDriver);
            connection = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword);
        } catch (ClassNotFoundException ex) {
            throw new DAOException(ex);
        } catch (IOException ex) {
            throw new DAOException(ex);
        } catch (SQLException ex) {
            throw new DAOException(ex);
        }
    }

    private Connection getConnection() throws DAOException {
        try {
            if (connection == null || connection.isClosed()) {
                initConnection();
            }
            return connection;
        } catch (SQLException ex) {
            throw new DAOException();
        }
    }

    private void execute(String query, Object ... parameters) throws DAOException {
        Statement statement = null;
        try {
            statement = getConnection().createStatement();           
            statement.execute(query);
        } catch (SQLException ex) {
            throw new DAOException(ex);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException sqlEx) {
                // je ne fais rien , car j'ai essayé
            }
        }
    }

    private List<Person> find(String sqlQuery, String... parameters) throws DAOException {
        List<Person> persons = new ArrayList<Person>();
        Statement statement = null;
        ResultSet result = null;
        try {
            statement = getConnection().createStatement();
            result = statement.executeQuery(sqlQuery);
            while (result.next()) {
                Person person = new Person(result.getInt("id"), result.getString("firstName"), result.getString("lastName"));
                persons.add(person);
            }
            return persons;
        } catch (SQLException ex) {
            throw new DAOException(ex);
        } finally {
            if (result != null) {
                try {
                    result.close();
                } catch (SQLException sqlEx) {
                    // je ne fais rien , car j'ai essayé.
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException sqlEx) {
                    // je ne fais rien , car j'ai essayé.
                }
            }

        }
    }
}
