import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Service {
    static Scanner scanner = new Scanner(System.in);

    public Service() {
    }

    public void createChild(  ){
        //code to to insert data to sql database
        // Insert Query
        System.out.println("Enter first name : ");
        String firstName = scanner.next();
        System.out.println("Enter last name : ");
        String lastName = scanner.next();
        System.out.println("Enter birth day : ");
        String birth_date = scanner.next();
        System.out.println("Enter sex : ");
        String sex = scanner.next();
        System.out.println("Enter age : ");
        String age = scanner.next();
        System.out.println("Enter joining date (YYYY-MM-DD) : ");
        String joinedDate = scanner.next();
        System.out.println("Enter parent ID : ");
        int parentID = scanner.nextInt();
        DBConnection.executeQuery("INSERT INTO child(first_name, last_name, birth_date, sex, age, joined_date, parent_id) VALUES\n" +
                "(\"" + firstName + "\", \"" + lastName + "\", \"" + birth_date + "\", \"" + sex + "\", " +
                age + ", \"" + joinedDate + "\", " + parentID + ");");
    }
    public void deleteChild(){
        //code to to delete data from sql database
        // if parent has no more children in the DB, then delete the parent associated with the child.
        // delete telephone_list entries related to the parent
        // Delete the waiting_list entries tied to the child
        // Delete specific row ( id )
        System.out.println("Select child : ");
        int id = scanner.nextInt();
        ResultSet pid = DBConnection.sendQuery("SELECT parent_id FROM child\n" +
                "WHERE child_id = " + id + ";");

        try {
            pid.next();
            String parentID = pid.getString("parent_id");
            ResultSet rs = DBConnection.sendQuery("SELECT COUNT(child_id) AS count FROM child\n" +
                    "WHERE parent_id = " + parentID + ";");
            rs.next();
            // checks if the parent has any more children than the one we are about to delete
            if (rs.getInt("count") == 1) {
                // deletes the telephone list entries related to the parent
                DBConnection.executeQuery("DELETE FROM telephone_list\n" +
                        "WHERE parent_id = " + parentID + ";");
                // deletes the parent
                DBConnection.executeQuery("DELETE FROM parent\n" +
                        "WHERE parent_id = " + parentID + ";");
            }
            DBConnection.executeQuery("DELETE FROM child\n" +
                    "WHERE child_id = " + id + ";");

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void displayChildList(){
        //code to to select data from sql database
        // select all from child + join with parent first & last name
        ResultSet rs = DBConnection.sendQuery("SELECT child.child_id, child.first_name, child.last_name, parent.first_name AS \"parent_first_name\", parent.last_name AS \"parent_Last_name\"\n" +
                                                "FROM child\n" +
                                                "JOIN parent\n" +
                                                "ON child.parent_id = parent.parent_id;");
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
    public void createParent(){
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
        System.out.println("Enter alternate phone number (If none, press enter) : ");
        String phoneNoAlt = scanner.next();
        DBConnection.executeQuery("INSERT INTO parent(first_name, last_name, birth_date, sex) VALUES (\"" + firstName + "\", \"" + lastName +
                "\", \"" + birth_date + "\", \"" + sex + "\");");

        // Finds the parent and retrieves the ID
        ResultSet rs = DBConnection.sendQuery("SELECT parent_id FROM parent\n" +
                "WHERE first_name = \"" + firstName + "\" AND last_name = \"" + lastName + "\";");
        String parentID = "";
        try {
            rs.next();
            parentID = rs.getString("parent_id");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        // Adds the main phone no in the DB
        DBConnection.executeQuery("INSERT INTO telephone_list VALUES (\"" + phoneNo + "\", " + parentID + ");");

        // Adds the alternate phone no ( if exsists ) in the DB
        if (phoneNoAlt.length() == 8) {
            DBConnection.executeQuery("INSERT INTO telephone_list VALUES (\"" + phoneNoAlt + "\", " + parentID + ");");
        }
    }
    public void displayParentList(){
        //code to to select data from sql database
        // select all from parent + join with telephone_list
        ResultSet rs = DBConnection.sendQuery("SELECT *, telephone_list.phone_number\n" +
                "FROM parent\n" +
                "JOIN telephone_list\n" +
                "ON parent.parent_id = telephone_list.parent_id\n" +
                "ORDER BY parent.parent_id;");
        try {
            String lastID = "";
            while (rs.next()){
                if (rs.getString("parent_id").equals(lastID)) {
                    System.out.print(", " + rs.getString("telephone_list.phone_number"));
                }
                else {
                    System.out.println();
                    System.out.println("ID : " + rs.getString("parent_id") + " | Name : " + rs.getString("first_name") + rs.getString("last_name") +
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
        ResultSet rs = DBConnection.sendQuery("SELECT *, telephone_list.phone_number\n" +
                "FROM parent\n" +
                "JOIN telephone_list\n" +
                "ON parent.parent_id = telephone_list.parent_id\n" +
                "WHERE parent.parent_id =  " + id + ";");
        try {
            rs.next();
            System.out.println("ID : " + rs.getString("parent_id") + " | Name : " + rs.getString("first_name") + rs.getString("last_name") +
                    " | Birth Date : " + rs.getString("birth_date") + " | Sex : " + rs.getString("sex"));
            System.out.print("Phone Number : " + rs.getString("telephone_list.phone_number"));
            while (rs.next()) {
                System.out.print(", " + rs.getString("telephone_list.phone_number"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void createTeacher(){ //works
        //code to to insert data to sql database
        // insert query - WIP
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

        DBConnection.executeQuery("INSERT INTO teacher (first_name, last_name, birth_date, sex, salary, group_id, super_id) VALUES\n" +
                "(\"" + firstName + "\", \"" + lastName + "\", \"" + birth_date + "\", \"" + sex + "\", " + salary + ", \"" + group_id + "\", " + 101 +");");
        System.out.println("You created a teacher.");
    }
    public void deleteTeacher(){ // works
        //code to to delete data from sql database
        // delete teacher and associated appointments
        System.out.println("Enter teacher ID : ");
        int teacher_id = scanner.nextInt();
        DBConnection.executeQuery("DELETE FROM appointment WHERE teacher_id = " + teacher_id + ";");
        DBConnection.executeQuery("DELETE FROM teacher WHERE teacher_id = " + teacher_id + ";");

        System.out.println("You created a teacher.");
        new AdminMenu();
    }
    public void displayTeacherList(){
        //code to to select data from sql database
        // select all from teacher
    }
    public void createAppointment(){ //check if works
        //code to to insert data to sql database
        // create an appointment and delete the waiting_list entry for the corresponding child
        System.out.println("Enter appointment date (YYYY-MM-DD) : ");
        String date = scanner.next();
        System.out.println("Enter appointment time (HH:MM:SS) : ");
        String time = scanner.next();
        System.out.println("Enter child ID : ");
        int child_id = scanner.nextInt();
        System.out.println("Enter teacher ID : ");
        String teacher_id = scanner.next();

        DBConnection.executeQuery("INSERT INTO teacher (date, time, child_id, teacher_id) VALUES\n" +
                "(\"" + date + "\", \"" + time + "\", \"" + child_id + "\", \"" + teacher_id + ");");

        System.out.println("You created an appointment.");

        DBConnection.executeQuery("DELETE FROM waiting_list WHERE child_id = " + child_id + ";");
    }
    public void deleteAppointment(){ //check if works
        //code to to delete data from sql database
        // delete appointment
        System.out.println("Enter an appointmnt ID : ");
        int appointment_id = scanner.nextInt();
        DBConnection.executeQuery("DELETE FROM appointment WHERE appointment_id = " + appointment_id + ";");
    }
    public void displayAppointmentList(){
        //code to to select data from sql database
        // select all from appointment + join with teacher name + child name + parent name
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
    public void createRecordInWaitingList(){
        //code to to insert data to sql database
        // insert query
    }
    public void deleteRecordInWaitingList(){
        //code to to delete data from sql database
        // delete query
    }
    public void displayWaitingList(){ //chech if works
        //code to to select data from sql database
        // select all + join with child name + parent name
        ResultSet rs = DBConnection.sendQuery("SELECT *, parent.firstName AS \"Parent name\", parent.lastName AS \"Parent surname\" \n" +
                "FROM waiting_list\n" +
                "JOIN parent\n" +
                "ON parent.child_id = waiting_list.child_id;");
        try {
            rs.next();
            System.out.println("ID : " + rs.getString("waiting_list_id") + " | Date : " + rs.getString("date") +
                    " | Reason : " + rs.getString("reason") + " | Child ID : " + rs.getString("child_id")+ " | Parent name : " + rs.getString("Parent name")
                    + " | Parent last name : " + rs.getString("Parent surname"));

        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void displayRowFromWaitingList(){
        // select all from waiting_list for a given child id
        //code
    }
    public void createSchedule(){ //check if works
        //code to to insert data to sql database
        // insert query
        System.out.println("Enter number of nap hours daily : ");
        int nap_hours_daily = scanner.nextInt();
        System.out.println("Enter number of activity hours weekly : ");
        int activity_hours_weekly = scanner.nextInt();

        DBConnection.executeQuery("INSERT INTO schedule(nap_hrs_daily, activity_hrs_weekly)\n" +
                "                  VALUES (" + nap_hours_daily + ", \" " + activity_hours_weekly + ";");
    }
    public void deleteSchedule(){ //check if works
        //code to to delete data from sql database
        // entries in schedule_has_activity
        System.out.println("Enter schedule ID : ");
        System.out.println("Press 0 to go back : ");
        int schedule_id = scanner.nextInt();

        DBConnection.executeQuery("DELETE FROM schedule_has_activity WHERE schedule_has_activity.schedule_id = " + schedule_id + ";");
        DBConnection.executeQuery("DELETE FROM schedule WHERE schedule.schedule_id = " + schedule_id + ";");

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
    }
    public void displayAcitivties(){
        //code to to select data from sql database
        // select all
    }
    public void createInvoice(){
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
        if (parentID == -1) {
            DBConnection.executeQuery("INSERT INTO invoice(amount, date_received, date_sent, from, to, parent_id, teacher_id)\n" +
                    "                  VALUES (" + amount + ", \" " + dateReceived + "\", \"" +
                    dateSent + "\", \"" + from + "\", \"" + to + "\", NULL, " + teacherID + ");");
        }
        else {
            DBConnection.executeQuery("INSERT INTO invoice(amount, date_received, date_sent, from, to, parent_id, teacher_id)\n" +
                    "                  VALUES (" + amount + ", \" " + dateReceived + "\", \"" +
                    dateSent + "\", \"" + from + "\", \"" + to + "\"," + parentID + ", NULL);");
        }
    }
    public void deleteInvoice(){
        //code to to delete data from sql database
        // delete
        System.out.println("Select invoice : ");
        int id = scanner.nextInt();
        DBConnection.executeQuery("DELETE FROM invoice\n" +
                "WHERE invoice_id = " + id + ";\n");
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
    public void createGroup(){
        //code to to insert data to sql database
        // insert
    }
    public void deleteGroup(){
        //code to to delete data from sql database
        // delete group
    }
    public void displayGroups(){
        //code to to select data from sql database
        // select all from group + join on teacher name
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
    }
    public void addActivitiesToSchedule () { // NEEDS TO BE INCLUDED IN MENUS
        System.out.println("Select Schedule : ");
        int scheduleID = scanner.nextInt();
        System.out.println("How many activities do you want to add : ");
        int nr = scanner.nextInt();
        for (int i = 1; i <= nr; i ++){
            System.out.println("Select activity : ");
            int activityID = scanner.nextInt();
            System.out.println("How many times would you like to have the activity during the month :");
            int instances = scanner.nextInt();
            DBConnection.executeQuery("INSERT INTO schedule_has_activity  VALUES (" + scheduleID + ", " + activityID +", " + instances + ");");
        }
    }
}
