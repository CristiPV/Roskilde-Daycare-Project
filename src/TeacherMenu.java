import java.util.Scanner;

public class TeacherMenu {
    // scanner for user input
    private Scanner console = new Scanner(System.in);

    //constructor
    public TeacherMenu() {}

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
                    menuSwitcher = true;
                    break;
                case 4:
                    displaySchedule();
                    menuSwitcher = true;
                    break;
                case 5:
                    System.out.println("|______________________________|   ");
                    System.out.println("| What do you want to display  |" +
                            "  (1)All OR (2)One instance?  ");
                    int displayChoice = console.nextInt();
                    if (displayChoice == 1) {
                        displayParentList();
                    } else if (displayChoice == 2) {
                        displayOneParent();
                    } else {
                        System.out.println("You have entered an invalid choice try again!");
                    }
                    menuSwitcher = true;
                    break;
                case 6:
                    System.out.println("You are logged out.");
                    new MainMenu();
                    menuSwitcher = true;
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
                    createAppointment();
                    menuSwitcher = true;
                    System.out.println("");
                    appointmentsDatabaseMenu();
                    break;
                case 2:
                    deleteAppointment();
                    menuSwitcher = true;
                    System.out.println("");
                    appointmentsDatabaseMenu();
                    break;
                case 3:
                    System.out.println("|______________________________|   ");
                    System.out.println("| What do you want to display  |" +
                            "  (1)All OR (2)One instance?  ");
                    int displayChoice = console.nextInt();
                    if (displayChoice == 1) {
                        displayAppointmentList();
                    } else if (displayChoice == 2) {

                        System.out.println("Enter Parent ID:");
                        displayRowFromAppointmentList();
                    } else {
                        System.out.println("You have entered an invalid choice try again!");
                    }
                    System.out.println("");
                    appointmentsDatabaseMenu();
                    menuSwitcher = true;
                    break;
                case 4:
                    teacherMenu();
                    menuSwitcher = true;
                    break;
            }
        }

    }

    public void createAppointment() {
        App.getController().createAppointment();
    }

    public void deleteAppointment() {
        App.getController().deleteAppointment();
    }

    public void displayAppointmentList() {
        App.getController().displayAppointmentList();
    }

    public void displayRowFromAppointmentList() {
        App.getController().displayRowFromAppointmentList();
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
                    createRecordInWaitingList();
                    menuSwitcher = true;
                    System.out.println("");
                    waitingListMenu();
                    break;
                case 2:
                    deleteRecordInWaitingList();
                    menuSwitcher = true;
                    System.out.println("");
                    waitingListMenu();
                    break;
                case 3:
                    System.out.println("|______________________________|   ");
                    System.out.println("| What do you want to display  |" +
                            "  (1)All OR (2)One instance? ");
                    int displayChoice = console.nextInt();
                    if (displayChoice == 1) {
                        displayWaitingList();
                    } else if (displayChoice == 2) {

                        System.out.println("Enter Parent ID:");
                        displayRowFromWaitingList();
                    } else {
                        System.out.println("You have entered an invalid choice try again!");
                    }
                    System.out.println("");
                    waitingListMenu();
                    menuSwitcher = true;
                    break;
                case 4:
                    teacherMenu();
                    menuSwitcher = true;
                    break;
            }
        }
    }

    public void createRecordInWaitingList() {App.getController().createRecordInWaitingList();}
    public void deleteRecordInWaitingList() {
        App.getController().deleteRecordInWaitingList();
    }
    public void displayWaitingList() {App.getController().displayWaitingList(); }

    public void displayRowFromWaitingList() {App.getController().displayRowFromWaitingList();}

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
                    createGroup();
                    menuSwitcher = true;
                    System.out.println("");
                    groupsMenu();
                    break;
                case 2:
                    deleteGroup();
                    menuSwitcher = true;
                    System.out.println("");
                    groupsMenu();
                    break;
                case 3:
                    displayGroups();
                    menuSwitcher = true;
                    System.out.println("");
                    groupsMenu();
                    break;
                case 4:
                    teacherMenu();
                    menuSwitcher = true;
                    break;
            }
        }

    }

    public void createGroup() {
        App.getController().createGroup();
    }

    public void deleteGroup() {
        App.getController().deleteGroup();
    }

    public void displayGroups() {
        App.getController().displayGroups();
    }

    //Display Schedules
    public void displaySchedule() {
        App.getController().displaySchedule();
    }

    //Phone List
    public void displayParentList(){
        App.getController().displayParentList();
    }
    public void displayOneParent(){
        App.getController().displayOneParent();
    }
}
