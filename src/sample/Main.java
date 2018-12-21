package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        int width = 1000;
        int height = 600;
        Group root = new Group() ;
        primaryStage.setTitle("LapinDeDouady");
        primaryStage.setScene(new Scene(root, 300, 150));
        //Modelisation modelisation = new Modelisation(primaryStage, width, height);
        Acceuil acceuil = new Acceuil(primaryStage, width, height);
        root.getChildren().add(acceuil);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
