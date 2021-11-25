# Adapter Pattern

## Introduction
한국인 김씨는 길을 걷던 도중, 한국을 여행 중인 일본인 고쿠과 마주쳤습니다.  
일본인 고쿠는 김씨에게 길을 물어보고, 김씨는 번역기를 사용해 소통을 하고자 합니다.  

## Definition
어댑터 패턴은 한 클래스의 인터페이스를 클라이언트에서 사용하고자 하는 다른 인터페이스로 변환합니다.  
어댑터를 이용하면 인터페이스 호환성 문제 때문에 같이 쓸 수 없는 클래스들을 연결해서 쓸 수 있습니다.  

## Structure
![image](https://user-images.githubusercontent.com/78812317/143394561-3caa2245-81bb-4db9-89a0-5335e688ec10.png)

현재 상황에서 한국어 인터페이스가 Target이고  
일본어 인터페이스가 Adaptee가 됩니다.  
## Source code

한국어 인터페이스를 만들어줍니다.(Target)  
```Java
package adapter_pattern;

public interface Korean {
	public void helloInKorean();
	public void goodbyeInKorean();
}

```
한국어 인터페이스를 구현하는 클래스를 만듭니다.  
```Java
package adapter_pattern;

public class PersonInKorea implements Korean {

	@Override
	public void helloInKorean() {
		System.out.println("안녕하세요! ");
	}

	@Override
	public void goodbyeInKorean() {
		System.out.println("안녕히계세요! ");
	}

}

```

일본어 인터페이스를 만듭니다.(Adaptee)  
```Java
package adapter_pattern;

public interface Japanese {
	public void helloInJapanese();
	public void goodbyeInJapanese();
}

```

일본어 인터페이스를 구현하는 클래스를 만듭니다.  
```Java
package adapter_pattern;

public class PersonInJapan implements Japanese{

	@Override
	public void helloInJapanese() {
		System.out.println("Konnichiwa! ");
	}

	@Override
	public void goodbyeInJapanese() {
		System.out.println("Sayonara! ");
	}

}

```

이제 어댑터를 만들어봅시다.  
어댑터는 한국어 인터페이스를 구현하도록 해야 합니다. 

```Java
package adapter_pattern;

public class JapaneseAdapter implements Korean {

	Japanese japanese;
	
	public JapaneseAdapter(Japanese japanese) {
		this.japanese = japanese;
	}
	
	@Override
	public void helloInKorean() {
		japanese.helloInJapanese();
	}

	@Override
	public void goodbyeInKorean() {
		japanese.goodbyeInJapanese();
	}

}

```

테스트는 아래와 같이 진행됩니다.  

```Java
package adapter_pattern;

public class PatternTest {

	public static void main(String[] args) {
		
		PersonInKorea kim = new PersonInKorea();
		kim.helloInKorean();
		kim.goodbyeInKorean();
		
		System.out.println("==번역기를 이용하여 번역==");
		Korean japaneseAdapter = new JapaneseAdapter(new PersonInJapan());
		japaneseAdapter.helloInKorean();
		japaneseAdapter.goodbyeInKorean();

	}

}

```

출력 결과는 아래와 같습니다.  
```Java
안녕하세요! 
안녕히계세요! 
==번역기를 이용하여 번역==
Konnichiwa! 
Sayonara! 
```
김씨는 어댑터 패턴을 이용하여 성공적으로 번역기를 사용하였습니다.  
어댑터 패턴을 사용하면 클라이언트 입장에서 Japan 인터페이스의 메서드의 이름을 알 필요가 없어집니다.  


## Reference
책 - 헤드퍼스트 디자인패턴  
