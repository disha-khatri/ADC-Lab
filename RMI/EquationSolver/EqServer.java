import java.rmi.*;
import java.rmi.registry.*; 
public class EqServer
{
public static void main(String args[])
{
try
{
EqImp stub =new EqImp();
Naming.rebind("rmi://localhost:1099/EqSol ver",stub); //It binds the remote object to the new name.
}
catch(Exception e)
{	
System.out.println(e);
}
}
}
