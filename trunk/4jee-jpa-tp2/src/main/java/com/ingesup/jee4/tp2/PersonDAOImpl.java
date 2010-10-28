package com.ingesup.jee4.tp2;

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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lforet
 */
public class PersonDAOImpl implements PersonDAO {

    private Connection connection;

    public void create(String firstName, String lastName) throws DAOException {
        try {
            Statement statement = getConnection().createStatement();
            statement.execute("INSERT INTO PERSON (firstName, lastName) values ('" + firstName + "','" + lastName + "')");
            try {
                statement.close();
            } catch (SQLException sqlEx) {
                // je ne fais rien , car j'ai essayé.
            }

        } catch (SQLException ex) {
            throw new DAOException(ex);
        }
    }

    //DELETE FROM TEST WHERE ID=2;
    public void delete(Person person) throws DAOException {
        try {
            Statement statement = getConnection().createStatement();
            statement.execute("DELETE FROM Person WHERE id = " + person.getId());
            try {
                statement.close();
            } catch (SQLException sqlEx) {
                // je ne fais rien , car j'ai essayé.
            }
        } catch (SQLException ex) {
            throw new DAOException(ex);
        }
    }

    public List<Person> getAllPersons() throws DAOException {
        return find("SELECT * FROM Person ORDER BY id ASC");
    }

    public List<Person> findAllWithPrefixLastName(String prefixLastName) throws DAOException {
        return find("SELECT * FROM Person WHERE lastname like '" + prefixLastName + "%' ORDER BY id ASC");
    }

    //UPDATE TEST SET NAME='Hi' WHERE ID=1;
    public void updateLastName(Person person) throws DAOException {
        try {
            Statement statement = getConnection().createStatement();
            statement.execute("UPDATE Person set Lastname = '" + person.getLastName() + "' WHERE id = " + person.getId());
        } catch (SQLException ex) {
            throw new DAOException(ex);
        }
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

    private List<Person> find(String sqlQuery) throws DAOException {
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
