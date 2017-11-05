import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class endScreen extends Pane{
	
    final WebView browser = new WebView();
    final WebEngine webEngine = browser.getEngine();

	public endScreen() { 
		Button learnMore= new Button("Learn More"); 
		learnMore.setFont(new Font("Berlin Sans FB", 20));
		
		Hyperlink link = new Hyperlink();
		link.setText("Learn More");
		
		link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                webEngine.load("https://girlup.org/schoolcycle/#sthash.gvUjDrj7.dpbs");
            }
        });
		
		
	}

}
