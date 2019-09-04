import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;


public class Character extends Pane{
	ImageView imageView;
	int COUNT = 2;
	int COLUMNS = 2;
	int OFFSET_X = 0; 
	int OFFSET_Y = 0;
	int WIDTH = 88;
	int HEIGHT = 100;
	
	int xpos = 30, ypos = 300;
	
	
	static Path path = new Path();
	static PathTransition pathTransition = new PathTransition();
	
	SpriteAnimation animation;
	
	public Character(ImageView imageView){
		this.imageView = imageView;
		this.imageView.setViewport(new Rectangle2D(OFFSET_X,OFFSET_Y,WIDTH,HEIGHT));
		this.imageView.setX(xpos);
		this.imageView.setY(ypos);
		
		animation = new SpriteAnimation(imageView, Duration.millis(200), COUNT, COLUMNS, OFFSET_X, OFFSET_Y, WIDTH, HEIGHT);
		animation.setCycleCount(Animation.INDEFINITE);
		animation.play();
		getChildren().addAll(imageView);
		
		path.getElements().add(new MoveTo(74,350));
    	path.getElements().add(new LineTo(74,150));
    	path.getElements().add(new LineTo(74,350));
		pathTransition.setDuration(Duration.millis(800));
		pathTransition.setCycleCount(1);
		pathTransition.setPath(path);
		pathTransition.setNode(this.imageView);
	}
	
	protected ImageView getImageView(){
		return this.imageView;
	}
	
	protected void jump(){
		pathTransition.play();
	}
	
	protected void setOffSetX(int x){
		this.OFFSET_X = x;
	}
	
	protected void setOffSetY(int y){
		this.OFFSET_Y = y;
	}
	
}
