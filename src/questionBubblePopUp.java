import java.awt.Button;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class questionBubblePopUp extends Application {

	@Override
	public void start(Stage stage) {
		Group root = new Group();
		Scene scene = new Scene(root, 500, 500);
		stage.setScene(scene);
		stage.setTitle("");

		VBox vb = new VBox();

		Pane canvas = new Pane();
		canvas.setPrefSize(500, 500);

		Rectangle rectangle = new Rectangle(200, 150);
		rectangle.relocate(50, 50);
		rectangle.setStroke(Color.BLACK);
		rectangle.setFill(null);

		Text t = new Text(70, 70, "Hello this is the question?");
		canvas.getChildren().addAll(rectangle, t);

		for (int i = 1; i <= 4; i++) {
			RadioButton t2 = new RadioButton("hello here is an answer");
			t2.relocate(70, 70 + (i * 20));
			canvas.getChildren().addAll(t2);

		}

		Button button = new Button("Submit");


		vb.getChildren().add(canvas);

		scene.setRoot(vb);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
