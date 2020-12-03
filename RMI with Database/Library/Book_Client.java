import java.rmi.Naming;
import java.rmi.registry.LocateRegistry; 
import java.rmi.registry.Registry; 
import java.util.*;
public class Book_Client 
{
    private Book_Client()
    {
        
    }
    public static void main(String args[])throws Exception
    {
        
        try
        { 
  
            // Getting the registry 
            Registry registry = LocateRegistry.getRegistry(1099); 
    
            // Looking up the registry for the remote object 
            Book_Intf stub = (Book_Intf) registry.lookup("Library_Book"); 

            // Calling the remote method using the obtained object 
            List<Book> list = (List)stub.bookDetails(); 
            for (Book s:list)
            { 
            
                // System.out.println("rn "+s.getrollno()); 
                System.out.println("Bookid: " + s.getBookid());
                System.out.println("BookName: " + s.getBookName());
                System.out.println("BookAuthor: " + s.getBookAuthor());
                System.out.println("BookPrice: " + s.getBookPrice()); 
                System.out.println("BookStatus " + s.getBookStatus()); 
                System.out.println("\n________________________\n");
            }  
            // System.out.println(list); 
        } 
        catch(Exception e)
        {
            
            System.err.println("Client exception: " + e.toString()); 
            e.printStackTrace();
        }
    }
}
