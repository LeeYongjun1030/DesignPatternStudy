# Factory Pattern
## Introduction
공을 만드는 공장이 있습니다. 클라이언트는 공장에게 원하는 공을 만들어 달라고 부탁합니다.
공장은 최대한 어떤 부탁이던 유연하게 대처할 수 있도록 만들고 싶습니다.  

## Definition
1. 팩토리 메서드 패턴은 객체를 생성하기 위한 인터페이스를 정의하고, 어떤 클래스의 인스턴스를 만들지는 서브클래스에서 결정하게 만듦니다.  
2. 추상 팩토리 패턴은 제품을 생성하는 인터페이스를 구성하고, 그 인터페이스를 사용하여 제품이 만들어지도록 하는 패턴입니다.  

## Question
팩토리 메서드 패턴과 추상 팩토리 패턴은 무엇이 다른가?  
  
팩터리 메서드 패턴에서는 구상 클래스에서 객체를 만든다. 즉 구상 클래스에서 인스턴스를 생성함.  
    
반면 추상 팩토리 페턴에서는 추상 팩토리 인터페이스를 구상하는 구상 인터페이스, 즉 concreteFactory()에서 직접 객체를 만들지는 않는다. 단지 구현 메서드를 구현할 뿐.  
이 경우 클라이언트가 추상 인터페이스를 통해서 제품들을 공급받는 구조이기 떄문에 팩토리는 어떤 제품이 생산되는지 알 필요가 없게 된다. 즉 클라이언트와 제품을 분리시킬 수 있다.  


## Structure
![image](https://user-images.githubusercontent.com/78812317/143057590-7516568d-46c6-45a5-a638-f98244b7a099.png)



## Source code
아래의 소스코드만으로 팩토리 패턴을 완벽히 나타내기에는 무리가 있으나,  
이해를 위하여 가장 간단한 팩토리 구조만을 설명합니다.  

```Java
package factory_pattern;

public interface Ball {
	public void make();
}

```  

```Java
package factory_pattern;

public class SoccerBall implements Ball {

	@Override
	public void make() {
		System.out.println("Soccer ball is maded.");
	}

}


```

```Java
package factory_pattern;

public class BaseBall implements Ball {

	@Override
	public void make() {
		System.out.println("Base ball is maded.");
	}

}


```

```Java
package factory_pattern;

public class TennisBall implements Ball {

	@Override
	public void make() {
		System.out.println("Tennis Ball is maded.");
	}

}


```

아래와 같이 팩토리 안에서 인스턴스를 생성하도록 합니다.  
```Java
package factory_pattern;

public class BallFactory {
	
	public Ball getBall(String ballType) {
		
	  if(ballType == null){
	         return null;
	      }		
	      if(ballType.equalsIgnoreCase("soccerball")){
	         return new SoccerBall();
	         
	      } else if(ballType.equalsIgnoreCase("baseball")){
	         return new BaseBall();
	         
	      } else if(ballType.equalsIgnoreCase("tennis")){
	         return new TennisBall();
	      }
	      
	      return null;
	}
}

```

테스트는 아래와 같이 진행됩니다.  

```Java
package factory_pattern;

public class PatternTest {

	public static void main(String[] args) {
		
		BallFactory ballFactory = new BallFactory();
		Ball ball = ballFactory.getBall("soccerBall");
		ball.make();
		
		Ball ball2 = ballFactory.getBall("baseBall");
		ball2.make();
	}

}

```

```
Soccer ball is maded.
Base ball is maded.
```

## Reference
도서: 헤드퍼스트디자인패턴  
글: https://jusungpark.tistory.com/14
