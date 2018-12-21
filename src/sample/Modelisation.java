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

    public Modelisation(Stage primatyStage, int width, int height) {
        this.width = width;
        this.height = height;
        Image i = randomPixels(this.width,this.height);
        ImageView imageView = new ImageView(i);
        imageView.setPreserveRatio(true);
        this.getChildren().add(imageView);
    }

    public Image randomPixels(int width, int height) {
        WritableImage img = new WritableImage(width, height);
        PixelWriter pw  = img.getPixelWriter();
        Random rnd = new Random();
        for (int y = 0 ; y < height ; y++) {
            for (int x = 0 ; x < width ; x++) {
                // Do the pixel manipulation
                pw.setColor(x, y, Color.rgb(rnd.nextInt(255),
                        rnd.nextInt(255),
                        rnd.nextInt(255)));
            }
        }
        return img;
    }
}
