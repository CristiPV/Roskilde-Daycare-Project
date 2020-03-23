import java.util.Scanner;

public class TeacherMenu {
    // scanner for user input
    private Scanner console = new Scanner(System.in);
    //constructor
    public TeacherMenu() {
    };

    // Teacher Logged in menu, switches through teacher menu functions
    public void teacherMenu() {

        boolean menuSwitcher = false;
        System.out.println(" ______________________________");
        System.out.println("|          Roskilde            |    ");
        System.out.println("|     _____________________    |   ");
        System.out.println("|              Daycare         |  ");
        System.out.println("|______________________________|  \n|         Teacher Menu         |");
        System.out.println("|______________________________|   ");
        System.out.println("|      1.Access Waiting List   |  ");
        System.out.println("|      2.Access Appointments   |  ");
        System.out.println("|      3.Access Groups         |");
        System.out.println("|      4.Display Schedules     |");
        System.out.println("|      5.Display Phone List    |");
        System.out.println("|      6.Log out               |  ");
        System.out.println("|______________________________|   ");
        System.out.println("        Select choice...        ");

        int choice = console.nextInt();
        while (!menuSwitcher) {
            switch (choice) {
                case 1:
                    waitingListMenu();
                    menuSwitcher = true;
                    break;
                case 2:
                    appointmentsDatabaseMenu();
                    menuSwitcher = true;
                    break;
                case 3:
                    groupsMenu();
                    menuSwitcher=true;
                    break;
                case 4:
                    menuSwitcher=true;
                    break;
                case 5:
                    menuSwitcher=true;
                    break;
                case 6:
                    menuSwitcher=true;
                    break;
            }
        }
    }
    //Menu method for the appointments database and functions you can use there
    public void appointmentsDatabaseMenu() {
        boolean menuSwitcher = false;
        System.out.println(" ______________________________");
        System.out.println("|         Roskilde             |    ");
        System.out.println("|     _______________________  |   ");
        System.out.println("|              Daycare         |  ");
        System.out.println("|______________________________|  \n" +
                "| Appointments Management Menu |");
        System.out.println("|______________________________|   ");
        System.out.println("|      1.Add Appointment       |  ");
        System.out.println("|      2.Delete Appointment    |  ");
        System.out.println("|      3.Display Appointment   |  ");
        System.out.println("|      4.Back                  |  ");
        System.out.println("|______________________________|   ");
        System.out.println("        Select choice...        ");

        int choice = console.nextInt();
        while (!menuSwitcher) {
            switch (choice) {
                case 1:
                    //addAppointment();
                    menuSwitcher = true;
                    break;
                case 2:
                    menuSwitcher = true;
                    break;
                case 3:

                    System.out.println("|______________________________|   ");
                    System.out.println("| What do you want to display  |" +
                            "  (1)All OR (2)One instance?  ");
                    int displayChoice=console.nextInt();
                    if(displayChoice==1)
                    {

                    }
                    else if(displayChoice==2)
                    {

                        System.out.println("Enter ID Or Name probably....");
                    }
                    else
                    {
                        System.out.println("You have entered an invalid choice try again!");
                        appointmentsDatabaseMenu();
                    }
                    menuSwitcher = true;
                    break;
                case 4:
                    teacherMenu();
                    menuSwitcher = true;
                    break;
            }
        }

    }
    //waiting list method menu
    public void waitingListMenu() {
        boolean menuSwitcher = false;
        System.out.println(" ______________________________");
        System.out.println("|         Roskilde             |    ");
        System.out.println("|     _______________________  |   ");
        System.out.println("|              Daycare         |  ");
        System.out.println("|______________________________|  \n" +
                "|     Waiting List Menu        |");
        System.out.println("|______________________________|   ");
        System.out.println("|     1.Create Waiting List    |  ");
        System.out.println("|     2.Delete Waiting List    |  ");
        System.out.println("|     3.Display Waiting List   |  ");
        System.out.println("|     4.Back                   |");
        System.out.println("|______________________________|   ");
        System.out.println("        Select choice...        ");

        int choice = console.nextInt();
        while (!menuSwitcher) {
            switch (choice) {
                case 1:
                    menuSwitcher = true;
                    break;
                case 2:
                    menuSwitcher = true;
                    break;
                case 3:
                    System.out.println("|______________________________|   ");
                    System.out.println("| What do you want to display  |" +
                            "  (1)All OR (2)One instance? ");
                    int displayChoice=console.nextInt();
                    if(displayChoice==1)
                    {

                    }
                    else if(displayChoice==2)
                    {

                        System.out.println("Enter ID Or Name probably....");
                    }
                    else
                    {
                        System.out.println("You have entered an invalid choice try again!");
                        waitingListMenu();
                    }
                    menuSwitcher = true;
                    break;
                case 4:
                    teacherMenu();
                    menuSwitcher = true;
                    break;
            }
        }
    }
    //Menu method for the admin to manage the groups
    public void groupsMenu() {
        boolean menuSwitcher = false;
        System.out.println(" ______________________________");
        System.out.println("|         Roskilde             |    ");
        System.out.println("|     _______________________  |   ");
        System.out.println("|              Daycare         |  ");
        System.out.println("|______________________________|  \n" +
                           "|           Groups Menu        |");
        System.out.println("|______________________________|   ");
        System.out.println("|      1.Add Group             |  ");
        System.out.println("|      2.Delete Group          |  ");
        System.out.println("|      3.Display Groups        |  ");
        System.out.println("|      4.Back                  |  ");
        System.out.println("|______________________________|   ");
        System.out.println("        Select choice...        ");

        int choice = console.nextInt();
        while (!menuSwitcher) {
            switch (choice) {
                case 1:
                    menuSwitcher = true;
                    break;
                case 2:
                    menuSwitcher = true;
                    break;
                case 3:
                    System.out.println("|______________________________|   ");
                    System.out.println("| What do you want to display  |" +
                            "  (1)All OR (2)One instance?  ");
                    int displayChoice=console.nextInt();
                    if(displayChoice==1)
                    {

                    }
                    else if(displayChoice==2)
                    {

                        System.out.println("Enter ID Or Name probably....");
                    }
                    else
                    {
                        System.out.println("You have entered an invalid choice try again!");
                        groupsMenu();
                    }
                    menuSwitcher = true;
                    break;
                case 4:
                    teacherMenu();
                    menuSwitcher = true;
                    break;
            }
        }

    }
    //Display Schedules
    public void Schedules(){}
    public void phoneList(){}
}
