/*
    Намалювати сонечко з променями.
    Кількість променів задається константою.
    Промені мають бути розміщені рівномірно.

    File: Sun.java
    Author: Федорич Володимир
 */

import acm.graphics.GLine;
import acm.graphics.GOval;
import acm.program.GraphicsProgram;
import java.awt.*;

public class Sun extends GraphicsProgram {
    final int rays =  1000;
    final double rayLength = 200.0;
    final double rayCenterOffset = 120.0;
    final Color sunColor = Color.white;

    //draws the sun center and calls a method that draws rays
    public void run(){
        this.setSize(600, 600);
        this.setBackground(Color.black);
        GOval sunCenter = new GOval(200, 200, 200, 200);
        sunCenter.setFilled(true);
        sunCenter.setFillColor(sunColor);

        add(sunCenter);
        drawRays();
    }

    /*
        draws rays(quantity is determined by the constant @rays defined above).
        To calculate start/end point for each ray we find current angle's sin/cos and multiply it
        by @rayCenterOffset and @rayLength which gives us a convenient vector to use.
        We add 300 to align rays starting point with the sun center.
     */
    private void drawRays(){
        for(int i = 1; i < rays + 1; i++){
            double currentAngle = (360.0/rays) * i;
            double xStartRayCoordinate = 300 + rayCenterOffset * Math.cos(Math.toRadians(currentAngle));
            double yStartRayCoordinate = 300 + rayCenterOffset * Math.sin(Math.toRadians(currentAngle));
            double xEndRayCoordinate = 300 + rayLength * Math.cos(Math.toRadians(currentAngle));
            double yEndRayCoordinate = 300 + rayLength * Math.sin(Math.toRadians(currentAngle));

            GLine rayToDraw = new GLine(xStartRayCoordinate, yStartRayCoordinate, xEndRayCoordinate, yEndRayCoordinate);
            rayToDraw.setColor(sunColor);
            add(rayToDraw);
        }
    }
}