/*
    Ви маєте написати програму, що малює зображення "мішень для лучника". Приклад:

    Мішень має розташовуватися по центру вікна. Мають бути використані константи:

    ширира світу;
    висота світу;
    кількість кругів.

    File name: Target.java
    Author: Федорич Володимир
 */

import acm.program.GraphicsProgram;
import acm.graphics.*;
import java.awt.*;

public class Target extends GraphicsProgram {
    private static final int WORLD_WIDTH = 500;
    private static final int WORLD_HEIGHT = 500;
    private static final int NUM_CIRCLES = 3;

    public void run() {
        this.setSize(WORLD_WIDTH, WORLD_HEIGHT);

        //calcule base offset
        int centerX = WORLD_WIDTH / 2;
        int centerY = WORLD_HEIGHT / 2;

        for (int i = NUM_CIRCLES - 1; i >= 0; i--) {

            //calculate radius based on circle number and world size
            int radius = (WORLD_WIDTH) / 2 / (2 * NUM_CIRCLES) * (i + 1);
            GOval circle = new GOval(centerX - radius, centerY - radius, 2 * radius, 2 * radius);

            //determine if circle should be red or white
            if (i % 2 == 0) {
                circle.setFillColor(Color.RED);
            } else {
                circle.setFillColor(Color.WHITE);
            }
            circle.setFilled(true);
            add(circle);
        }
    }
}
