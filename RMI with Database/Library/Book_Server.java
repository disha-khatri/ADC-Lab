import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.RemoteException; 
import java.rmi.server.UnicastRemoteObject;
public class Book_Server extends Book_Impl
{
    public Book_Server()
    {
        
    }
    public static void main(String args[])
    {
        try
        {
            // Instantiating the implementation class 
            Book_Impl obj = new Book_Impl(); 
    
            // Exporting the object of implementation class (here we are exporting the remote object to the stub) 
            Book_Intf stub = (Book_Intf) UnicastRemoteObject.exportObject(obj, 0);  
         
            // Binding the remote object (stub) in the registry 
            Registry registry = LocateRegistry.createRegistry(1099); 
         
            registry.bind("Library_Book", stub);  
            System.err.println("Server ready"); 
            
        }
        catch(Exception e)
        { 
            System.err.println("Server exception: " + e.toString()); 
            e.printStackTrace(); 
        }
    }
}
