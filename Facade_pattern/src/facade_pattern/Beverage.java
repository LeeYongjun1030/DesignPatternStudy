package facade_pattern;

public class Beverage {
	
	private String beverageName;
	
	public Beverage(String beverageName) {
		this.beverageName = beverageName;
	}
	
	public void prepare() {
		System.out.println("음료 "+beverageName+" 준비 완료.");
	}
}
