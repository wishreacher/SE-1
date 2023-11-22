package Elements;

import acm.graphics.*;
import acm.util.RandomGenerator;

import java.awt.*;

public class Ball extends GOval {
    private double posX;
    private double posY;

    private double size;

    private double direction;

    private double velocity;

    public double getDirection(){ return direction; }

    public void setDirection(double direction)
    {
        this.direction += direction;

        if(this.direction >= 2 * Math.PI)
            this.direction -= (2 * Math.PI);
    }

    public Ball(double posX, double posY, double size)
    {
        super(posX, posY, size, size);
        RandomGenerator rgen = RandomGenerator.getInstance();
        this.posX = posX;
        this.posY = posY;
        this.size = size;
        setFilled(true);
        setColor(Color.BLACK);
        setLocation(posX, posY);
        direction = rgen.nextDouble(0.5, 2.51);
        velocity = 1;
    }

    public void move()
    {
        checkCollisions();
        posX += Math.sin(direction) * velocity;
        posY -= Math.cos(direction) * velocity;
        //ballInstance.move(posX, posY);
        setLocation(posX, posY);
    }

    public void checkCollisions()
    {
        //TODO remove magic numbers 420
        if (posX <= 0 || posX + size >= 420 - 15 || posY <= 0)
        {
            direction += Math.PI / 8;

            if(direction >= 2 * Math.PI)
                direction -= (2 * Math.PI);
        }
        /*if(posY + size >= Vars.APPLICATION_HEIGHT - 65){
            Vars.GameIsOver = true;
            Vars.HasWon = false;
        }
        */

    }
}
