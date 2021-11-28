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
