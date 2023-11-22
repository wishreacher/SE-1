//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import Elements.Ball;
import Elements.Brick;
import Elements.GameBorder;
import Elements.Paddle;
import acm.graphics.*;
import acm.program.*;
import acm.util.RandomGenerator;

import java.awt.*;
import java.awt.event.MouseEvent;

public class Breakout extends GraphicsProgram {
    public static final int appWidth = 420;
    public static final int appHeight = 600;
    public static final int appPadding = 5;
    private static final int paddleWidth = 60;
    private static final int paddleHeight = 10;
    private static final int paddleYOffset = 30;
    private static final int bricksPerRow = 6;
    private static final int brickRows = 10;
    private static final int distanceBetweenBricks = 4;
    private static final int brickWidth = 36;
    private static final int brickHeight = 8;
    private static final int ballRadius = 10;
    private static final int brickYOffset = 70;
    private static final int turns = 3;
    private static final Color color1 = Color.RED;
    private static final Color color2 = Color.ORANGE;
    private static final Color color3 = Color.YELLOW;
    private static final Color color4 = Color.GREEN;
    private static final Color color5 = Color.CYAN;

    private static final int delay = 3;
    private static Paddle paddle;
    private static Ball ball;
    public RandomGenerator rgen = RandomGenerator.getInstance();

    boolean wasBallSpawned = false;
    int bounceCount = 0;
    private double mouseX;
    private double mouseY;

    public void run() {
        init();
        Tick(); //TODO додат ще 4 точки
    }

    private void Tick(){
        while(true) {
            /*moveBall();
            GObject collider = getCollidingObject();
            if (collider != null && collider != ball) {
                bounceBall(bounceCount);
                if (collider instanceof Brick) {
                    Brick brick = (Brick) collider;
                    if (!brick.isHit()) {
                        remove(brick);
                        brick.setHit(true);
                    }
                }
            }
            pause(delay);
        }*/

            ball.move();
            checkCollisions();
            paddle.move(mouseX);
            pause(delay);
        }
    }

    public void init(){
        this.setSize(appWidth, appHeight);
        createBricks();
        createPaddle();
        createBall();
        //createFrame();
        addMouseListeners();
    }

    private void createBricks(){
        //there are 5 colors to paint the bricks and i need to use all rows of bricks equally
        int brickX = (appWidth - (bricksPerRow * brickWidth) -
                ((bricksPerRow - 1) * distanceBetweenBricks)) / 2;
        int brickY = brickYOffset;
        for (int row = 0; row < brickRows; row++){
            for (int col = 0; col < bricksPerRow; col++){
                Brick brick = new Brick(brickX, brickY, brickWidth, brickHeight);
                brick.setFilled(true);
                setBrickColor(brick, row / 2 % 5);
                add(brick);
                brickX += brickWidth + distanceBetweenBricks;
            }
            brickX = (appWidth - (bricksPerRow * brickWidth) -
                    ((bricksPerRow - 1) * distanceBetweenBricks)) / 2;
            brickY += brickHeight + distanceBetweenBricks;
        }
    }
    private void setBrickColor(GRect brick, int index){
        switch (index) {
            case 0 -> brick.setColor(color1);
            case 1 -> brick.setColor(color2);
            case 2 -> brick.setColor(color3);
            case 3 -> brick.setColor(color4);
            case 4 -> brick.setColor(color5);
        }
    }
    private void createPaddle(){
        int paddleX = (appWidth - paddleWidth) / 2;
        int paddleY = appHeight - paddleYOffset - 20; //20 is the height of the window bar
        paddle = new Paddle(paddleX, paddleY, paddleWidth, paddleHeight);
        add(paddle);
    }
    private void createFrame(){
        GameBorder topBorder = new GameBorder(appPadding, appPadding, appWidth - appPadding, appPadding);
        GameBorder leftBorder = new GameBorder(appPadding, appPadding, appPadding, appHeight - appPadding - 30);
        GameBorder rightBorder = new GameBorder(appWidth - appPadding, appPadding, appWidth - appPadding, appHeight - appPadding - 30);
        GameBorder bottomBorder = new GameBorder(appPadding, appHeight - appPadding - 30, appWidth - appPadding, appHeight - appPadding - 30);
        add(leftBorder);
        add(topBorder);
        add(rightBorder);
        add(bottomBorder);
    }
    private void checkCollisions()
    {
        double bx1 = ball.getX() - 1;
        double by1 = ball.getY() - 1;

        double bx2 = ball.getX() + ball.getWidth() - 1;
        double by2 = by1;

        double bx3 = ball.getX() + 1;
        double by3 = ball.getY() + ball.getHeight() + 1;

        double bx4 = ball.getX() + ball.getWidth() + 1;
        double by4 = by3;

        GObject obj = null;

        if(getElementAt(bx1, by1) != null) {
            obj = getElementAt(bx1, by1);
        }
        else if(getElementAt(bx2, by2) != null) {
            obj = getElementAt(bx2, by2);
        }
        else if(getElementAt(bx3, by3) != null) {
            obj = getElementAt(bx3, by3);
        }
        else if(getElementAt(bx4, by4) != null) {
            obj = getElementAt(bx4, by4);
        }

        boolean side = rgen.nextBoolean(0.5);

        if(obj == paddle) {
            double direction = side == true ? Math.PI/4 : Math.PI/2;
            ball.setDirection(direction);
        }
        else if(obj != null){
            double direction = side == true ? Math.PI/1.1 : Math.PI/2.2;
            ball.setDirection(direction);
            remove(obj);
            //GameObjects.Bricks.deleteBrick();
        }
    }

    private void createBall(){
        if(!wasBallSpawned) { //TODO костиль
            double vx = rgen.nextDouble(1,3);
            if(rgen.nextBoolean(0.5)) vx = -vx;
            ball = new Ball(appWidth / 2, appHeight / 2, ballRadius);
            add(ball);
            wasBallSpawned = true;
        }
    }

    public void mouseMoved(MouseEvent e)
    {
        mouseX = e.getX();
        mouseY = e.getY();
    }

    /*private void moveBall(){
        ball.moveBall();
    }
    */

    /*
    private GObject getCollidingObject() {
        double ballX = ball.getX();
        double ballY = ball.getY();
        double ballWidth = ball.getWidth();
        double ballHeight = ball.getHeight();

        // Check top edge
        for (double x = ballX; x <= ballX + ballWidth; x++) {
            if (getElementAt(x, ballY) != null) {
                bounceCount = 0;
                return getElementAt(x, ballY);
            }
        }

        // Check bottom edge
        for (double x = ballX; x <= ballX + ballWidth; x++) {
            if (getElementAt(x, ballY + ballHeight) != null) {
                bounceCount = 2;
                return getElementAt(x, ballY + ballHeight);
            }
        }

        // Check left edge
        for (double y = ballY; y <= ballY + ballHeight; y++) {
            if (getElementAt(ballX, y) != null) {
                bounceCount = 1;
                return getElementAt(ballX, y);
            }
        }

        // Check right edge
        for (double y = ballY; y <= ballY + ballHeight; y++) {
            if (getElementAt(ballX + ballWidth, y) != null) {
                bounceCount = 3;
                return getElementAt(ballX + ballWidth, y);
            }
        }

        return null;
    }
    private void moveBall(){
        double oldX = ball.getX();
        double oldY = ball.getY();

        ball.moveBall();

        /*GObject collider = getCollidingObject();
        if (collider != null) {
            // Move the ball back to its previous position before bouncing
            ball.setLocation(oldX, oldY);
            bounceBall(bounceCount);
        }
        */

    }

//    private void bounceBall(int i){
//        switch (i) {
//            case 0, 2 -> ball.bounceBall(false, true); // Top or bottom edge collision, invert y velocity
//            case 1, 3 -> ball.bounceBall(true, false); // Left or right edge collision, invert x velocity
//        }
//    }
//


/*
    Problems: when trying to spawn the ball, spawns one movable and one static
        Solution: add a boolean to check if the ball was spawned
    Problems: sometimes the ball goes through the bricks

 */

/*TODO list
    1. add lives
    2. add a brick sound
    3. win/lose condition
    4. random ball location
    5. move paddle with mouse
    6. add a menu
 */