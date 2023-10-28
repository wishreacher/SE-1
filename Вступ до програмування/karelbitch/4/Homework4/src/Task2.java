/*
    Карелу необхідно побудувати піраміду з біперів. Основою для піраміди є ширина всього світу.

    Світ може бути будь-якої ширини. Кількість вулиць не парна.

    Світ може бути будь-якої висоти. І може бути ситуація,
    що Керол побудує зрізану піраміду (якщо світ занизький).

    Керол може закінчити роботу програми в будь-якій позиції, стоячи на ногах.

    File: Task2.java
    Author: Федорич Володимир
 */

import stanford.karel.SuperKarel;

public class Task2 extends SuperKarel {
    public void run(){
        createFoundation();
        returnToStart();
        buildNextRow();
    }

    //fills the first row with beepers
    private void createFoundation(){
        putBeeper();
        while (frontIsClear()){
            move();
            putBeeper();
        }
    }

    //returns to the starting point
    private void returnToStart(){
        turnAround();
        while(frontIsClear()){
            move();
        }
        turnAround();
    }

    /*we start with placing borderline beepers, the left one, then the right one
    Location of the left one is predetermined(one tile to the right diagonally), and
    to calculate the location of the right one Karel goes down the row and moves forward
    until beepers are present. When he reaches a tile with no beeper he comes back
    one tile and moves diagonally to the left. The process is repeated, and will be
    terminated if he tries to put right-border beeper in tile which already has beepers.
    That indicated the top of the pyramid.
     */
    /*Side note: this method could be split into more pieces, but since we can't use "return"
    or methods with return types it stays this big to manage all the blocking checks.
    */
    private void buildNextRow(){
        while(facingEast()){
            //here we check if we have space for the next row and if we do place the first beeper
            if(leftIsBlocked()){
                break;
            }
            if(frontIsClear() && leftIsClear()){
                moveRightDiagonally();
                putBeeper();
            } else{
                break;
            }
            moveDown();

            //move forward until beepers are present
            while(facingEast()){
                if(frontIsClear()){
                    move();
                    if (noBeepersPresent()){
                        turnAround();
                        move();
                        move();
                        break;
                    }
                }
                if (frontIsBlocked()){
                    turnAround();
                    move();
                }
            }

            if(rightIsBlocked()){
                break;
            }
            moveLeftDiagonally();

            /*put beeper on the right side of the row and move forward, if a beeper is already
            present, it indicated the top of the pyramid*/
            if(noBeepersPresent()){
                putBeeper();
            } else{
                break;
            }
            move();
            returnPlacingBeepers();
        }
        fixPosition();
    }
    //moves to the right diagonally
    private void moveRightDiagonally() {
        turnLeft();
        move();
        turnRight();
        move();
    }

    //moves down one tile
    private void moveDown(){
        turnRight();
        move();
        turnLeft();
    }
    //rotates Karel so he ends up facing east
    private void fixPosition(){
        if(leftIsClear() && frontIsClear()){
            turnRight();
            if(frontIsBlocked()){
                turnRight();
            } else{
                move();
                turnRight();
            }

        }
    }

    //move until we hit the left end of the row and place beepers in the meantime
    private void returnPlacingBeepers(){
        while(noBeepersPresent()){
            putBeeper();
            move();
        }
        turnAround();
    }

    //moves to the left Diagonally
    private void moveLeftDiagonally(){
        turnRight();
        move();
        turnLeft();
    }
}
