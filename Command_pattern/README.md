# Command Pattern

## Introduction
이씨의 집에는 만능 리모컨이 있습니다. 이 리모컨으로 전등을 키고 끄는 것은 물론, 텔레비젼을 키고 끌 수도 있습니다.  
이 만능 리모컨은 차후 발전하여 더 많은 기기에 명령을 내릴 수 있습니다.  

## Definition
명령을 객체로 캡슐화할 수 있으며, 매개변수를 통해 여러가지 다른 요구사항도 집어넣을 수 있습니다.  
또한 요청 내역을 큐에 저장하고나 로그를 기록할 수도 있습니다.  

## Structure

![image](https://user-images.githubusercontent.com/78812317/143221108-6ced1713-275a-489f-b41d-41426d226eac.png)



주어진 상황에서, 다음과 같이 비유될 수 있습니다.  
   
Receiver - 전등, 컴퓨터와 같이 명령을 직접 수행할 수 있는 객체.  
Invoker - 리모컨(리시버로 하여금 명령을 수행하도록 지시)  
Client - 리모컨을 조종하는 이씨.



## Source code
   
전등 객체와 컴퓨터 객체를 만들어줍니다.  
```Java
package command_pattern;

public class Light {
	
	public void on() {
		System.out.println("light on.");
	}
	
	public void off() {
		System.out.println("light off.");
	}
}

```

```Java
package command_pattern;

public class Television {
	
	public void on() {
		System.out.println("tv on.");
	}
	
	public void off() {
		System.out.println("tv off.");
	}
	
	public void volumeUp() {
		System.out.println("tv volume up.");
	}
	
	public void volumeDown() {
		System.out.println("tv volume down.");
	}
}


```
   
그리고 커맨드 인터페이스를 정의합니다.  
   
```Java
package command_pattern;

public interface Command {
	public void excute();
	public void undo();
}

```

다양한 ConcreteCommand를 구현합니다.  

```Java
package command_pattern;

public class LightOnCommand implements Command {

	Light light;
	
	public LightOnCommand(Light light) {
		this.light = light;
	}
	
	@Override
	public void excute() {
		light.on();
	}

	@Override
	public void undo() {
		light.off();
	}

}

```


```Java
package command_pattern;

public class TelevisionOnCommand implements Command {
	
	Television tv;
	
	public TelevisionOnCommand(Television tv) {
		this.tv = tv;
	}
	
	@Override
	public void excute() {
		tv.on();
	}

	@Override
	public void undo() {
		tv.off();
	}

}

```

```Java
package command_pattern;

public class TelevisionVolumeCommand implements Command {

	Television tv;
	
	public TelevisionVolumeCommand(Television tv) {
		this.tv = tv;
	}
	
	@Override
	public void excute() {
		tv.volumeUp();
	}

	@Override
	public void undo() {
		tv.volumeDown();
	}

}

```

Invoke 역할의 리모컨을 만들어줍니다. 이 리모컨이 다양한 커맨드를 객체로 받아서 리시버로 하여금 명령을 지시합니다.  

```Java
package command_pattern;

public class RemoteControl {
	Command command;
	
	public void setCommand(Command command) {
		this.command = command;
	}
	
	public void onButtonPushed() {
		command.excute();
	}
	
	public void offButtonPushed() {
		command.undo();
	}
}

```

다음과 같이 테스트할 수 있습니다.  
클라이언트는 그저 다양한 명령에 대한 버튼을 누르기만 하면 됩니다.  
전등, 컴퓨터 같은 객체들이 실제로 어떤 일을 하는 지 알 필요가 없게 됩니다.  

```Java
package command_pattern;

public class PatternTest {
	public static void main(String[] args) {
		
		RemoteControl remote = new RemoteControl();
		
		Command lightOnCommand = new LightOnCommand(new Light());
		remote.setCommand(lightOnCommand);
		remote.onButtonPushed();
		remote.offButtonPushed();
		
		Command televisionOnCommand = new TelevisionOnCommand(new Television());
		remote.setCommand(televisionOnCommand);
		remote.onButtonPushed();
		remote.offButtonPushed();
		
		Command televisionVolumeCommand = new TelevisionVolumeCommand(new Television());
		remote.setCommand(televisionVolumeCommand);
		remote.onButtonPushed();
		remote.offButtonPushed();
	}
}


```

실행 결과  
```
light on.
light off.
tv on.
tv off.
tv volume up.
tv volume down.
```


## Reference
도서 : 헤드퍼스트 디자인패턴  
글: 쉽게 설명 https://victorydntmd.tistory.com/295
