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
        String username, password;
        System.out.println(" ______________________________");
        System.out.println("|          Roskilde            |    ");
        System.out.println("|     ______________________   |   ");
        System.out.println("|              Daycare         |  ");
        System.out.println("|______________________________|  \n|                              |");
        System.out.println("|          Sign in             |  ");
        System.out.println("|______________________________|  ");
        System.out.println("|       Enter Username :       | ");
        username = console.next();
        System.out.println("|______________________________|\n|       Enter password:        |");
        password = console.next();
        System.out.println("|______________________________|  ");
        loginDB(username, password);
        if (username.equalsIgnoreCase("administrator")) {
            adminMenu.adminMenu();
        } else {
            teacherMenu.teacherMenu();
        }
    }

    public static void loginDB(String username, String password)
    {
        DBConnection.setUsername(username);
        DBConnection.setPassword(password);
    }

}
