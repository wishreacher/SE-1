//Федорич Володимир
import stanford.karel.SuperKarel;

public class Chess extends SuperKarel {
    public void run() {
        setBeepersInBag(666);
        putBeeper();
        if(frontIsClear() && leftIsBlocked() && rightIsBlocked()){ //if in horizontal tube
            while(frontIsClear()){
                runForwardPlacingBeepers();
            }
            return;
        }

        turnLeft();
        while (facingNorth() || facingSouth()){
            runForwardPlacingBeepers();
            if (facingNorth()){
                switchToEvenColumn();
            }else if (facingSouth()){
                switchToOddColumn();
            }
        }
    }
    private void switchToOddColumn(){
        turnLeft();
        if(frontIsBlocked() && rightIsBlocked()){
            turnLeft();
            while(frontIsClear()){
                move();
            }
        } else{
            move();
            putBeeper();
            turnLeft();
        }
    }
    private void switchToEvenColumn(){
        if(beepersPresent()){
            turnRight();
            if (frontIsBlocked()){
                return;
            }
            move();
            turnRight();
            move();
            putBeeper();
        }
        if(noBeepersPresent()){
            turnRight();
            if (frontIsBlocked()){
                return;
            }
            move();
            turnRight();
            putBeeper();
        }
    }
    private void runForwardPlacingBeepers() {
        while (frontIsClear()){
            move();
            if(frontIsBlocked()){
                break;
            }
            move();
            putBeeper();
        }
    }
}