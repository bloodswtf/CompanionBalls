package companionBalls.robotContainerParts.networking;

import java.io.IOException;


public class ClientAndServerCreator{
	WebsocketClient	wc;
	WebsocketServer ws;

	public void ClientServerCreate(String servername, int ApplicationType, int port){
		int servertype = 0;
		int clienttype = 1;

		if (ApplicationType==servertype)
			try 
		{
				ws = new WebsocketServer(port);
				ws.start();
		} catch (IOException e) {e.printStackTrace();}


		else if (ApplicationType==clienttype){
			wc = new WebsocketClient(port, servername);


		} else {
			System.out.println("Warning: invalid second argument");	
		}
	}
}
