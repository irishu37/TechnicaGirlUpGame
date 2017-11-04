
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class questionBubblePopUp extends Application {

	Pane canvas = new Pane();
	String chosenAnswer = "";
	QuestionBank bank = new QuestionBank();
	ToggleGroup group;
	int quesNum;
	Label label = new Label();

	@Override
	public void start(Stage stage) {
		Group root = new Group();
		Scene scene = new Scene(root, 500, 500);
		stage.setScene(scene);
		stage.setTitle("");

		VBox vb = new VBox();

		canvas.setPrefSize(500, 500);

		Rectangle rectangle = new Rectangle(200, 200);
		rectangle.relocate(50, 50);
		rectangle.setStroke(Color.BLACK);
		rectangle.setFill(Color.WHITE);
		canvas.getChildren().addAll(rectangle);

		displayQuestion(4);

		Button button = new Button("Submit");
		button.setOnAction(new ButtonHandler());
		button.relocate(180, 180);
		canvas.getChildren().addAll(button, label);

		vb.getChildren().add(canvas);
		

		scene.setRoot(vb);
		
		stage.setScene(scene);

		stage.show();

	}

	public void displayQuestion(int quesNum) {
		group = new ToggleGroup();
		Text t = new Text(70, 70, bank.getQuestion(quesNum).getQuestionText());
		t.setWrappingWidth(175);
		canvas.getChildren().addAll(t);

		for (int i = 1, j = 0; i <= 4; j++, i++) {
			RadioButton t2 = new RadioButton(bank.getQuestion(quesNum).getAnswerChoices()[j]);
			t2.setUserData(bank.getQuestion(quesNum).getAnswerChoices()[j]);
			t2.relocate(70, 120 + (i * 20));
			t2.setToggleGroup(group);
			canvas.getChildren().addAll(t2);
		}

		this.quesNum = quesNum;
	}

	private class ButtonHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			chosenAnswer = group.getSelectedToggle().getUserData().toString();
			if (chosenAnswer.equals(bank.getQuestion(quesNum).getCorrectAnswer())) {
				label.setText("That is correct!");
				label.setTextFill(Color.GREEN);
				label.relocate(165, 220);

			} else {
				label.setText(
						"That's wrong. The right answer is " + bank.getQuestion(quesNum).getCorrectAnswer());
				label.setTextFill(Color.RED);
				label.relocate(62, 220);
				
			}
		}

	}

	public static void main(String[] args) {
		launch(args);
	}
}
