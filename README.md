# DesignPatternStudy
🌱 Let's study design patterns!   
😄 I aim to study easily and joyfully.  
📫 I tried to set an interesting situation for each pattern.   
  

# Contents  

*  [Strategy Pattern](https://github.com/LeeYongjun1030/DesignPatternStudy/tree/master/Strategy_pattern#readme)  
*  [Observer Pattern](https://github.com/LeeYongjun1030/DesignPatternStudy/tree/master/Observer_pattern#readme)  
*  [Decorator Pattern](https://github.com/LeeYongjun1030/DesignPatternStudy/tree/master/Decorator_pattern#readme)   
*  [Factory Pattern](https://github.com/LeeYongjun1030/DesignPatternStudy/blob/master/Factory_pattern#readme)
*  [Singleton Pattern](https://github.com/LeeYongjun1030/DesignPatternStudy/tree/master/Singleton_pattern#readme)  
*  [Command Pattern](https://github.com/LeeYongjun1030/DesignPatternStudy/tree/master/Command_pattern#readme)  
*  [Adapter Pattern](https://github.com/LeeYongjun1030/DesignPatternStudy/tree/master/Adapter_pattern#readme)  
*  [Facade Pattern](https://github.com/LeeYongjun1030/DesignPatternStudy/tree/master/Facade_pattern#readme)  
*  [Template Method Pattern](https://github.com/LeeYongjun1030/DesignPatternStudy/tree/master/Template_Method_pattern#readme)  
*  [Iterator Pattern](https://github.com/LeeYongjun1030/DesignPatternStudy/tree/master/Iterator_pattern#readme)



# Summary
* Strategy Pattern이란 행동을 클래스로 캡슐화하여 동적으로 행동 전략을 바꿀 수 있게 해주는 디자인 패턴이다.   
코드 블럭 내부를 일일이 수정하지 않고도 손쉽게 전략을 바꿀 수 있다. 

* Observer Pattern은 한 객체의 상태가 바뀌면 그 객체에 의존하는 다른 객체들한테 연락이 가고 자동으로 내용이 갱신되는 방식으로, 일대다 의존성을 정의합니다.   

* Decorator Pattern은 객체에 추가적인 요건을 동적으로 첨가합니다. 쉽게 말해 장식과 같이 하나의 객체에 여러 기능을 꾸며줍니다.   
데코레이터는 서브클래스를 만드는 것을 통해서 기능을 유연하게 확장할 수 있는 방법을 제공합니다. 


* Factory Pattern은 객체를 생성하기 위한 인터페이스를 정의하고, 어떤 클래스의 인스턴스를 만들지는 서브클래스에서 결정하게 만듦니다.


* Singleton Pattern은 해당 클래스의 인스턴스가 하나만 만들어지고, 어디서든 그 인스턴스에 접근할 수 있도록 하기 위한 패턴입니다.   

* Command Pattern은 명령을 객체로 캡슐화할 수 있으며, 매개변수를 통해 여러가지 다른 요구사항도 집어넣을 수 있습니다.   
또한 요청 내역을 큐에 저장하고나 로그를 기록할 수도 있습니다. 


* Adapter Pattern은 한 클래스의 인터페이스를 클라이언트에서 사용하고자 하는 다른 인터페이스로 변환합니다.  
어댑터를 이용하면 인터페이스 호환성 문제 때문에 같이 쓸 수 없는 클래스들을 연결해서 쓸 수 있습니다.  

   
* Facade Pattern은 어떤 서브시스템의 일련의 인터페이스에 대한 통합된 인터페이스를 제공합니다.   
퍼사드에서 고수준 인터페이스를 정의하기 때문에 서브시스템을 더 쉽게 사용할 수 있습니다. 


* Template Method Pattern에서는 메서드에서 알고리즘의 골격을 정의합니다.   
알고리즘의 여러 단계 중 일부는 서브클래스에서 구현할 수 있습니다.   
이때 알고리즘의 구조를 유지하며 서브클래스에서 특정 단계를 재정의할 수 있습니다.     


* Iterator Pattern은 컬렉션 구현 방법을 노출시키지 않으면서도 그 집합체 안에 들어있는 모든 항목에 접근할 수 있는 방법을 제공해줍니다.   
