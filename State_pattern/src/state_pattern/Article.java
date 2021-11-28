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
