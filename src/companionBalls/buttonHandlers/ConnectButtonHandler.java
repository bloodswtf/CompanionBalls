package companionBalls.buttonHandlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import companionBalls.RobotContainer;

public class ConnectButtonHandler implements ActionListener {
	
	private RobotContainer rb;
	
	public ConnectButtonHandler(RobotContainer robotContainer)	{
		this.rb = robotContainer;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		rb.searchAndConnectToSphero();
	}
	
	
}
