import acm.graphics.GImage;
import acm.util.RandomGenerator;
import acm.util.SoundClip;
import java.awt.*;
import java.util.ArrayList;

public class Variables {

    //--------------------GAME--------------------
    public static RandomGenerator rg = new RandomGenerator();

    public static final int appWidth = 600;

    public static final int appHeight = 800;

    public static final int paddleWidth = 100;

    public static final int paddleHeight = 10;

    public static double mouseX;

    public static double mouseY;

    public static Color backgroundColor = Color.BLACK;

    public static int level = 1;

    public static int score;

    public static int lives = 9;

    public static int getLives() {
        switch (level) {
            case 1:
                return 5;
            case 2:
                return 3;
            case 3:
                return 2;
        }
        return 0;
    }

    public static ArrayList<GImage> hearts = new ArrayList<>();
    //--------------------BRICKS--------------------
    public static int bricksPerRow = 5;

    public static int rows = 10;

    public static int brickDelta = 10;

    public static int brickWidth = 75;

    public static int brickHeight = 25;

    public static int brickYOffset = 70;

    public static int brickCount;
    //--------------------BALL--------------------
    public static final int radius = 15;

    //--------------------FLAGS--------------------
    public static boolean shouldOpenMenu = true;

    public static boolean shouldRestart = false;

    public static boolean shouldOpenLevel = false;

    public static boolean gameOver = false;

    public static boolean won = false;

    //--------------------SOUNDS--------------------
    public static SoundClip bounceSound = new SoundClip("../sounds/click.wav");

    public static SoundClip brickSound = new SoundClip("../sounds/break.wav");

    public static SoundClip loseLifeSound = new SoundClip("../sounds/loseLife.wav");

    public static SoundClip winSound = new SoundClip("../sounds/win.wav");

    public static SoundClip loseSound = new SoundClip("../sounds/lose.wav");
}