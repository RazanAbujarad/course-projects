import javafx.application.*;
//import javafx.scene.*;
import javafx.scene.layout.StackPane;
import javafx.event.*;
//import javafx.geometry.Pos;
//import javafx.stage.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
//import javafx.geometry.*;
import javafx.scene.Group;
import javafx.scene.Scene; 
import javafx.scene.image.ImageView;
//import javafx.scene.layout.HBox;
//import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class UI extends Application{

	//declaring variables for buttons, images, characters and landscapes
	Button button1;
	Button button2;
	Button button3;
	Button button4;
	Button button5;
	Button button6;
	Button button7;
	Image image1;
	Image image2;
	Image image3;
	Image image4;
	Image image5;
	Image image6;
	static Stage theStage;
	//variables for the characters/landscape chosen if true character/landscape is chosen, if false char/lands is not chosen
	static boolean c1, c2, c3, l1, l2, l3;
	
	static Button playAgain = new Button();
	static Button mainMenu = new Button();
	
	static StackPane layout = new StackPane();
	static Scene scene = new Scene(layout, 1000, 500);
	
	static Group playLayout = new Group();
	static Scene playScene = new Scene(playLayout, 1000, 500);
	
	static StackPane gameOverLayout;
	static Scene gameOverScene;
	
	
	static int highScore = 0;
	//static PointCounter pc;
	
	static String pointsString;
	
	
	public static void main(String[] args){
		Application.launch(args);
	}

	public void start(Stage primaryStage) throws Exception {
		//setting stage title
		primaryStage.setTitle("DinoDodger");
		primaryStage.setResizable(false);
		
		//allows the stage variable to be used anywhere
		theStage = primaryStage; 
		
		//creating buttons
		button1 = new Button();
		button1.setText("Character1");
		button2 = new Button();
		button2.setText("Character2");
		button3 = new Button();
		button3.setText("Character3");
		button4 = new Button();
		button4.setText("Landscape1");
		button5 = new Button();
		button5.setText("Landscape2");
		button6 = new Button();
		button6.setText("Landscape3");
		button7 = new Button();
		button7.setText("Play");
		
		//creating images
		image1 = new Image("images/character1.png");
		ImageView iv1 = new ImageView();
		iv1.setImage(image1);
		
		image2 = new Image("images/character2.png");
		ImageView iv2 = new ImageView();
		iv2.setImage(image2);
		
		image3 = new Image("images/character3.png");
		ImageView iv3 = new ImageView();
		iv3.setImage(image3);
		
		image4 = new Image("images/cactus1_4.png");
		ImageView iv4 = new ImageView();
		iv4.setImage(image4);
		
		image5 = new Image("images/cactus2_4.png");
		ImageView iv5 = new ImageView();
		iv5.setImage(image5);
		
		image6 = new Image("images/cactus3_4.png");
		ImageView iv6 = new ImageView();
		iv6.setImage(image6);
		
		
		//StackPane layout = new StackPane();
		
		//adds buttons and images
		layout.getChildren().add(button1);
		layout.getChildren().add(button2);
		layout.getChildren().add(button3);
		layout.getChildren().add(button4);
		layout.getChildren().add(button5);
		layout.getChildren().add(button6);
		layout.getChildren().add(button7);
		layout.getChildren().add(iv1);
		layout.getChildren().add(iv2);
		layout.getChildren().add(iv3);
		layout.getChildren().add(iv4);
		layout.getChildren().add(iv5);
		layout.getChildren().add(iv6);
		
		Text chooseCharacter = new Text("Choose Character");
		Text chooseLandScape = new Text("Choose Landscape");
		Text instructions = new Text("Press 'SPACE' to jump");
		
		layout.getChildren().add(chooseLandScape);
		layout.getChildren().add(chooseCharacter);
		layout.getChildren().add(instructions);
		
		chooseLandScape.setFont(new Font(20));
		chooseCharacter.setFont(new Font(20));
		
		chooseCharacter.setLayoutX(0);
		chooseCharacter.setLayoutY(0);
		chooseCharacter.setTranslateX(-400);
		chooseCharacter.setTranslateY(-150);
		
		chooseLandScape.setLayoutX(0);
		chooseLandScape.setLayoutY(0);
		chooseLandScape.setTranslateX(-400);
		chooseLandScape.setTranslateY(150);
		
		instructions.setLayoutX(0);
		instructions.setLayoutY(0);
		instructions.setTranslateX(400);
		instructions.setTranslateY(150);
		
		
		
		//sets buttons and image positions in the window
		button1.setLayoutX(0);
		button1.setLayoutY(0);
		button1.setTranslateX(-250);
		button1.setTranslateY(-100);
		
		button2.setLayoutX(0);
		button2.setLayoutY(0);
		button2.setTranslateX(0);
		button2.setTranslateY(-100);
		
		button3.setLayoutX(0);
		button3.setLayoutY(0);
		button3.setTranslateX(250);
		button3.setTranslateY(-100);
		
		button4.setLayoutX(0);
		button4.setLayoutY(0);
		button4.setTranslateX(-250);
		button4.setTranslateY(200);
		
		button5.setLayoutX(0);
		button5.setLayoutY(0);
		button5.setTranslateX(0);
		button5.setTranslateY(200);
		
		button6.setLayoutX(0);
		button6.setLayoutY(0);
		button6.setTranslateX(250);
		button6.setTranslateY(200);
		
		button7.setLayoutX(0);
		button7.setLayoutY(0);
		button7.setTranslateX(400);
		button7.setTranslateY(200);
		button7.setMinWidth(100);		
		button7.setFont(new Font(20));
		
		iv1.setLayoutX(0);
		iv1.setLayoutY(0);
		iv1.setTranslateX(-250);
		iv1.setTranslateY(-160);
		
		iv2.setLayoutX(0);
		iv2.setLayoutY(0);
		iv2.setTranslateX(0);
		iv2.setTranslateY(-160);
		
		iv3.setLayoutX(0);
		iv3.setLayoutY(0);
		iv3.setTranslateX(250);
		iv3.setTranslateY(-160);
		
		iv4.setLayoutX(0);
		iv4.setLayoutY(0);
		iv4.setTranslateX(-250);
		iv4.setTranslateY(140);
		
		iv5.setLayoutX(0);
		iv5.setLayoutY(0);
		iv5.setTranslateX(0);
		iv5.setTranslateY(140);
		
		iv6.setLayoutX(0);
		iv6.setLayoutY(0);
		iv6.setTranslateX(250);
		iv6.setTranslateY(140);

		//creating scene
		/////Scene scene = new Scene(layout, 1000, 500);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		//sets button functions when pressed
		button1.setOnAction(e -> char1Selected(e));
		
		button2.setOnAction(e -> char2Selected(e));
		
		button3.setOnAction(e -> char3Selected(e));
		
		button4.setOnAction(e -> landscape1Selected(e));
		
		button5.setOnAction(e -> landscape2Selected(e));
		
		button6.setOnAction(e -> landscape3Selected(e));
		
		button7.setOnAction(e -> {
			try {
				playButtonClicked(e);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		
		
		
//		//to test the third scene
//		button1.setOnAction(e -> {
//			try {
//				crashed(e);
//			} catch (Exception e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//		});
			
		
		playAgain.setOnAction(e -> {
			try {
				playButtonClicked(e);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		
		mainMenu.setOnAction(e -> {
			try {
				highScore = 0;
				mainMenuClicked(e);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		
		
		
		
	}
	

	private static void char1Selected(ActionEvent e) {
		//sets character 1 boolean value to true, others false
		c1 = true;
		c2 = false;
		c3 = false;
		
	}
	
	private static void char2Selected(ActionEvent e) {
		//sets character 2 boolean value to true, others false
		c2 = true;
		c1 = false;
		c3 = false;
		
	}
	
	private static void char3Selected(ActionEvent e) { 
		//sets character 3 boolean value to true, others false
		c3 = true;
		c1 = false;
		c2 = false;
	}

	private static void landscape1Selected(ActionEvent e) {
		//sets landscape 1 boolean value to true, others false
		l1 = true;
		l2 = false;
		l3 = false;
	}
	
	private static void landscape2Selected(ActionEvent e) {
		//sets landscape 2 boolean value to true, others false
		l2 = true;
		l1 = false;
		l3 = false;
	}
	
	private static void landscape3Selected(ActionEvent e) {
		//sets landscape 3 boolean value to true, others false
		l3 = true;
		l1 = false;
		l2 = false;
	}

	private static void playButtonClicked(ActionEvent e) throws Exception{
		//When the user presses play the stage goes to a new scene which is the play scene
		//The play scene is where the character is running.
		
		//creating the layout for the play scene
		//StackPane playLayout = new StackPane();
		
		
		//creating the play scene
		//playScene = new Scene(playLayout, 1000, 500);
		
		//highScore = pc.showHighScore(); 
		//pc = new PointCounter(0, highScore);
		
		theStage.setScene(playScene);
		theStage.show();

		//launches play scene
		PlayScene.startGame(theStage);		
		
	}
	
	
	private static void mainMenuClicked(ActionEvent e) {
		PlayScene.highScore = 0;
		theStage.setScene(scene);
		theStage.show();
	}
	
	private static void crashed(){
		//creating layout and scene of game over scene
		gameOverLayout = new StackPane();		
		gameOverScene = new Scene(gameOverLayout, 1000, 500);
		
		//creating text objects
		Text gameOverText = new Text("GAME OVER");
		gameOverText.setFont(new Font(40));
		
		//Text highScoreText = new Text(pc.getRunningScore());
		Text highScoreText = new Text(pointsString);
		highScoreText.setFont(new Font(30));				
		
		//creating buttons
		playAgain.setText("Play Again");
		mainMenu.setText("Main Menu");
		
		//adding text, buttons
		gameOverLayout.getChildren().add(gameOverText);
		gameOverLayout.getChildren().add(highScoreText);
		gameOverLayout.getChildren().add(playAgain);
		gameOverLayout.getChildren().add(mainMenu);
		
		//modifying the layout of the text, buttons
		gameOverText.setLayoutX(0);
		gameOverText.setLayoutY(0);
		gameOverText.setTranslateX(0);
		gameOverText.setTranslateY(-100);
		
		playAgain.setLayoutX(0);
		playAgain.setLayoutY(0);
		playAgain.setTranslateX(200);
		playAgain.setTranslateY(100);
		
		mainMenu.setLayoutX(0);
		mainMenu.setLayoutY(0);
		mainMenu.setTranslateX(-200);
		mainMenu.setTranslateY(100);
		
		theStage.setScene(gameOverScene);
		theStage.show();		
	}
	
	public static void launchCrashed(){
		highScore = PlayScene.highScore;
		pointsString = PlayScene.pointsResult;
		crashed();
	}

}
