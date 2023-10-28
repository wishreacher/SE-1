/*
    Карел має покласти біпер по центру 1-ої вулиці (першого рядка). Якщо ви працюєте з світом,
    що зображено на малюнку нижче, то Карел має закінчити роботу стоячи на біпері по центру стрічки,
    як на малюнку нижче.

    Тобто на дошці має стояти вісього один біпер. І цей біпер має бути розташований по центру першого рядка і Карел стоїть на ньому.

    При вирішенні проблеми ви маєте спиратися на наступні знання про світ:

    Карел не вміє рахувати
    Карел починає роботу з клітинки 1х1 обличчам на схід з необмеженою кількістю біперів
    Початковий світ не містить ні стін ні біперів
    Світ не повинен бути квадратним, але ви можете вважати, що він принаймні, такий же високий, як і широкий
    Якщо довжина рядка непарна, тоді Карел має покласти біпер саме по центру, якщо парна тоді в одній з
    двох центральних клітин
    Не має різниці в якому напрямку Карел дивиться в кінці., але обов'язково стоїть на ногах.

    File: Task2
    Author: Федорич Володимир
 */

import stanford.karel.SuperKarel;

public class Task2 extends SuperKarel {
    public void run() {
        if(frontIsClear()){
            fillRow();
            moveBeepersToEastWall();
            findMidPoint();
        } else{
            putBeeper();
        }
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
}