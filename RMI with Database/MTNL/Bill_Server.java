import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.RemoteException; 
import java.rmi.server.UnicastRemoteObject;
public class Bill_Server extends Bill_Impl
{
    public Bill_Server()
    {
        
    }
    public static void main(String args[])
    {
        try
        {
            // Instantiating the implementation class 
            Bill_Impl obj = new Bill_Impl(); 
    
            // Exporting the object of implementation class (here we are exporting the remote object to the stub) 
            Bill_Intf stub = (Bill_Intf) UnicastRemoteObject.exportObject(obj, 0);  
         
            // Binding the remote object (stub) in the registry 
            Registry registry = LocateRegistry.createRegistry(1099); 
         
            registry.bind("MTNL_Billing", stub);  
            System.err.println("Server ready"); 
            
        }
        catch(Exception e)
        { 
            System.err.println("Server exception: " + e.toString()); 
            e.printStackTrace(); 
        }
    }
}
