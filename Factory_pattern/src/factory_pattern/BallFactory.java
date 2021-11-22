package factory_pattern;

public class BallFactory {
	
	public Ball getBall(String ballType) {
		
	  if(ballType == null){
	         return null;
	      }		
	      if(ballType.equalsIgnoreCase("soccerball")){
	         return new SoccerBall();
	         
	      } else if(ballType.equalsIgnoreCase("baseball")){
	         return new BaseBall();
	         
	      } else if(ballType.equalsIgnoreCase("tennis")){
	         return new TennisBall();
	      }
	      
	      return null;
	}
}
