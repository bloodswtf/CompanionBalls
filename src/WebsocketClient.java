import java.net.*;
import java.io.*;

public class WebsocketClient
{
   public static void main(String [] args)
   {
      String serverName = args[0];
      int port = Integer.parseInt(args[1]);
      try
      {
         System.out.println("Connecting to " + serverName
                             + " on port " + port);
         Socket client = new Socket(serverName, port);
         System.out.println("Just connected to "
                      + client.getRemoteSocketAddress());
         
         InputStream inFromServer = client.getInputStream();
         DataInputStream in =
                        new DataInputStream(inFromServer);
         while(true){
        	 System.out.println("Server says " + in.readInt());
         }
         //client.close();
      }catch(IOException e)
      {
         e.printStackTrace();
      }
   }
}