package fr.devcoop.jee.tp3;

import java.sql.Statement;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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

    private static PersonDAOImpl instance;

    private PersonDAOImpl() {
    }

    public static PersonDAOImpl getInstance() {
        if (instance == null) {
            instance = new PersonDAOImpl();
        }
        return instance;
    }
    private Connection connection;

    @Override
    public void create(String firstName, String lastName) throws DAOException {
        execute("INSERT INTO PERSON (firstName, lastName) values (?, ?)", firstName, lastName);
    }

    @Override
    public void delete(Person person) throws DAOException {
        execute("DELETE FROM PERSON WHERE PERSON.id = ?", person.getId());
    }

    @Override
    public List<Person> getAllPersons() throws DAOException {
        return find("SELECT * FROM Person ORDER BY id ASC");
    }

    @Override
    public List<Person> findAllWithPrefixLastName(String prefixLastName) throws DAOException {
        PreparedStatement pstmt;
        try {
            pstmt = getConnection().prepareStatement("SELECT * FROM Person WHERE lastname like ? ORDER BY id ASC");
            return extractFrom(executeQuery(pstmt, prefixLastName + "%"));
        } catch (SQLException ex) {
            throw new DAOException(ex);
        }
    }

    @Override
    public void updateLastName(Person person) throws DAOException {
        execute("UPDATE Person set Lastname = ? WHERE id = ?", person.getLastName(), person.getId());
    }

    @Override
    public void close() throws DAOException {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException ex) {
            throw new DAOException(ex);
        }
    }

    public void initConnection() throws DAOException {
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

    private void execute(String query, Object... parameters) throws DAOException {
        PreparedStatement pstmt = null;
        try {
            pstmt = getConnection().prepareStatement(query);

            int i = 1;
            for (Object parameter : parameters) {
                if (parameter instanceof Integer) {
                    pstmt.setInt(i, (Integer) parameter);

                }
                if (parameter instanceof String) {
                    pstmt.setString(i, (String) parameter);
                }
                i++;
            }

            pstmt.execute();
        } catch (SQLException ex) {
            throw new DAOException(ex);
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException sqlEx) {
                // je ne fais rien , car j'ai essayé.
            }
        }
    }

    private ResultSet executeQuery(PreparedStatement pstmt, Object... parameters) throws DAOException {
        try {

            int i = 1;
            for (Object parameter : parameters) {
                if (parameter instanceof Integer) {
                    pstmt.setInt(i, (Integer) parameter);

                }
                if (parameter instanceof String) {
                    pstmt.setString(i, (String) parameter);
                }
                i++;
            }

            return pstmt.executeQuery();
        } catch (SQLException ex) {
            throw new DAOException(ex);
        } finally {
            
        }
    }

    private List<Person> find(String sqlQuery, String... parameters) throws DAOException {
        Statement statement = null;
        ResultSet result = null;
        try {
            statement = getConnection().createStatement();
            result = statement.executeQuery(sqlQuery);
            return extractFrom(result);
        } catch (SQLException ex) {
            throw new DAOException(ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException sqlEx) {
                    // je ne fais rien , car j'ai essayé.
                }
            }

        }
    }

    private List<Person> extractFrom(ResultSet rs) throws SQLException {
        List<Person> persons = new ArrayList<Person>();

        try {
            while (rs.next()) {
                Person person = new Person(rs.getInt("id"), rs.getString("firstName"), rs.getString("lastName"));
                persons.add(person);
            }
            return persons;
        } catch (SQLException ex) {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) {
                    // je ne fais rien , car j'ai essayé.
                }
            }
            throw ex;
        }

    }
}
