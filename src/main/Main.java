package main;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/layout/main.fxml"));
        StackPane stackPane = loader.load();
        Scene scene = new Scene(stackPane, 800, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Calc v 0.1");
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
