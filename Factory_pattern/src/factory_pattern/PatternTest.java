package factory_pattern;

public class PatternTest {

	public static void main(String[] args) {
		
		BallFactory ballFactory = new BallFactory();
		Ball ball = ballFactory.getBall("soccerBall");
		ball.make();
		
		Ball ball2 = ballFactory.getBall("baseBall");
		ball2.make();
	}

}
