

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class middleScreen extends Pane {

	public middleScreen() {
		this.setStyle("-fx-background-color: CORNFLOWERBLUE;" );
		
		this.setPrefSize(300, 600);
				
		Text l = new Text ("After 2 hours, you finally reach the closest school. You are tired, sweaty "
				+ "and do not have the energy to pay attention in class. However, your teacher announced"
				+ " that through GirlUp's SchoolCycle initiative you were going to be gifted a bicycle. "
				+ "Let's see if this affects your journey to and from school"); 
		l.relocate(50, 50);
		l.setFill(Color.LIGHTPINK);
		l.setWrappingWidth(500);
		l.setFont(new Font("Berlin Sans FB", 30));
		l.setTextAlignment(TextAlignment.CENTER);
		
		Button next = new Button("Let's Go!"); 
		next.setFont(new Font("Berlin Sans FB", 20));
		next.relocate(250, 350);
		
		this.getChildren().addAll(l,next); 
	
	}

}
