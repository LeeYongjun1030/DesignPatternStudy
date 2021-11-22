# Observer Pattern  
## Introduce
아이돌스타의 팬들은 아이돌 스타를 팔로우합니다.  
팔로우하는 동안은 아이돌 스타의 일거수일투족을 알 수 있습니다.  
하지만 언팔로우를 하면 더 이상 일거수일투족을 알지 못하게 됩니다.  
이럴때 옵저버 패턴이 사용될 수 있습니다.  


## Definition  
옵저버 패턴은 한 객체의 상태가 바뀌면 그 객체에 의존하는 다른 객체들한테 연락이 가고 자동으로 내용이 갱신되는 방식으로, 일대다 의존성을 정의합니다. 

## Structure  

주체 객체와 옵저버 객체가 존재합니다.  
주체 객체는 리스트에 옵저버 객채를 넣고, 빼고, 알림을 보내는 Subject 인터페이스를 구현합니다.  
옵저버 객체는 상태를 업데이트하는 Observer 인터페이스를 구현합니다.  
![observerPatternStructure](https://user-images.githubusercontent.com/78812317/142654191-da9626bc-bc09-481d-a12f-c04860cee9ef.PNG)


## Source Code

Subject 인터페이스를 작성합니다.  
Subject 인터페이스를 구현하는 클래스는 register, unresister, notify 메서드를 구현해야 합니다.  
  
여기선 Star 인터페이스를 만들어주고 추상메서드 follow, unfollow, notifyFans를 작성합니다.  

```Java
package observer_pattern2;

public interface Star {
	public void follow(Fan fan);
	public void unfollow(Fan fan);
	public void notifyFans(String msg);
}

```
  
```Java
package observer_pattern2;

import java.util.ArrayList;

public class IdolStar implements Star {

	ArrayList<Fan> fans = new ArrayList<>();
	
	public void follow(Fan fan) {
		fans.add(fan);
	}

	public void unfollow(Fan fan) {
		int idx = fans.indexOf(fan);
		if (idx != -1) {
			fans.remove(idx);
		}
	}

	public void notifyFans(String msg) {
		fans.forEach(fan -> fan.update(msg));
	}

}

```  
  
한편, Observer 인터페이스도 작성해야 합니다.  
Observer 인터페이스를 구현하는 클래스는 update() 메서드를 구현합니다. 이 메서드를 통해 바뀐 정보를 저장합니다.  
  

  
```Java
package observer_pattern2;

public interface Fan {
	public void update(String msg);
}

```



```Java
package observer_pattern2;

public class BoyFan implements Fan {

	public void update(String msg) {
		System.out.println("boyFan 수신:"+msg);
	}

}

```



```Java
package observer_pattern2;

public class GirlFan implements Fan {

	public void update(String msg) {
		System.out.println("girlFan 수신:"+msg);
	}

}

```



  
테스트는 아래와 같이 진행됩니다.  
  
```Java
package observer_pattern2;

public class PatternTest {

	public static void main(String[] args) {
		BoyFan boy = new BoyFan();
		GirlFan girl = new GirlFan();
		
		IdolStar kim = new IdolStar();
		
		kim.follow(boy);
		kim.follow(girl);
		kim.notifyFans("밥 먹었습니다.");
		
		kim.unfollow(boy);
		kim.notifyFans("운동 했습니다.");
	}

}

```


``` 
boyFan 수신:밥 먹었습니다.
girlFan 수신:밥 먹었습니다.
girlFan 수신:운동 했습니다.
```  
아이돌 김씨는 소년팬과 소녀팬을 갖고 있습니다.  
소년팬과 소녀팬이 김씨를 팔로우하고 있는 동안엔 김씨의 메세지를 전달받게 됩니다.  
그러다 언팔로우를 하게 되면 그 팬은 더 이상 메세지를 전달받지 않게 됩니다.  
  
  여기선 개념 이해를 목적으로 가장 간단한 구조만을 작성했으므로, subject가 직접 observer를 관리하지만 변형을 통해 observer가 직접 resister, unresister를 실행하도록 작성할 수도 있습니다.  
