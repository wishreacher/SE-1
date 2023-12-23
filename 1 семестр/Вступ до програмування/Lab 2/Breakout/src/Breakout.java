import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.program.GraphicsProgram;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Breakout extends GraphicsProgram {
    Paddle paddle;
    Ball ball;
    GLabel scoreLabel = new GLabel("Score: " + Variables.score, 20, Variables.appHeight - 60);

    private boolean gameStarted = false;

    /**
     * Handles program initialization and game loop. Runs infinitely operating with params changed during the game.
     */
    public void run() {
        this.setSize(Variables.appWidth, Variables.appHeight);
        this.setBackground(Variables.backgroundColor);

        while(true){
            addMouseListeners();
            addKeyListeners();
            resetValues();

            //handle game replayability
            if(Variables.shouldOpenMenu){
                Menu menu = new Menu();
                add(menu.getStartMenuGObject());

                while(!gameStarted) { pause(5); }
                initialize();

                remove(menu.getStartMenuGObject());
            } else{
                initValues(Variables.level);
                initialize();
            }

            //game loop
            while(!Variables.gameOver) {
                ball.move();
                handleCollisions();
                paddle.move();
                handleBallPresence();
                pause(0.5);
            }

            //win condition check
            if(Variables.won){
                win();
            } else {
                lose();
            }
        }
    }

    /**
     * If ball is not on screen, resets it and decrements lives.
     */
    private void handleBallPresence() {
        if(!ball.isBallOnScreen()){
            resetBall();
            decrementHearts();
            paddle.reset();
            if(Variables.lives <= 0){
                Variables.gameOver = true;
            }
        }
    }

    /**
     * Respawns ball and paddle, resets score, lives and bricks.
     */
    private void initialize(){
        //remove old paddle and ball
        if(paddle != null){
            remove(paddle);
        }
        if(ball != null){
            remove(ball);
        }

        //draw platform
        paddle = new Paddle((Variables.appWidth-15)/2 - Variables.paddleWidth/2,
                (Variables.appHeight - (Variables.paddleHeight * 2) - 60) , Variables.paddleWidth, Variables.paddleHeight);
        add(paddle);

        //draw ball
        ball = new Ball(paddle.getX()+
                paddle.getWidth()/2 - Variables.radius/2,
                paddle.getY() - Variables.radius - 15, Variables.radius);
        add(ball);

        Variables.brickCount = Variables.rows * Variables.bricksPerRow;

        //draw hearts and bricks
        Graphics.drawBricks(getGCanvas());
        Graphics.drawHearts(getGCanvas());

        //draw score
        add(scoreLabel);
        scoreLabel.setFont("TimesNewRoman-20");
        scoreLabel.setColor(Color.WHITE);
    }

    /**
     * Handles collisions with paddle, bricks and walls via checking if 8 points of ball are colliding with something.
     * These point are located on the edges and corners of ball.
     */
    private void handleCollisions() {
        //define coordinates of 8 points
        double bx1 = ball.getX() - 1;
        double by1 = ball.getY() - 1;

        double bx2 = ball.getX() + ball.getWidth() - 1;
        double by2 = by1;

        double bx3 = ball.getX() + 1;
        double by3 = ball.getY() + ball.getHeight() + 1;

        double bx4 = ball.getX() + ball.getWidth() + 1;
        double by4 = by3;

        double bx5 = ball.getX();
        double by5 = ball.getY();

        double bx6 = ball.getX() + ball.getWidth();
        double by6 = by5;

        double bx7 = ball.getX();
        double by7 = ball.getY() + ball.getHeight();

        double bx8 = ball.getX() + ball.getWidth();
        double by8 = by7;

        GObject obj = null;

        //check if any of 8 points are colliding with something
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
        else if(getElementAt(bx5, by5) != null) {
            obj = getElementAt(bx5, by5);
        }
        else if(getElementAt(bx6, by6) != null) {
            obj = getElementAt(bx6, by6);
        }
        else if(getElementAt(bx7, by7) != null) {
            obj = getElementAt(bx7, by7);
        }
        else if(getElementAt(bx8, by8) != null) {
            obj = getElementAt(bx8, by8);
        }

        boolean side = Variables.rg.nextBoolean(0.5);

        //old code
        /*if(obj == paddle) {
            double direction = side == true ? Math.PI/4 : Math.PI/2;
            ball.setDirection(direction);

         */

        //check what object is colliding with ball and change direction accordingly
        if(obj == paddle) {
            double direction = ball.getDirection() > Math.PI ? Math.PI/4 : 3*Math.PI/4;
            ball.setDirection(direction);
        } else if(obj instanceof Brick){
            double direction = side == true ? Math.PI/1.1 : Math.PI/2.2;
            ball.setDirection(direction);
            Brick x = (Brick)obj;
            x.onDeleteBrick();
            scoreLabel.setLabel("Score: " + Variables.score);
            remove(obj);
        } else if(obj != null && !(obj instanceof GLabel) && !(obj instanceof GImage)){
            double direction = side == true ? Math.PI/1.1 : Math.PI/2.2;
            direction += Variables.rg.nextBoolean(0.5) ? 0.05 : -0.05; // Add a slight random variation
            ball.setDirection(direction);
        }
    }

    /**
     * Handles key presses.
     * @param e key event
     */
    public void keyPressed(KeyEvent e) {
        if(!gameStarted && e.getKeyCode() >= 49 && e.getKeyCode() <= 51){
            openLevel(e.getKeyCode());
        }
        if(Variables.gameOver && !Variables.won){
            if(e.getKeyCode() == 82){
                Variables.shouldRestart = true;
            }
        } else if(Variables.gameOver && Variables.won){
            if(e.getKeyCode() == 78){
                Variables.shouldOpenLevel = true;
            }
        }
        if(Variables.gameOver && Variables.won && Variables.level == 3){
            Variables.shouldOpenMenu = true;
        }
    }

    /**
     * Handles mouse movement.
     * @param e mouse event
     */
    public void mouseMoved(MouseEvent e) {
        Variables.mouseX = e.getX();
        Variables.mouseY = e.getY();
    }

    /**
     * Handles win condition visualisation and level transition.
     * If level is 3, proceeds to final screen.
     */
    private void win(){
        if(Variables.level == 3){
            endGame();
        } else{
            Variables.winSound.setVolume(1);
            Variables.winSound.play();

            Graphics.addWinText(getGCanvas());

            //wait for click to open next level
            while(!Variables.shouldOpenLevel){
                pause(5);
            }
            Variables.level++;
            setDefaultValuesForLevel(Variables.level);
            removeAll();
            Variables.shouldOpenMenu = false;
        }
    }

    /**
     * Handles endgame screen.
     */
    private void endGame(){
        Variables.shouldOpenMenu = false;
        removeAll();
        Graphics.addEndgameUI(getGCanvas());
        while(!Variables.shouldOpenMenu){
            pause(5);
        }
        removeAll();
    }

    /**
     * Handles lose condition visualisation and restart.
     */
    private void lose() {
        Variables.loseSound.setVolume(1);
        Variables.loseSound.play();

        Graphics.addLoseText(getGCanvas());

        while(!Variables.shouldRestart){
            pause(5);
        }
        removeAll();
        Variables.shouldOpenMenu = false;
    }

    /**
     * Respawns ball.
     */
    private void resetBall(){
        remove(ball);
        ball = new Ball(paddle.getX()+
                paddle.getWidth()/2 - Variables.radius/2,
                paddle.getY() - Variables.radius - 15, Variables.radius);
        add(ball);
    }

    /**
     * Decrements lives and removes heart from screen.
     */
    private void decrementHearts(){
        --Variables.lives;
        if(Variables.lives > 0){
            Variables.loseLifeSound.setVolume(1);
            Variables.loseLifeSound.play();
        }

        Variables.hearts.get(Variables.lives).setVisible(false);
        Variables.hearts.remove(Variables.lives);
    }

    /**
     * Sets default values for level.
     * @param key level number
     */
    private void initValues(int key){
        switch(key){
            case 49:
                setDefaultValuesForLevel(1);
                break;
            case 50:
                setDefaultValuesForLevel(2);
                break;
            case 51:
                setDefaultValuesForLevel(3);
                break;
        }
    }

    /**
     * Opens level.
     * @param i level number
     */
    private void openLevel(int i){
        initValues(i);
        gameStarted = true;
    }

    /**
     * Resets game-handling variables that have been changed during the game to default values.
     */
    private void resetValues(){
        Variables.won = false;
        Variables.gameOver = false;
        Variables.score = 0;
        Variables.hearts.clear();
        scoreLabel.setLabel("Score: ");
        Variables.shouldRestart = false;
        gameStarted = false;
        Variables.shouldOpenLevel = false;
        Variables.lives = Variables.getLives();
    }

    /**
     * Handles starting params for each level.
     * @param level level number
     */
    private void setDefaultValuesForLevel(int level){
        switch(level) {
            case 1:
                Variables.rows = 3;
                Variables.bricksPerRow = 3;
                Variables.lives = 5;
                Variables.level = 1;
                break;
            case 2:
                Variables.rows = 5;
                Variables.bricksPerRow = 5;
                Variables.lives = 3;
                Variables.level = 2;
                break;
            case 3:
                Variables.rows = 1;
                Variables.bricksPerRow = 1;
                Variables.lives = 1;
                Variables.level = 3;
                break;
        }
    }
}