import org.w3c.dom.ls.LSOutput;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
public class Menu
{
    public static void selectAll( String table )
    {
        ResultSet rs = DBConnection.sendQuery("SELECT * FROM " + table + ";");
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

    /*public static void insertRow ( int id, String firstName, String lastName, String birth_date, String sex, int age, String joinedDate, int parentID  ) {
        DBConnection.executeQuery("INSERT INTO child(child_id, first_name, last_name, birth_date, sex, age, joined_date, group_id, parent_id) VALUES\n" +
                                  "(" + id + ",\"" + firstName + "\", \"" + lastName + "\", \"" + birth_date + "\", \"" + sex + "\", " + age + ", \"" + joinedDate + "\", " + groupID + ", " + parentID + ");");
    }*/

    public static void createParent ( String firstName, String lastName, String birthDate, String sex, String phoneNo, String phoneNoAlt ) {
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

    public static void displayparentlist () {
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

    public static void displayparentrow ( int id ) {
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

    public static void createInvoice ( int amount, String dateReceived, String dateSent, String from, String to, int parentID, int teacherID ) {
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

    public static void deleteinvoice ( int id ) {
        DBConnection.executeQuery("DELETE FROM invoice\n" +
                "WHERE invoice_id = " + id + ";\n");
    }

    public static void displayinvoices () {
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

    public static void deleteRow( int id ) {
        DBConnection.executeQuery("DELETE FROM child WHERE child_id = " + id + ";");
    }

    public static void updateRow ( int id, String name ) {
        DBConnection.executeQuery("UPDATE child\n" +
                                  "SET first_name = \"" + name + "\" \n" +
                                  "WHERE child_id = " + id + ";");
    }

    public static void deleteChild ( int id ) {
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
}


