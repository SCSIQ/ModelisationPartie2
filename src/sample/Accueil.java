package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Accueil extends Parent {

    public Accueil(Stage primaryStage, int width, int height) {

        //Labels
        Label t_c = new Label("Entrez c :");
        Label t_m = new Label("Entrez M :");
        Label plus = new Label("+");
        Label i = new Label("i");

        t_c.setFont(Font.font("Verdana", FontWeight.SEMI_BOLD, 20));
        t_m.setFont(Font.font("Verdana", FontWeight.SEMI_BOLD, 20));
        plus.setFont(Font.font("Verdana", FontWeight.SEMI_BOLD, 20));
        i.setFont(Font.font("Verdana", FontWeight.SEMI_BOLD, 20));

        t_c.setLayoutX(20);
        t_c.setLayoutY(10);

        t_m.setLayoutX(20);
        t_m.setLayoutY(50);

        plus.setLayoutX(300);
        plus.setLayoutY(10);

        i.setLayoutX(480);
        i.setLayoutY(10);

        this.getChildren().add(t_c);
        this.getChildren().add(t_m);
        this.getChildren().add(plus);
        this.getChildren().add(i);

        //Combo box
        //ComboBox cb_c = new ComboBox();
        TextField tf_c_r = new TextField();
        TextField tf_c_i = new TextField();
        ComboBox cb_m = new ComboBox();

        //cb_c.getItems().addAll("1","2");
        cb_m.getItems().addAll("1","2");

        //cb_c.getSelectionModel().selectFirst();
        cb_m.getSelectionModel().selectFirst();

        //cb_c.setLayoutX(150);
        //cb_c.setLayoutY(10);

        tf_c_r.setLayoutX(150);
        tf_c_r.setLayoutY(10);

        tf_c_i.setLayoutX(320);
        tf_c_i.setLayoutY(10);

        cb_m.setLayoutX(150);
        cb_m.setLayoutY(50);

        //cb_c.setPrefSize(100,30);
        cb_m.setPrefSize(100, 30);

        //this.getChildren().add(cb_c);
        this.getChildren().addAll(tf_c_r);
        this.getChildren().addAll(tf_c_i);
        this.getChildren().add(cb_m);

        //Bouton
        Button b_lancer = new Button("Lancer");

        b_lancer.setLayoutX(400);
        b_lancer.setLayoutY(100);

        b_lancer.setPrefSize(90,30);

        b_lancer.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                Stage nouvelle_fenetre=new Stage();
                double c_r = Double.parseDouble(tf_c_r.getText());
                double c_i = Double.parseDouble(tf_c_i.getText());
                Complex c = new Complex(c_r,c_i);
                Modelisation modelisation = new Modelisation(primaryStage,nouvelle_fenetre,width,height,c,(Integer.valueOf((String) cb_m.getValue())));
                Scene nouvelle_scene = new Scene(modelisation,width,height);

                nouvelle_fenetre.setScene(nouvelle_scene);

                nouvelle_fenetre.show();
                primaryStage.close();
            }
        });

        this.getChildren().add(b_lancer);

    }
}
