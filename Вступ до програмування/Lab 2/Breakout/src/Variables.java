import acm.graphics.GImage;
import acm.util.RandomGenerator;
import acm.util.SoundClip;

import java.awt.*;
import java.util.ArrayList;

public class Variables {
    public static RandomGenerator rg = new RandomGenerator();
    public static final int appWidth = 600;
    public static final int appHeight = 800;
    public static final int paddleWidth = 100;
    public static final int paddleHeight = 10;
    public static int bricksPerRow = 5;

    public static int rows = 10;
    public static final int brickDelta = 10;

    public static final int brickWidth =
            ((appWidth - 15) - (bricksPerRow - 1) * brickDelta) / bricksPerRow;
    public static final int brickHeight = 8;

    public static final int brickYOffset = 70;

    public static final int radius = 10;
    public static double mouseX;
    public static double mouseY;
    public static boolean won = false;

    public static Color backgroundColor = Color.BLACK;

    public static int brickCount = rows * bricksPerRow;
    public static int score;
    public static boolean gameOver = false;
    public static int lives = 9;
    //public static GImage[] heartsArray = new GImage[100];
    public static ArrayList<GImage> hearts = new ArrayList<>();

    public static SoundClip bounceSound = new SoundClip("../sounds/bounce.au");
}