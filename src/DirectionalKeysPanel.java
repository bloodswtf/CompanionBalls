import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import se.nicklasgavelin.sphero.macro.*;
import se.nicklasgavelin.sphero.macro.command.Roll;

/**
 * To be continued 
 * 
 * @author CompanionBall
 *
 */

public abstract class DirectionalKeysPanel extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3277777915713439929L;
//	private ConnectThread ct;
	private JButton forwardButton, leftButton, rightButton, stopButton;

	int currentHeading = 0;
	double speed = 0.2;
	
	public DirectionalKeysPanel(/*ConnectThread ct*/)	{
		//this.ct = ct;
		
		forwardButton = new JButton("Forward!");
		leftButton = new JButton("Left");
		rightButton = new JButton("Right");
		
		forwardButton.addActionListener(this);
		leftButton.addActionListener(this);
		rightButton.addActionListener(this);
		
		this.add(forwardButton, BorderLayout.CENTER);
		this.add(stopButton, BorderLayout.CENTER);
		this.add(leftButton, BorderLayout.PAGE_START);
		this.add(rightButton, BorderLayout.PAGE_END);
	}
	
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		if (e.getSource()==leftButton){
//			MacroObject m = new MacroObject();
//			currentHeading = (currentHeading+270)%360;
//			m.addCommand(new Roll(speed, currentHeading, 0));
//			ct.r.sendCommand(m);
//		}
//		if (e.getSource()==rightButton){
//			MacroObject m = new MacroObject();
//			currentHeading = (currentHeading+90)%360;
//			m.addCommand(new Roll(speed, currentHeading, 0));
//			ct.r.sendCommand(m);
//		}
//		
//		if (e.getSource()==forwardButton){
//			MacroObject m = new MacroObject();
//			m.addCommand(new Roll(speed, currentHeading, 0));
//			ct.r.sendCommand(m);
//		} 
//		
//		
//		if (e.getSource()==stopButton){
//			MacroObject m = new MacroObject();
//			//m.addCommand(command);
//			m.addCommand( new Roll(0,1,10) );
//			ct.r.sendCommand(m);
////			ct.r.sendCommand(new AbortMacroCommand());
////			ct.stopThread();
//		} 
//		
//	}
	
	
	
}
