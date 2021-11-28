# Composite Pattern

## Definition
컴포지트 패턴을 이용하면 객체들을 트리구조로 구성하여 부분과 전체를 나타내는 계층구조를 만들 수 있습니다.  
이 패턴을 이용하면 클라이언트는 개별 객체와 복합 객체(collection)를 똑같은 방식으로 다룰 수 있습니다.  

## Structure
![image](https://user-images.githubusercontent.com/78812317/143765148-d5f4bbea-1e58-4ae9-856d-571aff8f1441.png)


## Source Code
가장 먼저 Component 인터페이스를 만들어줍니다.  
```Java
package composite_pattern;

public interface Component {
	public void getInfo();
}

```
   
그리고 Leaf 객체를 만들어줍니다.  
여기선 File에 해당합니다.  
```Java
package composite_pattern;

public class File implements Component {
	
	String name;
	int fileSize;
	
	public File(String name, int fileSize) {
		this.name = name;
		this.fileSize = fileSize;
	}
	
	
	@Override
	public void getInfo() {
		System.out.println("이름 : "+ name + ", 파일 크기는 : "+ fileSize);
	}

}

```

이제 복합 객체, 즉 Composite 객체를 만들어줍니다.  
이때 복합 객체는 개별 객체(Leaf)를 담는 배열을 가져야 합니다.  
복합 객체의 getInfo() 메서드에서는 복합 객체가 담고있는 개별 객체들의 getInfo()를 실행하도록 합니다.  
```Java
package composite_pattern;

import java.util.ArrayList;
import java.util.Iterator;

public class Folder implements Component {

	ArrayList<Component> folder;
	
	public Folder() {
		folder = new ArrayList<>();
	}
	
	public void add(Component component) {
		folder.add(component);
	}

	
	@Override
	public void getInfo() {
		for(Component component : folder) {
			component.getInfo();
		}
	}

}

```

테스트는 아래와 같이 진행됩니다.  
기본 폴더 두 개를 만들고 그 안에 각각 파일 두개씩을 집어넣었습니다.  
각 폴더의 파일들을 확인하는 테스트1, 테스트2를 작성하고 실행해봅니다.  
그리고 또 다른 폴더3을 만들고 이 안에는 앞서 만들었던 폴더1와 폴더2를 집어넣습니다.  
**컴포지트 패턴을 사용하였기 때문에 클라이언트는 이렇게 파일과 폴더를 구분없이 같은 방법으로 집어넣을 수 있는 것입니다.**  
테스트3에서 이 폴더3의 내용을 확인해봅니다.  

```Java
package composite_pattern;

public class PatternTest {
	public static void main(String[] args) {
		Folder folder1 = new Folder();
		Folder folder2 = new Folder();
		
		File file1 = new File("picture.jpg", 5);
		File file2 = new File("video.avi", 100);
		File file3 = new File("music.mp3", 10);
		File file4 = new File("text.txt", 1);
		
		System.out.println("==Test1==");
		folder1.add(file1);
		folder1.add(file2);
		folder1.getInfo();
		
		System.out.println("==Test2==");
		folder2.add(file3);
		folder2.add(file4);
		folder2.getInfo();
		
		System.out.println("==Test3==");
		Folder folder3 = new Folder();
		folder3.add(folder1); // folder 객체에 file이 아닌 folder 객체를 add
		folder3.add(folder2);
		folder3.getInfo();
		
		
	
		
	}
}

```
결과는 다음과 같습니다.  
테스트 3 결과는 우리가 의도했던대로 하위 폴더가 갖고 있는 파일들의 내용을 보여줍니다.  
```
==Test1==
이름 : picture.jpg, 파일 크기는 : 5
이름 : video.avi, 파일 크기는 : 100
==Test2==
이름 : music.mp3, 파일 크기는 : 10
이름 : text.txt, 파일 크기는 : 1
==Test3==
이름 : picture.jpg, 파일 크기는 : 5
이름 : video.avi, 파일 크기는 : 100
이름 : music.mp3, 파일 크기는 : 10
이름 : text.txt, 파일 크기는 : 1

```



## Reference
책 - 헤드퍼스트 디자인패턴
