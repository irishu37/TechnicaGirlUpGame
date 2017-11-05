

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.*;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.event.*;



public class MainGUI extends Application {
	
	private boolean freeze;
	private int questionNum=1; 
	StackPane allPane = new StackPane();
	
	@Override
	public void start(Stage primaryStage) {
		freeze = false;
		//sky
		FlowPane backgroundPane = new FlowPane();
		backgroundPane.setStyle("-fx-background-color: rgb(" + 130 + "," + 207 + ", " + 255 + ");");
		backgroundPane.setPrefSize(600, 300);

		Canvas canvas = new Canvas(600, 400);
		GraphicsContext graphicsContext = canvas.getGraphicsContext2D();

		Image cloud = new Image("Images/Cloud.png", 150, 100, true, true);
		ImageView imageView = new ImageView();
		imageView.setImage(cloud);

		Image[] personAnimation = {new Image("Images/girl1.png", 100, 150, true, true), 
				new Image("Images/girl2.png", 100, 150, true, true)};

		backgroundPane.getChildren().add(canvas);


		//grass
		//		FlowPane grassPane = new FlowPane();
		//		grassPane.setPrefSize(600,  100);
		//		grassPane.setStyle("-fx-background-color: rgb(" + 111 + "," + 201 + ", " + 104 + ");");
		//		
		graphicsContext.setFill(Color.GREEN);
		graphicsContext.fillRect(0, 300, 600, 100);
		
		graphicsContext.setFill(Color.BLACK);
		graphicsContext.fillRect(20, 17, 560, 25);

		graphicsContext.drawImage(personAnimation[0], 50, 200);

		allPane.getChildren().add(backgroundPane); 
		
		AnimationTimer animator = new AnimationTimer()
		{
			int[] xPositions = {600, 800, 1000, 1200};
			int[] yPositions = {5,200,100,150};
			int obstacleX = 600;
			int personPos = 0;
			int timer = 0;
			int progress = 0;

			@Override
			public void handle(long arg0) 
			{
				timer++;
				
				if(personPos == 0 && timer % 5 == 0) {
					personPos = 1;
				}else if(personPos == 1 && timer % 5 == 0){
					personPos = 0;
				}
				
				if(timer%5==0) {
					progress++; //maxprogress is um 554 i think 
				}

				for(int i = 0; i < xPositions.length; i ++) {
					xPositions[i] -= 3; //determines speed of clouds

					if(xPositions[i] <= -200) {
						xPositions[i] = 600;
						yPositions[i] = (int)(Math.random()*150);
					}

				}
				
				
				
				//clouds & person:
				graphicsContext.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
				graphicsContext.drawImage(cloud, xPositions[0], yPositions[0]);
				graphicsContext.drawImage(cloud, xPositions[1], yPositions[1]);
				graphicsContext.drawImage(cloud, xPositions[2], yPositions[2]);
				graphicsContext.drawImage(cloud, xPositions[3], yPositions[3]);
				graphicsContext.setFill(Color.GREEN);
				graphicsContext.fillRect(0, 300, 600, 100);
				
				
				graphicsContext.setFill(Color.BLACK);
				graphicsContext.fillRect(20, 17, 560, 26);
				graphicsContext.setFill(Color.BLANCHEDALMOND);
				graphicsContext.fillRect(23, 20, progress, 20);
				
				obstacleX -=3;
				graphicsContext.setFill(Color.BLUE);
				graphicsContext.fillOval(obstacleX, 320, 100, 25);
				graphicsContext.setFill(Color.GRAY);
				graphicsContext.fillArc(obstacleX + 50, 320, 100, 100, 0, Math.PI, ArcType.OPEN);
				
				if(obstacleX == 51) {
					questionBubblePopUp question = new questionBubblePopUp(questionNum);
					allPane.getChildren().add(question);
				}
				
				graphicsContext.drawImage(personAnimation[personPos], 50, 200);
			}
		};


		//action listeners for key:
		Scene scene = new Scene(allPane, 600, 400);
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				if(event.getCode() == KeyCode.RIGHT && !freeze) {
					animator.start();
				} 
				if(event.getCode() == KeyCode.UP && !freeze) {
					for(int i = 200; i>100; i--)
						graphicsContext.drawImage(personAnimation[0], 50, i);
					for(int i = 100; i<=200; i++)
						graphicsContext.drawImage(personAnimation[0], 50, i);

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


		primaryStage.setScene(scene);
		primaryStage.setTitle("LEARN YO FAX");
		primaryStage.show();

	}
	

	public static void main(String[] args) {
		Application.launch(args);
	}

}