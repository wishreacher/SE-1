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

    public double getDirection(){ return direction; }

    public void setDirection(double direction)
    {
        this.direction += direction;

        if(this.direction >= 2 * Math.PI)
            this.direction -= (2 * Math.PI);

        Variables.bounceSound.setVolume(1);
        Variables.bounceSound.play();
    }

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
        if (posX <= 0 || posX + size >= Variables.appWidth - 15 || posY <= 0)
        {
            direction += Math.PI / 8;

            if(direction >= 2 * Math.PI){
                direction -= (2 * Math.PI);
            }
            Variables.bounceSound.setVolume(1);
            Variables.bounceSound.play();
        }
    }

    public void reset() {
//            ballInstance.setLocation(Variables.appWidth/2 - Variables.radius,
//                    Variables.appWidth/2 - Variables.radius);

    }
}