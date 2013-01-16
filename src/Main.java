
import java.io.IOException;
import java.sql.ClientInfoStatus;
import java.util.Iterator;


import se.nicklasgavelin.sphero.Robot;

import companionBalls.*;
import companionBalls.buttonHandlers.AddRobotsToArrayButtonHandler;
import companionBalls.buttonHandlers.BackwardButtonHandler;
import companionBalls.buttonHandlers.ChangeColorButtonHandler;
import companionBalls.buttonHandlers.ConnectButtonHandler;
import companionBalls.buttonHandlers.ForwardButtonHandler;
import companionBalls.buttonHandlers.LeftButtonHandler;
import companionBalls.buttonHandlers.MakeClientButtonHandler;
import companionBalls.buttonHandlers.MakeServerButtonHandler;
import companionBalls.buttonHandlers.RightButtonHandler;
import companionBalls.buttonHandlers.SpinButtonHandler;
import companionBalls.buttonHandlers.StopButtonHandler;
import companionBalls.gui.JavaGui;
import companionBalls.robotContainerParts.RobotController;

public class Main {
	
	
//	public static void main(String[] args) {
//		//Example_Site_API example = new Example_Site_API();
//		// new Thread( new Example_Site_API() ).start();
//		//	DirectionalKeysPanel DKP = null;// = new DirectionalKeysPanel();if( ct != null )
//		//ct.stopThread();
//		// Create a new thread
//		//		ConnectThread ct = new ConnectThread();
//		//		ct.start();
//		//		while(ct.getRobotArray().size()==0){}
//		
//		String bluetoothAddress = "000666440DB8"; //NEW , WBG
//		//String bluetoothAddress = "0006664438B8"; //OLD, BBR
//		String ConnectToIP = "130.240.95.209";
//		
//		GurrUI gurrui = new GurrUI(new ConnectThread(bluetoothAddress), ConnectToIP);
//		gurrui.fixGUI();
//		
//		
//		//backgroundvariables, do not touch
//		//server sends commands - clients recieves and does them	
//	}
	
	public static void main(String[] args)	{
		JavaGui gui = new JavaGui();
		String ipToServer = "";  //TODO: fill in the server ip
		
		RobotContainer robotContainer = new RobotContainer();
		
		//Adding the button listeners to the buttons
		gui.addForwardButtonHandler(new ForwardButtonHandler(robotContainer.controller));
		gui.addBackwardButtonHandler(new BackwardButtonHandler(robotContainer.controller));
		gui.addLeftButtonHandler(new LeftButtonHandler(robotContainer.controller));
		gui.addRightButtonHandler(new RightButtonHandler(robotContainer.controller));
		gui.addChangeColorButtonHandler(new ChangeColorButtonHandler(robotContainer.controller));
		gui.addSpinButtonHandler(new SpinButtonHandler(robotContainer.controller));
		gui.addStopButtonHandler(new StopButtonHandler(robotContainer.controller));
		gui.addConnectButtonHandler(new ConnectButtonHandler(robotContainer));
		gui.addAddRobotsToArrayButtonHandler(new AddRobotsToArrayButtonHandler(robotContainer));
		gui.addClientButtonHandler(new MakeClientButtonHandler(robotContainer, ipToServer));
		gui.addServerButtonHanlder(new MakeServerButtonHandler(robotContainer));
	}
}

