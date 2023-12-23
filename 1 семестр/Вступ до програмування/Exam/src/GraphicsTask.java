/*
    Написати програму, що малює мʼячик, що стрибає зліва направо по екрану.
    Федорич Володмимир
 */

import acm.graphics.GOval;
import acm.program.GraphicsProgram;

public class GraphicsTask extends GraphicsProgram {
  GOval ball = new GOval(0, 0, 50, 50);
  double vx = 3;
  double vy = 1;
  boolean facingRight = true;

  public void run() {
    add(ball);
    while(true){
        ball.move(vx, vy);
        add(ball);
        pause(20);
        if(ball.getX() > getWidth() || ball.getX() < 0){
            reflect();
        }
        bounce();
    }
  }
  public void bounce(){
      vy += 1;
      ball.move(vx, vy);
      if(ball.getY() > getHeight() - ball.getHeight()){
          vy = -vy;
      }
  }
  public void reflect(){
      vx = -vx;
      facingRight = !facingRight;
  }
}
