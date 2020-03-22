import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
public class Menu
{
    public static void display()
    {
        ResultSet rs = DBConnection.sendQuery("SELECT * FROM roskilde_daycare.child");
        try
        {
            while (rs.next())
            {
                // ResultSet has rows with columns accessible by using the column name
                System.out.println("ID: " + rs.getString("child_id") + " | " +
                                   "Name: " + rs.getString("first_name") + " " + rs.getString("last_name"));
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    Scanner console = new Scanner(System.in);
    
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
        System.out.println("|      Enter Email adress:     | ");
        console.next();
        System.out.println("|______________________________|\n|       Enter password:        |");
        String answer;
        answer = console.next();
        System.out.println("|______________________________|  ");
        if (answer.equalsIgnoreCase("123")) {
            adminMenu();
        } else {
            teacherMenu();
        }
    }

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
                    waitingListMenu();
                    menuSwitcher = true;
                    break;
                case 2:
                    appointmentsDatabaseMenu();
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
                    teacherDatabaseMenu();
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
                    manageDatabaseMenu();
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
        System.out.println("|      3.Modify Information    |  ");
        System.out.println("|      4.Back                  |  ");
        System.out.println("|______________________________|   ");
        System.out.println("        Select choice...        ");

        int choice = console.nextInt();
        while (!menuSwitcher) {
            switch (choice) {
                case 1:
                    addAppointment();
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

    //Menu method to add an appointment to the system
    public void addAppointment() {
        System.out.println(" ______________________________");
        System.out.println("|         Roskilde             |    ");
        System.out.println("|     _______________________  |   ");
        System.out.println("|              Daycare         |  ");
        System.out.println("|______________________________| ");
        System.out.println("|      Register Appointment    |");
        System.out.println("        Enter Name...");
        String name = console.next();
        System.out.println("        Enter Date...");
        String date = console.next();
        System.out.println("        Enter Parent Name...");
        String parentName = console.next();
        System.out.println("        Enter Child Name....");
        String childName = console.next();
        System.out.println("        Enter Phone Number....");
        String phone = console.next();
        System.out.println("        Confirm Creation 1.Yes/2.No ?");
        int confirmation = console.nextInt();
        if (confirmation == 1) {
            appointmentsDatabaseMenu();
        } else if (confirmation == 2) {
            addAppointment();
        }
    }

    /*public  void scheduleMenu()
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
                    teacherDatabaseMenu();
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

    }
*/
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
}


