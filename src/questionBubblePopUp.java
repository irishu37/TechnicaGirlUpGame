
import javax.swing.event.ChangeListener;

import gui.InterestTableGUI.ButtonHandler;
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
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class questionBubblePopUp extends Application {

	Pane canvas = new Pane();
	QuestionBank bank = new QuestionBank(); 
	
	@Override
	public void start(Stage stage) {
		Group root = new Group();
		Scene scene = new Scene(root, 500, 500);
		QuestionBank qb = new QuestionBank();
		ToggleGroup group = new ToggleGroup();
		stage.setScene(scene);
		stage.setTitle("");

		VBox vb = new VBox();

		canvas.setPrefSize(500, 500);

		Rectangle rectangle = new Rectangle(200, 200);
		rectangle.relocate(50, 50);
		rectangle.setStroke(Color.BLACK);
		rectangle.setFill(null);

		canvas.getChildren().addAll(rectangle); 
		
		displayQuestion(4);

		Button button = new Button("Submit");
		button.relocate(180, 180);
		button.setOnAction(new ButtonHandler());
		canvas.getChildren().add(button); 
		
		vb.getChildren().add(canvas);

		scene.setRoot(canvas);
		stage.show();
	}
	
	public void displayQuestion(int quesNum) {
		ToggleGroup group = new ToggleGroup(); 
		String chosenAnswer=""; 
		Text t = new Text(70, 70, bank.getQuestion(quesNum).getQuestionText());
		t.setWrappingWidth(175);
		canvas.getChildren().addAll(t);

		for (int i = 1, j=0; i <= 4; j++, i++) {
			RadioButton t2 = new RadioButton(bank.getQuestion(quesNum).getAnswerChoices()[j]);
			t2.relocate(70, 120 + (i * 20));
			t2.setToggleGroup(group);
			canvas.getChildren().addAll(t2);
		}
		
		group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            public void changed(ObservableValue<? extends Toggle> ov, Toggle t, Toggle t1) {
                System.out.println(group.selectedToggleProperty().toString());
            }
        });
	}
	
	private class ButtonHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) { 
			output.setText(printedOutput(true,false));
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
