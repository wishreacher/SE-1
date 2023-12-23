/*
    Написати програму, що намалює стовпчики з біперів через кожні 50(або інше задане число) пікселів.
    Кольори біперів чергуються. Висота кожного наступного стовпчика більша за попередню
    на 2(або інше задане число) біперів. Розмір біперів 50х50 (або інше задане число).

    Біпер робити з чотирьох ліній.

    Використати: константи, цикли

    File: BeeperTowers.java
    Author: Федорич Володимир
 */

import acm.program.*;
import acm.graphics.*;
import java.awt.*;

public class BeeperTowers extends GraphicsProgram {
    final double beeperWidth = 50.0;
    final double beeperHeight = 50.0;
    final int startingHeight = 4;
    final int deltaColumnHeight = 2;
    final double deltaHeight = 10.0;
    final double deltaWidth = 50.0;

    final Color firstColor = Color.BLUE;
    final Color secondColor = Color.yellow;
    final Color thirdColor = Color.GREEN;
    final Color fourthColor = Color.RED;

    public void run() {
        this.setSize(600, 600);
        drawColumns();
    }

    //Draws columns based on constants defined above. Each step is explained within the method
    private void drawColumns(){

        //calculate coordinates for the first element. 10 is added and substracted to conteract borders
        final double x0 = beeperWidth / 2 + 10;
        final double y0 = getHeight() - beeperHeight / 2 - 10;

        /*
            Calculate how many beepers we can draw in a column and how many columns we can draw,
            so they stay within app borders
         */
        int maxBeepersInColumn = getSize().height / (int)(beeperHeight + deltaHeight);
        int maxColumns = getSize().width / (int)(beeperWidth + deltaWidth);

        //Move through columns
        int beepersToDrawInColumn = startingHeight;

        for(int j = 0; j < maxColumns; j++){
            //Calculate the x offset for current column
            double x = x0 + deltaWidth * j + beeperWidth * j;

            //This doesn't let us draw a beeper if it's out of vertical borders
            if(beepersToDrawInColumn + deltaColumnHeight >= maxBeepersInColumn){
                beepersToDrawInColumn = maxBeepersInColumn;
            } else{
                if(j != 0){
                    beepersToDrawInColumn += deltaColumnHeight;
                } else{
                    beepersToDrawInColumn = startingHeight;
                }
            }

            //Draw beepers within current column
            for(int i = 0; i < beepersToDrawInColumn; i++){
                double y = y0 - (beeperHeight) * i - deltaHeight * i;
                drawBeeper(x, y, beeperWidth, beeperHeight, getBeeperColor(i));
            }
        }
    }

    //Calculates which color to paint a beeper, so it matches the description of the task
    private Color getBeeperColor(int i){
        Color currentColor;

        switch ((i) % 4){
            case 0:
                currentColor = firstColor;
                break;
            case 1:
                currentColor = secondColor;
                break;
            case 2:
                currentColor = thirdColor;
                break;
            case 3:
                currentColor = fourthColor;
                break;
            default:
                currentColor = Color.white;
        }
        return currentColor;
    }

    /*
        Draws a beeper of diamond shape. @centerX and @centerY are the variables for offset calculated
        starting from top-left corner. @xSize, @ySize, @fillColor - self-explanatory
     */
    private void drawBeeper(double centerX, double centerY, double xSize, double ySize, Color fillColor){
        //dalculate the coordinates of the four corners of the diamond
        double x1 = centerX - xSize / 2;
        double y1 = centerY;
        double x2 = centerX;
        double y2 = centerY - ySize / 2;
        double x3 = centerX + xSize / 2;
        double y3 = centerY;
        double x4 = centerX;
        double y4 = centerY + ySize / 2;

        //draw the lines to form the diamond
        GLine line1 = new GLine(x1, y1, x2, y2);
        GLine line2 = new GLine(x2, y2, x3, y3);
        GLine line3 = new GLine(x3, y3, x4, y4);
        GLine line4 = new GLine(x4, y4, x1, y1);

        add(line1);
        add(line2);
        add(line3);
        add(line4);

        GPolygon beeperColor = new GPolygon();
        beeperColor.addVertex(x1, y1);
        beeperColor.addVertex(x2, y2);
        beeperColor.addVertex(x3, y3);
        beeperColor.addVertex(x4, y4);
        beeperColor.setFilled(true);
        beeperColor.setFillColor(fillColor);

        add(beeperColor);
    }
}