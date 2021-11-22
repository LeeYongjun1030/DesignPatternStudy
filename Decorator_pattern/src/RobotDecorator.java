
public class RobotDecorator implements Robot {

	private Robot robot;
	
	public RobotDecorator(Robot robot) {
		this.robot = robot; 
	}
	
	public void operate() {
		robot.operate();
	}
}
