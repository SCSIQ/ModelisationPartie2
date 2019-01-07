package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        int width = 1000;
        int height = 600;
        Group root = new Group() ;
        primaryStage.setTitle("LapinDeDouady");
        primaryStage.setScene(new Scene(root, 300, 150));
        Accueil accueil = new Accueil(primaryStage, width, height);
        root.getChildren().add(accueil);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
