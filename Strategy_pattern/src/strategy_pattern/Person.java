package strategy_pattern;

public class Person {
	MoveStrategy ms;
	
	public Person(MoveStrategy ms){
		this.ms = ms;
	}

	public void setMs(MoveStrategy ms) {
		this.ms = ms;
	}
	
	public void performMove() {
		ms.move();
	}

}
