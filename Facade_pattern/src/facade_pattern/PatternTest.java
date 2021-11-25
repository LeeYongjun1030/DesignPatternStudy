package facade_pattern;

public class PatternTest {

	public static void main(String[] args) {
		MovieFacade movieFacade = new MovieFacade("spiderman", "powerade");
		movieFacade.watchMovie();
	}

}
