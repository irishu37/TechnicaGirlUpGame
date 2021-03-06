
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class questionBubblePopUp extends Pane {

	String chosenAnswer = "";
	QuestionBank bank = new QuestionBank();
	ToggleGroup group;
	int quesNum;
	Label label = new Label();
	VBox mainBox;
	StackPane stackpane;

	public questionBubblePopUp(int questionNum) {
		stackpane = new StackPane();
		mainBox = new VBox();
		mainBox.setPadding(new Insets(20,20,20,20));
		mainBox.setSpacing(10);
		this.setPrefSize(330, 250);
		this.getChildren().add(stackpane);

		Rectangle rectangle = new Rectangle(330, 275);
		rectangle.relocate(200, 90);
		rectangle.setStroke(Color.BLACK);
		rectangle.setFill(Color.WHITE);
		this.getChildren().addAll(rectangle);

		displayQuestion(questionNum);

		Button button = new Button("Submit");
		button.setOnAction(new ButtonHandler());
		mainBox.getChildren().add(button);
		mainBox.getChildren().add(label);
		stackpane.relocate(225, 75);
		stackpane.getChildren().addAll(rectangle, mainBox);
	}

	public void displayQuestion(int quesNum) {
		group = new ToggleGroup();
		Text t = new Text(225, 120, bank.getQuestion(quesNum).getQuestionText());
		t.setWrappingWidth(275);
		mainBox.getChildren().add(t);

		for (int i = 1, j = 0; i <= 4; j++, i++) {
			RadioButton t2 = new RadioButton(bank.getQuestion(quesNum).getAnswerChoices()[j]);
			t2.setUserData(bank.getQuestion(quesNum).getAnswerChoices()[j]);
			mainBox.getChildren().add(t2);
			t2.setToggleGroup(group);
		}

		this.quesNum = quesNum;
	}

	private class ButtonHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			Button b = (Button) e.getSource();
			if (b.getText().equals("Submit")) {
				chosenAnswer = group.getSelectedToggle().getUserData().toString();
				if (chosenAnswer.equals(bank.getQuestion(quesNum).getCorrectAnswer())) {
					label.setText("That is correct!");
					label.setTextFill(Color.GREEN);
				} else {
					label.setText("Incorrect. The right answer is " + bank.getQuestion(quesNum).getCorrectAnswer());
					label.setTextFill(Color.RED);
				}
				b.setText("Close");
			} else if (b.getText().equals("Close")) {
				((StackPane) questionBubblePopUp.this.getParent()).getChildren().remove(questionBubblePopUp.this);
				MainGUI.setFreeze(false);
				
			}

		}

	}

}
