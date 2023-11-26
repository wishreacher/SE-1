import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.program.GraphicsProgram;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/* TODO
    * Create menu
    * Set up winning and losing strings
    * Add 3 different levels
    * Add symmetry axis
    * Javadoc documentation
    * Cleanup
 */
public class Breakout extends GraphicsProgram {
    Paddle paddle = new Paddle((Variables.appWidth-15)/2 - Variables.paddleWidth/2,
            (Variables.appHeight - (Variables.paddleHeight * 2) - 60) , Variables.paddleWidth, Variables.paddleHeight);
    Ball ball = new Ball(paddle.getX()+
            paddle.getWidth()/2 - Variables.radius/2,
            paddle.getY() - Variables.radius - 15, Variables.radius);
    GLabel scoreLabel = new GLabel("Score: " + Variables.score, 20, Variables.appHeight - 60);

    private boolean gameStarted = false;
    public void run() {
        this.setSize(Variables.appWidth, Variables.appHeight);
        this.setBackground(Variables.backgroundColor);

        // init key listeners
        addMouseListeners();
        addKeyListeners();

        Menu menu = new Menu();
        add(menu.getStartMenuGObject());

        // wait 4 game to start
        while(!gameStarted) { pause(5); }

        // remove menu
        remove(menu.getStartMenuGObject());

        initialize();

        // game loop
        while(!Variables.gameOver) {
            //checkCollisions();
            ball.move();
            checkCollisions();
            paddle.move();
            handleBallPresence();
            pause(Variables.tickrate);
        }
        if(Variables.won){
            win();
        } else {
            lose();
        }
    }

    private void handleBallPresence() {
        if(!isBallOnScreen()){
            resetBall();
            paddle.reset();
            if(Variables.lives <= 0){
                Variables.gameOver = true;
            }
        }
    }

    private void initialize(){
        // draw platform
        add(paddle);

        // draw ball
        add(ball);

        // draw bricks
        drawBricks();

        drawHearts();

        add(scoreLabel);
        scoreLabel.setFont("TimesNewRoman-20");
        scoreLabel.setColor(Color.WHITE);
    }

    private void checkCollisions() {
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

        boolean side = Variables.rg.nextBoolean(0.5);
        if(obj == paddle) { // todo прибрати повтори
            double direction = side == true ? Math.PI/4 : Math.PI/2;
            ball.setDirection(direction);
        } else if(obj instanceof Brick){
            double direction = side == true ? Math.PI/1.1 : Math.PI/2.2;
            ball.setDirection(direction);
            Brick x = (Brick)obj;
            x.onDeleteBrick();
            scoreLabel.setLabel("Score: " + Variables.score);
            remove(obj);
        }
        else if(obj != null && !(obj instanceof GLabel) && !(obj instanceof GImage)){
            double direction = side == true ? Math.PI/1.1 : Math.PI/2.2;
            ball.setDirection(direction);
        }
    }

    public void keyPressed(KeyEvent e) {
        if (gameStarted) {
            return;
        }

        switch (e.getKeyCode()) {
            case 49 -> {
                Variables.lives = 5;
                Variables.rows = 1;
                Variables.bricksPerRow = 1;
                Variables.tickrate = 2;
                Variables.level = 1;
                gameStarted = true;
            }
            case 50 -> {
                Variables.lives = 3;
                Variables.rows = 1;
                Variables.bricksPerRow = 1;
                Variables.tickrate = 2;
                Variables.level = 2;
                gameStarted = true;
            }
            case 51 -> {
                Variables.lives = 1;
                Variables.rows = 1;
                Variables.bricksPerRow = 1;
                Variables.tickrate = 2;
                Variables.level = 3;
                gameStarted = true;
            }
        }
    }

    public void mouseMoved(MouseEvent e) {
        Variables.mouseX = e.getX();
        Variables.mouseY = e.getY();
    }

    private void drawBricks() {
        //TODO it doesn't work as intended
        int totalBricksWidth = Variables.bricksPerRow * Variables.brickWidth + (Variables.bricksPerRow - 1) * Variables.brickDelta;
        int totalBricksHeight = Variables.rows * Variables.brickHeight + (Variables.rows - 1) * Variables.brickDelta;
        if (totalBricksWidth > Variables.appWidth || totalBricksHeight > Variables.appHeight) {
            Variables.bricksPerRow = Variables.appWidth / (Variables.brickWidth + Variables.brickDelta);
            totalBricksWidth = Variables.bricksPerRow * Variables.brickWidth + (Variables.bricksPerRow - 1) * Variables.brickDelta;
            totalBricksHeight = Variables.rows * Variables.brickHeight + (Variables.rows - 1) * Variables.brickDelta;
        }
        int baseOffset = (Variables.appWidth - totalBricksWidth) / 2;
        for (int x = 0; x < Variables.bricksPerRow; x++)
            for (int y = 0; y < Variables.rows; ++y) {
                int bx = baseOffset + x * (Variables.brickWidth + Variables.brickDelta);
                int by = Variables.brickYOffset + y * (Variables.brickHeight + Variables.brickDelta);
                add(new Brick(bx, by, y));
            }
    }

    private void win(){/*
        int timer = 5;
        GLabel winLabel = new GLabel("You won!", Variables.appWidth/2, Variables.appHeight/2);
        GLabel timerLabel = new GLabel("Next level starts in:" + timer, Variables.appWidth/2, Variables.appHeight/2);
        winLabel.setFont("TimesNewRoman-20");
        winLabel.setColor(Color.WHITE);
        add(winLabel);
        add(timerLabel);
        while(timer >= 0){
            timerLabel.setLabel("Next level starts in:" + timer);
            pause(1000);
            --timer;
        }
        exit();
        */
    }

    private void lose(){
        GLabel loseLabel = new GLabel("You lost!", Variables.appWidth/2, Variables.appHeight/2);
        loseLabel.setFont("TimesNewRoman-20");
        loseLabel.setColor(Color.WHITE);
        add(loseLabel);
    }

    private boolean isBallOnScreen(){
        return ball.getY() < Variables.appHeight;
    }

    private void resetBall(){
        remove(ball);
        ball = new Ball(paddle.getX()+
                paddle.getWidth()/2 - Variables.radius/2,
                paddle.getY() - Variables.radius - 15, Variables.radius);
        add(ball);
        --Variables.lives;
        Variables.hearts.get(Variables.lives).setVisible(false);
        Variables.hearts.remove(Variables.lives);
    }

    private void drawHearts(){
        for(int i = 0; i < Variables.lives; ++i){
            GImage heart = new GImage("../images/heart.png");
            heart.scale(0.1, 0.1);
            add(heart, i * 25, 0);
            Variables.hearts.add(heart);
        }
    }
}

/*
Проблема - коли намагаюсь перевірити чи мʼяч поза екраном, перевірка спрацьовує кожен тік.
Вирішення - перестворити мʼячик замість того щоб рухати його.
Проблема - мʼячик застрягає в платформі і стінах.
Проблема - мʼячик вдаряється об текст
Вирішення - ігнорувати цей випадок у перевірці колізій
 */