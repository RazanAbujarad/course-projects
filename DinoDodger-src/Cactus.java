import java.util.Random;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Cactus {
	Image cactus1_1 = new Image("images//cactus1_1.png");
	Image cactus1_2 = new Image("images//cactus1_2.png");
	Image cactus1_3 = new Image("images//cactus1_3.png");
	Image cactus1_4 = new Image("images//cactus1_4.png");
	Image cactus2_1 = new Image("images//cactus2_1.png");
	Image cactus2_2 = new Image("images//cactus2_2.png");
	Image cactus2_3 = new Image("images//cactus2_3.png");
	Image cactus2_4 = new Image("images//cactus2_4.png");
	Image cactus3_1 = new Image("images//cactus3_1.png");
	Image cactus3_2 = new Image("images//cactus3_2.png");
	Image cactus3_3 = new Image("images//cactus3_3.png");
	Image cactus3_4 = new Image("images//cactus3_4.png");
	
	Image cactus1, cactus2, cactus3, cactus4;
	
	public Cactus(){
		if (UI.l1) {
			cactus1 = cactus1_1;
			cactus2 = cactus1_2;
			cactus3 = cactus1_3;
			cactus4 = cactus1_4;
		}
		else if (UI.l2){
			cactus1 = cactus2_1;
			cactus2 = cactus2_2;
			cactus3 = cactus2_3;
			cactus4 = cactus2_4;
		}
		else if (UI.l3){
			cactus1 = cactus3_1;
			cactus2 = cactus3_2;
			cactus3 = cactus3_3;
			cactus4 = cactus3_4;
		}
		else {
			cactus1 = cactus1_1;
			cactus2 = cactus1_2;
			cactus3 = cactus1_3;
			cactus4 = cactus1_4;
		}
	}
	protected ImageView getRandomCactus(){
		Random r = new Random();
		Image[] cacti = {cactus1, cactus2, cactus3, cactus4};
		ImageView cactus = new ImageView(cacti[r.nextInt(4)]);
		cactus.setX(999);
		cactus.setY(325);
		return cactus;
	}
}
