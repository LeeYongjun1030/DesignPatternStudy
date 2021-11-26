package template_method_pattern;

public abstract class SoccerClass {
	
	public void routine() {
		warmUp();
		practice();
		finish();
	}
	
	public void warmUp() {
		System.out.println("�غ� �");
	}
	
	public void finish() {
		System.out.println("� ��");
	}
	
	public abstract void practice();
}
