import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
public class Menu
{
    public static void display()
    {
       //DBConnection.sendQuery("INSERT INTO child VALUES (212, \"Rob\", \"Spencer\", \"2016-12-31\", \"M\", 4, \"2020-03-21\", 501, 301);");
        //boolean wat = DBConnection.executeQuery("INSERT INTO child(child_id, first_name, last_name, birth_date, sex, age, joined_date, group_id, parent_id) VALUES\n" +
             // "(212,\"Barbara\", \"Spencer\", \"2017-04-28\", \"F\", 3, \"2020-03-21\", 501, 301);");

       /* DBConnection.executeQuery("UPDATE child\n" +
                "SET first_name = \"Robert\" \n" +
                "WHERE child_id = 201;");*/
      // DBConnection.executeQuery("DELETE FROM roskilde_daycare.child WHERE first_name = \"Barbara\";");

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
}


