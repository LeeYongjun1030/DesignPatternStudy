package facade_pattern;

public class Movie {
	String movieName;
	
	public Movie(String movieName) {
		this.movieName = movieName;
	}
	
	public void findMovie() {
		System.out.println("영화 " + movieName + " 검색.");
		
	}
	
	public void payMovie() {
		System.out.println("영화 " + movieName + " 결제 완료.");
		
	}
	
	public void playMovie() {
		System.out.println("영화 " + movieName + " 재생.");
		
	}
	
	
	
}
