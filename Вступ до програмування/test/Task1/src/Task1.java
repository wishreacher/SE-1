/*
    Карел має зробити хрест по центру світу як зображено на малюнку.

    Умови, що мають виконуватися:
    1.	Карел починає в лівому нижньому кутку
    2.	Світ може мати парну або непарну будь-яку розмірність.
    3.	Карел може закінчити роботу де завгодно, але стоячи на ногах.
    4.	В разі парної розмірності світу для вертикальної і горизонтальної лінії
    обирається будь-яка (ліва або права) центральна клітина

    File: Task1.java
    Author: Федорич Володимир

 */

import stanford.karel.SuperKarel;

public class Task1 extends SuperKarel {
    public void run() {
        if(frontIsClear()){
            fillRow();
            moveBeepersToEastWall();
            findMidPoint();
        } else{
            putBeeper();
        }
        move();
        buildVertical();
        returnToStart();
        fillFirstColumn();
        moveBeepersToTheTop();
        findMidPointVertical();
        move();
        turnRight();
        putBeeper();
        buildHorizontal();
    }

    //fills the whole row with beepers
    private void fillRow(){
        putBeeper();
        while (frontIsClear()){
            move();
            putBeeper();
        }
    }
    //move each beeper in the row in one tile near the east wall
    private void moveBeepersToEastWall(){
        while(facingEast()){
            turnAround();
            move();
            while(noBeepersPresent()){
                move();
            }
            pickBeeper();
            if(frontIsBlocked() && leftIsBlocked()){
                returnToEastWall();
                putBeeper();
                break;
            }
            returnToEastWall();
            putBeeper();
        }
    }

    //return to the east wall
    private void returnToEastWall(){
        if(facingEast()){
            while(frontIsClear()){
                move();
            }
        } else if(facingWest()){
            turnAround();
            while(frontIsClear()){
                move();
            }
        }
    }

    /*for each 2 beepers on the storage tile places 1 beeper in a row from right to left until
    storage room runs out of beepers. When there are no beepers left on the storage tile, executes CleanUp
    */
    private void findMidPoint(){
        while(beepersPresent()){
            pickBeeper();
            if(noBeepersPresent()){
                cleanUp();
                break;
            }
            pickBeeper();
            turnAround();
            move();
            while(beepersPresent()){
                move();
            }
            putBeeper();
            returnToEastWall();
        }
        cleanUp();
        while(notFacingEast()){
            turnLeft();
        }
    }

    //removes all excess beepers left from finding the midpoint
    private void cleanUp(){
        turnAround();
        if(beepersPresent()){
            checkNextTileForBeepers();
        } else{
            while (noBeepersPresent()){
                move();
            }
            checkNextTileForBeepers();
        }
    }

    //if next tile has beepers, pick a beeper on current tile
    private void checkNextTileForBeepers(){
        while(beepersPresent()){
            if (frontIsBlocked()){
                break;
            }
            move();
            if(beepersPresent()){
                turnAround();
                move();
                pickBeeper();
                turnAround();
                move();
            } else{
                break;
            }
        }
    }

    public void buildVertical(){

        pickBeeper();
        putBeeper();
        putBeeper();
        turnLeft();
        while(frontIsClear()){
            move();
            putBeeper();
            putBeeper();
        }
    }

    public void returnToStart(){
        turnLeft();
        while(frontIsClear()){
            move();
        }
        turnLeft();
        while(frontIsClear()){
            move();
        }
        turnLeft();
    }

    public void fillFirstColumn(){
        putBeeper();
        turnLeft();
        while(frontIsClear()){
            move();
            putBeeper();
        }
    }

    public void returnToNorthWall(){
        if(facingNorth()){
            while(frontIsClear()){
                move();
            }
        } else if(facingSouth()){
            turnAround();
            while(frontIsClear()){
                move();
            }
        }
    }
    public void moveBeepersToTheTop(){
        while(facingNorth()){
            turnAround();
            move();
            while(noBeepersPresent()){
                move();
            }
            pickBeeper();
            if(frontIsBlocked() && rightIsBlocked()){
                turnAround();
                returnToNorthWall();
                putBeeper();
                break;
            }
            returnToNorthWall();
            putBeeper();
        }
    }

    public void findMidPointVertical(){
        while(beepersPresent()){
            pickBeeper();
            if(noBeepersPresent()){
                cleanUp();
                break;
            }
            pickBeeper();
            turnAround();
            move();
            while(beepersPresent()){
                move();
            }
            putBeeper();
            returnToNorthWall();
        }
        cleanUp();
        while(notFacingNorth()){
            turnLeft();
        }
    }

    public void buildHorizontal(){
        while(frontIsClear()){
            move();
            while(beepersPresent()){
                pickBeeper();
            }
            putBeeper();
            putBeeper();
        }
    }
}
