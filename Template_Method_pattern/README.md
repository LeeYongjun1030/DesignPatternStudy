# Template Method Pattern

## Introduction
운동을 좋아하는 이씨는 축구 배우기 수업을 등록했습니다.  
강의는 짜여진 루틴대로 진행이 됩니다.  
요일마다 슈팅연습, 패스연습을 번갈아 가며 진행합니다.  


## Definition
템플릿 메서드 패턴에서는 메서드에서 알고리즘의 골격을 정의합니다.  
알고리즘의 여러 단계 중 일부는 서브클래스에서 구현할 수 있습니다.  
이때 알고리즘의 구조를 유지하며 서브클래스에서 특정 단계를 재정의할 수 있습니다.  


## Structure
![dd](https://user-images.githubusercontent.com/78812317/143424260-72cefe5a-9f8c-49d4-981f-b7e52cb22386.PNG)



## Source code

먼저 추상 클래스를 만들어줍니다.  
이때 이 클래스 안에 템플릿 메서드를 만들어주면 됩니다.  
여기서 추상 메서드로 선언된 메서드들은 서브클래스에서 구현되어야 합니다.  
```Java
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


```

추상 클래스를 상속받은 콘크리트 클래스들을 만들어줍니다. 이때 추상메서드를 구현하게 됩니다.  

```Java
package template_method_pattern;

public class ShootingClass extends SoccerClass {

	@Override
	public void practice() {
		System.out.println("슈팅 훈련");
	}

}

```


```Java
package template_method_pattern;

public class PassClass extends SoccerClass  {

	@Override
	public void practice() {
		System.out.println("패스 훈련");
	}

}

```
테스트는 아래와 같이 진행됩니다.  
```Java
package template_method_pattern;

public class PatternTest {

	public static void main(String[] args) {
		
		System.out.println("== Day 1 ==");
		SoccerClass today = new ShootingClass();
		today.routine();
		
		System.out.println("\n== Day 2 ==");
		SoccerClass tomorrow = new PassClass();
		tomorrow.routine();
	}

}

```

출력 결과는 아래와 같습니다.  
```Java
== Day 1 ==
준비 운동
슈팅 훈련
운동 끝

== Day 2 ==
준비 운동
패스 훈련
운동 끝
```
   
   
   
   
* 훅(HOOK)이란??  
훅은 추상클래스에서 선언되는 메소드긴 하지만 기본적인 내용만 구현되어 있거나 아무 코드도 들어있지 않은 메소드입니다.  
   
서브 클래스 하나를 더 만듭니다. 이전의 서브클래스와는 다르게 practice() 메서드 뿐만 아니라 finish() 메서드도 재정의합니다.  

```Java
package template_method_pattern;

public class SpecialClass extends SoccerClass {

	@Override
	public void practice() {
		System.out.println("축구 시합");
	}

	public void finish() {
		System.out.println("오늘은 회식이다!");
	}
}

```

다음과 같이 테스트하고 결과를 살펴봅니다. 

```Java
package template_method_pattern;

public class PatternTest {

	public static void main(String[] args) {
		
		System.out.println("== Day 1 ==");
		SoccerClass today = new ShootingClass();
		today.routine();
		
		System.out.println("\n== Day 2 ==");
		SoccerClass tomorrow = new PassClass();
		tomorrow.routine();
		
		
		System.out.println("\n== Day 3 ==");
		SoccerClass special = new SpecialClass();
		special.routine();
	}

}


```
출력 결과

```
== Day 1 ==
준비 운동
슈팅 훈련
운동 끝

== Day 2 ==
준비 운동
패스 훈련
운동 끝

== Day 3 ==
준비 운동
축구 시합
오늘은 회식이다!


```

## Question
* 언제 추상 메서드를 쓰고, 언제 후크을 써야 하나요?  
서브클래스에서 알고리즘의 특정 단계를 제공해야만 하는 경우에는 추상 메서드를 써야합니다.  
알고리즘의 특정 부분이 선택적으로 적용된다던가 하는 경우에는 후크를 쓰면 됩니다.  
후크를 쓰면 서브클래스에서 필요한 경우에 후크를 구현할 수 있지만, 반드시 구현해야 하는 것은 아니기때문입니다.  

## Reference
책: 헤드퍼스트 디자인패턴  
