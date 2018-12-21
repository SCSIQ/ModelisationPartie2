package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Acceuil extends Parent {

    public Acceuil(Stage primaryStage, int width, int height) {

        //Labels
        Label t_c = new Label("Entrez c :");
        Label t_m = new Label("Entrez m :");

        t_c.setFont(Font.font("Verdana", FontWeight.SEMI_BOLD, 20));
        t_m.setFont(Font.font("Verdana", FontWeight.SEMI_BOLD, 20));

        t_c.setLayoutX(10);
        t_c.setLayoutY(10);

        t_m.setLayoutX(10);
        t_m.setLayoutY(50);

        this.getChildren().add(t_c);
        this.getChildren().add(t_m);

        //Combo box
        ComboBox cb_c = new ComboBox();
        ComboBox cb_m = new ComboBox();

        cb_c.getItems().addAll("1","2");
        cb_m.getItems().addAll("a","b");

        cb_c.getSelectionModel().selectFirst();
        cb_m.getSelectionModel().selectFirst();

        cb_c.setLayoutX(150);
        cb_c.setLayoutY(10);

        cb_m.setLayoutX(150);
        cb_m.setLayoutY(50);

        cb_c.setPrefSize(100,30);
        cb_m.setPrefSize(100, 30);

        this.getChildren().add(cb_c);
        this.getChildren().add(cb_m);

        //Bouton
        Button b_lancer = new Button("Lancer");

        b_lancer.setLayoutX(190);
        b_lancer.setLayoutY(100);

        b_lancer.setPrefSize(90,30);

        /*Stage newWindow = new Stage();

        b_lancer.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                primaryStage.show();
                newWindow.close() ;

            }
        });*/

        this.getChildren().add(b_lancer);

    }
}
