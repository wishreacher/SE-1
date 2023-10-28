/*
    Ітак, Карел сидить на лівому кутку перфокарти.


    За замовчанням користувачу видається перфокарта, що повністю заповнена.
    Всі прямокутники заповнені як це зроблено на малюнку в стовбчику 2 та 8.

    якщо в центральній комірці біпер продавлений то виборець голосує проти даного кандидата і Карел
    має прибрати інші зайві біпери з колонки, як це зображено на малюнку нижче:

    Карел має спиратися на наступні знання:

    світ складається з одного рядка прямокутників для голосування
    прямокутники для голосування чергуються одним порожнім стовпчиком
    прямокутників для голосування може бути більше (або менше) ніж зображено на малюнку
    світ починається порожнім стовпчиком і закінчується порожнім стовбчиком
    прямокутники не завжди складаються з трьох комірок (висота прямокутників може бути різною)
    Карел завжди починає роботу зліва від першого прямокутника для голосування, головою на схід, в рядку,
    що проходить через всі прямокутники
    Карел має закінчити роботу обличчам на схід в останньому стовпчику перфокарти
    Напишіть програму в якій Карел чистить перфокарту. Пам'ятайте, що перфокарта може бути довша
    за зображену на малюнку.

    File: Task1.java
    Author: Федорич Володимир
 */

import stanford.karel.SuperKarel;

public class Task1 extends SuperKarel {
    public void run(){
        while(frontIsClear()){
            move();
            ExploreColumn();
        }
    }

    //checks if beeper is present on the central cell and decides wether to clean or fill the column
    private void ExploreColumn(){
        if(beepersPresent()){
            FillColumn();
        } else{
            ClearColumn();
        }
    }

    //clears the column of all excess beepers
    private void ClearColumn(){
        turnLeft();
        MoveTowardWallCollectingAllBeepers();
        turnAround();
        MoveTowardWallCollectingAllBeepers();
        LeaveColumn();
    }

    /*fills the column with beepers. If some beepers are already present on the cell, removes them all
    and places just one instead*/
    private void FillColumn(){
        turnLeft();
        MoveTowardWallLeavingOneBeeper();
        turnAround();
        MoveTowardWallLeavingOneBeeper();
        LeaveColumn();
    }

    //moving forward while front is clear and collecting all beepers on the way
    private void MoveTowardWallCollectingAllBeepers(){
        while(frontIsClear()){
            move();
            while(beepersPresent()){
                pickBeeper();
            }
        }
    }

    //moving forward while front is clear and leaving one beeper at each cell
    private void MoveTowardWallLeavingOneBeeper(){
        while(frontIsClear()){
            move();
            if(beepersPresent()){
                while(beepersPresent()){
                    pickBeeper();
                }
            }
            putBeeper();
        }
    }
    //finds a way out column and leaves
    private void LeaveColumn(){
        turnAround();
        while(rightIsBlocked()){
            move();
        }
        turnRight();
        move();
    }
}