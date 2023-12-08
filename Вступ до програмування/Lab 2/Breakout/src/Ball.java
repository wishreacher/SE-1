import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.util.SoundClip;

import java.awt.*;

public class Ball extends GOval
{
    private double posX;
    private double posY;

    private double size;

    private double direction;

    private double velocity;

    public void setDirection(double direction)
    {
        this.direction += direction;

        if(this.direction >= 2 * Math.PI)
            this.direction -= (2 * Math.PI);

        Variables.bounceSound.setVolume(1);
        Variables.bounceSound.play();
    }

    /**
     * Default constructor
     * @param posX - x coordinate of the ball
     * @param posY - y coordinate of the ball
     * @param size - size of the ball
     */
    public Ball(double posX, double posY, double size)
    {
        super(posX, posY, size, size);
        this.posX = posX;
        this.posY = posY;
        this.size = size;
        setFilled(true);
        setColor(Color.WHITE);
        setLocation(posX, posY);
        direction = Variables.rg.nextDouble(0.5, 2.51);
        velocity = 0.7;
    }

    /**
     * Moves the ball by multiplying the velocity by the sin and cos of the direction
     */
    public void move()
    {
        checkCollisions();
        posX += Math.sin(direction) * velocity;
        posY -= Math.cos(direction) * velocity;
        setLocation(posX, posY);
    }

    /**
     * Calculates the angle of reflection randomly
     */
    public void checkCollisions()
    {
        if (posX <= 0 || posX + size >= Variables.appWidth - 15 || posY <= 0)
        {
            direction += Math.PI / 8 + Variables.rg.nextDouble(-0.05, 0.05);

            if(direction >= 2 * Math.PI){
                direction -= (2 * Math.PI);
            }
            Variables.bounceSound.setVolume(1);
            Variables.bounceSound.play();
        }
    }

    /**
     * Checks if the ball is on the screen
     */
    public boolean isBallOnScreen(){
        return getY() < Variables.appHeight;
    }

    /**
     * Public direction getter
     */
    public double getDirection() {
        return direction;
    }
}