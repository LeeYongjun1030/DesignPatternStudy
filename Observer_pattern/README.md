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
