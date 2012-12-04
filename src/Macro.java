import se.nicklasgavelin.sphero.Robot;
import se.nicklasgavelin.sphero.macro.MacroObject;
import se.nicklasgavelin.sphero.macro.command.Delay;
import se.nicklasgavelin.sphero.macro.command.Roll;


public class Macro {
	Robot r;
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
}
