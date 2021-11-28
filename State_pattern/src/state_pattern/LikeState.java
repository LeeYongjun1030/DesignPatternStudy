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
