
public class Fly extends RobotDecorator {
		
	public Fly(Robot robot){
		super(robot); 
	}
	
	public void operate() {
		super.operate();
		System.out.print(" + Fly");
	}
	
}
