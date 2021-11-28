package state_pattern;

public class LikeState implements State {

	@Override
	public void like(Article article) {
		article.setState(new IdleState());
		System.out.println("���ƿ� ����!");
	}

	@Override
	public void dislike(Article article) {
		article.setState(new DislikeState());
		System.out.println("���ƿ信�� �Ⱦ��� ����!");
	}

}
