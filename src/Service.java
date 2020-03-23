import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Service {
    static Scanner scanner = new Scanner(System.in);

    public Service() {
    }

    public void createChild(){
        //code to to insert data to sql database
        // Insert Query
    }
    public void deleteChild(){
        //code to to delete data from sql database
        // if parent has no more children in the DB, then delete the parent associated with the child.
        // delete telephone_list entries related to the parent
        // Delete the waiting_list entries tied to the child
        // Delete specific row ( id )
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
    }
    public void displayParentList(){
        //code to to select data from sql database
        // select all from parent + join with telephone_list
    }
    public void displayOneParent(){ //added no sql comment
        //code
    }
    public void createTeacher(){
        //code to to insert data to sql database
        // insert query - WIP
    }
    public void deleteTeacher(){
        //code to to delete data from sql database
        // delete teacher and associated appointments
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
    public static void displayRowFromAppointmentList(){
        // select all from appointment for a given teacher id
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
    public void displaySchedule(){
        //code to to select data from sql database
        // select all from schedule + activities that it has
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
    }
    public void deleteInvoice(){
        //code to to delete data from sql database
        // delete
    }
    public void displayInvoicesList(){
        //code to to select data from sql database - WIP
        // select all
        // if possible, add join for teacher name &  parent name
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
