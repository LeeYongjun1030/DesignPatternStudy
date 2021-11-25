# Facade Pattern

## Definition
어떤 서브시스템의 일련의 인터페이스에 대한 통합된 인터페이스를 제공합니다.  
퍼사드에서 고수준 인터페이스를 정의하기 때문에 서브시스템을 더 쉽게 사용할 수 있습니다.  

## Structure
![image](https://user-images.githubusercontent.com/78812317/143416601-df3ae814-fe55-4d97-83f1-ca46772ba1e4.png)

## Source Code

영화를 보는 데에 필요한 음료, 리모컨, 영화에 대한 각각의 클래스를 만들고 기능을 설정해줍니다.  
```Java
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

```

```Java
package facade_pattern;

public class RemoteControl {
	public void turnOn(){
		System.out.println("TV를 켭니다.");
	}
	
}

```


```Java
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

```

이제 가장 핵심이 되는 Facade 클래스를 만들어 줍니다.  
이곳에서 복잡했던 일련의 과정들을 묶어줍니다.  

```Java
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

```

다음과 같이 테스트 할 수 있습니다.   
클라이언트 입장에서는 복잡한 일련의 과정을 일일이 거칠 필요 없이 손 쉽게 영화를 볼 수 있습니다.   
```Java
package facade_pattern;

public class PatternTest {

	public static void main(String[] args) {
		MovieFacade movieFacade = new MovieFacade("spiderman", "powerade");
		movieFacade.watchMovie();
	}

}

```


```Java
package facade_pattern;

public class PatternTest {

	public static void main(String[] args) {
		MovieFacade movieFacade = new MovieFacade("spiderman", "powerade");
		movieFacade.watchMovie();
	}

}

```
