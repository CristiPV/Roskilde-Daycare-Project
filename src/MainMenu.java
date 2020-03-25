import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class MainMenu {

    private static Scanner console = new Scanner(System.in);

    public MainMenu () {
        signInMenu();
    }

    /*Method for signing in to the system as an admin or teacher
    with basic prints
    */
    public static void signInMenu() {
        AdminMenu adminMenu=new AdminMenu();
        TeacherMenu teacherMenu=new TeacherMenu();
        String username = "", password = "", user = "";
        boolean loggedIn = false;
        while (!loggedIn) {

            System.out.println(" ______________________________");
            System.out.println("|          Roskilde            |    ");
            System.out.println("|     ______________________   |   ");
            System.out.println("|              Daycare         |  ");
            System.out.println("|______________________________|  \n|                              |");
            System.out.println("|          Sign in             |  ");
            System.out.println("|______________________________|  ");
            System.out.println("|       Enter Username :       | ");
            System.out.println("|______________________________| ");
            System.out.println("|      To Exit, Insert 0 :     | ");
            System.out.println("|______________________________| ");
            username = console.next();
            if (username.equals("0")) {
                System.exit(0);
            }
            System.out.println("|______________________________|\n|       Enter password:        |");
            password = console.next();
            System.out.println("|______________________________|  ");

            user = DBConnection.loginQuery(username,password);
            loggedIn = !user.isEmpty();
        }
        System.out.println("Welcome, " + user);
        if (username.equalsIgnoreCase("administrator")) {
            adminMenu.adminMenu();
        } else {
            teacherMenu.teacherMenu();
        }
    }



}
