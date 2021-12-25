# Singleton Pattern

## Definition
싱글턴 패턴은 해당 클래스의 인스턴스가 하나만 만들어지고, 어디서든 그 인스턴스에 접근할 수 있도록 하기 위한 패턴입니다.  

## Source code
기본적인 구조는 아래와 같습니다.  

```Java
package singleton_pattern;

public class Singleton {
	private static Singleton instance;
	private Singleton(){}
	
	public static Singleton getInstance() {
		if(instance == null) {
			instance = new Singleton();
		}
		return instance;
	}
	
}

```
하지만 이 경우, 동기화 이슈가 발생할 수 있습니다.  
여러 스레드가 동시에 실행되면 인스턴스가 여러개 생성될 가능성이 있습니다.  
그래서 그 해결법으로 getInstance() 메서드를 동기화 시키는 방법이 있습니다.  
변화된 코드는 아래와 같습니다.  

```Java
package singleton_pattern;

public class Singleton {
	private static Singleton instance;
	private Singleton(){}
	
	public static synchronized Singleton getInstance() {
		if(instance == null) {
			instance = new Singleton();
		}
		return instance;
	}
	
}

```
