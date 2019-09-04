import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class PointCounter extends TimerTask {
	private static int points;
	private static int highscore;
	private static Timer timer;
	static Scanner sc;
	
	protected PointCounter(int initial_points, int initial_highscore){
		points = initial_points;
		highscore = initial_highscore;
		timer = new Timer();
		timer.schedule(this, 0, 100);
	}
	
	protected void hasCollided(){
		timer.cancel();
		timer.purge();
		updateHighScore();
	}
	
	protected int showPoints(){
		return points;
	}
	
	protected int showHighScore(){
		return highscore;
	}
	
	protected void updateHighScore(){
		if (points > highscore) highscore = points;
	}
	
	protected void reset(){
		points = 0;
		highscore = 0;
	}
	
	protected String getRunningScore(){
		return ("SCORE: " + showPoints() + " || HIGHSCORE: " + showHighScore());
	}
	
	@Override
	public void run() {		
		points+=1;
	}
	
	//for demo
//	public static void main(String[] args){
//		Scanner sc = new Scanner(System.in); // to simulate input
//		PointCounter pc = new PointCounter(0, 0);
//		while (true){
//			if (sc.nextInt() == 0) {
//				pc.hasCollided(); 
//			}
//			System.out.println(pc.getRunningScore());
//			System.out.println("Play Again? 1=continue 0=end");
//			if (sc.nextInt() == 1) { 
//				int h = pc.showHighScore();
//				pc = new PointCounter(0, h);
//			}
//			else break;			
//		}
//		System.out.println("Game Over!");
//		sc.close();
//	}
	
}
