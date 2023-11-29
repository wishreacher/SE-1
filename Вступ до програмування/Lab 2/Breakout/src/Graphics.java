import acm.graphics.GCanvas;
import acm.graphics.GImage;

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
        int baseOffset = (Variables.appWidth - Variables.bricksPerRow * (Variables.brickWidth + Variables.brickDelta));
        for (int x = 0; x < Variables.bricksPerRow; x++)
            for (int y = 0; y < Variables.rows; ++y) {
                int bx = baseOffset + x * (Variables.brickWidth + Variables.brickDelta);
                int by = Variables.brickYOffset + y * (Variables.brickHeight + Variables.brickDelta);
                canvas.add(new Brick(bx, by, y));
            }
    }
}
