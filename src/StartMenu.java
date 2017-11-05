
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class StartMenu extends Pane{

	public StartMenu() {
		GridPane menuPane = new GridPane();
		menuPane.setAlignment(Pos.CENTER);

		Label gameLabel = new Label("Can you help this girl");
		Label gameLabel2 = new Label(" get to school?");
		gameLabel.setFont(new Font("arial", 50));
		gameLabel.setAlignment(Pos.CENTER);
		gameLabel2.setFont(new Font("arial", 50));
		gameLabel2.setAlignment(Pos.CENTER);

		Image girl = new Image("Images/girl1.png");
		ImageView girlView = new ImageView();
		girlView.setImage(girl);
		girlView.prefWidth(20);
		girlView.prefHeight(40);

		Button startButton = new Button("START");
		startButton.setMinSize(70, 50);
		startButton.setAlignment(Pos.CENTER);
		startButton.setOnAction(e -> {
//			state = STATE.GAME;
		});

		menuPane.add(gameLabel, 0, 0);
		menuPane.add(gameLabel2, 0, 1);
		menuPane.add(girlView, 0, 2);
		menuPane.add(startButton, 0, 3);
		
	}
}
