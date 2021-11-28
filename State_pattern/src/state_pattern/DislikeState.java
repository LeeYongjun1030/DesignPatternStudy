package state_pattern;

public class DislikeState implements State {

	@Override
	public void like(Article article) {
		article.setState(new LikeState());
		System.out.println("�Ⱦ�信�� ���ƿ�� ����!");
	}

	@Override
	public void dislike(Article article) {
		article.setState(new IdleState());
		System.out.println("�Ⱦ�� ����!");

	}

}
