import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;
import java.util.SplittableRandom;

public class Service {
    static Scanner scanner = new Scanner(System.in);

    public Service() {
    }

    public void createChild(  ){ //works
        //code to to insert data to sql database
        // Insert Query
        System.out.println("Enter first name : ");
        String firstName = scanner.next();
        System.out.println("Enter last name : ");
        String lastName = scanner.next();
        System.out.println("Enter birth day (YYYY-MM-DD) : ");
        String birth_date = scanner.next();
        System.out.println("Enter sex : ");
        String sex = scanner.next();
        System.out.println("Enter age : ");
        String age = scanner.next();
        System.out.println("Enter joining date (YYYY-MM-DD) : ");
        String joinedDate = scanner.next();
        System.out.println("Enter parent ID : ");
        int parentID = scanner.nextInt();
        System.out.println("Do you want to confirm this addition to the database?\n"+
                "Name: "+firstName+"|Family: "+lastName+"|Birthday: "+birth_date+"|Sex: "+sex+"|Age: "+age+
                "|Joining date: "+joinedDate+"|Parent ID: "+parentID+
                "\n (1).Yes/ (2).No");
        int confirmation=scanner.nextInt();
        if(confirmation==1) {
            System.out.println("You added a child to the system.");
            DBConnection.executeQuery("INSERT INTO child(first_name, last_name, birth_date, sex, age, joined_date, parent_id) VALUES\n" +
                    "(\"" + firstName + "\", \"" + lastName + "\", \"" + birth_date + "\", \"" + sex + "\", " +
                    age + ", \"" + joinedDate + "\", " + parentID + ");");
        }
        else if(confirmation==2)
        {
            System.out.println("Canceling creation.....");
        }
        else
        {
            System.out.println("Wrong input....**CANCELING CREATION** ");
        }
    }
    public void deleteChild(){
        System.out.println("Select child : ");
        int id = scanner.nextInt();

        //program gets parent_id from table child on condition that child_id equals to inputed child_id
        ResultSet pid = DBConnection.sendQuery("SELECT parent_id FROM child\n" +
                "WHERE child_id = " + id + ";");

        //program gets attributes from child table if child_id equals to inputed child_id
        ResultSet cC= DBConnection.sendQuery("SELECT * FROM child WHERE child_id="+id+";");
            try {
                cC.next(); //progra gets next row from cC result set

                //program prints information about child from row from cC result set
                System.out.println("Do you want to confirm this deletion from the database?");
                System.out.println("ID"+cC.getString("child_id")+"|Name: "+cC.getString("first_name")+
                        "|Family: "+cC.getString("last_name")+"|Birthday: "+cC.getString("birth_date")+
                        "|Sex: "+cC.getString("sex")+"|Age: "+cC.getString("age")+"|Joined Date: "+cC.getString("joined_date")+
                        "|Group ID: "+cC.getString("group_id")+"|Parent ID: "+cC.getString("parent_id")+
                        "    \n   (1).Yes/(2).No      ");
               int confirmation=scanner.nextInt();
                if(confirmation==1) {
                    pid.next(); //get next row from pid result set

                    //gets parent_if from pid result set and assigned it to variable
                    String parentID = pid.getString("parent_id");

                    //counts children for parent whose parent_id matches parent_id from pid result set
                    ResultSet rs = DBConnection.sendQuery("SELECT COUNT(child_id) AS count FROM child\n" +
                            "WHERE parent_id = " + parentID + ";");

                    rs.next(); //next row from rs result set

                    // checks if the parent has any more children than the one we are about to delete
                    if (rs.getInt("count") == 1) {

                        // deletes the telephone list entries related to the parent
                        DBConnection.executeQuery("DELETE FROM telephone_list\n" +
                                "WHERE parent_id = " + parentID + ";");

                        // deletes the parent
                        DBConnection.executeQuery("DELETE FROM parent\n" +
                                "WHERE parent_id = " + parentID + ";");
                    }
                    //deletes the child
                    DBConnection.executeQuery("DELETE FROM child\n" +
                            "WHERE child_id = " + id + ";");
                    System.out.println("You removed the child from the system.");
                }
              else if(confirmation==2)
                {
                    System.out.println("Canceling Deletion...");
                }
                else
                {
                    System.out.println("Wrong input...*CANCELING DELETION*");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }


    public void displayChildList(){
        // select all from child + join with parent first & last name
        ResultSet rs = DBConnection.sendQuery("SELECT child.child_id, child.first_name, child.last_name," +
                " parent.first_name AS \"parent_first_name\"," +
                " parent.last_name AS \"parent_Last_name\"\n" +
                                                "FROM child\n" +
                                                "JOIN parent\n" +
                                                "ON child.parent_id = parent.parent_id\n" +
                                                 "ORDER BY child.child_id;");
        try {
            while (rs.next()) {
                System.out.println("ID : " + rs.getString("child.child_id") + " | " +
                                    "Name : " + rs.getString("child.first_name") + " " + rs.getString("child.last_name") + " | " +
                                    "Parent Name : " + rs.getString("parent.parent_first_name") + " " + rs.getString("parent.parent_Last_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void createParent(){ //works
        //code to to insert data to sql database
        // Insert Query
        // Adds the parent into the DB
        System.out.println("Enter first name : ");
        String firstName = scanner.next();
        System.out.println("Enter last name : ");
        String lastName = scanner.next();
        System.out.println("Enter birth day : ");
        String birth_date = scanner.next();
        System.out.println("Enter sex : ");
        String sex = scanner.next();
        System.out.println("Enter phone number : ");
        String phoneNo = scanner.next();
        System.out.println("Enter alternate phone number (If none, enter 0) : ");
        String phoneNoAlt = scanner.next();
        System.out.println("Do you want to confirm this addition to the database?\n"+
                "Name: "+firstName+"|Family: "+lastName+"|Birthday: "+birth_date+"|Sex: "+sex+"|Phone number: "+phoneNo+
                "|Phone number ALT:  "+phoneNoAlt+
                "\n (1).Yes/ (2).No");
        int confirmation=scanner.nextInt();
        if(confirmation==1) {
            DBConnection.executeQuery("INSERT INTO parent(first_name, last_name, birth_date, sex) VALUES (\"" + firstName + "\", \"" + lastName +
                    "\", \"" + birth_date + "\", \"" + sex + "\");");

            // Finds the parent and retrieves the ID
            ResultSet rs = DBConnection.sendQuery("SELECT parent_id FROM parent\n" +
                    "WHERE first_name = \"" + firstName + "\" AND last_name = \"" + lastName + "\";");
            String parentID = "";
            try {
                rs.next();
                parentID = rs.getString("parent_id");
            } catch (SQLException e) {
                e.printStackTrace();
            }

            // Adds the main phone no in the DB
            DBConnection.executeQuery("INSERT INTO telephone_list VALUES (\"" + phoneNo + "\", " + parentID + ");");

            // Adds the alternate phone no ( if exsists ) in the DB
            if (phoneNoAlt.length() == 8) {
                DBConnection.executeQuery("INSERT INTO telephone_list VALUES (\"" + phoneNoAlt + "\", " + parentID + ");");
            }
        }
        else if(confirmation==2)
        {
            System.out.println("Canceling creation...");
        }
        else
        {
            System.out.println("Wrong input...**CANCELING CREATION**");
        }
        System.out.println("You added a parent to the system.");
    }
    public void displayParentList(){
        // program gets attributes from parent table and joins them with phone_number attribute from telephone_list table
        //if parent_id in both tables match and orders the result set by parent_id
        ResultSet rs = DBConnection.sendQuery("SELECT *, telephone_list.phone_number\n" +
                "FROM parent\n" +
                "JOIN telephone_list\n" +
                "ON parent.parent_id = telephone_list.parent_id\n" +
                "ORDER BY parent.parent_id;");
        try {
            String lastID = "";
            while (rs.next()){ //program gets row from rs result set
                if (rs.getString("parent_id").equals(lastID)) {
                    System.out.print(", " + rs.getString("telephone_list.phone_number"));
                }
                else {
                    System.out.println();
                    System.out.println("ID : " + rs.getString("parent_id") + " | Name : " + rs.getString("first_name") + " " + rs.getString("last_name") +
                            " | Birth Date : " + rs.getString("birth_date") + " | Sex : " + rs.getString("sex"));
                    System.out.print("Phone Number : " + rs.getString("telephone_list.phone_number"));
                }
                lastID = rs.getString("parent_id");
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

    }
    public void displayOneParent( ){
        System.out.println("Select parent : ");
        int id = scanner.nextInt();
        // program gets attributes from parent table and phone number from telephone_list table
        //it joins tables based on parent_id
        ResultSet rs = DBConnection.sendQuery("SELECT *, telephone_list.phone_number\n" +
                "FROM parent\n" +
                "JOIN telephone_list\n" +
                "ON parent.parent_id = telephone_list.parent_id\n" +
                "WHERE parent.parent_id =  " + id + ";");
        try {
            rs.next(); //program takes a row from result set
            //program prints specified information from the row
            System.out.println("ID : " + rs.getString("parent_id") + " | Name : " + rs.getString("first_name")
                    + rs.getString("last_name") +
                    " | Birth Date : " + rs.getString("birth_date") + " | Sex : " + rs.getString("sex"));
            System.out.print("Phone Number : " + rs.getString("telephone_list.phone_number"));
            while (rs.next()) { //if next line exist it add after comma next phone number belonging to the parent
                System.out.print(", " + rs.getString("telephone_list.phone_number"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void createTeacher() {
        System.out.println("Enter first name : ");
        String firstName = scanner.next();
        System.out.println("Enter last name : ");
        String lastName = scanner.next();
        System.out.println("Enter birth day (YYYY-MM-DD) : ");
        String birth_date = scanner.next();
        System.out.println("Enter sex (F/M) : ");
        String sex = scanner.next();
        System.out.println("Enter salary : ");
        int salary = scanner.nextInt();
        System.out.println("Enter group ID : ");
        int group_id = scanner.nextInt();
        System.out.println("Do you want to confirm this addition to the database?\n" +
                "|Name: " + firstName + "|Family: " + lastName + "|Birthday: " + birth_date + "|Sex: " + sex +
                "|Salary: " + salary + "|Group ID: " + group_id +
                "\n   (1).Yes/(2).No");
        int confirmation=scanner.nextInt();
        if (confirmation == 1) {
            //insert inputed data into scpecified columns in table teacher in database
            DBConnection.executeQuery("INSERT INTO teacher (first_name, last_name, birth_date, sex," +
                    " salary, group_id, super_id) VALUES\n" +
                    "(\"" + firstName + "\", \"" + lastName + "\", \"" + birth_date + "\", \"" + sex + "\", "
                    + salary + ", " + group_id + ", " + 101 + ");");
            System.out.println("You created a teacher in the system.");
            //method which creates user teacher in the system (grant access, creates login and password)
            createUser (firstName,lastName);
        }
        else if(confirmation==2)
        {
            System.out.println("Canceling creation...");
        }
        else
        {
            System.out.println("Wrong input...**CANCELING CREATION**");
        }

    }
    public void deleteTeacher(){ // works
        //code to to delete data from sql database
        // delete teacher and associated appointments
        System.out.println("Enter teacher ID : ");
        int teacher_id = scanner.nextInt();
        ResultSet rs= DBConnection.sendQuery("SELECT * FROM teacher WHERE teacher_id="+teacher_id);
        System.out.println("Do you want to delete this teacher from the database");
        try {

            System.out.println("ID: "+rs.getString("teacher_id")+"|Name: "+rs.getString("first_name")+
                    "|Family" + rs.getString("last_name")+"|Birthday: "+rs.getString("birth_date")+
                    "|Sex"+rs.getString("sex")+"|Salary"+rs.getString("salary")+"|Group ID: "+rs.getString("group_id")+
                    "\n (1).Yes/(2).No");
        }
        catch(SQLException e)
            {
                e.printStackTrace();
            }
        int confirmation=scanner.nextInt();

        if(confirmation==1) {
            DBConnection.executeQuery("DELETE FROM appointment WHERE teacher_id = " + teacher_id + ";");
            DBConnection.executeQuery("DELETE FROM teacher WHERE teacher_id = " + teacher_id + ";");

            System.out.println("You deleted a teacher from the system.");
            new AdminMenu();
        }
        else if(confirmation==2)
        {
            System.out.println("Canceling deletion...");
        }
        else
        {
            System.out.println("Wrong input...**CANCELING DELETION** ");
        }
    }
    public void displayTeacherList(){ //works
        //code to to select data from sql database
        // select all from teacher
        ResultSet rs=DBConnection.sendQuery("SELECT * FROM teacher");
        try {
            while(rs.next())
            {
                System.out.println("ID: "+rs.getString("teacher_id")+
                        "|First Name: "+rs.getString("first_name")+
                        "|Last Name: "+rs.getString("last_name")+
                        "|Birthday: "+rs.getString("birth_date")+
                        "|Sex: "+rs.getString("sex")+
                        "|Salary: "+rs.getString("salary")+
                        "|Group ID: "+rs.getString("group_id"));
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();

        }
    }
    public void createAppointment(){ //works
        //code to to insert data to sql database
        // create an appointment and delete the waiting_list entry for the corresponding child
        System.out.println("Enter appointment date (YYYY-MM-DD) : ");
        String date = scanner.next();
        System.out.println("Enter appointment time (HHMM) : ");
        int time = scanner.nextInt();
        System.out.println("Enter child ID : ");
        int child_id = scanner.nextInt();
        System.out.println("Enter teacher ID : ");
        int teacher_id = scanner.nextInt();
        System.out.println("Do you want to confirm this addition to the database?\n"+
                "Date: "+date+"|Time: "+time+"|Child ID: "+child_id+"Teacher ID: "+teacher_id+
                "\n (1).Yes/(2).No   ");
        int confirmation=scanner.nextInt();
        if(confirmation==1) {
            DBConnection.executeQuery("INSERT INTO appointment (date, time, child_id, teacher_id) VALUES\n" +
                    "(\"" + date + "\"," + time + "," + child_id + "," + teacher_id + ");");

            System.out.println("You created an appointment in the system.");

            DBConnection.executeQuery("DELETE FROM waiting_list WHERE child_id = " + child_id + ";");
        }
        else if(confirmation==2)
        {
            System.out.println("Canceling creation...");
        }
        else
        {
            System.out.println("Wrong input...**CANCELING CREATION**");
        }
    }
    public void deleteAppointment() { //check if works
        //code to to delete data from sql database
        // delete appointment
        System.out.println("Enter an appointmnt ID : ");
        int appointment_id = scanner.nextInt();
        ResultSet rs = DBConnection.sendQuery("SELECT * FROM appointment WHERE appointment_id=" + appointment_id);
        try {
            rs.next();
            System.out.println("Do you want to confirm this deletion from the database?\n" +
                    "ID: " + rs.getString("appointment_id") + "|Date: " + rs.getString("date") +
                    "|Time: " + rs.getString("time") + "|Child ID: " + rs.getString("child_id") +
                    "|Teacher ID: " + rs.getString("teacher_id") +
                    "\n (1).Yes/(2).No");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int confirmation = scanner.nextInt();
        if (confirmation == 1) {
            DBConnection.executeQuery("DELETE FROM appointment WHERE appointment_id = " + appointment_id + ";");

            System.out.println("You deleted an appointment in the system.");
        }
        else if(confirmation==2){
            System.out.println("Canceling Deletion");
        }
            else
        {
            System.out.println("Wrong input....**CANCELING DELETION**");
        }
    }
    public void displayAppointmentList(){ //works
        //code to to select data from sql database
        // select all from appointment + join with teacher name + child name + parent name
        ResultSet rs = DBConnection.sendQuery("SELECT  appointment.*, teacher.first_name AS teacher_first_name, teacher.last_name AS teacher_last_name, \n" +
                "child.first_name AS child_first_name, parent.first_name AS parent_first_name, parent.last_name AS parent_last_name\n" +
                "FROM appointment\n" +
                "JOIN teacher\n" +
                "ON appointment.teacher_id = teacher.teacher_id\n" +
                "JOIN child\n" +
                "ON appointment.child_id = child.child_id\n" +
                "JOIN parent\n" +
                "ON child.parent_id = parent.parent_id;");
        try {
            while (rs.next()) {
                System.out.println("ID : " + rs.getString("appointment.appointment_id") + " | Date : " + rs.getString("appointment.date") + " | Time : " +
                        rs.getString("appointment.time") + " | Child ID : " + rs.getString("appointment.child_id") + " | Teacher ID :" +
                        rs.getString("appointment.teacher_id") + " | Teacher Name : " + rs.getString("teacher_first_name") + " " + rs.getString("teacher_last_name") +
                        " | Child Name : " + rs.getString("child_first_name") + " | Parent Name : " + rs.getString("parent_first_name") + rs.getString("parent_last_name"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
    public static void displayRowFromAppointmentList(){ // works
        // select all from appointment for a given teacher id
        int teacher_id = scanner.nextInt();

        ResultSet rs = DBConnection.sendQuery("SELECT * FROM  appointment WHERE teacher_id =" + teacher_id + ";");
        try
        {
            while (rs.next())
            {
                // ResultSet has rows with columns accessible by using the column name
                System.out.println("ID: " + rs.getString("appointment_id") + " | " +
                        "Date: " + rs.getString("date") + " | "+ "Time: " + rs.getString("time") + " | " +
                        "Child ID: " + rs.getString("child_id") + " | " +
                        "Teacher ID: " + rs.getString("teacher_id") );
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }

    }
    public void createRecordInWaitingList() {
        //code to to insert data to sql database
        // insert query
        System.out.println("Enter today's date: ");
        String dateAdded = scanner.next();
        System.out.println("Enter reason for adding: ");
        String reason = scanner.next();
        System.out.println("Enter child ID: (if none: enter -1)");
        String child_id = scanner.next();
        System.out.println("Do you want to confirm this addition to the database?\n" + "Date Added: "+dateAdded+"|Reason: "+reason+"Child ID: "+child_id+
                "\n (1).Yes/(2).No");
        int confirmation=scanner.nextInt();
        if(confirmation==1) {
        DBConnection.executeQuery("INSERT INTO waiting_list(date_added,reason,child_id) \n" +
                "VALUES(\"" + dateAdded + "\", \"" + reason + "\"," + child_id + ");");
    }
           else if(confirmation==2)
        {
            System.out.println("Canceling creation...");
        }
        else
        {
            System.out.println("Wrong input...**CANCELING CREATION**");
        }
    }
    public void deleteRecordInWaitingList(){
        //code to to delete data from sql database
        // delete query
        System.out.println("Enter Child ID to Delete: ");
        int child_id=scanner.nextInt();
        System.out.println("Do you want to confirm this deletion to the database?\n (1).Yes/(2).No");
        ResultSet rs=DBConnection.sendQuery("SELECT * FROM waiting_list WHERE child_id="+child_id);
        int confirmation = scanner.nextInt();
        if(confirmation==1) {
            try {
                rs.next();
                System.out.println("Entry ID: " + rs.getString("entry_id") + "|Date Added: " + rs.getString("date_added") +
                        "|Reason: " + rs.getString("reason") + "|Child ID" + rs.getString("child_id"));
            } catch (SQLException e) {
                e.printStackTrace();
            }
            DBConnection.executeQuery("DELETE FROM waiting_list WHERE child_id=" + child_id);
            System.out.println("You deleted a record from the waiting list.");
        }
        else if(confirmation==2){System.out.println("Canceling deletion");}
        else{System.out.println("Wrong input..**CANCELING DELETION**");}
    }
    public void displayWaitingList(){ // works
        //code to to select data from sql database
        // select all + join with child name + parent name
        ResultSet rs = DBConnection.sendQuery("SELECT waiting_list.*, child.first_name AS child_first_name, parent.first_name AS parent_first_name, parent.last_name AS parent_last_name\n" +
                "FROM waiting_list\n" +
                "JOIN child\n" +
                "ON waiting_list.child_id = child.child_id\n" +
                "JOIN parent\n" +
                "ON child.parent_id = parent.parent_id;");
        try {
            while ( rs.next() ) {
                System.out.println("ID : " + rs.getString("entry_id") + " | Date : " + rs.getString("date_added") +
                        " | Reason : " + rs.getString("reason") + " | Child ID : " + rs.getString("child_id") +
                        " | Child Name : " + rs.getString("child_first_name") + " | Parent name : " + rs.getString("parent_first_name")
                        + " " + rs.getString("parent_last_name"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void displayRowFromWaitingList() {
        // select all from waiting_list for a given child id
        //code
        System.out.println("Enter child Id to show: ");
        int child_id = scanner.nextInt();
        ResultSet rs = DBConnection.sendQuery("SELECT waiting_list.*,child.first_name,child.last_name " +
                "FROM waiting_list " +
                "JOIN child " +
                "On waiting_list.child_id=child.child_id " +
                "WHERE waiting_list.child_id=" + child_id +";");
        try {
            while (rs.next()) {
                // ResultSet has rows with columns accessible by using the column name
                System.out.println("ID: " + rs.getString("entry_id") +
                        "|First Name: " + rs.getString("first_name") +
                        "|Last Name: " + rs.getString("last_name") +
                        "|Date Added: " + rs.getString("date_added") +
                        "|Reason: " + rs.getString("reason"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void createSchedule() { //check if works
        //code to to insert data to sql database
        // insert query
        System.out.println("Enter number of nap hours daily : ");
        int nap_hours_daily = scanner.nextInt();
        System.out.println("Enter number of activity hours weekly : ");
        int activity_hours_weekly = scanner.nextInt();
        System.out.println("Do you want to confirm this addition to the database?\n" +
                "Nap hours: " + nap_hours_daily + "|Activity hours weekly" + activity_hours_weekly +
                "\n (1).Yes/(2).No");
        int confirmation = scanner.nextInt();
        if (confirmation == 1) {
            DBConnection.executeQuery("INSERT INTO schedule(nr_activities, nap_hrs_daily, activity_hrs_weekly)\n" +
                    "                  VALUES (" + 0 + "," + nap_hours_daily + ", " + activity_hours_weekly + ");");
            System.out.println("You added a schedule to the system.");
        }
        else if(confirmation==2)
        {
            System.out.println("Canceling creation...");
        }
        else
        {
            System.out.println("Wrong input...**CANCELING CREATION**");
        }
    }
    public void deleteSchedule() { //fix if in the group
        //code to to delete data from sql database
        // entries in schedule_has_activity
        System.out.println("Enter schedule ID : ");
        int schedule_id = scanner.nextInt();
        System.out.println("Do you want to confirm this deletion to the database?\n (1).Yes/(2).No");
        ResultSet rs =DBConnection.sendQuery("SELECT * FROM schedule WHERE schedule_id="+schedule_id);
        int confirmation = scanner.nextInt();

        if(confirmation==1) {
            try {
                rs.next();
                System.out.println("Schedule ID: "+rs.getString("schedule_id")
                        +"|Number of activities: "+rs.getString("|#_activities")
                        +"|Nap hours daily:"+rs.getString("nap_hrs_daily")+"|Activity Hrs weekly: "+rs.getString("activity_hrs_weekly"));

                DBConnection.executeQuery("DELETE FROM schedule_has_activity WHERE schedule_has_activity.schedule_id = " + schedule_id + ";");
                DBConnection.executeQuery("DELETE FROM schedule WHERE schedule.schedule_id = " + schedule_id + ";");
                System.out.println("You deleted a schedule from the system.");
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
        else if(confirmation==2){System.out.println("Canceling deletion");}
        else{System.out.println("Wrong input..**CANCELING DELETION**");}
    }
    public void displaySchedule(){ //works
        //code to to select data from sql database
        // select all from schedule + activities that it has
        ResultSet rs = DBConnection.sendQuery("SELECT schedule.schedule_id, schedule.nap_hrs_daily, schedule.activity_hrs_weekly, activity.name\n"+
                "FROM  schedule\n" +
                "JOIN schedule_has_activity \n" +
                "ON schedule.schedule_id = schedule_has_activity.schedule_id\n"+
                "JOIN activity\n" +
                "ON schedule_has_activity.activity_id = activity.activity_id;");
        try
        {
            while (rs.next())
            {
                // ResultSet has rows with columns accessible by using the column name
                System.out.println("ID: " + rs.getString("schedule.schedule_id") + " | "+ "Nap hours daily: " + rs.getString("schedule.nap_hrs_daily") + " | " +
                        "Activity hours weekly: " + rs.getString("schedule.activity_hrs_weekly") + " | " +
                        "Activity: " + rs.getString("activity.name") );
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    public void createActivity(){
        //code to to insert data to sql database
        // insert query
        System.out.println("Enter name of activity:");
        String name = scanner.next();
        System.out.println("Enter short description of activity:");
        String desc = scanner.next() + scanner.nextLine();
        System.out.println("Do you want to confirm this addition to the database?\n" +
                "Name: "+name+"|Description: "+desc+"\n (1).Yes/(2).No ");
        int confirmation = scanner.nextInt();
        if (confirmation == 1) {
            DBConnection.executeQuery("INSERT INTO activity(activity.name, activity.desc) VALUES (\"" + name + "\", \"" + desc + "\");");
            System.out.println("You added an activity to the system.");
        }
        else if(confirmation==2){System.out.println("Canceling creation");}
        else{System.out.println("Wrong input..**CANCELING CREATION**");}
    }
    public void displayAcitivties(){
        //code to to select data from sql database
        // select all
        ResultSet rs = DBConnection.sendQuery("SELECT * FROM activity;");

        try {

            while(rs.next()) {
                System.out.println("ID:" + rs.getString("activity.activity_id") + " | " + "Name:" + rs.getString("activity.name"));
                System.out.println("Description:" + rs.getString("activity.desc"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void createInvoice() {
        //code to to insert data to sql database
        // insert
        System.out.println("Enter amount : ");
        String amount = scanner.next();
        System.out.println("Enter date received : ");
        String dateReceived = scanner.next();
        System.out.println("Enter date sent : ");
        String dateSent = scanner.next();
        System.out.println("Enter from : ");
        String from = scanner.next();
        System.out.println("Enter to : ");
        String to = scanner.next();
        System.out.println("Enter parent ID (if none, enter -1) : ");
        int parentID = scanner.nextInt();
        System.out.println("Enter teacher ID (if none, enter -1) : ");
        int teacherID = scanner.nextInt();
        System.out.println("Do you want to confirm this addition to the database?\n" + "Amount: "+amount+"|Date received: "+dateReceived+
                "|Date Sent: "+dateSent+"|From: "+from+"|To: "+to+"|Parent ID: "+parentID+"|Teacher ID"+teacherID+"\n   (1).Yes/(2).No");
        int confirmation = scanner.nextInt();
        if (confirmation == 1) {
            if (parentID < 0) {
                DBConnection.executeQuery("INSERT INTO invoice(amount, date_received, date_sent, from, to, parent_id, teacher_id)\n" +
                        "VALUES (" + amount + ", \"" + dateReceived + "\", \"" +
                        dateSent + "\", \"" + from + "\", \"" + to + "\", NULL, " + teacherID + ");");
            } else {
                DBConnection.executeQuery("INSERT INTO invoice(amount, date_received, date_sent, from, to, parent_id, teacher_id)\n" +
                        "VALUES (" + amount + ", \" " + dateReceived + "\", \"" + dateSent + "\", \"" + from + "\", \"" + to + "\"," + parentID + ", NULL);");
            }
            System.out.println("You added an invoice to the system.");
        }
        else if(confirmation==2)
        {
            System.out.println("Canceling creation...");
        }
        else
        {
            System.out.println("Wrong input...**CANCELING CREATION**");
        }
    }

    public void deleteInvoice(){
        //code to to delete data from sql database
        // delete
        System.out.println("Select invoice : ");
        int id = scanner.nextInt();
        System.out.println("Do you want to confirm this deletion to the database?");
        ResultSet rs=DBConnection.sendQuery("SELECT * FROM invoice WHERE invoice_id="+id);

            try {
                rs.next();
                System.out.println("ID:"+rs.getString("invoice_id")+"|Amount: "+rs.getString("amount") +
                        "|Date received: "+rs.getString("date_received")+"|Date sent:"+rs.getString("date sent") +
                        "|From: "+rs.getString("from")+"|To"+rs.getString("to") +
                        "|Parent Id: "+rs.getString("parent_id")+"|Teacher Id: "+rs.getString("teacher_id")+"\n (1).Yes/(2).No");
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        int confirmation = scanner.nextInt();
        if(confirmation==1) {
            DBConnection.executeQuery("DELETE FROM invoice\n" +
                    "WHERE invoice_id = " + id + ";\n");
        }
        else if(confirmation==2){System.out.println("Canceling deletion");}
        else{System.out.println("Wrong input..**CANCELING DELETION**");}
    }
    public void displayInvoicesList(){
        //code to to select data from sql database - WIP
        // select all
        ResultSet rs = DBConnection.sendQuery("SELECT * FROM invoice;");
        try {
            while (rs.next()) {
                System.out.println("ID : " + rs.getString("invoice.invoice_id") + " | Amount : " + rs.getString("invoice.amount") +
                        " | Date Received : " + rs.getString("invoice.date_received") + " | Date Sent : " + rs.getString("invoice.date_sent") +
                        " | From : " + rs.getString("invoice.from") + " | To : " + rs.getString("invoice.to") + " | Parent ID : " +
                        rs.getString("parent_id") + " | Teacher ID : " + rs.getString("teacher_id"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void createGroup() {
        //code to to insert data to sql database
        // insert
        System.out.println("Enter group name:");
        String name = scanner.next();
        System.out.println("Enter schedule id:");
        int id = scanner.nextInt();
        System.out.println("Do you want to confirm this addition to the database?\n" + "Name: "+name+"|Schedule ID: "+id+
                "\n  (1).Yes/(2).No");
        int confirmation = scanner.nextInt();
        if (confirmation == 1) {
        DBConnection.executeQuery("INSERT INTO roskilde_daycare.group (name, schedule_id, avg_age) VALUES (\"" + name + "\", " + id + ", " + 0 + ");");
        System.out.println("You added a group to the system.");
    }
         else if(confirmation==2)
        {
            System.out.println("Canceling creation...");
        }
        else
        {
            System.out.println("Wrong input...**CANCELING CREATION**");
        }
    }
    public void deleteGroup(){
        //code to to delete data from sql database
        // delete group
        System.out.println("Select group ID to delete group:");
        int id = scanner.nextInt();
        System.out.println("Do you want to confirm this deletion to the database?");
        ResultSet rs=DBConnection.sendQuery("SELECT * FROM group     WHERE group_id="+id);
            try {
                rs.next();
                System.out.println("ID: "+rs.getString("group_id")+"|Name: "+rs.getString("name")+
                        "|Average age: "+rs.getString("avg_age")+"|Schedule ID: "+rs.getString("schedule_id")+"\n (1).Yes/(2).No");
            }
                catch(SQLException e)
                {
                    e.printStackTrace();
                }
        int confirmation = scanner.nextInt();
        if(confirmation==1) {
            DBConnection.executeQuery("DELETE FROM roskilde_daycare.group WHERE group_id = " + id + ";\n");


        }
        else if(confirmation==2){System.out.println("Canceling deletion");}
        else{System.out.println("Wrong input..**CANCELING DELETION**");}
    }
    public void displayGroups(){
        //code to to select data from sql database
        // select all from group + join on teacher name
        ResultSet rs = DBConnection.sendQuery("SELECT roskilde_daycare.group.*, teacher.first_name, teacher.last_name\n" +
                "FROM roskilde_daycare.group\n" +
                "JOIN teacher\n" +
                "ON roskilde_daycare.group.group_id = teacher.group_id;");

        try {
            while(rs.next()) {
                System.out.println("ID: " + rs.getString("group.group_id") + " | " + "Name: " + rs.getString("group.name") +
                " | " + "Average age:" + rs.getString("group.avg_age") + " | " + "Schedule ID: " + rs.getString("group.schedule_id") +
                " | " + "Teacher name: " + rs.getString("teacher.first_name") + " " + rs.getString("teacher.last_name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void addChildrenToGroup () { // NEEDS TO BE INCLUDED IN MENUS
        //code to select a group and then add a few children
        System.out.println("Select group : ");
        int groupID = scanner.nextInt();
        System.out.println("How many children do you want to add : ");
        int nr = scanner.nextInt();
        for (int i = 1; i <= nr; i ++){
            System.out.println("Select child : ");
            int childID = scanner.nextInt();
            DBConnection.executeQuery("UPDATE child\n" +
                    "SET group_id = " + groupID + "\n" +
                    "WHERE child_id = " + childID + ";");
        }
        System.out.println("You added child to the group.");
    }
    public void addActivityToSchedule()  {
        System.out.println("Select Schedule : ");
        int scheduleID = scanner.nextInt();
        System.out.println("How many activities do you want to add : ");
        int nr = scanner.nextInt();
        while (nr >0 ){
            System.out.println("Select activity : ");
            int activityID = scanner.nextInt();
            ResultSet rs = DBConnection.sendQuery("SELECT schedule_has_activity.activity_id FROM schedule_has_activity WHERE schedule_has_activity.schedule_id = " + scheduleID + ";");
            try {
                while (rs.next()) {
                    if (activityID == rs.getInt("schedule_has_activity.activity_id")){
                        System.out.println("This activity is already in the schedule.");
                        System.out.println("Select activity : ");
                        activityID = scanner.nextInt();
                    }
                }
            } catch (SQLException e){
                e.printStackTrace();
            }
            System.out.println("How many times would you like to have the activity during the month :");
            int instances = scanner.nextInt();
            DBConnection.executeQuery("INSERT INTO schedule_has_activity  VALUES (" + scheduleID + ", " + activityID +", " + instances + ");");
            nr =-1;
        }
        System.out.println("You added activity to the schedule.");
    }

    public void createUser (String firstName, String lastName) {

        ResultSet rs = DBConnection.sendQuery("SELECT teacher_id\n" +
                "FROM teacher\n" +
                "WHERE last_name = \"" + lastName + "\" AND first_name = \"" + firstName + "\";");
        try {
            rs.next();

            String id = rs.getString("teacher_id");

            String username = firstName.substring(0, 4) + id;
            username = username.toLowerCase();
            String password = createPassword();

            DBConnection.executeQuery("CREATE USER IF NOT EXISTS " + username + "@'%' IDENTIFIED BY '" + password + "';");
            DBConnection.executeQuery("GRANT ALL PRIVILEGES ON roskilde_daycare.* TO " + username + "@'%';");
            /*DBConnection.executeQuery("GRANT ALL PRIVILEGES ON roskilde_daycare.activity TO " + username + "@'%';");
            DBConnection.executeQuery("GRANT ALL PRIVILEGES ON roskilde_daycare.schedule_has_activity TO " + username + "@'%';");
            DBConnection.executeQuery("GRANT ALL PRIVILEGES ON roskilde_daycare.schedule TO " + username + "@'%';");
            DBConnection.executeQuery("GRANT ALL PRIVILEGES ON roskilde_daycare.group TO " + username + "@'%';");
            DBConnection.executeQuery("GRANT ALL PRIVILEGES ON roskilde_daycare.appointment TO " + username + "@'%';");
            DBConnection.executeQuery("GRANT ALL PRIVILEGES ON roskilde_daycare.child TO " + username + "@'%';");
            DBConnection.executeQuery("GRANT ALL PRIVILEGES ON roskilde_daycare.waiting_list TO " + username + "@'%';");
            DBConnection.executeQuery("GRANT ALL PRIVILEGES ON roskilde_daycare.parent TO " + username + "@'%';");
            DBConnection.executeQuery("GRANT ALL PRIVILEGES ON roskilde_daycare.telephone_list TO " + username + "@'%';");
            DBConnection.executeQuery("GRANT ALL PRIVILEGES ON roskilde_daycare.user TO " + username + "@'%';");
            DBConnection.executeQuery("GRANT ALL PRIVILEGES ON roskilde_daycare.teacher TO " + username + "@'%';");*/
            DBConnection.executeQuery("INSERT INTO user(username, password, teacher_id) VALUES(\"" + username + "\", \"" + password + "\", " + id + ")");
        } catch (SQLException e ) {
            e.printStackTrace();
        }
    }

    public String createPassword() {

        Random rand = new Random();
        String password = "";
        for (int i = 0; i < 10; i++){
            if(rand.nextBoolean()){
                int nextChar = 97 + rand.nextInt(25);
                char Char = (char) nextChar;
                if ( rand.nextBoolean() ) {
                    password += Character.toUpperCase(Char);
                } else {
                    password += Char;
                }
            } else {
                password += rand.nextInt(9);
            }
        }
        return password;
    }
}
