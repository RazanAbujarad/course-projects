
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PlayScene extends Application {

	private static Image landScape_Image;
	private static Image character_Image;
	private static final Image pteradactyl_Image = new Image("images//pteradactyl.png");
	
	private static Cactus cactus;
	private static ImageView cactusSelected, ptera1_ImageView, bird1Selected, bird2Selected, ptera2_ImageView, character_ImageView, landScape_ImageView;
	private static BooleanBinding collision1;
	private static Path cactusPath, bird1Path, bird2Path;
	private static PathTransition cactusTransition, bird1Transition, bird2Transition;
	private static Pteradactyl ptera1, ptera2;

	private static int counter = 0;
	
	private static Group root;
	protected static Scene gameModeScene;
	private static AnimationTimer timer;
	
	private static Timeline pointsCounter, landScape_Timeline;
	private static Character character;
	
	protected static int highScore;
	protected static String pointsResult;

	protected static boolean hasCollided = false, canJumpAgain = true;
	private static Label label;
	
	//temp
	static Path jumpPath;
	static PathTransition jumpTransition;
	
	//private static int prob;
	
	static int landScapeSpeed = 2000;
	static int cactusSpeed = 2000;
	static int birdSpeed = 1800;

	public static void startGame(Stage primaryStage) throws Exception {
		landScape_Image = DinoDodger.getLandScapeSelected();
		character_Image = DinoDodger.getCharacterSelected();
		landScape_ImageView = new ImageView(landScape_Image); //landscape imageview
		character_ImageView = new ImageView(character_Image); //character imageview		
			
		character = new Character(character_ImageView); //character object

		cactus = new Cactus();
		//cactusSelected = new ImageView();
		
		root = new Group(); //Group object to add other objects to
		gameModeScene = new Scene(root, 1000, 500); //scene takes group to display upon stage
		
		//Creates points label in top right corner of scene
		label = new Label();
		label.setTextFill(Color.BLACK);
		label.setFont(Font.font(20));
		label.setTranslateX(700);
		root.getChildren().add(label);
		doPoints();
		
		//set location of ground
		landScape_ImageView.setX(10);
		landScape_ImageView.setY(378);
		
		//set location of character
		character.getImageView().setX(30);
		character.getImageView().setY(300);

		//add landscape, character and pteradactyls to root
		root.getChildren().add(landScape_ImageView);
		root.getChildren().add(character.getImageView());
		
		//jump animation
		jumpPath = new Path();
		jumpPath.getElements().add(new MoveTo(74, 350));
		jumpPath.getElements().add(new LineTo(74, 150));
		jumpPath.getElements().add(new LineTo(74, 350));
		jumpTransition = new PathTransition();
		jumpTransition.setDuration(Duration.millis(800));
		jumpTransition.setPath(jumpPath);
		jumpTransition.setNode(character.getImageView());
		jumpTransition.setCycleCount(1);
		jumpTransition.setAutoReverse(true);

		animateGround(landScapeSpeed);
		
		timer = new AnimationTimer() {
			@Override
			public void handle(long now) {
				
				gameModeScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
					@Override
					public void handle(KeyEvent event) {
						switch (event.getCode()) {
							case SPACE:
								if (onGround() && canJumpAgain)	{
									//canJumpAgain = false;
									jumpTransition.play();						
								}
								break;
							default:
								break;
						}
					}
				});
				gameModeScene.setOnKeyReleased(new EventHandler<KeyEvent>() {
					@Override
					public void handle(KeyEvent event) {
						switch (event.getCode()) {
						case SPACE:
							//canJumpAgain = true;								
							break;
						default:
							break;
						}
					}
				});
				
				if (counter%300 == 0 && counter != 0){
					speedUp();
				}
				
				if (counter%130==0){
					ImageView c1 = cactus.getRandomCactus();
					releaseCactus(c1, cactusSpeed);
					checkCollision(c1);
				}
				if (counter%450==0){
					ImageView c2 = cactus.getRandomCactus();
					releaseCactus(c2, cactusSpeed);
					checkCollision(c2);
				}
				
				if (counter%800==0 && counter>500){
					ptera1_ImageView = new ImageView(pteradactyl_Image);
					ptera1 = new Pteradactyl(ptera1_ImageView);
					ptera1.getImageView().setX(1100);
					ptera1.getImageView().setY(200);
					releasePtera1(ptera1.getImageView());
					checkCollision(ptera1.getImageView());
				}
				
				if (counter%300==0 && counter>500){
					ptera2_ImageView = new ImageView(pteradactyl_Image);
					ptera2 = new Pteradactyl(ptera2_ImageView);
					ptera2.getImageView().setX(1100);
					ptera2.getImageView().setY(350);
					releasePtera2(ptera2.getImageView());
					checkCollision(ptera2.getImageView());
				}
				counter++;
			}
		};
		timer.start();
		primaryStage.setScene(gameModeScene);
		primaryStage.show();
	}
	
	private static void speedUp(){
		cactusSpeed-=5;
		birdSpeed-=5;
	}
	
	private static void checkCollision(ImageView a){
		collision1 = Bindings.createBooleanBinding(
				() -> character.getImageView().getBoundsInParent().intersects(a.getBoundsInParent()),
				character.getImageView().boundsInParentProperty(), a.boundsInParentProperty());
		collision1.addListener((obs, wasColliding, isNowColliding) -> {
			if (isNowColliding){
				hasCollided = true;
				stopAll();
			}
		});
	}
	
	private static void releasePtera1(ImageView c){
		bird1Selected = c;
		bird1Path = new Path();
		bird1Path.getElements().add(new MoveTo(1100, 350));
		bird1Path.getElements().add(new LineTo(-150, 350));
		
		root.getChildren().add(bird1Selected);
		bird1Transition = new PathTransition();
		bird1Transition.setDuration(Duration.millis(birdSpeed));
		bird1Transition.setPath(bird1Path);
		bird1Transition.setNode(bird1Selected);
		bird1Transition.play();
	}
	
	private static void releasePtera2(ImageView c){
		bird2Selected = c;
		bird2Path = new Path();
		bird2Path.getElements().add(new MoveTo(1100, 200));
		bird2Path.getElements().add(new LineTo(-150, 200));
		
		root.getChildren().add(bird2Selected);
		bird2Transition = new PathTransition();
		bird2Transition.setDuration(Duration.millis(birdSpeed));
		bird2Transition.setPath(bird2Path);
		bird2Transition.setNode(bird2Selected);
		bird2Transition.play();
	}
	
	private static void releaseCactus(ImageView c, int speed){
		cactusSelected = c;
		cactusPath = new Path();
		cactusPath.getElements().add(new MoveTo(1100, 350));
		cactusPath.getElements().add(new LineTo(-150, 350));
		
		root.getChildren().add(cactusSelected);
		cactusTransition = new PathTransition();
		cactusTransition.setDuration(Duration.millis(speed));
		cactusTransition.setPath(cactusPath);
		cactusTransition.setNode(cactusSelected);
		cactusTransition.play();
	}
	
	
	private static void stopGround(){
		landScape_Timeline.stop();
	}
	
	
	
	private static void animateGround(int speed){
		landScape_Timeline = new Timeline(new KeyFrame(Duration.millis(speed), new KeyValue(landScape_ImageView.xProperty(), -2150))); //landscape animation with timeline
		landScape_Timeline.setCycleCount(Timeline.INDEFINITE); // timeline continuously runs until stopped
		landScape_Timeline.setAutoReverse(false); // timeline will not reverse
		landScape_Timeline.playFromStart();
	}
	
	private static boolean onGround(){
		if (!(character.getImageView().getY() == 300)){
			return false;
		}
		return true;
	}
	
	private static void doPoints(){
		pointsCounter = new Timeline();
		pointsCounter.setCycleCount(Timeline.INDEFINITE);
		PointCounter pc = new PointCounter(0,highScore);
		
		KeyFrame frame = new KeyFrame(Duration.millis(100), new EventHandler<ActionEvent>(){
			public void handle(ActionEvent e){
				if (!hasCollided){
					label.setText(pc.getRunningScore());
				}
				else {
					hasCollided = false;
					timer.stop();
					pointsCounter.stop();
					pc.hasCollided();
					highScore = pc.showHighScore();
					pointsResult = pc.getRunningScore();
					try{
        				UI.launchCrashed();
        			} catch (Exception f){
        				f.printStackTrace();
        			}
				}
				
			}
		});
		pointsCounter.getKeyFrames().add(frame);
		pointsCounter.playFromStart();
    }
	
	private static void stopAll(){
		stopGround();
		timer.stop();
		counter = 0;
		cactusSpeed = 2000;
//		character.animation.pause();
//		ptera1.animation.pause();
//		ptera2.animation.pause();
//		cactusTransition.pause();
//		bird1Transition.pause();
//		bird2Transition.pause();
	}

//	public static void main(String[] args) {
//		launch(args);
//	}

	@Override
	public void start(Stage arg0) throws Exception {
		
	}
}

