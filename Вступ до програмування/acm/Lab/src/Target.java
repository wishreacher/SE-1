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
    private static final int WORLD_WIDTH = 400;
    private static final int WORLD_HEIGHT = 400;
    private static final int NUM_CIRCLES = 6;

    public void run() {
        int centerX = WORLD_WIDTH / 2;
        int centerY = WORLD_HEIGHT / 2;

        for (int i = NUM_CIRCLES - 1; i >= 0; i--) {
            int radius = WORLD_WIDTH / (2 * NUM_CIRCLES) * (i + 1);
            GOval circle = new GOval(centerX - radius, centerY - radius, 2 * radius, 2 * radius);

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
