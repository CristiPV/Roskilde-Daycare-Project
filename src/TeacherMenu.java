import java.util.Scanner;

public class TeacherMenu extends MainMenu {

    private Scanner console = new Scanner(System.in);

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
        System.out.println("|      1.Manage Waiting List   |  ");
        System.out.println("|      2.Manage Appointments   |  ");
        System.out.println("|      3.Log out               |  ");
        System.out.println("|______________________________|   ");
        System.out.println("        Select choice...        ");

        int choice = console.nextInt();
        while (!menuSwitcher) {
            switch (choice) {
                case 1:
                    //waitingListMenu();
                    menuSwitcher = true;
                    break;
                case 2:
                    appointmentsDatabaseMenu();
                    menuSwitcher = true;
                    break;
            }
        }
    }

    // Menu method for the teacher database and functions you can use there
    public void teacherDatabaseMenu() {
        boolean menuSwitcher = false;
        System.out.println(" ______________________________");
        System.out.println("|         Roskilde             |    ");
        System.out.println("|     _______________________  |   ");
        System.out.println("|              Daycare         |  ");
        System.out.println("|______________________________|  \n" +
                " | Teacher Management Menu      |");
        System.out.println("|______________________________|   ");
        System.out.println("|      1.Add Teacher to DB     |  ");
        System.out.println("|      2.Delete Teacher        |  ");
        System.out.println("|      3.Modify Information    |  ");
        System.out.println("|      4.Back                  |  ");
        System.out.println("|______________________________|   ");
        System.out.println("        Select choice...        ");

        int choice = console.nextInt();
        while (!menuSwitcher) {
            switch (choice) {
                case 1:
                    addTeacher();
                    menuSwitcher = true;
                    break;
                case 2:
                    menuSwitcher = true;
                    break;
                case 3:
                    menuSwitcher = true;
                    break;
                case 4:
                    //manageDatabaseMenu();
                    menuSwitcher = true;
                    break;
            }
        }

    }

    //Menu method to add a teacher to the system
    public void addTeacher() {
        System.out.println(" ______________________________");
        System.out.println("|         Roskilde             |    ");
        System.out.println("|     _______________________  |   ");
        System.out.println("|              Daycare         |  ");
        System.out.println("|______________________________| ");
        System.out.println("|        Register Teacher      |");
        System.out.println("        Enter Name...");
        String name = console.next();
        System.out.println();
        System.out.println("        Enter Email...");
        String email = console.next();
        System.out.println("        Enter Password...");
        String password = console.next();
        System.out.println("        Enter Phone Number....");
        String phone = console.next();
        System.out.println("        Enter Address...");
        String address = console.next();
        System.out.println("        Confirm Creation 1.Yes/2.No ?");
        int confirmation = console.nextInt();
        if (confirmation == 1) {
            teacherDatabaseMenu();
        } else if (confirmation == 2) {
            addTeacher();
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
        System.out.println("|      3.Modify Information    |  ");
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
                    menuSwitcher = true;
                    break;
                case 4:
                    teacherMenu();
                    menuSwitcher = true;
                    break;
            }
        }

    }
}
