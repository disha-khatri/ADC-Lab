import java.net.*; 
import java.io.*; 
import java.util.*;
import java.rmi.registry.*; 
import java.rmi.*;

public class EqClient {
public static void main(String args[]) throws Exception
{
Scanner sc = new Scanner(System.in); try{
int a =0,b=0;


EqInterface stub
=(EqInterface)Naming.lookup("rmi://localho st:1099/EqSolver");
System.out.println("\n\nSolving Equation : (a-b)^2 = a^2 - 2*a*b + b^2");
System.out.println("\nEnter value of a and b
: \n");
a = sc.nextInt(); b = sc.nextInt();

stub.setValue(a,b);


System.out.println("Calling Server to solve the equation ...");
System.out.println("Answer : "+stub.getAns());
}
catch(Exception e){ System.out.println(e);
}
}
}
