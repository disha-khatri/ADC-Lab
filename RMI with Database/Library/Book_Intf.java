import java.rmi.Remote; 
import java.rmi.RemoteException; 
import java.util.*;
// Creating Remote interface for our application
public interface Book_Intf extends Remote
{
    public List<Book> bookDetails() throws Exception;
}
