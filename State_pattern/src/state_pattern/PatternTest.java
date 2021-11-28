package state_pattern;

public class PatternTest {
	
	public static void main(String[] args) {
		Article article = new Article();
		
		article.likeClick(); // Idle -> Like
		article.dislikeClick(); // Like -> Dislike
		
		article.likeClick();  // Dislike -> Like
		article.dislikeClick();  // Like -> Dislike
		
		article.dislikeClick();  // Dislike -> Idle
		article.dislikeClick();  // Idle -> Dislike
		
		article.dislikeClick();  // Dislike -> Idle
		article.likeClick();  // Idle -> Like
	} 
}
