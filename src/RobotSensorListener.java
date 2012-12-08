import java.awt.Color;

import se.nicklasgavelin.sphero.Robot;
import se.nicklasgavelin.sphero.command.CommandMessage;
import se.nicklasgavelin.sphero.command.RGBLEDCommand;
import se.nicklasgavelin.sphero.response.InformationResponseMessage;
import se.nicklasgavelin.sphero.response.ResponseMessage;
import se.nicklasgavelin.sphero.response.information.DataResponse;


public class RobotSensorListener implements se.nicklasgavelin.sphero.RobotListener {

	DataResponse dr;
	
	//TODO: put a network thingy in the constructor
	public RobotSensorListener()	{
		
	}
	
	@Override
	public void responseReceived(Robot r, ResponseMessage response,
			CommandMessage dc) {
	}

	@Override
	public void event(Robot r, EVENT_CODE code) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void informationResponseReceived(Robot r,
			InformationResponseMessage response) {
		dr = ( DataResponse ) response;
		byte[] data = dr.getSensorData();
		System.out.print("Roll: " + data[1]+" ");
		System.out.print("Pitch: " + data[3]+" ");
		System.out.print("Yaw: " + data[5]+" ");
		DirectionCalculation dc = new DirectionCalculation();
		dc.calcDirection((int)(data[1]), (int)(data[3]));
		System.out.println("Heading "+dc.getHeading());
		System.out.println("  Speed "+dc.getSpeed()+"/n");
	}

}
