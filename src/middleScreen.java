

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class middleScreen extends Pane {

	public middleScreen() {
		this.setStyle("-fx-background-color: CORNFLOWERBLUE;" );
		
		this.setPrefSize(300, 600);
		VBox vbox = new VBox();
				
		Text l = new Text ("After 2 hours, you finally reach the closest school. You are tired, sweaty "
				+ "and do not have the energy to pay attention in class. However, your teacher announced"
				+ " that through GirlUp's SchoolCycle initiative you were going to be gifted a bicycle. "
				+ "Let's see if this affects your journey to and from school"); 
		l.relocate(50, 50);
		l.setFill(Color.LIGHTPINK);
		l.setWrappingWidth(500);
<<<<<<< HEAD
		l.setFont(new Font("Berlin Sans FB", 30));
		l.setTextAlignment(TextAlignment.CENTER);
=======
		l.setFont(new Font("Berlin Sans FB", 20));
		l.setTextAlignment(TextAlignment.CENTER); 
>>>>>>> 0054a634c64ff651709445ce26c8c70bce5e5c2a
		
		Image girl = new Image("Images/girlHappy.png");
		ImageView iv = new ImageView();
		iv.setFitHeight(200);
		iv.setFitWidth(132);
        iv.setImage(girl);
		
		Button next = new Button("Let's Go!"); 
		next.setFont(new Font("Berlin Sans FB", 15));
		next.relocate(250, 350);
		
		vbox.setPrefWidth(600);
		vbox.setPadding(new Insets(10,10,10,10));
		vbox.setAlignment(Pos.CENTER);
		vbox.getChildren().addAll(l,iv,next);
		this.getChildren().add(vbox); 
	
	}

}
