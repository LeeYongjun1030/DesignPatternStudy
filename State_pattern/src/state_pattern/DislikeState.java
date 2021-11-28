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
