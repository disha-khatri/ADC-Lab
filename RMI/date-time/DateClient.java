import java.rmi.*;
public class DateClient
{
      public static void main(String[] args)
{
try{

IDate intf=(IDate)Naming.lookup("rmi://localhost:1099/DateServer");

System.out.println("The Date On Server is: "+intf.getDate());
}
catch(Exception e){
e.printStackTrace();
}}}
