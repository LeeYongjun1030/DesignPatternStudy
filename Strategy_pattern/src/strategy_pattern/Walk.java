package strategy_pattern;

public class Walk implements MoveStrategy {

	public void move() {
		System.out.println("걸어서 학교에 갑니다.");
	}

}
