import java.util.Random;

import javafx.animation.Animation;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class Pteradactyl extends Pane{
	ImageView imageView;
	int COUNT = 2;
	int COLUMNS = 2;
	int OFFSET_X = 0; 
	int OFFSET_Y = 0;
	int WIDTH = 92;
	int HEIGHT = 100;
	
	Random r;
	
	SpriteAnimation animation;
	
	public Pteradactyl(ImageView imageView){
		this.imageView = imageView;
		this.imageView.setViewport(new Rectangle2D(OFFSET_X,OFFSET_Y,WIDTH,HEIGHT));
		
		animation = new SpriteAnimation(imageView, Duration.millis(400), COUNT, COLUMNS, OFFSET_X, OFFSET_Y, WIDTH, HEIGHT);
		animation.setCycleCount(Animation.INDEFINITE);
		animation.play();
		getChildren().addAll(imageView);
	}
	
	public ImageView getImageView(){
		return this.imageView;
	}
	
	public int getRandomHeight(){
		int[] h = {250, 350}; 
		return h[r.nextInt(1)];
	}
	
	
}
