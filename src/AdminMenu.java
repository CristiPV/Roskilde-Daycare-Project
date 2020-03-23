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
        System.out.println("|              Daycare         |  ");
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
        System.out.println("|              Daycare         |  " );
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
                    menuSwitcher = true;
                    break;
                case 2:
                    menuSwitcher = true;
                    break;
                case 3:
                    menuSwitcher = true;
                    break;
                case 4:
                    System.out.println("|______________________________|   ");
                    System.out.println("| What do you want to display  |" +
                            "  (1)All OR (2)One instance?  ");
                    int displayChoice = console.nextInt();
                    if (displayChoice == 1) {

                    } else if (displayChoice == 2) {

                        System.out.println("Enter ID Or Name probably....");
                    } else {
                        System.out.println("You have entered an invalid choice try again!");
                        childrenMenu();
                    }
                    menuSwitcher = true;
                    break;
                case 5:
                    adminMenu();
                    menuSwitcher = true;
                    break;
            }
        }
    }
    //Teacher information menu and all the functions it provides
    public void teacherInfoMenu()
    {
        boolean menuSwitcher=false;
        System.out.println(" ______________________________");
        System.out.println("|         Roskilde             |    ");
        System.out.println("|     _______________________  |   ");
        System.out.println("|              Daycare         |  " );
        System.out.println("|______________________________|  \n" +
                           "|    Teacher Management Menu   |");
        System.out.println("|______________________________|   ");
        System.out.println("|    1.Add Teacher in System   |  ");
        System.out.println("|    2.Remove Teacher in System|  ");
        System.out.println("|    3.Display Children        |  ");
        System.out.println("|    4.Back                    |  ");
        System.out.println("|______________________________|   ");
        System.out.println("        Select choice...        ");

        int choice=console.nextInt();
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
                    System.out.println("|______________________________|   ");
                    System.out.println("| What do you want to display  |" +
                            "  (1)All OR (2)One instance?  ");
                    int displayChoice = console.nextInt();
                    if (displayChoice == 1) {

                    } else if (displayChoice == 2) {
                        System.out.println("Enter ID Or Name probably....");
                    } else {
                        System.out.println("You have entered an invalid choice try again!");
                        teacherInfoMenu();
                    }
                    menuSwitcher = true;
                    break;
                case 5:
                    adminMenu();
                    menuSwitcher = true;
                    break;
            }
        }

    }
   public void parentsMenu()
   {
       boolean menuSwitcher=false;
       System.out.println(" ______________________________");
       System.out.println("|         Roskilde             |    ");
       System.out.println("|     _______________________  |   ");
       System.out.println("|              Daycare         |  " );
       System.out.println("|______________________________|  \n" +
                          "|   Parents Management Menu    |");
       System.out.println("|______________________________|   ");
       System.out.println("|     1.Phone list             |  ");
       System.out.println("|     2.Add Parent in System   |  ");
       System.out.println("|     3.Remove Parent in System|  ");
       System.out.println("|     4.Display Parents        |  ");
       System.out.println("|     5.Back                   |  ");
       System.out.println("|______________________________|   ");
       System.out.println("        Select choice...        ");

       int choice=console.nextInt();
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
                   System.out.println("|______________________________|   ");
                   System.out.println("| What do you want to display  |" +
                           "  (1)All OR (2)One instance?  ");
                   int displayChoice = console.nextInt();
                   if (displayChoice == 1) {

                   } else if (displayChoice == 2) {

                       System.out.println("Enter ID Or Name probably....");
                   } else {
                       System.out.println("You have entered an invalid choice try again!");
                       parentsMenu();
                   }
                   menuSwitcher = true;
                   break;
               case 5:
                   adminMenu();
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
        System.out.println("|      1.Schedules             |  ");
        System.out.println("|      2.Add Group             |  ");
        System.out.println("|      3.Delete Group          |  ");
        System.out.println("|      4.Display Groups        |  ");
        System.out.println("|      5.Back                  |  ");
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
                    menuSwitcher = true;
                    break;
                case 3:
                    menuSwitcher = true;
                    break;
                case 4:
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
                case 5:
                    adminMenu();
                    menuSwitcher = true;
                    break;
            }
        }

    }
    // Schedule Menu method and all functions it provides
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
        System.out.println("|      1.Activities            |  ");
        System.out.println("|      2.Create Schedule       |  ");
        System.out.println("|      3.Delete Schedule       |  ");
        System.out.println("|      4.Display Schedules     |  ");
        System.out.println("|      5.Back                  |  ");
        System.out.println("|______________________________|   ");
        System.out.println("        Select choice...        ");

        int choice=console.nextInt();
        while (!menuSwitcher) {
            switch (choice) {
                case 1:
                    activitiesMenu();
                    menuSwitcher = true;
                    break;
                case 2:
                    menuSwitcher = true;
                    break;
                case 3:
                    menuSwitcher=true;
                    break;
                case 4:
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
                        scheduleMenu();
                    }
                    menuSwitcher=true;
                    break;
                case 5:
                    groupsMenu();
                    menuSwitcher=true;
                    break;
            }
        }

    }
   //Activities Menu method and all functions it provides
    public void activitiesMenu() {
        boolean menuSwitcher = false;
        System.out.println(" ______________________________");
        System.out.println("|         Roskilde             |    ");
        System.out.println("|     _______________________  |   ");
        System.out.println("|              Daycare         |  ");
        System.out.println("|______________________________|  \n" +
                           "|        Activities Menu       |");
        System.out.println("|______________________________|   ");
        System.out.println("|      1.Create Activity     |  ");
        System.out.println("|      2.Delete Activity     |  ");
        System.out.println("|      3.Display Activities    |  ");
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
                    int displayChoice = console.nextInt();
                    if (displayChoice == 1) {

                    } else if (displayChoice == 2) {

                        System.out.println("Enter ID Or Name probably....");
                    } else {
                        System.out.println("You have entered an invalid choice try again!");
                        activitiesMenu();
                    }
                    menuSwitcher = true;
                    break;
                case 4:
                    scheduleMenu();
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
                        paymentManagement();
                    }
                    menuSwitcher = true;
                    break;
                case 4:
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
                    adminMenu();
                    menuSwitcher = true;
                    break;
            }
        }

    }

}
