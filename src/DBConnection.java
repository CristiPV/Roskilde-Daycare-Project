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
    private static String schema = "";
    // endregion

    // region Methods
    // Establishes a connection to the DB, sends a query & executes it.
    // Returns a ResultSet containing metadata of the query.
    // NEED TO CHECK : is it good practice to set up a new connection for each query ?
    //
    public static ResultSet sendQuery(String query) { // Select Queries only
        try {
            // Sets up the connection to the DB
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);
            Statement st = con.createStatement();
            st.execute("USE " + schema + ";");
            ResultSet rs = st.executeQuery(query); // Query is executed.
            return rs; // The ResultSet is being returned.
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null; // Returns null in case of any exception.
    }
    public static boolean executeQuery(String query) {
        try {
            // Sets up the connection to the DB
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);
            Statement st = con.createStatement();
            st.execute("USE " + schema + ";");
            boolean rs = st.execute(query); // Query is executed.
            return rs; // The ResultSet is being returned.
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false; // Returns null in case of any exception.
    }
    public static String loginQuery(String username, String password) {
        DBConnection.setUsername(username);
        DBConnection.setPassword(password);
        String connectedUser = "";
        try {
            Class.forName("com.mysql.jdbc.Driver"); // explain
            Connection con = DriverManager.getConnection(url, username, password); //explain
            Statement st = con.createStatement(); //explain
            st.execute("USE " + schema + ";"); //explain
            ResultSet rs = st.executeQuery("SELECT teacher_id\n" +  //extract column teacher_id
                                            "FROM user\n" +            //from user table
                                            "WHERE username = \"" + username + "\";"); //on condition that username equals to the username in the table
            rs.next(); //
            String teacherID = rs.getString("teacher_id");
            if (teacherID == null) {
                connectedUser = "Administrator : Sandra Madsen";
            }
            else {
                rs = st.executeQuery("SELECT first_name, last_name \n" +
                        "FROM teacher\n" +
                        "WHERE teacher_id = " + teacherID + ";");
                rs.next();
                connectedUser = "Teacher : " + rs.getString("first_name") + " " + rs.getString("last_name");
            }
        }  catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Wrong Credentials. Please try again !");
        }
        return connectedUser;
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

    public static String getSchema() {
        return schema;
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

    public static void setSchema (String schema) {
        DBConnection.schema = schema;
    }
    // endregion
}
