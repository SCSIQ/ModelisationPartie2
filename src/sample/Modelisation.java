package sample;

import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Random;

public class Modelisation extends Parent {

    private int width;
    private int height;
    private Complex c;
    private int m;

    public Modelisation(Stage primatyStage, Stage cette_fenetre, int width, int height, Complex c, int m) {
        this.width = width;
        this.height = height;
        this.c = c;
        this.m = m;
        Image i = randomPixels(this.width,this.height);
        //Image i = juliaSet(this.width, this.height, this.c, this.m);
        ImageView imageView = new ImageView(i);
        imageView.setPreserveRatio(true);
        this.getChildren().add(imageView);
    }

    private Image randomPixels(int width, int height) {
        WritableImage img = new WritableImage(width, height);
        PixelWriter pw  = img.getPixelWriter();
        Random rnd = new Random();
        for (int y = 0 ; y < height ; y++) {
            for (int x = 0 ; x < width ; x++) {
                //do the pixel manipulation (ramdom RGB)
                pw.setColor(x, y, Color.rgb(rnd.nextInt(255),
                        rnd.nextInt(255),
                        rnd.nextInt(255)));
            }
        }
        return img;
    }

    private Image juliaSet(int width, int height, Complex c, int m) {
        WritableImage img = new WritableImage(width, height);
        PixelWriter pw  = img.getPixelWriter();

        //write code here

        return img;
    }


}
