package companionBalls;

import companionBalls.robotContainerParts.*;

public class RobotContainer {

	private RobotConnector connector;
	public RobotController controller;
	
	/**
	 * Starts a device search and if a Sphero is found then it's connected and stored in the RobotConnector
	 */
	public void searchAndConnectToSphero()	{
		connector.start();
	}
	
	/**
	 * Connects to a device without doing a device search 
	 * 
	 * @param bluetoothId The id to the bluetooth device
	 */
	public void connectToSphero(String bluetoothId)	{
		connector = new RobotConnector(bluetoothId);
	}
	
	/**
	 * Takes the Robot object from RobotConnector and makes it controllable by adding it to the RobotController object
	 */
	//TODO(For the far future): Remove this in the future and make the search and connect methods do this instead. 
	//Need some thing that checks if all the threads started by Bluetooth discover has finnished
	public void finilizeConnection()	{
		connector.getRobotArray();
		controller = new RobotController(connector.getRobotArray().get(0));
	}
}
