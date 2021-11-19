package strategy_pattern;

public class Car implements MoveStrategy {

	public void move() {
		System.out.println("차를 타고 학교에 갑니다.");
	}

}
