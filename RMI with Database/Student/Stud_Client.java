import java.rmi.Naming;
import java.rmi.registry.LocateRegistry; 
import java.rmi.registry.Registry; 
import java.util.*;
public class Stud_Client 
{
    private Stud_Client()
    {
        
    }
    public static void main(String args[])throws Exception
    {
        
        try
        { 
  
            // Getting the registry 
            Registry registry = LocateRegistry.getRegistry(1099); 
    
            // Looking up the registry for the remote object 
            Stud_Intf stub = (Stud_Intf) registry.lookup("Student_Intf"); 

            // Calling the remote method using the obtained object 
            List<Student> list = (List)stub.studentDetails(); 
            for (Student s:list)
            { 
            
                // System.out.println("rn "+s.getrollno()); 
                System.out.println("rollno: " + s.getrollno()); 
                System.out.println("sname: " + s.getsname()); 
                System.out.println("sub1: " + s.getsub1()); 
                System.out.println("sub2: " + s.getsub2()); 
                System.out.println("sub3: " + s.getsub3()); 
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
