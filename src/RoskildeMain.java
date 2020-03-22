public class RoskildeMain {

    // The url to the DB used for the project.
    private static final String URLDB = "personal-database.cfi7hnmvjvlo.eu-central-1.rds.amazonaws.com";

    public static void main(String[] args)
    {
        // Login Credentials
        String username = "administrator";
        String password = "j042307y9";

        selectDB(URLDB);
        loginDB(username, password);

        // launch the actual user interface
        Menu.display();
    }

    // Sets the url for the DB connection.
    public static void selectDB( String url ) {
        DBConnection.setUrl(url);
    }

    // Sets the variables needed for DB login.
    public static void loginDB(String username, String password)
    {
        DBConnection.setUsername(username);
        DBConnection.setPassword(password);
    }
}
