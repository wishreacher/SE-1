/*
    Написати програму, що намалює шахову доску.
    Можливі варіанти малювання  будь-яких n*m рядків та колонок, дошка може бути поділена
    не тільки на квадрати а й на прямокутники так, щоб заповнювати весь аплет.
    Тут постановка задачі відрізняється від того, що є на дістеду через зауваження викладача.

    File: Chess.java
    Author: Федорич Володимир
 */

import acm.graphics.GRect;
import acm.program.GraphicsProgram;

import java.awt.*;

public class Chess extends GraphicsProgram {
    final int rows = 8;
    final int columns = 8;

    public void run(){
        this.setSize(850, 850);
        drawBoard();
    }

    //determines the width of the grid element
    private double calculateSqWidth(){
        return (getSize().width) / rows;
    }

    //determines the height of the grid element
    private double calculateSqHeight(){
        return (getSize().height) / columns;
    }

    //draw the board using loops, which are dependent on @rows and @columns variables
    private void drawBoard(){
        double sqWidth = calculateSqWidth();
        double sqHeight = calculateSqHeight();

        for(int i = 0; i < rows ; i++){
            for(int j = 0; j < columns; j++){
                double x = i * sqWidth;
                double y = 1 + j * sqHeight;
                GRect gridElement = new GRect(x, y, sqWidth, sqHeight);
                gridElement.setFillColor(Color.black);
                if(i % 2 == 0){
                    if(j % 2 == 0) {
                        gridElement.setFilled(true);
                    }
                } else {
                    if(j % 2 == 1){
                        gridElement.setFilled(true);
                    }
                }
                add(gridElement);
            }
        }
    }
}
