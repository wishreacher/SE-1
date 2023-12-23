/*
    Використовуючи графічну бібліотеку  acm намалювати наступне зображення:

    Знизу додати підпис в якому зазначити ПІБ студента, що виконав і варіант завдання.
    Умови:
    Найбільша кількість кульок по вертикалі та по горизонталі  і їх розмір задаються константами.

    File: Task2.java
    Author: Федорич Володимир
 */

import acm.graphics.GLabel;
import acm.graphics.GOval;
import acm.program.*;

import java.awt.*;

public class Task2 extends GraphicsProgram {
    final int circleRadius = 20;
    final int horizontalN = 5;
    final int verticalN = 7;
    final int circleSpacing = 50;

    public void run(){

        //Adjust canvas size to fit the circles
        setSize(verticalN * circleSpacing, (horizontalN * circleSpacing) + (circleRadius * 2));

        //Draw circles in a chessboard pattern
        for (int row = 0; row < horizontalN; row++) {
            for (int col = 0; col < verticalN; col++) {
                int x = col * circleSpacing;
                int y = row * circleSpacing;

                if ((row + col) % 2 == 0) { //Chessboard pattern
                    GOval circle = new GOval(x, y, circleRadius * 2, circleRadius * 2);
                    circle.setFilled(true);
                    circle.setColor(Color.RED);
                    add(circle);
                }
            }
        }

        GLabel sign = new GLabel("Федорич Володимир, варіант 4", 20, 20);
        add(sign);
    }
}
