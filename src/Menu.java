import java.sql.ResultSet;
import java.sql.SQLException;
//poo poo 
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
}
