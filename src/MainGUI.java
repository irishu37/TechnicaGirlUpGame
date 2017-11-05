import java.util.ArrayList;
import java.util.function.Consumer;

import javafx.animation.AnimationTimer;
import javafx.application.*;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.event.*;
import javafx.geometry.Pos;

public class MainGUI extends Application {

	private static boolean freeze;
	private int questionNum = 1,speed = 5,yPosition = 200,totalObstacles = 13;
	final static int WIDTH = 600;
	final static int HEIGHT = 400;
	private Stage primaryStage;
	private ArrayList<Image> obstacles = new ArrayList<Image>();
	private static AnimationTimer animator;

	private enum STATE {
		MENU, WALKINGGAME, BIKINGGAME, MIDDLE, END
	};

	private STATE state = STATE.MENU;

	private void setState(STATE newState) {
		state = newState;
		reloadScene();
	}

	private void reloadScene() {
		Scene currentScene = new Scene(new Pane());
		if (state == STATE.WALKINGGAME || state == STATE.BIKINGGAME) {
			currentScene = runGame();
		} else if (state == STATE.MENU) {
			currentScene = runMenu();
		} else if(state == STATE.MIDDLE) {
			currentScene = runMiddle();
		} else if(state == STATE.END) {
			currentScene = runEnd();
		}
		
		primaryStage.setScene(currentScene);
	}
	
	private Scene runEnd() {
		endScreen ed = new endScreen();
		return new Scene(ed, WIDTH, HEIGHT);
	}
	
	private Scene runMiddle() {
		middleScreen md = new middleScreen(e -> {
			setState(STATE.BIKINGGAME);
		});
		return new Scene(md, WIDTH, HEIGHT);
	}

	public static void setFreeze(boolean newFreeze) {
		freeze = newFreeze;
		animator.stop();
	}

	private Scene runMenu() {
		VBox menuPane = new VBox();
		menuPane.setStyle("-fx-background-color: rgb(" + 255 + "," + 192 + ", " + 203 + ");");
		menuPane.setAlignment(Pos.CENTER);

		Text intro = new Text("Can you help this girl get to school?");
		intro.relocate(50, 50);
		intro.setFill(Color.CORNFLOWERBLUE);
		intro.setWrappingWidth(500);
		intro.setFont(new Font("Berlin Sans FB", 30));
		intro.setTextAlignment(TextAlignment.CENTER);

		Image girl = new Image("Images/girl1.png");
		ImageView girlView = new ImageView();
		girlView.setImage(girl);
		girlView.setFitHeight(130);
		girlView.setFitWidth(80);

		Button startButton = new Button("START");
		startButton.setMinSize(70, 50);
		startButton.setAlignment(Pos.CENTER);
		startButton.setFont(new Font("Berlin Sans FB", 30));
		startButton.setOnAction(e -> {
			setState(STATE.WALKINGGAME); 
		});

		menuPane.getChildren().addAll(intro, girlView, startButton);

		return new Scene(menuPane, WIDTH, HEIGHT);
	}

	private Scene runGame() {
		// sky
		FlowPane backgroundPane = new FlowPane();
		backgroundPane.setStyle("-fx-background-color: rgb(" + 130 + "," + 207 + ", " + 255 + ");");
		backgroundPane.setPrefSize(600, 300);

		Canvas canvas = new Canvas(WIDTH, HEIGHT);
		GraphicsContext graphicsContext = canvas.getGraphicsContext2D();

		Image cloud = new Image("Images/Cloud.png", 150, 100, true, true);
		ImageView imageView = new ImageView();
		imageView.setImage(cloud);
		
		Image[] personAnimation = new Image[2];
		if(state == STATE.WALKINGGAME) {
			speed = 5;
			yPosition = 200;
			totalObstacles = 12;
			personAnimation[0] = new Image("Images/girl1.png", 100, 150, true, true);
			personAnimation[1] = new Image("Images/girl2.png", 100, 150, true, true);
		} else if (state == STATE.BIKINGGAME){
			speed = 2;
			yPosition = 210;
			totalObstacles = 5;
			personAnimation[0] = new Image("Images/girlBike1.png", 100, 150, true, true);
			personAnimation[1] = new Image("Images/girlBike2.png", 100, 150, true, true);
		}

		backgroundPane.getChildren().add(canvas);

		// grass
		// FlowPane grassPane = new FlowPane();
		// grassPane.setPrefSize(600, 100);
		// grassPane.setStyle("-fx-background-color: rgb(" + 111 + "," + 201 + ", " +
		// 104 + ");");
		//
		graphicsContext.setFill(Color.GREEN);
		graphicsContext.fillRect(0, 300, 600, 100);

		graphicsContext.setFill(Color.BLACK);
		graphicsContext.fillRect(20, 17, 560, 25);

		graphicsContext.drawImage(personAnimation[0], 50, yPosition);

		StackPane allPane = new StackPane();
		allPane.getChildren().add(backgroundPane);
		
		
		animator = new AnimationTimer() {
			int[] xPositions = { 600, 800, 1000, 1200 };
			int[] yPositions = { 5, 200, 100, 150 };
			int obstacleX = 600;
			int personPos = 0;
			int timer = 0;
			int progress = 0;
			int randomObstacle = 0;
			int obstacleNum = 1;
			boolean complete = false;
			
			
			@Override
			public void handle(long arg0) {
				timer++;

				if (personPos == 0 && timer % 5 == 0) {
					personPos = 1;
				} else if (personPos == 1 && timer % 5 == 0) {
					personPos = 0;
				}

				//change this thing for faster progress fill! 
				if (timer % speed == 0) {
					progress++; // maxprogress is um 554 i think
				}

				for (int i = 0; i < xPositions.length; i++) {
					xPositions[i] -= 3; // determines speed of clouds

					if (xPositions[i] <= -200) {
						xPositions[i] = 600;
						yPositions[i] = (int) (Math.random() * 150);
					}

				}

				// clouds & person:
				graphicsContext.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
				graphicsContext.drawImage(cloud, xPositions[0], yPositions[0]);
				graphicsContext.drawImage(cloud, xPositions[1], yPositions[1]);
				graphicsContext.drawImage(cloud, xPositions[2], yPositions[2]);
				graphicsContext.drawImage(cloud, xPositions[3], yPositions[3]);
				graphicsContext.setFill(Color.GREEN);
				graphicsContext.fillRect(0, 300, 600, 100);

				//progressbar
				graphicsContext.setFill(Color.BLACK);
				graphicsContext.fillRect(20, 17, 560, 26);
				graphicsContext.setFill(Color.BLANCHEDALMOND);
				if(!complete) {
					graphicsContext.fillRect(23, 20, progress, 20);
				} else {
					graphicsContext.fillRect(23, 20, 554, 20);
				}
				if(progress == 554) {
					complete = true;
					if(state == STATE.WALKINGGAME) {
						setState(STATE.MIDDLE);
					}else if (state == STATE.BIKINGGAME) {
						setState(STATE.END);
					}
				}

				obstacleX -= 3;
				if(obstacleX==-99) {
					obstacleX = 600;
					obstacleNum++;
					randomObstacle = (int) (Math.random()*4);
				}
				if(obstacleNum<totalObstacles) {
					graphicsContext.drawImage(obstacles.get(randomObstacle),obstacleX,250);
				} else {
					graphicsContext.drawImage(new Image("Images/school.png"), obstacleX, 175);
				}

				if (obstacleX == 81) {
					setFreeze(false);
					questionBubblePopUp question = new questionBubblePopUp(questionNum);
					allPane.getChildren().add(question);
					questionNum++;	
				}

				graphicsContext.drawImage(personAnimation[personPos], 50, yPosition);
			}
		};

		// action listeners for key:
		Scene scene = new Scene(allPane, WIDTH, HEIGHT);

		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				if (event.getCode() == KeyCode.RIGHT && !freeze) {
					animator.start();
				}
				event.consume();
			}
		});

		scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				animator.stop();
				event.consume();
			}
		});
		
		return scene;
	}

	@Override
	public void start(Stage primaryStage) {
		freeze = false;
		obstacles.add(new Image("Images/puddle.png"));
		obstacles.add(new Image("Images/MAN.png",100,150,true,true));
		obstacles.add(new Image("Images/rock.png"));
		obstacles.add(new Image("Images/sticks.png"));
		
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Cycles for Her Future");
		reloadScene();
		this.primaryStage.show();
	}

	// }

	public static void main(String[] args) {
		Application.launch(args);
	}

}