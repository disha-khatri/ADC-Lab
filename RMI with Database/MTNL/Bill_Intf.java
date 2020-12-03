import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.*;

// Creating Remote interface for our application 
public interface Bill_Intf extends Remote
{
    public List<Billing> billDetails(int num) throws Exception;
}
