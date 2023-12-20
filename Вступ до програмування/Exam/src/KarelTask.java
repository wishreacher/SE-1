/*
    Карел має знайти діамант і перенести його у іншу частину світу.

    Федорич Володимир
 */

import stanford.karel.SuperKarel;
public class KarelTask extends SuperKarel {
    public void run() {
        if(frontIsBlocked() && leftIsBlocked() && rightIsBlocked()){
            return;
        }

        //this part handles beeper being in the top world
        handleTopSearch();

        //prevents a situation when karel considers newly placed beeper as one he should move
        if(beepersPresent()){
            return;
        }

        //return to the middle
        returnToMiddle();

        //this part handles beeper being in the bottom world
        handleBottomSearch();
    }

    private void enterBottom() {
        while(rightIsBlocked()){
            move();
        }
        turnRight();
        move();
        turnRight();
        while(frontIsClear()){
            move();
        }
        turnAround();
    }

    private void checkBottomWorld(){
        while(true){
            if(beepersPresent()){
                pickBeeper();
                return;
            }
            while(frontIsClear()){
                move();
                if(beepersPresent()){
                    pickBeeper();
                    return;
                }
            }
            turnRight();
            if(frontIsBlocked()){
                return;
            }
            turnLeft();
            turnAround();
            while(frontIsClear()){
                move();
            }
            turnLeft();
            move();
            turnLeft();
        }
    }

    public void checkTopWorld(){
        while(true){
            if(beepersPresent()){
                pickBeeper();
                return;
            }
            while(frontIsClear()){
                move();
                if(beepersPresent()){
                    pickBeeper();
                    return;
                }
            }
            turnAround();
            while(frontIsClear()){
                move();
            }
            turnRight();
            if(frontIsBlocked()){
                return;
            }
            move();
            turnRight();
        }
    }

    public void approachTopExit(){
        turnAround();
        while(frontIsClear()){
            move();
        }
        turnRight();
        while(frontIsClear()){
            move();
        }
        turnRight();
        while(leftIsBlocked()){
            move();
        }
    }

    public void goToCorner() {
        turnLeft();
        move();
        turnLeft();
        while (frontIsClear()) {
            move();
        }
        turnAround();
    }

    public void getTopBeeperToTheOtherSide(){
        //find exit
        while(notFacingSouth()){
            turnLeft();
        }
        while(frontIsClear()){
            move();
        }
        turnRight();
        while(frontIsClear()){
            move();
        }

        turnAround();
        while(rightIsBlocked()){
            move();
        }
        turnRight();

        //approach second barier
        while(frontIsClear()){
            move();
        }
        turnRight();
        while(frontIsClear()){
            move();
        }
        turnAround();
        while(rightIsBlocked()){
            move();
        }
        turnRight();
        while(frontIsClear()){
            move();
        }
        turnLeft();
        while(frontIsClear()){
            move();
        }
        if(getBeepersInBag() != 0){
            putBeeper();
        }
    }

    public void returnToMiddle(){
        turnLeft();
        while(frontIsClear()){
            move();
        }
        turnLeft();
        while(rightIsBlocked()){
            move();
        }
        turnRight();
        move();
        turnLeft();
        while(frontIsClear()){
            move();
        }
        turnAround();
    }
    public void getBottomBeeperToTheOtherSide(){
        while(notFacingEast()){
            turnLeft();
        }
        while(frontIsClear()){
            move();
        }
        turnLeft();
        while(frontIsClear()){
            move();
        }
        turnLeft();
        while(rightIsBlocked()){
            move();
        }
        turnRight();
        while(frontIsClear()){
            move();
        }
        turnRight();
        while(leftIsBlocked()){
            move();
        }
        turnLeft();
        move();
        turnRight();
        while(frontIsClear()){
            move();
        }
        if(getBeepersInBag() != 0){
            putBeeper();
        }
    }

    public void handleTopSearch(){
        approachTopExit();
        goToCorner();
        checkTopWorld();
        getTopBeeperToTheOtherSide();
    }
    public void handleBottomSearch(){
        enterBottom();
        checkBottomWorld();
        getBottomBeeperToTheOtherSide();
    }
}
