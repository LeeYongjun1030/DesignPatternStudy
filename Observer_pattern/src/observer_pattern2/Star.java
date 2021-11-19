package observer_pattern2;

public interface Star {
	public void follow(Fan fan);
	public void unfollow(Fan fan);
	public void notifyFans(String msg);
}
