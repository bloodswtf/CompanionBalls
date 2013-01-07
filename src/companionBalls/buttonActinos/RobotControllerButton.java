package companionBalls.buttonActinos;

import companionBalls.robotContainerParts.RobotController;

public abstract class RobotControllerButton {

	private RobotController rc;
	
	public RobotControllerButton(RobotController robotController)	{
		this.rc=robotController;
	}
}
