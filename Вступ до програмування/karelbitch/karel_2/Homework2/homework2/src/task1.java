import stanford.karel.SuperKarel;

public class task1 extends SuperKarel {
    public void run() {
        while(frontIsClear()){
            move();
            if(beepersPresent()){
                pickBeeper();
                turnAround();
                while (frontIsClear()){
                    move();
                }
                turnAround();
                return;
            }
        }
        if(frontIsBlocked()){
            turnRight();
            while(frontIsClear()){
                move();
            }
            turnLeft();
        }
        while(frontIsBlocked()){
            turnLeft();
            move();
            turnRight();
        }
        if(frontIsClear()){
            move();
            if(beepersPresent()){
                pickBeeper();
            }
            turnAround();
        }
        while(frontIsClear()){
            move();
        }
        turnRight();
        while (frontIsClear()){
            move();
        }
        turnRight();
    }
}
