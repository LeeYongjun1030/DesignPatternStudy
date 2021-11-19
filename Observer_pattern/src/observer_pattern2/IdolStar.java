package observer_pattern2;

import java.util.ArrayList;

public class IdolStar implements Star {

	ArrayList<Fan> fans = new ArrayList<>();
	
	public void follow(Fan fan) {
		fans.add(fan);
	}

	public void unfollow(Fan fan) {
		int idx = fans.indexOf(fan);
		if (idx != -1) {
			fans.remove(idx);
		}
	}

	public void notifyFans(String msg) {
		fans.forEach(fan -> fan.update(msg));
	}

}
