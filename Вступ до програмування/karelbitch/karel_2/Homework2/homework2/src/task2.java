import stanford.karel.SuperKarel;

public class task2 extends SuperKarel {
    public void run() {
        while(frontIsClear() || leftIsClear() || rightIsClear()){
            while(leftIsBlocked()){
                if(frontIsBlocked() && leftIsBlocked()){ //determining finish square
                    return;
                }
                move();
            }
            turnLeft(); // runs up until hits the wall
            runToTheWall();

            turnLeft(); //returns to the left side of the row
            runToTheWall();
            turnAround();
        }
    }

    private void runToTheWall(){
        while(frontIsClear()){
            move();
        }
    }
}