import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.RemoteException; 
import java.rmi.server.UnicastRemoteObject; 
public class Stud_Server extends Stud_Impl
{
    public Stud_Server()
    {
        
    }
    public static void main(String args[])
    {
        try
        {
            // Instantiating the implementation class 
            Stud_Impl obj = new Stud_Impl(); 
    
            // Exporting the object of implementation class (here we are exporting the remote object to the stub) 
            Stud_Intf stub = (Stud_Intf) UnicastRemoteObject.exportObject(obj, 0);  
         
            // Binding the remote object (stub) in the registry 
            Registry registry = LocateRegistry.createRegistry(1099); 
         
            registry.bind("Student_Intf", stub);  
            System.err.println("Server ready"); 
            
        }
        catch(Exception e)
        { 
            System.err.println("Server exception: " + e.toString()); 
            e.printStackTrace(); 
        }
    }
}
