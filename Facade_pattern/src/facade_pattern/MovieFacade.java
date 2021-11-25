package facade_pattern;

public class MovieFacade {
	
	String movieName;
	String bevarageName;
	
	public MovieFacade(String movieName, String bevarageName) {
		this.movieName = movieName;
		this.bevarageName = bevarageName;
	}

	public void watchMovie() {
		
		RemoteControl remoteControl = new RemoteControl();
		Movie movie = new Movie(movieName);
		Beverage beverage = new Beverage(bevarageName);
		
		beverage.prepare();
		remoteControl.turnOn();
		movie.findMovie();
		movie.payMovie();
		movie.playMovie();
	}
}
