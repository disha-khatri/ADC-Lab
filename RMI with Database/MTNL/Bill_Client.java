import java.rmi.Naming;
import java.rmi.registry.LocateRegistry; 
import java.rmi.registry.Registry; 
import java.util.*;
public class Bill_Client 
{
    private Bill_Client()
    {
        
    }
    public static void main(String args[])throws Exception
    {
        
        try
        { 
            
            // Getting the registry 
            Registry registry = LocateRegistry.getRegistry(1099); 
    
            // Looking up the registry for the remote object 
            Bill_Intf stub = (Bill_Intf) registry.lookup("MTNL_Billing"); 
            System.out.print("Enter cust Id: ");
            Scanner scan = new Scanner(System.in);      //System.in is a standard input stream
            int cust_id = scan.nextInt();

            // Calling the remote method using the obtained object 
            List<Billing> list = (List)stub.billDetails(cust_id); 
            
            for (Billing s:list)
            { 
            
                // System.out.println("rn "+s.getrollno()); 
                System.out.println("InvoiceId: " + s.getInvoiceId());
                System.out.println("CustId: " + s.getCustId());
                System.out.println("CustName: " + s.getCustName());
                System.out.println("InvoiceDate: " + s.getInvoiceDate()); 
                System.out.println("Amount: " + s.getAmount()); 
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
