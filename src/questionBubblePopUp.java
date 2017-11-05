
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
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class questionBubblePopUp extends Pane {

	String chosenAnswer = "";
	QuestionBank bank = new QuestionBank();
	ToggleGroup group;
	int quesNum;
	Label label = new Label();

	public questionBubblePopUp(int questionNum) {

		this.setPrefSize(300, 600);

		Rectangle rectangle = new Rectangle(200, 200);
		rectangle.relocate(200, 90);
		rectangle.setStroke(Color.BLACK);
		rectangle.setFill(Color.WHITE);
		this.getChildren().addAll(rectangle);

		displayQuestion(questionNum);

		Button button = new Button("Submit");
		button.setOnAction(new ButtonHandler());
		button.relocate(300, 225);
		this.getChildren().addAll(button, label);

	}

	public void displayQuestion(int quesNum) {
		group = new ToggleGroup();
		Text t = new Text(225, 120, bank.getQuestion(quesNum).getQuestionText());
		t.setWrappingWidth(175);
		this.getChildren().addAll(t);

		for (int i = 1, j = 0; i <= 4; j++, i++) {
			RadioButton t2 = new RadioButton(bank.getQuestion(quesNum).getAnswerChoices()[j]);
			t2.setUserData(bank.getQuestion(quesNum).getAnswerChoices()[j]);
			t2.relocate(225, 150 + (i * 20));
			t2.setToggleGroup(group);
			this.getChildren().addAll(t2);
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
					label.relocate(305, 265);
				} else {
					label.setText("Incorrect. The right answer is " + bank.getQuestion(quesNum).getCorrectAnswer());
					label.setTextFill(Color.RED);
					label.relocate(205, 265);
				}
				b.setText("Close");
			} else if (b.getText().equals("Close")) {
				((StackPane) questionBubblePopUp.this.getParent()).getChildren().remove(questionBubblePopUp.this);
			}

		}

	}

}
