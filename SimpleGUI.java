package com.github.rinarose3.trafficLight;

import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import javax.swing.*;

public class SimpleGUI extends JFrame {

    public void paint(Graphics g){
        Font font = new Font("Tahoma", Font.BOLD|Font.ITALIC, 18);
        g.setFont(font);
        g.drawString("Рисунок светофора JFrame", 10, 50);

        // //Drawing main thing

        Graphics2D g2D = (Graphics2D) g;
        g.setColor(Color.black);
        g.fillRoundRect(100, 100, 113, 311, 40, 40);
        g.fillArc(115, 78, 82, 40, 0, 180);

        //Drawing lights
        g.setColor(Color.red);
        g.fillOval(120, 130, 70, 70);

        g.setColor(Color.yellow);
        g.fillOval(120, 230, 70, 70);

        g.setColor(Color.green);
        g.fillOval(120, 330, 70, 70);

        //Drawing white things
        g.setColor(Color.white);
        Area area = new Area(new Ellipse2D.Double(115, 110, 80, 80));
        Area temp = new Area(new Ellipse2D.Double(115, 124, 80, 80));
        area.subtract(temp);
        g2D.fill(area);

        area = new Area(new Ellipse2D.Double(115, 210, 80, 80));
        temp = new Area(new Ellipse2D.Double(115, 224, 80, 80));
        area.subtract(temp);
        g2D.fill(area);

        area = new Area(new Ellipse2D.Double(115, 310, 80, 80));
        temp = new Area(new Ellipse2D.Double(115, 324, 80, 80));
        area.subtract(temp);
        g2D.fill(area);

        g.setColor(Color.black);
        this.paintThing(100, 140, true, g);
        this.paintThing(100, 240, true, g);
        this.paintThing(100, 340, true, g);
        this.paintThing(220, 140, false, g);
        this.paintThing(220, 240, false, g);
        this.paintThing(220, 340, false, g);



    }

    public void paintThing(int x, int y, boolean isLeft, Graphics g) {

        Graphics2D g2D = (Graphics2D) g;

        if (isLeft) {
            g2D.fillOval(x - 20, y, 15, 15);
            g2D.fillOval(x - 55, y, 15, 15);
            g2D.fillOval(x - 20, y + 36, 15, 15);

            Polygon p = new Polygon();
            p.addPoint(x - 8, y);
            p.addPoint(x - 43, y);
            p.addPoint(x - 52, y + 15);
            p.addPoint(x - 14, y + 52);
            p.addPoint(x-5, y + 42);
            p.addPoint(x-5, y + 2);
            g2D.fillPolygon(p);
        } else {
            g2D.fillOval(x, y, 15, 15);
            g2D.fillOval(x + 36, y, 15, 15);
            g2D.fillOval(x, y + 36, 15, 15);
            Polygon p = new Polygon();

            p.addPoint(x + 10, y);
            p.addPoint(x + 45, y);
            p.addPoint(x + 52, y + 9);
            p.addPoint(x + 15, y + 47);
            p.addPoint(x + 1, y + 49);
            p.addPoint(x, y + 10);
            g2D.fillPolygon(p);
        }
    }

    public SimpleGUI(){
        super("Светофор");
        this.setBounds(100, 100, 300, 450);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
