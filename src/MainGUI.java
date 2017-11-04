import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

import javafx.animation.AnimationTimer;
import javafx.application.*;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;



public class MainGUI extends Application {

	@Override
	public void start(Stage primaryStage) {
		//sky
		FlowPane backgroundPane = new FlowPane();
		backgroundPane.setStyle("-fx-background-color: rgb(" + 130 + "," + 207 + ", " + 255 + ");");
		backgroundPane.setPrefSize(600, 300);
		
		Canvas canvas = new Canvas(600, 300);
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        
        Image cloud = new Image("Images/Cloud.png", 150, 100, true, true);
		ImageView imageView = new ImageView();
        imageView.setImage(cloud);
        
        
        backgroundPane.getChildren().add(canvas);
        
        
		//grass
		FlowPane grassPane = new FlowPane();
		grassPane.setPrefSize(600,  100);
		grassPane.setStyle("-fx-background-color: green;");

		FlowPane pane = new FlowPane();
		pane.getChildren().addAll(backgroundPane, grassPane); 
		
		AnimationTimer animator = new AnimationTimer()
		{
			int[] xPositions = {600, 700, 800, 1000};
			
			@Override
			public void handle(long arg0) 
			{
				for(int i = 0; i < xPositions.length; i ++) {
					xPositions[i] -= 3; //determines speed of clouds
					
					if(xPositions[i] <= -200) {
						xPositions[i] = 600;
					}
				}
				
//				if(xPos == -200) {
//					xPos = 600;
//				}
//                // UPDATE
//				xPos--;
                // RENDER
				 graphicsContext.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
				 graphicsContext.drawImage(cloud, xPositions[0], 5);
				 graphicsContext.drawImage(cloud, xPositions[1], 200);
				 graphicsContext.drawImage(cloud, xPositions[2], 100);
				 graphicsContext.drawImage(cloud, xPositions[3], 150);
			}
		};
		

		Scene scene = new Scene(pane, 600, 400);
		primaryStage.setScene(scene);
		primaryStage.setTitle("LEARN YO FAX");
		primaryStage.show();
		
		animator.start();

	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}

}