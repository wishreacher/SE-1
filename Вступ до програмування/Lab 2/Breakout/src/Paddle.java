import acm.graphics.GRect;

import java.awt.*;

public class Paddle extends GRect{
    private double posX;
    private double posY;
    private double width;
    private double trgX;

    public Paddle(double posX, double posY, double width, double height)
    {
        super(posX, posY, width, height);
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.trgX = posX;

        setFilled(true);
        setColor(Color.WHITE);
    }

    public void move()
    {
        //checkCollisions();
        trgX = Variables.mouseX - width/2;

        double angle = Math.atan((70) / (trgX - this.posX));

        if(trgX >= posX) {
            if(posX + width < Variables.appWidth-15)
                posX += Math.cos(angle) * 3;
        }
        else if(posX > 0)
            posX -= Math.cos(angle) * 3;

        setLocation(posX, posY);
    }

    public void reset() {
        setLocation((Variables.appHeight-15)/2 - Variables.paddleWidth/2,
                (Variables.appHeight - (Variables.paddleHeight * 2) - 60));
    }
}
