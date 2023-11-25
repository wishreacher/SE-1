import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.program.GraphicsProgram;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/* TODO
    * Recreate menu - change colors, text, etc.
    * Add lives
    * Add lose condition
    * Add win condition
    * Add 3 different levels
    * Add bounce sound
    * Add symmetry axis
 */
public class Breakout extends GraphicsProgram {
    GameClasses.Platform platform = new GameClasses.Platform((Variables.appHeight-15)/2 - Variables.paddleWidth/2,
            (Variables.appHeight - (Variables.paddleHeight * 2) - 60) , Variables.paddleWidth, Variables.paddleHeight);
    GameClasses.Ball ball = new GameClasses.Ball(platform.getPlatformInstance().getX()+
            platform.getPlatformInstance().getWidth()/2 - Variables.radius/2,
            platform.getPlatformInstance().getY() - Variables.radius - 15, Variables.radius);
    GLabel scoreLabel = new GLabel("Score: " + Variables.score, 20, Variables.appHeight - 60);

    private boolean gameStarted = false;
    public void run() {
        initialize();
        Menu menu = new Menu();
        add(menu.getStartMenuGObject());

        // wait 4 game to start
        while(!gameStarted) { pause(5); }

        // remove menu
        remove(menu.getStartMenuGObject());
        // game loop
        while(!Variables.gameOver) {
            //checkCollisions();
            ball.move();
            checkCollisions();
            platform.move();
            handleBallPresence();
            pause(1);
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
            platform.reset();
            if(Variables.lives <= 0){
                Variables.gameOver = true;
            }
        }
    }

    private void initialize(){
        this.setSize(Variables.appWidth, Variables.appHeight);
        this.setBackground(Variables.backgroundColor);


        // init key listeners
        addMouseListeners();
        addKeyListeners();

        // draw platform
        add(platform.getPlatformInstance());

        // draw ball
        add(ball.getBallInstance());

        // draw bricks
        drawBricks();

        drawHearts();

        add(scoreLabel);
        scoreLabel.setFont("TimesNewRoman-20");
        scoreLabel.setColor(Color.WHITE);
    }

    private void checkCollisions() {
        double bx1 = ball.getBallInstance().getX() - 1;
        double by1 = ball.getBallInstance().getY() - 1;

        double bx2 = ball.getBallInstance().getX() + ball.getBallInstance().getWidth() - 1;
        double by2 = by1;

        double bx3 = ball.getBallInstance().getX() + 1;
        double by3 = ball.getBallInstance().getY() + ball.getBallInstance().getHeight() + 1;

        double bx4 = ball.getBallInstance().getX() + ball.getBallInstance().getWidth() + 1;
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

        if(obj == platform.getPlatformInstance()) { // todo прибрати повтори
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
        else if(obj != null){
            double direction = side == true ? Math.PI/1.1 : Math.PI/2.2;
            ball.setDirection(direction);
        }
    }

    public void keyPressed(KeyEvent e) {
        if(!gameStarted && e.getKeyCode() == 32)
            gameStarted = true;
    }

    public void mouseMoved(MouseEvent e) {
        Variables.mouseX = e.getX();
        Variables.mouseY = e.getY();
    }

    private void drawBricks() {
        for (int x = 0; x < Variables.bricksPerRow; ++x)
            for (int y = 0; y < Variables.rows; ++y) {
                int bx = x * (Variables.brickWidth + Variables.brickDelta);
                int by = Variables.brickYOffset + y * (Variables.brickHeight + Variables.brickDelta);
                add(new Brick(bx, by, y));
            }
    }

    private void win(){
        GLabel winLabel = new GLabel("You won!", Variables.appWidth/2, Variables.appHeight/2);
        winLabel.setFont("TimesNewRoman-20");
        winLabel.setColor(Color.WHITE);
        add(winLabel);
    }

    private void lose(){
        GLabel loseLabel = new GLabel("You lost!", Variables.appWidth/2, Variables.appHeight/2);
        loseLabel.setFont("TimesNewRoman-20");
        loseLabel.setColor(Color.WHITE);
        add(loseLabel);
    }

    private boolean isBallOnScreen(){
        return ball.getBallInstance().getY() < Variables.appHeight;
    }

    private void resetBall(){
        remove(ball.getBallInstance());
        ball = new GameClasses.Ball(platform.getPlatformInstance().getX()+
                platform.getPlatformInstance().getWidth()/2 - Variables.radius/2,
                platform.getPlatformInstance().getY() - Variables.radius - 15, Variables.radius);
        add(ball.getBallInstance());
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
 */