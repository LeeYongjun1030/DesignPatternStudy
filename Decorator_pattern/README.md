# Decorator Pattern  
## Introduce
천재 과학자 이씨는 아톰을 만들었습니다.  
아톰의 초기 버전은 로봇의 기본 동작만 수행합니다.  
앞으로 새로운 버전이 나올 때마다 아톰의 기능은 추가될 수 있습니다.  
기능이 반드시 추가만 되는 것은 아니고 특정 기능을 뺄 수도 있습니다.  
즉, 여러 기능을 자유롭게 조합시켜 아톰에게 탑재시킬 수 있어야 합니다.  
이럴때 데코레이터 패턴이 사용될 수 있습니다.  


## Definition  
데코레이터 패턴은 객체에 추가적인 요건을 동적으로 첨가합니다. 쉽게 말해 장식과 같이 하나의 객체에 여러 기능을 꾸며줍니다.  
데코레이터는 서브클래스를 만드는 것을 통해서 기능을 유연하게 확장할 수 있는 방법을 제공합니다.  

## Structure  
 
![image](https://user-images.githubusercontent.com/78812317/142823620-d6e3ef19-e0eb-4cc5-a39f-8a836eb2c69c.png)


## Source Code

가장 먼저 컴포넌트 인터페이스를 만들어줍니다. 구현체가 없는 operate() 메서드를 갖고 있습니다.  
```Java

public interface Robot {
	public void operate();
}

```

이 컴포넌트 인터페이스를 구현하는 콘크리트컴포넌트 클래스를 만들어줍니다. operate()를 구현합니다.  
```Java

public class DefaultRobot implements Robot {

	public void operate() {
		System.out.print("Basic");
	}

}

```

그리고 데코레이터 클래스를 작성합니다.   
여기에서도 operate() 메서드를 구현하게 됩니다.    

```Java

public class RobotDecorator implements Robot {

	private Robot robot;
	
	public RobotDecorator(Robot robot) {
		this.robot = robot; 
	}
	
	public void operate() {
		robot.operate();
	}
}

```

그리고 데코레이터 클래스를 상속받아 다양한 기능을 가진 클래스들을 작성해줍니다.  
구조가 조금 어렵게 느껴질 수 있는데, 생성자의 인자로 컴포넌트형을 받는 이유는 이렇게 해야 장식을 동적으로 연결시켜줄 수 있기 때문입니다.  
테스트 실행 코드를 보면 조금 감이 올 수도 있습니다.  하지만 그래도 어려움  


```Java

public class Fly extends RobotDecorator {
		
	public Fly(Robot robot){
		super(robot); 
	}
	
	public void operate() {
		super.operate();
		System.out.print(" + Fly");
	}
	
}

```


```Java

public class Attack extends RobotDecorator {
	
	public Attack(Robot robot) {
		super(robot);
	}
	
	public void operate() {
		super.operate();
		System.out.print(" + Attack");
	}
}

```

테스트는 아래와 같이 진행됩니다.  

```Java
import javax.print.attribute.standard.PrinterInfo;

public class PatternTest {

	public static void main(String[] args) {
		
		System.out.println("Atom verson1");
		Robot atom_v1 = new DefaultRobot();
		atom_v1.operate();
		
		System.out.println("\n\nAtom verson2");
		Robot atom_v2 = new Fly(new DefaultRobot());	
		atom_v2.operate();
		
		
		System.out.println("\n\nAtom verson3");
		Robot atom_v3 = new Attack(new Fly(new DefaultRobot()));
		atom_v3.operate();
		

	}

}

```

기능이 동적으로 추가되는 것을 볼 수 있습니다.  
```
Atom verson1
Basic

Atom verson2
Basic + Fly

Atom verson3
Basic + Fly + Attack
```

처음에 이 방식이 도통 이해가 되지 않았었는데,  
위의 atom_v3를 보면 우선 new Attack(~)으로 인스턴스를 생성하게 되고 그 인자로 new Fly()가 들어갑니다.  
Attack의 생성자를 보면 이 Fly()를 super의 robot에 할당하게 됩니다. 즉, 데코레이터 클래스에서 작성했었던 private Robot robot 이거!!  
그리고 atom_v3.operate()를 하게되면 Attack 클래스의 operate()를 보면 super.operate()를 먼저 실행하게 되어 있습니다.   
즉 상위 클래스인 데코레이터 클래스의 operate()를 먼저 실행하게 되는데 또 보면 데코레이터의 operate()는 robot.operate()를 하도록 되어 있습니다.  
근데 이 robot에선 뭐가 있다? 우리가 아까 할당해줬던 Fly()가 할당되어 있죠. 그래서 이때 Fly의 operate()부터 실행되는 것입니다.  
그렇게 재귀 구조로 진행을 하면 결국 감싸준 순서대로 기능이 점점 추가되는 것을 출력을 통해 보실 수 있습니다. 어렵다 어려워!!  
