package facade_pattern;

public class Movie {
	String movieName;
	
	public Movie(String movieName) {
		this.movieName = movieName;
	}
	
	public void findMovie() {
		System.out.println("��ȭ " + movieName + " �˻�.");
		
	}
	
	public void payMovie() {
		System.out.println("��ȭ " + movieName + " ���� �Ϸ�.");
		
	}
	
	public void playMovie() {
		System.out.println("��ȭ " + movieName + " ���.");
		
	}
	
	
	
}
