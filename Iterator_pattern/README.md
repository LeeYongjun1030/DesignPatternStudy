# Iterator Pattern

## Introduction
이씨는 가족 전화번호부와 친구 전화번호부를 갖고 있습니다.  
이들 목록을 보려고 합니다.  

## Definition
이터레이터 패턴은 컬렉션 구현 방법을 노출시키지 않으면서도 그 집합체 안에 들어있는 모든 항목에 접근할 수 있는 방법을 제공해줍니다.  

## Structure
![image](https://user-images.githubusercontent.com/78812317/143552847-20d81042-b71d-46fb-ae90-b5027b50acfa.png)

Aggregate는 집합이라는 의미를 가지고 있습니다.  
Aggregate 인터페이스는 createIterator()라는 추상메서드를 가지고 있습니다.  
ConcreteAggregate 클래스에서 createIterator() 메서드를 구현해야 합니다.  

## Source Code

가장 먼저, 이번 프로젝트에 쓰일 기본 객체를 만들어줍니다.  
Phone 객체를 만들고 설정합니다.  

```Java
package iterator_pattern;

public class Phone {
	private String name;
	private String number;
	
	public Phone(String name, String number) {
		this.name = name;
		this.number = number;
	}

	public String getName() {
		return name;
	}


	public String getNumber() {
		return number;
	}
	
}

```


그리고 Aggregate 인터페이스를 만들어줍니다. 여기서는 PhoneBook 인터페이스가 됩니다.  
Structure에서 봤듯이, createIterator()라는 추상메서드를 설정해줘야 합니다.  
```Java
package iterator_pattern;

import java.util.Iterator;

public interface PhoneBook {
	public Iterator<Phone> createIterator();
}
```

다음 단계로 ConcreteAggregate를 만들어서 Aggregate 인터페이스를 구현해야 합니다. 즉,  
PhoneBook 인터페이스를 구현하는 클래스를 만들어줘야 하는데,  
여기선 두가지 방법으로 구현 클래스를 만들고 그 차이에 대해 알아보겠습니다.  
   
   
   먼저, FriendsPhoneBook 클래스를 만듭니다. 이 곳에 Phone 객체들을 담아둘 Collection을 생성해야 하는데,  
   여기서는 ArrayList를 이용하여 콜렉션을 생성합니다.  


```Java
package iterator_pattern;

import java.util.ArrayList;
import java.util.Iterator;

public class FriendsPhoneBook implements PhoneBook {
	
	ArrayList<Phone> phones; // ArrayList로 배열을 생성

	
	public FriendsPhoneBook() {
		phones = new ArrayList();
		
		phones.add(new Phone("친구1", "123"));
		phones.add(new Phone("친구2", "456"));
	}

	@Override
	public Iterator<Phone> createIterator() {
		return phones.iterator();
	}
	


}

```

그리고 두번째 ConcreteAggregate 역할로 FamilyPhoneBook 클래스를 생성합니다. 앞서 만들었던 FriendsPhoneBook 클래스와는 다르게,  
ArrayList으로 Collection을 만들지 않고 기본 배열을 사용하여 만들어 줄겁니다.  

```Java
package iterator_pattern;

import java.util.Iterator;

public class FamilyPhoneBook implements PhoneBook {
	
	private Phone[] phones; // 고정 배열을 생성
	
	public FamilyPhoneBook() {
		phones = new Phone[2];
		
		phones[0] = new Phone("엄마","111");
		phones[1] = new Phone("아빠","222");
	}

	@Override
	public Iterator<Phone> createIterator() {
		return new FamilyIterator(phones);
	}

}

```

그렇다면 위의 두가지 방식에는 어떤 차이가 있는 걸까요?  
아까 말했듯이 ConcreteAggregate 역할의 클래스는 반드시 createIterator() 메서드를 구현해야 한다고 했습니다.  
이 메서드의 역할은 이름 그대로 iterator 역할을 해줄 객체를 생성해서 리턴하는 함수입니다.  
그런데 ArrayList는 우리가 알고 있듯이 이미 자바에서 iterator 기능이 구현되어 있습니다.  
그렇기 때문에 바로 .iterator()로 리턴해주면 됩니다. 위에서 확인할 수 있을 겁니다.  
   
   반면, 기본 배열로 콜렉션을 생성한 경우에는 iterator 기능을 쓸 수 없습니다.  
   그래서 우리가 직접 iterator 역할을 해줄 클래스를 만들어야 합니다.  
   그것이 아래 코드입니다. 다만 Iterator를 처음부터 만들진 않고, 자바에 원래 있는 Iterator 인터페이스를 구현하는 클래스로 만듭니다.  
   그리고 기존의 hasNext()와 next()를 오버라이드하여 재작성해줍니다.  

```Java
package iterator_pattern;

import java.util.Iterator;

public class FamilyIterator implements Iterator<Phone> {

	Phone[] list;
	int position = 0;
	
	public FamilyIterator(Phone[] list) {
		this.list = list; 
	}
	
	
	@Override
	public boolean hasNext() {
		return position < list.length;
	}

	@Override
	public Phone next() {
		Phone phone = list[position];
		position ++;
		return phone;
	}
	
}

```
그럼 이게 어떻게 활용되는지 아래 테스트 코드를 확인해보시죠.  
테스트 함수를 보시면 친구 전화번호부, 가족 전화번호부 모두 같은 방식의 iterator를 사용해 호출하는 것을 볼 수 있습니다.  
즉, 클라이언트 입장에서는 컬렉션 구조가 기본 배열이든 가변배열(arrayList)이든 상관하지 않아도 되는 것입니다.  

```Java
package iterator_pattern;

import java.util.Iterator;

public class PatternTest {

	public static void main(String[] args) {
		Iterator iterator;
		
		System.out.println("== 친구 전화번호부 ==");
		FriendsPhoneBook friends = new FriendsPhoneBook();
		iterator = friends.createIterator();
		
		while(iterator.hasNext()) {
			Phone phone = (Phone) iterator.next();
			String name = phone.getName();
			String number = phone.getNumber();
			
			System.out.println("이름은 "+name+", 번호는 "+number);
		}

		
		System.out.println("== 가족 전화번호부 ==");
		FamilyPhoneBook family = new FamilyPhoneBook();
		iterator = family.createIterator();
		
		while(iterator.hasNext()) {
			Phone phone = (Phone) iterator.next();
			String name = phone.getName();
			String number = phone.getNumber();
			
			System.out.println("이름은 "+name+", 번호는 "+number);
		}
		
		
	}

}

```
출력 결과  
```
== 친구 전화번호부 ==
이름은 친구1, 번호는 123
이름은 친구2, 번호는 456
== 가족 전화번호부 ==
이름은 엄마, 번호는 111
이름은 아빠, 번호는 222

```

## Reference
책 - 헤드퍼스트 디자인패턴
