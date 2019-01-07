package sample;

import java.awt.*;

public class Julia {

    public void paintJulia(Graphics d){
        double x1=-2.1;
        double x2=0.6;
        double y1=-1.2;
        double y2=1.2;
        double zoom=300;
        int Itmax=500;

        double imagex=(x2-x1)*zoom;
        double imagey=(y2-y1)*zoom;
        double i=x1;
        while(i<x2){
            double j=y1;
            while(j<y2){


                Complex Z=new Complex(0,0);

                int k=0;
                double r=0;
                do{
                    r=Z.x;
                    Z.x = Z.x*Z.x - Z.y*Z.y +i;
                    Z.y = 2*r*Z.y + j;
                    k++;
                }while((Z.x*Z.x+Z.y*Z.y)<5 && k<Itmax);

                if(k==Itmax){
                    Color c=new Color(0,0,0);
                    d.setColor(c);
                    d.fillOval((int)((i-x1)*zoom), (int)((j-y1)*zoom),2,2);
                }
                else{
                    Color c=new Color(0,0,k*255/Itmax);
                    d.setColor(c);
                    d.fillOval((int)((i-x1)*zoom), (int)((j-y1)*zoom),2,2);
                }
                j=j+1/imagey;

            }

            i=i+1/imagex;
        }

    }

}
