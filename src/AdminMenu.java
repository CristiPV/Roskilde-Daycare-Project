import java.util.Random;
import java.util.Scanner;

public class AdminMenu {
    // scanner for user input
    private Scanner console = new Scanner(System.in);
    // constructor
    public AdminMenu () {
    }

    //Admin menu method, switches through admins menu functions
    public void adminMenu() {

        boolean menuSwitcher = false;
        System.out.println(" ______________________________");
        System.out.println("|          Roskilde            |    ");
        System.out.println("|     ______________________   |   ");
        System.out.println("|          Daycare             |  ");
        System.out.println("|______________________________|  \n" +
                           "|         Admin Menu           |");
        System.out.println("|______________________________|");
        System.out.println("|        1.Children            |");
        System.out.println("|        2.Teachers            |");
        System.out.println("|        3.Parents             |");
        System.out.println("|        4.Appointments        |");
        System.out.println("|        5.Groups              |");
        System.out.println("|        6.Waiting list        |");
        System.out.println("|        7.Payment             |");
        System.out.println("|        8.Log out             |");
        System.out.println("|______________________________|");
        System.out.println("        Select choice...        ");

        int choice = console.nextInt();
        while (!menuSwitcher) {
            switch (choice) {
                case 1:
                    childrenMenu();
                    menuSwitcher = true;
                    break;
                case 2:
                    teacherInfoMenu();
                    menuSwitcher = true;
                    break;
                case 3:
                    parentsMenu();
                    menuSwitcher = true;
                    break;
                case 4:
                    appointmentsDatabaseMenu();
                    menuSwitcher = true;
                    break;
                case 5:
                    groupsMenu();
                    menuSwitcher = true;
                    break;
                case 6:
                    waitingListMenu();
                    menuSwitcher = true;
                    break;
                case 7:
                    paymentManagement();
                    menuSwitcher=true;
                    break;
                case 8:
                    System.out.println("You are logged out.");
                    new MainMenu();
                    menuSwitcher=true;
                    break;
            }
        }
    }
    //Children information menu and all the functions it provides
    public  void childrenMenu()
    {
        boolean menuSwitcher=false;
        System.out.println(" ______________________________");
        System.out.println("|         Roskilde             |    ");
        System.out.println("|     _______________________  |   ");
        System.out.println("|         Daycare              |  " );
        System.out.println("|______________________________|  \n" +
                           "|   Children Management Menu   |");
        System.out.println("|______________________________|   ");
        System.out.println("|      1.Add Child in System   |  ");
        System.out.println("|      2.Remove Child in System|  ");
        System.out.println("|      3.Display Children      |  ");
        System.out.println("|      4.Back                  |  ");
        System.out.println("|______________________________|   ");
        System.out.println("        Select choice...        ");

        int choice=console.nextInt();
        while (!menuSwitcher) {
            switch (choice) {
                case 1:
                    createChild();
                    menuSwitcher = true;
                    break;
                case 2:
                    deleteChild();
                    menuSwitcher = true;
                    break;
                case 3:
                    displayChildList();
                    menuSwitcher = true;
                    break;
                case 4:
                    adminMenu();
                    menuSwitcher = true;
                    break;
            }
            System.out.println();
            childrenMenu();
        }

    }
    public void createChild(){
        App.getController().createChild();
    }
    public void deleteChild(){
        App.getController().deleteChild();
    }
    public void displayChildList(){
        App.getController().displayChildList();
    }
    //Teacher information menu and all the functions it provides
    public void teacherInfoMenu()
    {
        boolean menuSwitcher=false;
        System.out.println(" ______________________________");
        System.out.println("|         Roskilde             |    ");
        System.out.println("|     _______________________  |   ");
        System.out.println("|         Daycare              |  " );
        System.out.println("|______________________________|  \n" +
                           "|    Teacher Management Menu   |");
        System.out.println("|______________________________|   ");
        System.out.println("|    1.Add Teacher in System   |  ");
        System.out.println("|    2.Remove Teacher in System|  ");
        System.out.println("|    3.Display Teacher List    |  ");
        System.out.println("|    4.Back                    |  ");
        System.out.println("|______________________________|   ");
        System.out.println("        Select choice...        ");

        int choice=console.nextInt();
        while (!menuSwitcher) {
            switch (choice) {
                case 1:
                    createTeacher();
                    menuSwitcher = true;
                    break;
                case 2:
                    deleteTeacher();
                    menuSwitcher = true;
                    break;
                case 3:
                    displayTeacherList();
                    menuSwitcher = true;
                    break;
                case 4:
                    adminMenu();
                    menuSwitcher = true;
                    break;
            }
            System.out.println("");
            teacherInfoMenu();
        }

    }
    public void createTeacher(){
        App.getController().createTeacher();
    }
    public void deleteTeacher(){
        App.getController().deleteTeacher();
    }
    public void displayTeacherList(){
        App.getController().displayTeacherList();
    }

   public void parentsMenu()
   {
       boolean menuSwitcher=false;
       System.out.println(" ______________________________");
       System.out.println("|         Roskilde             |    ");
       System.out.println("|     _______________________  |   ");
       System.out.println("|         Daycare              |  " );
       System.out.println("|______________________________|  \n" +
                          "|   Parents Management Menu    |");
       System.out.println("|______________________________|   ");
       System.out.println("|     1.Display Parents        |  ");
       System.out.println("|     2.Add Parent in System   |  ");
       System.out.println("|     3.Back                   |  ");
       System.out.println("|______________________________|   ");
       System.out.println("        Select choice...        ");

       int choice=console.nextInt();
       while (!menuSwitcher) {
           switch (choice) {
               case 1:
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
               case 2:
                   createParent();
                   menuSwitcher = true;
                   break;
               case 3:
                   adminMenu();
                   menuSwitcher = true;
           }
           System.out.println("");
           parentsMenu();
       }

   }
    public void createParent(){
        App.getController().createParent();
    }

    public void displayParentList(){
        App.getController().displayParentList();
    }
    public void displayOneParent(){
        App.getController().displayOneParent();
    }
    //Menu method for the admin to manage the groups
    public void groupsMenu() {
        boolean menuSwitcher = false;
        System.out.println(" ______________________________");
        System.out.println("|         Roskilde             |    ");
        System.out.println("|     _______________________  |   ");
        System.out.println("|         Daycare              |  ");
        System.out.println("|______________________________|  \n" +
                           "|         Groups Menu          |");
        System.out.println("|______________________________|   ");
        System.out.println("|      1.Schedules             |  ");
        System.out.println("|      2.Add Group             |  ");
        System.out.println("|      3.Add Child To Group    |  ");
        System.out.println("|      4.Delete Group          |  ");
        System.out.println("|      5.Display Groups        |  ");
        System.out.println("|      6.Back                  |  ");
        System.out.println("|______________________________|   ");
        System.out.println("        Select choice...        ");

        int choice = console.nextInt();
        while (!menuSwitcher) {
            switch (choice) {
                case 1:
                    scheduleMenu();
                    menuSwitcher = true;
                    break;
                case 2:
                    createGroup();
                    menuSwitcher = true;
                    break;
                case 3:
                    addChildrenToGroup();
                    menuSwitcher = true;
                    break;
                case 4:
                    deleteGroup();
                    menuSwitcher = true;
                    break;
                case 5:
                    displayGroups();
                    menuSwitcher = true;
                    break;
                case 6:
                    adminMenu();
                    menuSwitcher = true;
                    break;
            }
            System.out.println("");
            groupsMenu();
        }

    }

    public void createGroup(){
        App.getController().createGroup();
    }
    public void deleteGroup(){
        App.getController().deleteGroup();
    }
    public void displayGroups(){
        App.getController().displayGroups();
    }
    public static void addChildrenToGroup() {App.getController().addChildrenToGroup();}
    // Schedule Menu method and all functions it provides
    public  void scheduleMenu()
    {
        boolean menuSwitcher=false;
        System.out.println(" ________________________________");
        System.out.println("|         Roskilde               |    ");
        System.out.println("|     _______________________    |   ");
        System.out.println("|         Daycare                |  " );
        System.out.println("|________________________________|  \n" +
                           "|   Schedule Management Menu     |");
        System.out.println("|________________________________|   ");
        System.out.println("|      1.Display Activities      |  ");
        System.out.println("|      2.Add Activity To Schedule|  ");
        System.out.println("|      3.Create Schedule         |  ");
        System.out.println("|      4.Delete Schedule         |  ");
        System.out.println("|      5.Display Schedules       |  ");
        System.out.println("|      6.Back                    |  ");
        System.out.println("|________________________________|   ");
        System.out.println("        Select choice...        ");

        int choice=console.nextInt();
        while (!menuSwitcher) {
            switch (choice) {
                case 1:
                    activitiesMenu();
                    menuSwitcher = true;
                    break;
                case 2:
                    addActivityToSchedule();
                    menuSwitcher = true;
                    break;
                case 3:
                    createSchedule();
                    menuSwitcher = true;
                    break;
                case 4:
                    deleteSchedule();
                    menuSwitcher=true;
                    break;
                case 5:
                    displaySchedule();
                    menuSwitcher=true;
                    break;
                case 6:
                    groupsMenu();
                    menuSwitcher=true;
                    break;
            }
            System.out.println("");
            scheduleMenu();
        }
    }
    public void createSchedule(){
        App.getController().createSchedule();
    }
    public void displaySchedule() {
        App.getController().displaySchedule();
    }
    public void deleteSchedule() {
        App.getController().deleteSchedule();
    }
    public static void addActivityToSchedule() {App.getController().addActivityToSchedule();}

   //Activities Menu method and all functions it provides
    public void activitiesMenu() {
        boolean menuSwitcher = false;
        System.out.println(" ______________________________");
        System.out.println("|         Roskilde             |    ");
        System.out.println("|     _______________________  |   ");
        System.out.println("|         Daycare              |  ");
        System.out.println("|______________________________|  \n" +
                           "|        Activities Menu       |");
        System.out.println("|______________________________|   ");
        System.out.println("|      1.Create Activity       |  ");
        System.out.println("|      2.Display Activities    |  ");
        System.out.println("|      3.Back                  |  ");
        System.out.println("|______________________________|   ");
        System.out.println("        Select choice...        ");

        int choice = console.nextInt();
        while (!menuSwitcher) {
            switch (choice) {
                case 1:
                    createActivity();
                    menuSwitcher = true;
                    break;
                case 2:
                    displayAcitivties();
                    menuSwitcher = true;
                    break;
                case 3:
                    scheduleMenu();
                    menuSwitcher = true;
                    break;
            }
            System.out.println("");
            activitiesMenu();
        }
    }
    public void createActivity(){
        App.getController().createActivity();
    }

    public void displayAcitivties() {
        App.getController().displayAcitivties();
    }
    //waiting list method menu
    public void waitingListMenu() {
        boolean menuSwitcher = false;
        System.out.println(" ______________________________");
        System.out.println("|         Roskilde             |    ");
        System.out.println("|     _______________________  |   ");
        System.out.println("|         Daycare              |  ");
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
                    break;
                case 2:
                    deleteRecordInWaitingList();
                    menuSwitcher = true;
                    break;
                case 3:
                    System.out.println("|______________________________|   ");
                    System.out.println("| What do you want to display  |\n" +
                                       "  (1)All OR (2)One instance? ");
                    int displayChoice=console.nextInt();
                    if(displayChoice==1)
                    {
                        displayWaitingList();
                    }
                    else if(displayChoice==2)
                    {
                        displayRowFromWaitingList();
                    }
                    else
                    {
                        System.out.println("You have entered an invalid choice try again!");
                    }
                    menuSwitcher = true;
                    break;
                case 4:
                    adminMenu();
                    menuSwitcher = true;
                    break;
            }
            System.out.println("");
            waitingListMenu();
        }
    }
    public void createRecordInWaitingList(){
        App.getController().createRecordInWaitingList();
    }
    public void deleteRecordInWaitingList(){
        App.getController().deleteRecordInWaitingList();
    }
    public void displayWaitingList(){ App.getController().displayWaitingList(); }
    public void displayRowFromWaitingList(){ App.getController().displayRowFromWaitingList(); }

    //payment method menu
    public void paymentManagement() {
        boolean menuSwitcher = false;
        System.out.println(" ______________________________");
        System.out.println("|         Roskilde             |    ");
        System.out.println("|     _______________________  |   ");
        System.out.println("|         Daycare              |  ");
        System.out.println("|______________________________|  \n" +
                           "|         Payment Menu         |");
        System.out.println("|______________________________|   ");
        System.out.println("|     1.Create Invoice         |  ");
        System.out.println("|     2.Delete Invoice         |  ");
        System.out.println("|     3.Display Invoice        |  ");
        System.out.println("|     4.Back                   |");
        System.out.println("|______________________________|   ");
        System.out.println("        Select choice...        ");

        int choice = console.nextInt();
        while (!menuSwitcher) {
            switch (choice) {
                case 1:
                    createInvoice();
                    menuSwitcher = true;
                    break;
                case 2:
                    deleteInvoice();
                    menuSwitcher = true;
                    break;
                case 3:
                    displayInvoicesList();
                    menuSwitcher = true;
                    break;
                case 4:
                    adminMenu();
                    menuSwitcher = true;
                    break;
            }
            System.out.println("");
            paymentManagement();
        }
    }
    public void createInvoice() {
        App.getController().createInvoice();
    }
    public void deleteInvoice(){
        App.getController().deleteInvoice();
    }
    public void displayInvoicesList(){
        App.getController().displayInvoicesList();
    }


    // SELECT ALL QUERY

    //Menu method for the appointments database and functions you can use there
    public void appointmentsDatabaseMenu() {
        boolean menuSwitcher = false;
        System.out.println(" ______________________________");
        System.out.println("|         Roskilde             |    ");
        System.out.println("|     _______________________  |   ");
        System.out.println("|         Daycare              |  ");
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
                    break;
                case 2:
                    deleteAppointment();
                    menuSwitcher = true;
                    break;
                case 3:

                System.out.println("|______________________________|   ");
                System.out.println("| What do you want to display  |" +
                                    "  (1)All OR (2) FOR SPECIFIC TEACHER? ?  ");
                int displayChoice=console.nextInt();
                if(displayChoice==1)
                {
                    displayAppointmentList();
                }
                else if(displayChoice==2)
                {
                    System.out.println("Enter Teacher ID");
                    displayRowFromAppointmentList();
                }
                else
                {
                    System.out.println("You have entered an invalid choice try again!");
                }
                    menuSwitcher = true;
                    break;
                case 4:
                    adminMenu();
                    menuSwitcher = true;
                    break;
            }
            System.out.println("");
            appointmentsDatabaseMenu();
        }

    }
    public void createAppointment(){
        App.getController().createAppointment();
    }
    public void deleteAppointment(){
        App.getController().deleteAppointment();
    }
    public void displayAppointmentList(){
        App.getController().displayAppointmentList();
    }
    public void displayRowFromAppointmentList(){
        App.getController().displayRowFromAppointmentList();
    }

}
