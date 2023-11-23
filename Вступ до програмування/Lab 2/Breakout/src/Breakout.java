import acm.graphics.GObject;
import acm.program.GraphicsProgram;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Breakout extends GraphicsProgram
{
    GameClasses.Platform platform = new GameClasses.Platform((Variables.appHeight-15)/2 - Variables.paddleWidth/2,
            (Variables.appHeight - (Variables.paddleHeight * 2) - 60) , Variables.paddleWidth, Variables.paddleHeight);
    GameClasses.ball ball = new GameClasses.ball(platform.getPlatformInstance().getX()+
            platform.getPlatformInstance().getWidth()/2 - Variables.radius/2,
            platform.getPlatformInstance().getY() - Variables.radius - 15, Variables.radius);

    private boolean gameStarted = false;
    public void run()
    {
        this.setSize(Variables.appWidth, Variables.appHeight);
        this.setBackground(Color.decode("#263238"));

        // init key listeners
        addMouseListeners();
        addKeyListeners();

        // draw platform
        add(platform.getPlatformInstance());

        // draw ball
        add(ball.getBallInstance());

        Menu menu = new Menu();
        add(menu.getStartMenuGObject());

        // wait 4 game to start
        while(!gameStarted) { pause(5); }

        // remove menu
        remove(menu.getStartMenuGObject());

        // draw bricks
        drawBricks();

        // game loop
        while(!Variables.gameOver)
        {
            //checkCollisions();
            ball.move();
            checkCollisions();
            platform.move();
            pause(1);
        }

        if(Variables.won)
            add(menu.getWinMenuGObject());
        else
            add(menu.getLoseMenuGObject());
    }

    private void checkCollisions()
    {
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

        if(obj == platform.getPlatformInstance()) {
            double direction = side == true ? Math.PI/4 : Math.PI/2;
            ball.setDirection(direction);
        }
        else if(obj != null){
            double direction = side == true ? Math.PI/1.1 : Math.PI/2.2;
            ball.setDirection(direction);
            remove(obj);
            GameClasses.Bricks.deleteBrick();
        }
    }

    public void keyPressed(KeyEvent e)
    {
        if(!gameStarted && e.getKeyCode() == 32)
            gameStarted = true;
    }

    public void mouseMoved(MouseEvent e)
    {
        Variables.mouseX = e.getX();
        Variables.mouseY = e.getY();
    }

    private void drawBricks() {
        for (int x = 0; x < Variables.bricksPerRow; ++x)
            for (int y = 0; y < Variables.rows; ++y) {
                int bx = x * (Variables.brickWidth + Variables.brickDelta);
                int by = Variables.brickYOffset + y * (Variables.brickHeight + Variables.brickDelta);
                add(GameClasses.Bricks.setBrick(bx, by, y));
            }
    }
}