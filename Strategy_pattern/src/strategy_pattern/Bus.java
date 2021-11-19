package strategy_pattern;

public class Bus implements MoveStrategy {

	public void move() {
		System.out.println("버스를 타고 학교에 갑니다.");
	}

}
