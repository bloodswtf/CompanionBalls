
import java.awt.Color;

import se.nicklasgavelin.sphero.Robot;
import se.nicklasgavelin.sphero.command.SetDataStreamingCommand;
import se.nicklasgavelin.sphero.macro.MacroObject;
import se.nicklasgavelin.sphero.macro.command.*;

public class Macro {
	Robot r;
	private int currentHeading = 0;
	private double speed = 0.4; 
	
	public Macro(Robot spheroRobot){
		this.r = spheroRobot;
	}
	public void rollfwd(){
		MacroObject m = new MacroObject();
		m.addCommand( new Roll(1,1,0) );
		r.sendCommand(m);

	}
	public void rollcircle(){
		int degree=0;
		MacroObject m = new MacroObject();
		while(degree<=359){
			m.addCommand( new Roll(speed,degree, 0) );
			m.addCommand( new Delay( 500 ) );
			degree=degree+15;
		}
		m.addCommand(new Roll(0,0,0));
		r.sendCommand(m);
		//r.roll(degree, 1);
	}
	public void changeColor(Color color)	{
//		MacroObject m = new MacroObject();
//		m.addCommand(new Delay( 2000));
//		r.sendCommand(m);
		r.setRGBLedColor(color);
	}
	public void rollForward()	{
		MacroObject m = new MacroObject();
		m.addCommand(new Roll(speed,currentHeading,0));
		r.sendCommand(m);
	}
	public void stop()	{
		MacroObject m = new MacroObject();
		m.addCommand(new Roll(0,0,0));
		r.sendCommand(m);
	}
	public void rollLeft()	{
		MacroObject m = new MacroObject();
		currentHeading = (currentHeading+330)%360;
//		currentHeading = (currentHeading+270)%360;
		m.addCommand(new Roll(speed, currentHeading, 0));
		r.sendCommand(m);
	}
	public void rollRight()	{
		MacroObject m = new MacroObject();
		//currentHeading = (currentHeading+90)%360;
		currentHeading = (currentHeading+30)%360;
		m.addCommand(new Roll(speed, currentHeading, 0));
		r.sendCommand(m);
	}
	//From forum.gosphero.com/archive/index.php/t-806.html
	//TODO: change void return type
	public void getDataFromGyro()	{
		SetDataStreamingCommand sds = new SetDataStreamingCommand(210, 1, SetDataStreamingCommand.DATA_STREAMING_MASKS.GYRO.ALL.RAW, 100);
		r.sendCommand(sds);
	}
}
