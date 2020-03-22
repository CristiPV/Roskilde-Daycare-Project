import java.util.Scanner;

public class AdminMenu extends MainMenu {

    private Scanner console = new Scanner(System.in);

    public AdminMenu () {
    };

    //Admin menu method, switches through admins menu functions
    public void adminMenu() {

        boolean menuSwitcher = false;
        System.out.println(" ______________________________");
        System.out.println("|          Roskilde            |    ");
        System.out.println("|     ______________________   |   ");
        System.out.println("|              Daycare         |  ");
        System.out.println("|______________________________|  \n|          Admin Menu          |");
        System.out.println("|______________________________|   ");
        System.out.println("|      1.Manage Database       |  ");
        System.out.println("|      2.Manage Schedules      |  ");
        System.out.println("|      3.Manage Waiting List   |  ");
        System.out.println("|      4.Check Phone List      |  ");
        System.out.println("|      5.Check Payment         |  ");
        System.out.println("|      6.Log out               |  ");
        System.out.println("|______________________________|   ");
        System.out.println("        Select choice...        ");

        int choice = console.nextInt();
        while (!menuSwitcher) {
            switch (choice) {
                case 1:
                    manageDatabaseMenu();
                    menuSwitcher = true;
                    break;
                case 2:
                    // scheduleMenu();
                    menuSwitcher = true;
                    break;
                case 3:
                    waitingListMenu();
                    menuSwitcher = true;
                    break;
                case 4:
                    menuSwitcher = true;
                    break;
                case 5:
                    paymentManagement();
                    menuSwitcher = true;
                    break;
                case 6:
                    menuSwitcher = true;
                    break;
            }


        }
    }

    //Menu method for the admin to manage the databases
    public void manageDatabaseMenu() {
        boolean menuSwitcher = false;
        System.out.println(" ______________________________");
        System.out.println("|         Roskilde             |    ");
        System.out.println("|     _______________________  |   ");
        System.out.println("|              Daycare         |  ");
        System.out.println("|______________________________|  \n|    Database Management Menu  |");
        System.out.println("|______________________________|   ");
        System.out.println("|      1.Manage DB Children    |  ");
        System.out.println("|      2.Manage DB Teachers    |  ");
        System.out.println("|      3.Manage DB Parents     |  ");
        System.out.println("|      4.Manage DB Appointments|  ");
        System.out.println("|      5.Back                  |  ");
        System.out.println("|______________________________|   ");
        System.out.println("        Select choice...        ");

        int choice = console.nextInt();
        while (!menuSwitcher) {
            switch (choice) {
                case 1:
                    menuSwitcher = true;
                    break;
                case 2:
                    //teacherDatabaseMenu();
                    menuSwitcher = true;
                    break;
                case 3:
                    menuSwitcher = true;
                    break;
                case 4:
                    appointmentsDatabaseMenu();
                    menuSwitcher = true;
                    break;
                case 5:
                    adminMenu();
                    menuSwitcher = true;
                    break;
            }
        }

    }

    public  void scheduleMenu()
    {
        boolean menuSwitcher=false;
        System.out.println(" ______________________________");
        System.out.println("|         Roskilde             |    ");
        System.out.println("|     _______________________  |   ");
        System.out.println("|              Daycare         |  " );
        System.out.println("|______________________________|  \n" +
                "|   Schedule Management Menu   |");
        System.out.println("|______________________________|   ");
        System.out.println("|      1.Manage DB Children    |  ");
        System.out.println("|      2.Manage DB Teachers    |  ");
        System.out.println("|      3.Manage DB Parents     |  ");
        System.out.println("|      4.Manage DB Appointments|  ");
        System.out.println("|      5.Back                  |  ");
        System.out.println("|______________________________|   ");
        System.out.println("        Select choice...        ");

        int choice=console.nextInt();
        while (!menuSwitcher) {
            switch (choice) {
                case 1:
                    menuSwitcher = true;
                    break;
                case 2:
                    //teacherDatabaseMenu();
                    menuSwitcher = true;
                    break;
                case 3:
                    menuSwitcher=true;
                    break;
                case 4:
                    appointmentsDatabaseMenu();
                    menuSwitcher=true;
                    break;
                case 5:
                    adminMenu();
                    menuSwitcher=true;
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
        System.out.println("|     1.Remove Child from List |  ");
        System.out.println("|     2.Add Child to List      |  ");
        System.out.println("|     3.Move Child up List     |  ");
        System.out.println("|     4.Move Child down List   |  ");
        System.out.println("|     5.Back                   |");
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
                    menuSwitcher = true;
                    break;
                case 4:
                    menuSwitcher = true;
                    break;
                case 5:
                    adminMenu();
                    menuSwitcher = true;
                    break;
            }
        }
    }

    //payment method menu
    public void paymentManagement() {
        boolean menuSwitcher = false;
        System.out.println(" ______________________________");
        System.out.println("|         Roskilde             |    ");
        System.out.println("|     _______________________  |   ");
        System.out.println("|              Daycare         |  ");
        System.out.println("|______________________________|  \n" +
                "|          Payment Menu        |");
        System.out.println("|______________________________|   ");
        System.out.println("|     1.Invoices               |  ");
        System.out.println("|     2.Teacher Payment        |  ");
        System.out.println("|     3.Issue Fine    |  ");
        System.out.println("|     5.Back                   |");
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
                    menuSwitcher = true;
                    break;
                case 4:
                    menuSwitcher = true;
                    break;
                case 5:
                    adminMenu();
                    menuSwitcher = true;
                    break;
            }

        }
    }

    // SELECT ALL QUERY

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
                    manageDatabaseMenu();
                    menuSwitcher = true;
                    break;
            }
        }

    }

}
