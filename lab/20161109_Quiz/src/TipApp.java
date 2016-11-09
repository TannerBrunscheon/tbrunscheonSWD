/**
 * Created by tbrunscheon on 11/9/16.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TipApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("TipCalc.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setTitle("My Application");
            primaryStage.setScene(scene);
            primaryStage.show();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
