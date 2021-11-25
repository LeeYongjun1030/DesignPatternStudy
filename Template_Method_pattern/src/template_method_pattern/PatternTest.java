package template_method_pattern;

public class PatternTest {

	public static void main(String[] args) {
		
		System.out.println("== Day 1 ==");
		SoccerClass today = new ShootingClass();
		today.routine();
		
		System.out.println("\n== Day 2 ==");
		SoccerClass tomorrow = new PassClass();
		tomorrow.routine();
	}

}
