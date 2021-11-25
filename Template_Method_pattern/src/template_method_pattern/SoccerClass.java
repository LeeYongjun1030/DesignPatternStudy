package template_method_pattern;

public abstract class SoccerClass {
	public void routine() {
		warmUp();
		practice();
		finish();
		
		
	}
	
	public void warmUp() {
		System.out.println("준비 운동");
	}
	
	public void finish() {
		System.out.println("운동 끝");
	}
	
	public abstract void practice();
}
