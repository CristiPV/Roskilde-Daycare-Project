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

    public static void insertRow ( int id, String firstName, String lastName, String birth_date, String sex, int age, String joinedDate, int groupID, int parentID  ) {
        DBConnection.executeQuery("INSERT INTO child(child_id, first_name, last_name, birth_date, sex, age, joined_date, group_id, parent_id) VALUES\n" +
                                  "(" + id + ",\"" + firstName + "\", \"" + lastName + "\", \"" + birth_date + "\", \"" + sex + "\", " + age + ", \"" + joinedDate + "\", " + groupID + ", " + parentID + ");");
    }


    public static void deleteRow( int id ) {
        DBConnection.executeQuery("DELETE FROM child WHERE child_id = " + id + ";");
    }

    public static void updateRow ( int id, String name ) {
        DBConnection.executeQuery("UPDATE child\n" +
                                  "SET first_name = \"" + name + "\" \n" +
                                  "WHERE child_id = " + id + ";");
    }
}


