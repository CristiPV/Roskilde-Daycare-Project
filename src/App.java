public class App {
    /*
    Dependency: jdbc-connector.jar.
    It has to be downloaded and added in a ./lib/ directory.
    IntelliJ installation :
    1. Go to File.
    2. Select Project Structure.
    3. On the left tab, select Modules.
    4. Click on the right-side +, then select JARs or Directories
    5. Select the connector from the newly created directory, check the box & click accept.
    */
    private static Controller controller;
    private static final String URLDB = "personal-database.cfi7hnmvjvlo.eu-central-1.rds.amazonaws.com";
    private static final String SCHEMA = "roskilde_daycare";

    public static void main(String[] args){
        selectDB(URLDB);
        selectSchema(SCHEMA);
        controller = new Controller();
        new MainMenu();
    }

    // Sets the url for the DB connection.
    public static void selectDB( String url ) {
        DBConnection.setUrl(url);
    }
    public static void selectSchema ( String schema ) {
        DBConnection.setSchema(schema);
    }

    public static Controller getController(){
            return controller;
        }

}
