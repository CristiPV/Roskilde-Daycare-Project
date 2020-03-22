import java.sql.*;

public class DBConnection {
    /*
    This is the class that sets up the connection to the online SQL Database.
    It is used for running queries on the Database.
    */

    // region Static Variables
    private static String url = "";
    private static String username = "";
    private static String password = "";
    // endregion

    // region Methods
    // Establishes a connection to the DB, sends a query & executes it.
    // Returns a ResultSet containing metadata of the query.
    // NEED TO CHECK : is it good practice to set up a new connection for each query ?
    //
    public static ResultSet sendQuery(String query) {
        try {
            // Sets up the connection to the DB
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query); // Query is executed.
            return rs; // The ResultSet is being returned.
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null; // Returns null in case of any exception.
    }
    // endregion

    // region Getters
    public static String getUrl()
    {
        return url;
    }

    public static String getUsername()
    {
        return username;
    }

    public static String getPassword()
    {
        return password;
    }
    // endregion

    // region Setters
    public static void setUsername(String username)
    {
        DBConnection.username = username;
    }

    public static void setPassword(String password)
    {
        DBConnection.password = password;
    }

    public static void setUrl(String url)
    {
        DBConnection.url = "jdbc:mysql://" + url + "/";
    }
    // endregion
}