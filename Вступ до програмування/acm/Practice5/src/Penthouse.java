/*
    Намалювати різнокольоровий будинок в якого будуть:
    вікна, двері, дах, димохід, дим, паркан, хмаринки. Далі Ваша фантазія.

    Використовуйте цикли.
    Додайте підпис на малюнок.

    File: Penthouse.java
    Author: Федорич Володимир
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Penthouse extends GraphicsProgram {
    public void run() {
        this.setSize(650, 650);

        drawBaseHouse();
        drawDoor();
        drawWindow();
        drawChimney();
        drawDecorations();
    }

    //Draws the roof and the house body
    private void drawBaseHouse(){
        //Draw the roof
        GPolygon roof = new GPolygon();
        roof.addVertex(25, 300);
        roof.addVertex(275, 300);
        roof.addVertex(150, 200);
        roof.setFilled(true);
        roof.setFillColor(java.awt.Color.RED);
        add(roof);

        //Draw the house body
        GRect houseBody = new GRect(25, 300, 250, 150);
        houseBody.setFilled(true);
        houseBody.setFillColor(java.awt.Color.YELLOW);
        add(houseBody);
    }

    //Draws the base for window and bars for it
    private void drawWindow(){
        //Draw the window
        GRect window = new GRect(200, 320, 60, 60);
        window.setFilled(true);
        window.setFillColor(java.awt.Color.CYAN);
        add(window);

        //Add vertical and horizontal bars to the window
        double windowX = window.getX();
        double windowY = window.getY();
        double windowWidth = window.getWidth();
        double windowHeight = window.getHeight();

        //Vertical bar
        GLine verticalBar = new GLine(windowX + windowWidth / 2, windowY, windowX + windowWidth / 2, windowY + windowHeight);
        verticalBar.setColor(java.awt.Color.BLACK);
        add(verticalBar);

        //Horizontal bar
        GLine horizontalBar = new GLine(windowX, windowY + windowHeight / 2, windowX + windowWidth, windowY + windowHeight / 2);
        horizontalBar.setColor(java.awt.Color.BLACK);
        add(horizontalBar);
    }

    //Draws the door
    private void drawDoor(){
        GRect door = new GRect(105, 350, 80, 100);
        door.setFilled(true);
        door.setFillColor(java.awt.Color.BLUE);
        add(door);
    }

    //Draws the chimney
    private void drawChimney(){
        GRect chimney = new GRect(100, 200, 30, 80);
        chimney.setFilled(true);
        chimney.setFillColor(java.awt.Color.GRAY);
        add(chimney);

        // Add smoke particles
        for (int i = 0; i < 3; i++) {
            double x = 115 + i * 10;
            double y = 175 - i * 10;
            GOval smokeParticle = new GOval(x, y, 10, 10);
            smokeParticle.setFilled(true);
            smokeParticle.setFillColor(java.awt.Color.LIGHT_GRAY);
            add(smokeParticle);
        }
    }

    //Draws clouds, fence and grass clusters
    private void drawDecorations(){
        //Draw clouds with an offset between groups
        drawCloud(50, 50);
        drawCloud(180, 100);
        drawCloud(280, 50);

        //Draw the fence beside the house with taller segments
        for (int i = 0; i < 5; i++) {
            double x = 150 + i * 50;
            GRect fenceSegment = new GRect(x, 400, 40, 80);
            fenceSegment.setFilled(true);
            fenceSegment.setFillColor(java.awt.Color.ORANGE);
            add(fenceSegment);
        }

        //Draw cluster clusters
        for (int i = 0; i < 20; i++) {
            double x = 25 + Math.random() * 250;
            double y = 500 + Math.random() * 50;
            drawGrassCluster(x, y, 10, 20);
        }
    }

    //Draws row of circles that represents clouds
    private void drawCloud(double x, double y) {
        int numCircles = 5;
        double cloudRadius = 20;
        double spacing = 5;

        for (int i = 0; i < numCircles; i++) {
            double xOffset = i * (2 * cloudRadius + spacing);
            GOval cloudPart = new GOval(x + xOffset, y, cloudRadius * 2, cloudRadius * 2);
            cloudPart.setFilled(true);
            cloudPart.setFillColor(Color.DARK_GRAY);
            add(cloudPart);
        }
    }

    //Draws a grass cluster by creating a set of lines and rotating their end point randomly
    private void drawGrassCluster(double x, double y, int numLines, double lineLength) {
        for (int i = 0; i < numLines; i++) {
            // Generate a random rotation angle within a small range around 90 degrees (π/2 radians)
            double angle = Math.PI / 2 + (Math.random() - 0.5) * Math.PI / 6; // Adjust the range (π/6 radians) as needed

            // Calculate the endpoint of the line based on the angle
            double endX = x + lineLength * Math.cos(angle);
            double endY = y - lineLength * Math.sin(angle);

            // Create and draw the line
            GLine grassLine = new GLine(x, y, endX, endY);
            grassLine.setColor(Color.GREEN);
            add(grassLine);
        }
    }
}
