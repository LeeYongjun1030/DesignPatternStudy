# Proxy Pattern

## Definition
프록시 패턴은 어떤 객체에 대한 접근을 제어하기 위한 용도로 대리인이나 대변인에 해당하는 객체를 제공하는 패턴입니다.  
## Structure
![image](https://user-images.githubusercontent.com/78812317/144000216-461f84b2-7286-456c-ac51-66b055e3db10.png)

## Types
프록시 패턴은 다양하게 활용이 될 수 있습니다.  
   
**원격 프록시**는 원격 객체에 대한 접근을 제어할 수 있습니다.  
**가상 프록시**는 생성하기 힘든 자원에 대한 접근을 제어할 수 있습니다.  
**보호 프록시**는 접근 권한이 필요한 자원에 대한 접근을 제어할 수 있습니다.   

## Source Code
이번 예제에서는 가장 간단한 프록시 패턴 형태만을 살펴보겠습니다.  

가장 먼저 Subject 인터페이스를 만들어줍니다. 여기선 IService가 Subject 인터페이스에 해당합니다.  
```Java
package proxy_pattern;

public interface IService {
	String runSomething();
}

```

그리고 RealSubject 클래스를 작성합니다. 여기서는 Service 클래스에 해당합니다.  
```Java
package proxy_pattern;

public class Service implements IService {

	@Override
	public String runSomething() {
		return "서비스 실행";
	}

}

```

그리고 프록시 클래스를 만듭니다.  

```Java
package proxy_pattern;

public class Proxy implements IService {
	
	IService iService;
	
	@Override
	public String runSomething() {
		iService = new Service();
		return iService.runSomething(); // delegate  
	}

}

```

테스트는 다음과 같이 진행됩니다.  
```Java
package proxy_pattern;

public class PatternTest {

	public static void main(String[] args) {
		Proxy proxy = new Proxy();
		System.out.println(proxy.runSomething());
		
	}

}

```

출력 결과는 다음과 같습니다.  
```
서비스 실행
```


## Reference
책 - 헤드퍼스트 디자인패턴  
   
더 자세한 내용  
원격 프록시 관련 참고 글 : https://gre-eny.tistory.com/253  
가상 프록시, 보호 프록시 관련 글 : https://jdm.kr/blog/235  
