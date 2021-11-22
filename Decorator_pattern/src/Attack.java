
public class Attack extends RobotDecorator {
	
	public Attack(Robot robot) {
		super(robot);
	}
	
	public void operate() {
		super.operate();
		System.out.print(" + Attack");
	}
}
