//Федорич Володимир
import stanford.karel.SuperKarel;

public class Task1 extends SuperKarel {
    public void run() {
        safePickBeeper();
        while(frontIsClear() || leftIsClear() || rightIsClear()){
            searchCurrentRowForBeepers();
            searchForExitAndMoveUp();
            if(frontIsBlocked() && leftIsBlocked()){  //stop condition
                safePickBeeper();
                break;
            }
        }
    }
    private void searchForExitAndMoveUp(){
        while(leftIsBlocked()){
            if(frontIsBlocked() && leftIsBlocked()){
                return;
            }
            move();
        }
        turnLeft();
        move();
        turnRight();
        returnToWestWall();
    }
    private void returnToWestWall(){
        turnAround();
        while(frontIsClear()){
            move();
        }
        turnAround();
    }
    private void safePickBeeper(){
        if(beepersPresent()){
            pickBeeper();
        }
    }
    private void searchCurrentRowForBeepers(){
        safePickBeeper();
        while(frontIsClear()){
            move();
            safePickBeeper();
        }
        returnToWestWall();
    }
}
