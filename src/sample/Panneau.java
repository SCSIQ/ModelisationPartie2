package sample;

import javax.swing.*;
import java.awt.*;

public class Panneau extends JPanel {


    public void paintComponent(Graphics g) {

        g.setColor(Color.white);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        paintM(g);


    }

    public void paintM(Graphics g) {
        double x1 = -1.5;
        double x2 = 1.5;
        double y1 = -1.5;
        double y2 = 1.5;

        double zoom = 100;
        int Itmax = 200; //Iterations maximum

        double imagex = (x2 - x1) * zoom;
        double imagey = (y2 - y1) * zoom;

        double x = 0;
        double y = 0;

        while (x < imagex) {
            System.out.println("x=" + x);
            y = 0;
            while (y < imagey) {
                System.out.println("y=" + y);
                double cx = 0.285;
                double cy = 0.01;
                double zx = x / zoom + x1;
                double zy = y / zoom + y1;
                int i = 0;

                do {
                    double r = zx;
                    zx = zx * zx - zy * zy + cx;
                    zy = 2 * zy * r + cy;
                    i++;
                    System.out.println("i=" + i);
                    System.out.println(zx * zx + zy * zy);
                }
                while (zx * zx + zy * zy < 4 && i < Itmax);

                if (i == Itmax) {
                    System.out.println("converge");
                    g.setColor(Color.black);
                    g.fillOval((int) ((x - x1) * zoom), (int) ((y - y1) * zoom), 2, 2);
                } else {
                    System.out.println("diverge");
                    Color c = new Color(0, 0, i * 250 / Itmax);
                    g.setColor(c);
                    g.fillOval((int) ((x - x1) * zoom), (int) ((y - y1) * zoom), 2, 2);
                }

                y = y + 1;
            }
            x = x + 1;
        }
    }
}
