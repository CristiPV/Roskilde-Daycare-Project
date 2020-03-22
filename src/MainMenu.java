import java.util.Scanner;

public class MainMenu {

    private Scanner console = new Scanner(System.in);

    public MainMenu () {
    };

    /*Method for signing in to the system as an admin or teacher
    with basic prints
    */
    public void signInMenu() {
        System.out.println(" ______________________________");
        System.out.println("|          Roskilde            |    ");
        System.out.println("|     ______________________   |   ");
        System.out.println("|              Daycare         |  ");
        System.out.println("|______________________________|  \n|                              |");
        System.out.println("|          Sign in             |  ");
        System.out.println("|______________________________|  ");
        System.out.println("|       Enter Username :       | ");
        console.next();
        System.out.println("|______________________________|\n|       Enter password:        |");
        String answer;
        answer = console.next();
        System.out.println("|______________________________|  ");
        if (answer.equalsIgnoreCase("123")) {
            //adminMenu();
        } else {
            //teacherMenu();
        }
    }

}
