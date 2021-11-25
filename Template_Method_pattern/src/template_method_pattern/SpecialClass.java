package template_method_pattern;

public class SpecialClass extends SoccerClass {

	@Override
	public void practice() {
		System.out.println("축구 시합");
	}

	public void finish() {
		System.out.println("오늘은 회식이다!");
	}
}
