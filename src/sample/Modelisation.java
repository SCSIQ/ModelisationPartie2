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
        Image i = juliaSet();
        ImageView imageView = new ImageView(i);
        imageView.setPreserveRatio(true);
        this.getChildren().add(imageView);
    }

    private Image randomPixels() {
        WritableImage img = new WritableImage(width, height);
        PixelWriter pw  = img.getPixelWriter();
        Random rnd = new Random();
        for (int y = 0 ; y < height ; y++) {
            for (int x = 0 ; x < width ; x++) {
                pw.setColor(x, y, Color.rgb(rnd.nextInt(255), rnd.nextInt(255), rnd.nextInt(255)));
            }
        }
        return img;
    }

    private Image juliaSet() {
        WritableImage img = new WritableImage(width, height);
        PixelWriter pw  = img.getPixelWriter();

        int mTemp = 0;


        while (mTemp <= this.m) {
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {

                    int _y = y - height / 2;
                    int _x = x - width / 2;
                    Complex z = new Complex(_x/150.0, _y/150.0);
                    boolean inZ = true;
                    int a = 0;

                    while (a<mTemp && inZ==true)
                    {
                        if(z.mod()<=2) {
                            inZ=true;
                        }else{
                            inZ=false;
                        }
                        z = z.square();
                        z = z.plus(this.c);
                        a++;
                    }
                    if(inZ==true)  {

                        if(mTemp==0) pw.setColor(x, y, Color.rgb(0,0,0));

                        //vect ini : rouge
                        int R_ini = 255;
                        int G_ini = 0;
                        int B_ini = 0;

                        //vect fin : vert
                        int R_fin = 0;
                        int G_fin = 255;
                        int B_fin = 0;

                        //vect diff
                        int R_diff = R_fin - R_ini;
                        int G_diff = G_fin - G_ini;
                        int B_diff = B_fin - B_ini;

                        int coef = this.m;
                        double azerty = Math.log((((double)mTemp)/this.m)*coef+1);
                        double qwerty = azerty/Math.log(coef+1);

                        //vect couleur
                        int R_coul = (int) (qwerty * R_diff + R_ini);
                        int G_coul = (int) (qwerty * G_diff + G_ini);
                        int B_coul = (int) (qwerty * B_diff + B_ini);

                        if(mTemp>=this.m) {
                            R_coul = 0;
                            G_coul=0;
                            B_coul=0;
                        }

                        pw.setColor(x, y, Color.rgb(R_coul,G_coul,B_coul));

                    }

                }
            }
            mTemp = mTemp+1;
        }

        return img;
    }


}
