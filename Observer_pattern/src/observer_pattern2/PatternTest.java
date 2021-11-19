package observer_pattern2;

public class PatternTest {

	public static void main(String[] args) {
		BoyFan boy = new BoyFan();
		GirlFan girl = new GirlFan();
		
		IdolStar kim = new IdolStar();
		
		kim.follow(boy);
		kim.follow(girl);
		kim.notifyFans("�� �Ծ����ϴ�.");
		
		kim.unfollow(boy);
		kim.notifyFans("� �߽��ϴ�.");
	}

}
