# Strategy Pattern  
## Introduce 
서울대학교에 다니는 많은 학생들은 다양한 방법으로 학교에 통학합니다.  
집이 가깝거나 기숙사에 사는 학생들은 직접 걸어서 등교합니다.  
집이 멀거나 자취를 하는 학생들은 버스나 자동차를 이용해 등교합니다.  

즉, 학생들은 환경에 따라 여러 가지 등교 전략을 수립합니다.  
하지만 처음 정한 전략을 끝까지 유지하는 것은 아닙니다.  
상황에 따라 등교 전략을 바꿀 수도 있습니다.  


## Definition
전략 패턴이란 행동을 클래스로 캡슐화하여 동적으로 행동 전략을 바꿀 수 있게 해주는 디자인 패턴입니다.  
코드 블럭 내부를 일일이 수정하지 않고도 손쉽게 전략을 바꿀 수 있습니다.  


## Structure  
전략 패턴은 다음과 같은 구조를 가집니다.

![strategyPatternStructure](https://user-images.githubusercontent.com/78812317/142611871-e7141037-f618-488c-b2e7-29353de75749.PNG)

## Source Code
  
전략 인터페이스를 생성합니다.  
``` Java
package strategy_pattern;

public interface MoveStrategy {
	public void move();
}
```  

  
전략을 구현하는 클래스들을 만들어줍니다.  
``` Java
package strategy_pattern;

public class Walk implements MoveStrategy {

	public void move() {
		System.out.println("걸어서 학교에 갑니다.");
	}

}

```


``` Java
package strategy_pattern;

public class Bus implements MoveStrategy {

	public void move() {
		System.out.println("버스를 타고 학교에 갑니다.");
	}

}

```

``` Java
package strategy_pattern;

public class Car implements MoveStrategy {

	public void move() {
		System.out.println("차를 타고 학교에 갑니다.");
	}

}

```
  
전략을 사용할 객체를 만들어줍니다.  
``` Java
package strategy_pattern;

public class Person {
	MoveStrategy ms;
	
	public Person(MoveStrategy ms){
		this.ms = ms;
	}

	public void setMs(MoveStrategy ms) {
		this.ms = ms;
	}
	
	public void performMove() {
		ms.move();
	}

}

```
  
테스트는 다음과 같이 실행할 수 있습니다.  
``` Java
package strategy_pattern;

public class Test {

	public static void main(String[] args) {
		
		Person kim = new Person(new Walk());
		kim.performMove();
		
		Person lee = new Person(new Bus());
		lee.performMove();
		
		//lee가 차를 구입 -> 전략을 수정
		lee.setMs(new Car());
		lee.performMove();
		
		
	}

}
```

출력 결과는 다음과 같습니다. 
```
걸어서 학교에 갑니다.
버스를 타고 학교에 갑니다.
차를 타고 학교에 갑니다.
```
