import acm.graphics.GRect;
import java.awt.*;

public class Brick extends GRect {
    private int weight = 0;

    /**
     * Constructor for the Brick class. Sets the color and weight of the brick based on row.
     * @param x
     * @param y
     * @param nrow
     */
    Brick(double x, double y, int nrow) {
        super(x, y, Variables.brickWidth, Variables.brickHeight);
        setFilled(true);

        int colorRows = Math.max(Variables.rows / 5, 1);
        nrow /= colorRows;

        if (nrow > 4) nrow -= 5;

        switch (nrow) {
            case 0 -> {
                setColor(Color.RED);
                weight = 5;
            }
            case 1 -> {
                setColor(Color.ORANGE);
                weight = 4;
            }
            case 2 -> {
                setColor(Color.YELLOW);
                weight = 3;
            }
            case 3 -> {
                setColor(Color.GREEN);
                weight = 2;
            }
            case 4 -> {
                setColor(Color.CYAN);
                weight = 1;
            }
        }
    }

    /**
     * Called when a brick is hit. Decrements the brick count, plays a sound, and adds to the score.
     */
    public void onDeleteBrick(){
        Variables.brickCount--;
        Variables.brickSound.setVolume(0.5);
        Variables.brickSound.play();
        Variables.score += weight;
        if(Variables.brickCount <= 0) {
            Variables.won = true;
            Variables.gameOver = true;
        }
    }
}
