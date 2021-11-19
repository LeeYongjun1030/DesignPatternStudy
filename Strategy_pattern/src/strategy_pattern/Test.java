package strategy_pattern;

public class Test {

	public static void main(String[] args) {
		
		Person kim = new Person(new Walk());
		kim.performMove();
		
		Person lee = new Person(new Bus());
		lee.performMove();
		
		//lee가 차를 구입 -> 전략을 수정
		lee.setMs(new Car());
		lee.performMove();
		
		
	}

}
