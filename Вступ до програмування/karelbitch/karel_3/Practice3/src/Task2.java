//Федорич Володимир
import stanford.karel.SuperKarel;
public class Task2 extends SuperKarel {
    public void run() {
        while (facingEast() && leftIsClear()) {
            searchColumnForBeepers();
            searchForExit();
        }
    }
    private void searchForExit(){
        turnLeft();
        while(rightIsBlocked() && frontIsClear()){
            move();
        }
        if(rightIsClear()){
            turnRight();
            move();
            turnLeft();
            returnToBottom();
            return;
        }
        turnRight();
    }
    private void searchColumnForBeepers(){
        safePickBeeper();
        turnLeft();
        while(frontIsClear()){
            move();
            safePickBeeper();
        }
        returnToBottom();
    }
    private void safePickBeeper(){
        if(beepersPresent()){
            pickBeeper();
        }
    }
    private void returnToBottom(){
        turnAround();
        while(frontIsClear()){
            move();
        }
        turnLeft();
    }
}
