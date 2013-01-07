import java.io.IOException;

import se.nicklasgavelin.sphero.Robot;
import se.nicklasgavelin.sphero.command.CommandMessage;
import se.nicklasgavelin.sphero.response.InformationResponseMessage;
import se.nicklasgavelin.sphero.response.ResponseMessage;
import se.nicklasgavelin.sphero.response.information.DataResponse;

/**
 * For testing the sensor listener
 * 
 * @author david
 *
 */

public class RobotSensorListener implements se.nicklasgavelin.sphero.RobotListener {

	DataResponse dr;
	WebsocketServer ws;

	//TODO: put a network thingy in the constructor
	public RobotSensorListener(WebsocketServer ws)	{
		//if (ws!=null)
		this.ws=ws;
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
		int heading = dc.getHeading();
		double speed = dc.getSpeed();
		try {
			ws.sendcommands(heading, speed);
		} catch (IOException e) {
			System.out.println("lol fail in informationResponseReceived");
		}
		
		
	}
}
