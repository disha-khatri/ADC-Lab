import java.io.*;
import java.util.*;
import java.net.*;
import java.util.concurrent.TimeUnit;
 
// Server class
public class Server  
{
 
    // Vector to store active clients
    static Vector<ClientHandler> ar = new Vector<>();
    static List<String> list = new ArrayList<>();
    // counter for clients
    static int i = 0;
    static int flag=1;
    static String currentClient;
    
    public static void criticalSection(ClientHandler mtch) throws IOException
    {
        mtch.dos.writeUTF("Permission granted on Critical section.");
        System.out.println(currentClient+" has entered in Critical section!");
                try {
                        TimeUnit.SECONDS.sleep(10);
                      } catch (InterruptedException ie) {
                        ie.printStackTrace();
                      }
                System.out.println(currentClient+" has exited the Critical section!");
                
                if (mtch.name.equals(currentClient) && mtch.isloggedin==true)  
                    {
                        mtch.dos.writeUTF("Request processed!");
                    }
                
                list.remove(0);
    }
    public static void main(String[] args) throws IOException  
    {
        // server is listening on port 1234
        ServerSocket ss = new ServerSocket(1234);
         
        Socket s;
         
        // running infinite loop for getting
        // client request
        System.out.println("Coordinator is ready!");
        while (true)  
        {
            // Accept the incoming request
            s = ss.accept();
            
            System.out.println("\n______________________________________");
            System.out.println("New client request received : " + s);
             
            // obtain input and output streams
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
             
            //System.out.println("Creating a new handler for this client...");
 
            // Create a new handler object for handling this request.
            ClientHandler mtch = new ClientHandler(s,"Client-" + i, dis, dos);
            
            mtch.dos.writeUTF("Your request has been received and will be processed shortly ");
            
            // Create a new Thread with this object.
            //Thread t = new Thread(mtch);
            String client_name = mtch.name;
            //client_name = "Client-"+i;
            System.out.println("Request received from "+client_name);
 
            // add this client to active clients list
            ar.add(mtch);
                           
            list.add(client_name);
            
            //t.start();
            currentClient = list.get(0);
            
            //calling critical section
            if(!list.isEmpty() && flag==1)
            {
                flag = 0;
                criticalSection(mtch);
                flag = 1;
            }
            
            //List of clients
            System.out.print("List of Clients: ");
            for(ClientHandler ch: Server.ar)
            {
                System.out.print(ch.name+"\t");
            }
            // increment i for new client.
            // i is used for naming only, and can be replaced
            // by any naming scheme
            i++;
 
        }
    }
}
 
// ClientHandler class
class ClientHandler
{
    Scanner scn = new Scanner(System.in);
    String name;
    final DataInputStream dis;
    final DataOutputStream dos;
    Socket s;
    boolean isloggedin;
     
    // constructor
    public ClientHandler(Socket s, String name, DataInputStream dis, DataOutputStream dos) {
        this.dis = dis;
        this.dos = dos;
        this.name = name;
        this.s = s;
        this.isloggedin=true;
    }    
} 