import se.nicklasgavelin.sphero.Robot;
import se.nicklasgavelin.sphero.command.SpinLeftCommand;
import se.nicklasgavelin.sphero.command.SpinRightCommand;
import se.nicklasgavelin.sphero.macro.MacroObject;
import se.nicklasgavelin.sphero.macro.command.Delay;
import se.nicklasgavelin.sphero.macro.command.Roll;


public class Macro {
	Robot r;
	private int heading=0;
	private double speed= 0.1;
	public Macro(Robot spheroRobot){
		this.r = spheroRobot;
	}
	void rollfwd(){
		MacroObject m = new MacroObject();
		m.addCommand( new Roll(1,1,0) );
		r.sendCommand(m);
		
	}
	void rollcircle(){
		int degree=0;
		
		
				MacroObject m = new MacroObject();
				while(degree<=359){
				m.addCommand( new Roll(0.2,degree, 0) );
				m.addCommand( new Delay( 500 ) );
				degree=degree+10;
				}
				m.addCommand(new Roll(0,0,0));
				r.sendCommand(m);
				
				
				
				//r.roll(degree, 1);
		
				
			
		
		
	}
void maze(String source){
	System.out.println(source);
		MacroObject m = new MacroObject();
		if (source.equals("forward")){
			speed=speed+0.02;
			
		} else if (source.equals("backward")){
			speed=speed-0.02;
		} else if (source.equals("left")){
			heading = heading +270;
			//m.addCommand(new SpinRightCommand(90));
			m.addCommand(new Delay(10));
		} else if (source.equals("right")){
			heading = heading +90;
		}
		heading = heading % 360;
		if (speed <0){
			speed = 0;
		}
		
		m.addCommand(new Roll(speed,heading,0));
		r.sendCommand(m);
	}
}
