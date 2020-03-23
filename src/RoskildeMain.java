
public class RoskildeMain {

    // The url to the DB used for the project.
    private static final String URLDB = "personal-database.cfi7hnmvjvlo.eu-central-1.rds.amazonaws.com";
    private static final String SCHEMA = "roskilde_daycare";

    public static void main(String[] args)
    {
        // Login Credentials
        String username = "administrator";
        String password = "m8qhhxm0qwu";

        selectDB(URLDB);
        selectSchema(SCHEMA);
        loginDB(username, password);
        /*Menu.selectAll( "child" );*/
       /* Menu.insertRow(213, "David", "Spencer", "2014-01-02", "M", 6, "2020-03-23", 501 , 301);
        Menu.selectAll( "child" );*/
        /*Menu.updateRow( 213, "Chris" );
        Menu.selectAll("child");*/
        /*Menu.deleteRow(213 );
        Menu.selectAll("child");*/
    }

    // Sets the url for the DB connection.
    public static void selectDB( String url ) {
        DBConnection.setUrl(url);
    }
    public static void selectSchema ( String schema ) {
        DBConnection.setSchema(schema);
    }

    // Sets the variables needed for DB login.
    public static void loginDB(String username, String password)
    {
        DBConnection.setUsername(username);
        DBConnection.setPassword(password);
    }

}
