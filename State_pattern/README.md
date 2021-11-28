# State Pattern

## Introduction
게시물의 좋아요/싫어요 버튼 기능을 만들어봅시다!

## Definition
스테이트 패턴을 이용하면 객체의 내부 상태가 바뀜에 따라서 객체의 행동을 바꿀 수 있습니다.  
마치 객체의 클래스가 바뀌는 것과 같은 결과를 얻을 수 있습니다.  

## Structure
![image](https://user-images.githubusercontent.com/78812317/143773309-fa6a8817-8d2d-4b6e-ada4-4bdaa7b92d5d.png)  
스테이트 패턴은 전략 패턴과 동일한 구조를 가집니다.  

## Source Code

게시물에 좋아요/싫어요 기능을 만들어봅시다.  
우선 게시물 클래스를 만들어줍니다. 스테이트 패턴의 Context 클래스에 해당합니다.    
```Java
package state_pattern;

public class Article {

	State state = new IdleState();
	
	public void setState(State state) {
		this.state = state;
	}
	
	public void likeClick() {
		state.like(this);
	}
	
	public void dislikeClick() {
		state.dislike(this);
	}
}

```

그리고 State 인터페이스를 만들어줍니다.  
전략 패턴 때와 다른 점은 메서드의 인자로 Context 객체를 받습니다.  

```Java
package state_pattern;

public interface State {
	public void like(Article article);
	public void dislike(Article article);
}

```

State 인터페이스를 구현하는 세가지 클래스를 만들어줍니다.  
인자로 받은 article 객체의 상태를 상황에 따라 적절히 바꿔줍니다.  
   
   먼저, Idle상태에서는 좋아요 클릭시 Like상태로, 싫어요 클릭시 Dislike 상태가 됩니다.  

```Java
package state_pattern;

public class IdleState implements State {

	@Override
	public void like(Article article) {
		article.setState(new LikeState());
		System.out.println("좋아요!");
	}

	@Override
	public void dislike(Article article) {
		article.setState(new DislikeState());
		System.out.println("싫어요!");

	}

}

```

Like 상태에서는 좋아요를 또 누르게 되면 좋아요가 해제되어 Idle 상태가 되고, 
싫어요를 누르면 Dislike 상태가 됩니다.  
```Java
package state_pattern;

public class LikeState implements State {

	@Override
	public void like(Article article) {
		article.setState(new IdleState());
		System.out.println("좋아요 해제!");
	}

	@Override
	public void dislike(Article article) {
		article.setState(new DislikeState());
		System.out.println("좋아요에서 싫어요로 변경!");
	}

}

```

Dislike 상태에서 좋아요를 누르면 Like 상태가 되고, 싫어요 버튼을 한번더 누르게 되면 싫어요가 해제되어 Idle 상태가 됩니다.
```Java
package state_pattern;

public class DislikeState implements State {

	@Override
	public void like(Article article) {
		article.setState(new LikeState());
		System.out.println("싫어요에서 좋아요로 변경!");
	}

	@Override
	public void dislike(Article article) {
		article.setState(new IdleState());
		System.out.println("싫어요 해제!");

	}

}

```

테스트는 아래와 같이 진행됩니다.  
article에 좋아요, 싫어요 버튼을 연속적으로 무질서하게 눌렀을 때,  
우리가 의도한 상태로 적절히 바뀌는 지 파악해봅시다.  

```Java
package state_pattern;

public class PatternTest {
	
	public static void main(String[] args) {
		Article article = new Article();
		
		article.likeClick();     // Idle -> Like
		article.dislikeClick();  // Like -> Dislike
		article.likeClick();     // Dislike -> Like
		article.dislikeClick();  // Like -> Dislike
		article.dislikeClick();  // Dislike -> Idle
		article.dislikeClick();  // Idle -> Dislike
		article.dislikeClick();  // Dislike -> Idle
		article.likeClick();     // Idle -> Like
	} 
}

```

```
좋아요!
좋아요에서 싫어요로 변경!
싫어요에서 좋아요로 변경!
좋아요에서 싫어요로 변경!
싫어요 해제!
싫어요!
싫어요 해제!
좋아요!

```
## Question
구조도 동일한데, 스테이트 패턴은 전략 패턴과 무엇이 다른가요?  
(전략 패턴 보러가기: [여기]())  
   
   전략
