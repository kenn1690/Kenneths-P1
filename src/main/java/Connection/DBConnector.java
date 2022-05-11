package Connection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnector {

    //keep track of the connection
    private static Connection connection;

    /**
     * Keeps track of the singleton and is made private, so it can not be invoked
     */
    private DBConnector(){

    }

    /**
     * is made public so the connection can be returned and calls the connect method.
     * @return
     */
    public static Connection getConnection(){
        if(connection == null){
            connection = connect();
        }
        System.out.println("Connection successful");
        return connection;
    }

    /**
     * This method is made private so it can't be called directly outside of this class
     * It concatenates the URL together from the properties file to connect to correct DB.
     * @return
     */
    private static Connection connect()  {
        Properties props = new Properties();
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        InputStream input = loader.getResourceAsStream("application.properties");
        try {
            Class.forName("org.postgresql.Driver");
            props.load(input);

            String connectionString = "jdbc:postgresql://" +
                    props.getProperty("hostname") + ":" +
                    props.getProperty("port") + "/" +
                    props.getProperty("dbname");
            String username = props.getProperty("username");
            String password = props.getProperty("password");

            connection = DriverManager.getConnection(connectionString, username, password);
        }
        catch (IOException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        //System.out.println("Connection is successful with: " + connectionString);
        return connection;
    }

    /**
     * Closes connection when finished.
     */
    public static void close(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Closed JDBC successfully");
        connection = null;
    }
}
