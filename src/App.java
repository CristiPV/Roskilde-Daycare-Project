public class App {
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
