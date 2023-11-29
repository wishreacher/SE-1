import acm.graphics.GCanvas;
import acm.graphics.GImage;
import acm.graphics.GLabel;

import java.awt.*;

public class Graphics {
    public static void drawHearts(GCanvas canvas){
        for(int i = 0; i < Variables.lives; ++i){
            GImage heart = new GImage("../images/heart.png");
            heart.scale(0.1, 0.1);
            canvas.add(heart, i * 25, 0);
            Variables.hearts.add(heart);
        }
    }

    public static void drawBricks(GCanvas canvas){
        double totalBricksWidth = Variables.bricksPerRow * (Variables.brickWidth + Variables.brickDelta) - Variables.brickDelta;
        if (totalBricksWidth > Variables.appWidth) {
            Variables.bricksPerRow = (int) ((Variables.appWidth + Variables.brickDelta) / (Variables.brickWidth + Variables.brickDelta));
            totalBricksWidth = Variables.bricksPerRow * (Variables.brickWidth + Variables.brickDelta) - Variables.brickDelta;
        }
        double startX = (Variables.appWidth - totalBricksWidth) / 2;
        for (int x = 0; x < Variables.bricksPerRow; x++)
            for (int y = 0; y < Variables.rows; y++) {
                double bx = startX + x * (Variables.brickWidth + Variables.brickDelta);
                double by = y * (Variables.brickHeight + Variables.brickDelta) + Variables.brickYOffset;
                canvas.add(new Brick(bx, by, y));
            }
    }

    public static void addWinText(GCanvas canvas){
        GLabel winLabel = new GLabel("You won!");
        winLabel.setLocation((Variables.appWidth - winLabel.getWidth())/2, Variables.appHeight/2);
        winLabel.setFont("TimesNewRoman-20");
        winLabel.setColor(Color.WHITE);
        canvas.add(winLabel);

        GLabel nextLevelLabel = new GLabel("Press N to go to next level");
        nextLevelLabel.setLocation((Variables.appWidth - nextLevelLabel.getWidth())/2, Variables.appHeight/2 + 25);
        nextLevelLabel.setFont("TimesNewRoman-20");
        nextLevelLabel.setColor(Color.WHITE);
        canvas.add(nextLevelLabel);
    }

    public static void addLoseText(GCanvas canvas) {
        GLabel loseLabel = new GLabel("You lost!");
        loseLabel.setLocation((Variables.appWidth - loseLabel.getWidth())/2, Variables.appHeight/2);
        loseLabel.setFont("TimesNewRoman-20");
        loseLabel.setColor(Color.WHITE);
        canvas.add(loseLabel);

        GLabel restartLabel = new GLabel("Press R to restart");
        restartLabel.setLocation((Variables.appWidth - restartLabel.getWidth())/2, Variables.appHeight/2 + 25);
        restartLabel.setFont("TimesNewRoman-20");
        restartLabel.setColor(Color.WHITE);
        canvas.add(restartLabel);
    }

    public static void addEndgameUI(GCanvas canvas){
        GLabel endgameLabel = new GLabel("You beat the game! Love you <3");
        endgameLabel.setFont("TimesNewRoman-24");
        endgameLabel.setLocation((Variables.appWidth - endgameLabel.getWidth())/2, Variables.appHeight/2 - 200);
        endgameLabel.setColor(Color.PINK);
        canvas.add(endgameLabel);

        GImage cat = new GImage("../images/cat.gif");
        cat.scale(0.5, 0.5);
        cat.setLocation((Variables.appWidth - cat.getWidth())/2, Variables.appHeight/2 - 175);
        canvas.add(cat);

        GLabel restartLabel = new GLabel("Press any key to open menu ^^");
        restartLabel.setFont("TimesNewRoman-20");
        restartLabel.setLocation((Variables.appWidth - restartLabel.getWidth())/2, Variables.appHeight/2 + 300);
        restartLabel.setColor(Color.WHITE);
        canvas.add(restartLabel);
    }
}
