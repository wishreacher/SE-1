/*
    Напишіть програму що малює піраміду. Піраміда складається з горизонтальних рядів цеглин. В кожному наступному ряду кількість цеглин зменшується
    на один. Нижче наведено приклад:

    Піраміда має розташовуватися по центру горизонталі вікна. Мають бути використані наступні константи (тестувати при різних значеннях констант):

    BRICK_WIDTH - 30 пікселів
    BRICK_HEIGHT - 12 пікселів
    BRICKS_IN_BASE - 14

    File: Pyramid.java
    Author: Федорич Володимир
 */

import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class Pyramid extends GraphicsProgram {
    private final int BRICK_WIDTH = 40;
    private final int BRICK_HEIGHT = 20;
    private int BRICKS_IN_BASE = 13;
    public void run() {
        int pyramidWidth = BRICK_WIDTH * BRICKS_IN_BASE;

        //if some bricks don't fit in redefine pyramids base
        while (pyramidWidth > getWidth()) {
            BRICKS_IN_BASE--;
            pyramidWidth = BRICK_WIDTH * BRICKS_IN_BASE;
        }

        for (int row = 0; row < BRICKS_IN_BASE; row++) {
            //if a row doesn't fit in don't draw it
            if((row + 1) * BRICK_HEIGHT > getHeight()){
                break;
            }

            int bricksInRow = BRICKS_IN_BASE - row;
            int startX = (getWidth() - pyramidWidth) / 2 + (BRICK_WIDTH * row / 2);
            int y = getHeight() - (row + 1) * BRICK_HEIGHT;

            for (int brick = 0; brick < bricksInRow; brick++) {
                int x = startX + brick * BRICK_WIDTH;
                GRect rect = new GRect(x, y, BRICK_WIDTH, BRICK_HEIGHT);
                add(rect);
            }
        }
    }
}
