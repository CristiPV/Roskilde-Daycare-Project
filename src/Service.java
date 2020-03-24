import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Service {
    static Scanner scanner = new Scanner(System.in);

    public Service() {
    }

    public void createChild( String firstName, String lastName, String birth_date, String sex, int age, String joinedDate, int parentID ){
        //code to to insert data to sql database
        // Insert Query
        DBConnection.executeQuery("INSERT INTO child(first_name, last_name, birth_date, sex, age, joined_date, parent_id) VALUES\n" +
                "(\"" + firstName + "\", \"" + lastName + "\", \"" + birth_date + "\", \"" + sex + "\", " +
                age + ", \"" + joinedDate + "\", " + parentID + ");");
    }
    public void deleteChild(int id){
        //code to to delete data from sql database
        // if parent has no more children in the DB, then delete the parent associated with the child.
        // delete telephone_list entries related to the parent
        // Delete the waiting_list entries tied to the child
        // Delete specific row ( id )
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
    public void createParent( String firstName, String lastName, String birthDate, String sex, String phoneNo, String phoneNoAlt ){
        //code to to insert data to sql database
        // Insert Query
        // Adds the parent into the DB
        DBConnection.executeQuery("INSERT INTO parent(first_name, last_name, birth_date, sex) VALUES (\"" + firstName + "\", \"" + lastName +
                "\", \"" + birthDate + "\", \"" + sex + "\");");

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
    public void displayOneParent( int id ){ //added no sql comment
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
    public void createTeacher(){
        //code to to insert data to sql database
        // insert query - WIP
        System.out.println("Enter first name : ");
        String firstName = scanner.next();
        System.out.println("Enter last name : ");
        String lastName = scanner.next();
        System.out.println("Enter birth day : ");
        String birth_date = scanner.next();
        System.out.println("Enter sex : ");
        String sex = scanner.next();
        System.out.println("Enter salary : ");
        double salary = scanner.nextDouble();
        System.out.println("Enter group ID : ");
        int group_id = scanner.nextInt();

        DBConnection.executeQuery("INSERT INTO teacher(first_name, last_name, birth_date, sex, salary, group_id, super_id) VALUES\n" +
                "(" + firstName + "\", \"" + lastName + "\", \"" + birth_date + "\", \"" + sex + "\", " + salary + ", \"" + group_id + "\", " + 101 +");");

        new AdminMenu();
    }
    public void deleteTeacher(){ // didn't test it
        //code to to delete data from sql database
        // delete teacher and associated appointments
        System.out.println("Enter teacher ID : ");
        int teacher_id = scanner.nextInt();
        DBConnection.executeQuery("DELETE FROM appointment WHERE teacher_id = " + teacher_id + ";");
        DBConnection.executeQuery("DELETE FROM teacher WHERE teacher_id = " + teacher_id + ";");

        new AdminMenu();
    }
    public void displayTeacherList(){
        //code to to select data from sql database
        // select all from teacher
    }
    public void createAppointment(){
        //code to to insert data to sql database
        // create an appointment and delete the waiting_list entry for the corresponding child
    }
    public void deleteAppointment(){
        //code to to delete data from sql database
        // delete appointment
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
    public void displayWaitingList(){
        //code to to select data from sql database
        // select all + join with child name + parent name
    }
    public void displayRowFromWaitingList(){
        // select all from waiting_list for a given child id
        //code
    }
    public void createSchedule(){
        //code to to insert data to sql database
        // insert query
    }
    public void deleteSchedule(){
        //code to to delete data from sql database
        //  delete group + entries in schedule_has_activity
    }
    public void displaySchedule(){ //doesn't work ////
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
    public void createInvoice(int amount, String dateReceived, String dateSent, String from, String to, int parentID, int teacherID){
        //code to to insert data to sql database
        // insert
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
    public void deleteInvoice(int id){
        //code to to delete data from sql database
        // delete
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
}
