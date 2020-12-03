import java.rmi.Remote; 
import java.rmi.RemoteException; 
import java.util.*;
// Creating Remote interface for our application
public interface Stud_Intf extends Remote
{
    public List<Student> studentDetails() throws Exception;
}
