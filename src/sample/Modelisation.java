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
        //Image i = randomPixels();
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
                //do the pixel manipulation (ramdom RGB)
                pw.setColor(x, y, Color.rgb(rnd.nextInt(255), rnd.nextInt(255), rnd.nextInt(255)));
            }
        }
        return img;
    }

    private Image juliaSet() {
        WritableImage img = new WritableImage(width, height);
        PixelWriter pw  = img.getPixelWriter();
        /*int nb = 0;
        for (int y = 0 ; y < height ; y++) {
            for (int x = 0; x < width; x++) {
                int _y = y-height/2;
                int _x = x-width/2;
                Complex z = new Complex(_x,_y);
                int mTemp = 0;
                boolean inZ = true;
                while (mTemp < this.m && inZ==true) {
                    if(z.mod()>4000) {
                        inZ=false;
                    }else{
                        if(nb<254) nb++;
                    }
                    z = z.plus(this.c);
                    mTemp++;
                }
                if(inZ==true) {
                    pw.setColor(x, y, Color.rgb(255-nb,
                            255,
                            255));
                }else {
                    pw.setColor(x, y, Color.rgb(0,
                            0,
                            0));
                }
            }
        }*/

        for (int y = 0 ; y < height ; y++) {
            for (int x = 0; x < width; x++) {
                pw.setColor(x, y, Color.rgb(0,120,0));
            }
        }

        int mTemp = 0;
        while (mTemp <= /*this.m*/10) {
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    int _y = y - height / 2;
                    int _x = x - width / 2;
                    Complex z = new Complex(_x, _y);

                    boolean inZ = true;
                    int a = 0;


                    while (a<mTemp && inZ==true)
                    {
                        if(z.mod()<=200) {
                            //System.out.println("mod z("+_x+","+_y+") : "+z.mod());
                            //System.out.println("mTemp : "+mTemp+", a : "+a);
                            inZ=true;
                        }else{
                            inZ=false;
                        }
                        z = z.times(z);
                        z = z.plus(this.c);
                        a++;
                        //System.out.println("a : "+a);;
                    }

                    /*do {
                        if(z.mod()<=20) {
                            System.out.println("mod z("+_x+","+_y+") : "+z.mod());
                            System.out.println("mTemp : "+mTemp+", a : "+a);
                            inZ=true;
                        }
                        z = z.times(z);
                        z = z.plus(this.c);
                        a++;
                        System.out.println("a : "+a);;
                    }while (a < mTemp && inZ==true);*/

                    if(inZ==true)  {
                        if(mTemp==0) pw.setColor(x, y, Color.rgb(0,0,0));

                        /*if(mTemp==1) pw.setColor(x, y, Color.rgb(255,0,255));
                        if(mTemp==2) pw.setColor(x, y, Color.rgb(100,255,100));
                        if(mTemp==3) pw.setColor(x, y, Color.rgb(0,0,255));
                        if(mTemp==4) pw.setColor(x, y, Color.rgb(255,255,0));
                        if(mTemp==5) pw.setColor(x, y, Color.rgb(0,255,255));*/

                        if(mTemp==1) pw.setColor(x, y, Color.rgb(255,0,0));
                        if(mTemp==2) pw.setColor(x, y, Color.rgb(255,0,255));
                        if(mTemp==3) pw.setColor(x, y, Color.rgb(120,0,255));
                        if(mTemp==4) pw.setColor(x, y, Color.rgb(0,0,255));
                        if(mTemp==5) pw.setColor(x, y, Color.rgb(0,120,255));
                        if(mTemp==6) pw.setColor(x, y, Color.rgb(0,255,255));
                        if(mTemp==7) pw.setColor(x, y, Color.rgb(120,255,255));
                        if(mTemp==8) pw.setColor(x, y, Color.rgb(255,255,255));








                        //else pw.setColor(x, y, Color.rgb(0,0,255));
                    }


                    /*if(z.mod2()<4000) {
                        if (mTemp < 20) pw.setColor(x, y, Color.rgb(255,0,0+mTemp*10));
                        else pw.setColor(x, y, Color.rgb(0,0,255));
                    }*/
                }
            }
            mTemp = mTemp+1;
        }

        return img;
    }


}
