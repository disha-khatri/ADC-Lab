import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.NotBoundException;

public class CalculatorServer {
    public static void main(String[] args) throws RemoteException,NotBoundException
    {
        try
        {
            Registry r = java.rmi.registry.LocateRegistry.createRegistry(1090);
            r.rebind("Calculator", new Calculator());
            System.out.println("server is running");
        }
        catch(Exception e)
                {
                    System.out.println(e);
                }
    }
}
