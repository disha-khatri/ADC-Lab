import  java.rmi.*; 
import java.rmi.server.*; 
import java.util.*;
import java.sql.*;
// Implementing the remote interface
public class Bill_Impl implements Bill_Intf
{
    // Implementing the interface method
    public List<Billing> billDetails(int num) throws Exception
    {
        List<Billing> list = new ArrayList<Billing>();
        try 
        {
           
           // JDBC driver name and database URL 
           String JDBC_DRIVER = "com.mysql.jdbc.Driver";   
           String DB_URL = "jdbc:mysql://localhost:3306/mtnl";  
      
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
           String sql = "SELECT * FROM billingtable WHERE CustId= " + num; 
           ResultSet rs = stmt.executeQuery(sql);  
      
           //Extract data from result set 
           while(rs.next()) 
           { 
                // Retrieve by column name 
                int InvoiceId  = rs.getInt("InvoiceId"); 
         
                int CustId = rs.getInt("CustId"); 
                
                String CustName = rs.getString("CustName"); 
                String InvoiceDate = rs.getString("InvoiceDate"); 

                int Amount = rs.getInt("Amount");  
         
                // Setting the values 
                Billing billing = new Billing(); 
                billing.setInvoiceId(InvoiceId); 
                billing.setCustId(CustId); 
                billing.setCustName(CustName); 
                billing.setInvoiceDate(InvoiceDate);  
                billing.setAmount(Amount); 
                list.add(billing);
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
