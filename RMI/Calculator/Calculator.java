import java.rmi.RemoteException;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public class Calculator extends UnicastRemoteObject implements calculatorinterface{
    
    public Calculator() throws RemoteException
    {
        int a,b;
    }
    @Override
    public int add(int a,int b) throws RemoteException
    {
        return a+b;
    }
    @Override
      public int sub(int a,int b) throws RemoteException
    {
        return a-b;
    }
    @Override
    public int mul(int a,int b) throws RemoteException
    {
        return a*b;
    }
    @Override
    public int div(int a,int b) throws RemoteException
    {
        return a/b;
    } 
}
