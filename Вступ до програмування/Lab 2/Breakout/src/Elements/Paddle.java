package Elements;

import acm.graphics.*;

import java.awt.*;

public class Paddle extends GRect {
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
        setColor(Color.BLACK);
    }

    public void move(double mouseX)
    {
        trgX = mouseX - width/2;

        double angle = Math.atan((70) / (trgX - this.posX));

        //TODO remove magic numbers 420
        if(trgX >= posX) {
            if(posX + width < 420-15)
                posX += Math.cos(angle) * 3;
        }
        else if(posX > 0)
            posX -= Math.cos(angle) * 3;

        setLocation(posX, posY);
    }
}


