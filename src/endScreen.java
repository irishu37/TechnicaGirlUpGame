import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class endScreen extends Pane{
	
    final WebView browser = new WebView();
    final WebEngine webEngine = browser.getEngine();

	public endScreen() { 
		VBox vbox = new VBox();

		this.setPrefSize(300, 300);
		this.setStyle("-fx-background-color: LIGHTPINK;" );

		Button learnMore= new Button("Learn More"); 
		learnMore.setFont(new Font("Berlin Sans FB", 20));
		
		Hyperlink link = new Hyperlink();
		link.setText("Learn More");
		
		link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                webEngine.load("https://girlup.org/schoolcycle");
            }
        });
		
		learnMore.relocate(500, 500);
		learnMore.setStyle("-fx-background-color: CORNFLOWERBLUE;");
		
		Text l = new Text ("This time it only took you only 25 minutes to get to school. You are energized and ready for a new day!"
				+ " We hope that through this game you were able to understand the influence one bicycle can have on a girl's "
				+ "future. Please consider donating for a brighter future for herand to change these statistics"); 
		l.relocate(100, 100);
		l.setFill(Color.CORNFLOWERBLUE);
		l.setWrappingWidth(550);
		l.setFont(new Font("Berlin Sans FB", 20));
		l.setTextAlignment(TextAlignment.CENTER);
		

		Image girl = new Image("Images/girlBike1.png");
		ImageView iv = new ImageView();
		iv.setFitHeight(200);
		iv.setFitWidth(200);
        iv.setImage(girl);
	
		vbox.setSpacing(20);
		vbox.setPrefWidth(600);
		vbox.setPadding(new Insets(10,10,10,10));
		vbox.setAlignment(Pos.CENTER);
		vbox.getChildren().addAll(l, learnMore,iv); 
		this.getChildren().addAll(vbox); 
		
	}

}
