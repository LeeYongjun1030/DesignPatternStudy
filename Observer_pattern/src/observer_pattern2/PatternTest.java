package observer_pattern2;

public class PatternTest {

	public static void main(String[] args) {
		BoyFan boy = new BoyFan();
		GirlFan girl = new GirlFan();
		
		IdolStar kim = new IdolStar();
		
		kim.follow(boy);
		kim.follow(girl);
		kim.notifyFans("밥 먹었습니다.");
		
		kim.unfollow(boy);
		kim.notifyFans("운동 했습니다.");
	}

}
