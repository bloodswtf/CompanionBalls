package companionBalls.buttonActinos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import companionBalls.robotContainerParts.RobotController;

public class ForwardButtonHandler implements ActionListener {
	
	private RobotController rc;
	
	public ForwardButtonHandler(RobotController robotContainer)	{
		this.rc = robotContainer;
	}
	
	public void actionPerformed(ActionEvent e) {			
		rc.rollForward();
	}
}
