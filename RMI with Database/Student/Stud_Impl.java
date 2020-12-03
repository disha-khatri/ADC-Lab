import  java.rmi.*; 
import java.rmi.server.*; 
import java.util.*;
import java.sql.*;
// Implementing the remote interface
public class Stud_Impl implements Stud_Intf
{
    // Implementing the interface method
    public List<Student> studentDetails() throws Exception
    {
        List<Student> list = new ArrayList<Student>();
        try 
        {
           
           // JDBC driver name and database URL 
           String JDBC_DRIVER = "com.mysql.jdbc.Driver";   
           String DB_URL = "jdbc:mysql://localhost:3306/college";  
      
           // Database credentials 
           String USER = "root"; 
           String PASS = "";  
      
           Connection conn = null; 
           Statement stmt = null;  
      
           //Register JDBC driver 
           Class.forName("com.mysql.jdbc.Driver");    
      
           //Open a connection
           System.out.println("Connecting to a selected database..."); 
           conn = DriverManager.getConnection(DB_URL, USER, PASS); 
           System.out.println("Connected database successfully...");  
      
           //Execute a query 
           System.out.println("Creating statement..."); 
      
           stmt = conn.createStatement();  
           String sql = "SELECT * FROM student"; 
           ResultSet rs = stmt.executeQuery(sql);  
      
           //Extract data from result set 
           while(rs.next()) 
           { 
                // Retrieve by column name 
                int rollno  = rs.getInt("rollno"); 
         
                String sname = rs.getString("sname"); 
                String sub1 = rs.getString("sub1"); 
         
                String sub2 = rs.getString("sub2"); 
                String sub3 = rs.getString("sub3");  
         
                // Setting the values 
                Student student = new Student(); 
                student.setrollno(rollno); 
                student.setsname(sname); 
                student.setsub1(sub1); 
                student.setsub2(sub2); 
                student.setsub3(sub3); 
                list.add(student);
            }
            rs.close(); 
            
        }
        catch (Exception e) 
        { 
            System.out.println(e);
        }
        return list;
    }
}
