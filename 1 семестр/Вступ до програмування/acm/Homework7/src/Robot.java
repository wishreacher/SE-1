/*
    Намалювати обличчя робота.

    Обличчя складається з чотирьох частинок - голова, два ока, і рот

    Використати константи HEAD_WIDTH, HEAD_HEIGHT, EYE_RADIUS, MOUTH_WIDTH, MOUTH_HEIGHT

    Малюнок розміщується по центру вікна. При зміні розмірів вікна обличчя розміщується по центру вікна

    File: Robot.java
    Author: Федорич Володимир
 */
import acm.graphics.*;
import acm.program.GraphicsProgram;
import java.awt.*;

public class Robot extends GraphicsProgram {
    final double HEAD_WIDTH = 700;
    final double HEAD_HEIGHT = 300;
    final double EYE_RADIUS = 100;
    final double MOUTH_WIDTH = 800;
    final double MOUTH_HEIGHT = 50;
    final double EYES_DISTANCE = 20;

    public void run(){
        this.setSize(800, 500);
        drawFaceCanvas();
        drawMouth();
        drawEyes();
    }

    //draws a rectangle that represents the face canvas
    private void drawFaceCanvas(){
        double xOffset = (getWidth() / 2) - (HEAD_WIDTH / 2);
        double yOffset = (getHeight() / 2) - (HEAD_HEIGHT / 2);
        GRect face = new GRect(xOffset, yOffset, HEAD_WIDTH, HEAD_HEIGHT);

        face.setFillColor(Color.black);
        face.setFilled(true);
        add(face);
    }

    //draws a rectangle that represents mouth
    private void drawMouth(){
        double xOffset = (getWidth() / 2) - (MOUTH_WIDTH / 2);
        double yOffset = (getHeight() / 2) - (MOUTH_HEIGHT / 2) + 35;

        GRect mouth = new GRect(xOffset, yOffset, MOUTH_WIDTH, MOUTH_HEIGHT);

        mouth.setFillColor(Color.RED);
        mouth.setFilled(true);
        add(mouth);
    }

    //draws two circles that represent eyes
    private void drawEyes(){
        double diameter = EYE_RADIUS * 2;
        double yOffset = (getHeight() / 2) - (EYE_RADIUS / 2) - 35;
        double xLeftOffset = (getWidth() / 2) - diameter - (EYES_DISTANCE / 2);
        double xRightOffset = (getWidth() / 2) + (EYES_DISTANCE / 2);

        GOval leftEye = new GOval(xLeftOffset, yOffset, diameter, diameter);
        GOval rightEye = new GOval(xRightOffset, yOffset, diameter, diameter);

        leftEye.setFillColor(Color.YELLOW);
        leftEye.setFilled(true);
        add(leftEye);

        rightEye.setFillColor(Color.YELLOW);
        rightEye.setFilled(true);
        add(rightEye);
    }
}
