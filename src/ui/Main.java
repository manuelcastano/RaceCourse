package ui;

import java.util.Scanner;

import Controller.Controller;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Bettor;
import model.HorseRider;
import model.Iqueue;
import model.Pqueue;
import model.Race;
import threads.BetsThread;

public class Main extends Application{
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Controller c1 = new Controller();
			GridPane root = new GridPane();
			Button start = new Button("Start");
			start.setOnAction(e->{c1.Start( root);});
			root.getChildren().add(start);
			Scene scene = new Scene(root, 400, 400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	public static void main(String[] args) {
		launch(args);
	}
}
