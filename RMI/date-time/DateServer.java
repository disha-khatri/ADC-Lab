import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class DateServer
{
     public static void main(String[] args)
   {
     try{
            Registry r = java.rmi.registry.LocateRegistry.createRegistry(1099);
       
            DateImpl di=new DateImpl();
            Naming.rebind("DateServer", (Remote) di);
            System.out.println("Date Server is Ready");
}
catch(Exception e)
{
e.printStackTrace();
}
}}
