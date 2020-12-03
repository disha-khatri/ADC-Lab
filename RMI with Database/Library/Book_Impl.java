import  java.rmi.*; 
import java.rmi.server.*; 
import java.util.*;
import java.sql.*;
// Implementing the remote interface
public class Book_Impl implements Book_Intf
{
    // Implementing the interface method
    public List<Book> bookDetails() throws Exception
    {
        List<Book> list = new ArrayList<Book>();
        try 
        {
           
           // JDBC driver name and database URL 
           String JDBC_DRIVER = "com.mysql.jdbc.Driver";   
           String DB_URL = "jdbc:mysql://localhost:3306/library";  
      
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
           String sql = "SELECT * FROM bookdetails"; 
           ResultSet rs = stmt.executeQuery(sql);  
      
           //Extract data from result set 
           while(rs.next()) 
           { 
                // Retrieve by column name 
                int Bookid  = rs.getInt("Bookid"); 
         
                String BookName = rs.getString("BookName"); 
                
                String BookAuthor = rs.getString("BookAuthor"); 
                int BookPrice = rs.getInt("BookPrice"); 

                String BookStatus = rs.getString("BookStatus");  
         
                // Setting the values 
                Book book = new Book(); 
                book.setBookid(Bookid); 
                book.setBookName(BookName); 
                book.setBookAuthor(BookAuthor); 
                book.setBookPrice(BookPrice);  
                book.setBookStatus(BookStatus); 
                list.add(book);
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
