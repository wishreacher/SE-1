/*
    Написати програму, що дозволяє двом гравцям, грати в кості. Кількість кубиків, що кидає кожен
     гравець визначається на початку гри. Кількість сторін у кубика також задається на початку гри.

    Реалізувати вибір:
    1)гра може тривати визначену кількість кроків,
    2) після кожного ходу питається у гравців, чи продовжувати гру.
    Виводяться також всі проміжні результати.

    В кінці має бути визначений переможець. І пропозиція почати грати знову.

    File: Dices.java
    Author: Федорич Володимир
 */

import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;

public class Dices extends ConsoleProgram {
    private RandomGenerator rgen = RandomGenerator.getInstance();
    int firstPlayerScore = 0;
    int secondPlayerScore = 0;

    public void run(){
        while(true){
            firstPlayerScore = 0;
            secondPlayerScore = 0;
            getConsole().clear();
            menu();
            exitOptions();
        }
    }

    //prints description and handles game-mode choice
    private void menu(){
        println("To roll dices the selected amount of turns press 1");
        println("To roll dices infinitely press 2");

        int gameModeChoice = readInt();
        while(gameModeChoice != 1 && gameModeChoice != 2){
            println("Please enter 1 or 2: ");
            gameModeChoice = readInt();
        }
        getConsole().clear();

        if(gameModeChoice == 1){
            determinedThrows(getSides());

        } else if(gameModeChoice == 2){
            infiniteThrows(getSides());
        }
    }

    //rolls dices for @sides times
    private void determinedThrows(int sides){
        int iterations = readInt("Number of throws: ");
        while(iterations < 0){
            iterations = readInt("Number of throws cannot equal to a negative number: ");
        }

        for(int i = 0; i < iterations; i++){
            commitThrow(sides);
        }
        println(determineResult(firstPlayerScore, secondPlayerScore));
    }

    //rolls dices until user says to stop
    private void infiniteThrows(int sides){
        getConsole().clear();
        println("Current score: " + firstPlayerScore + "/" + secondPlayerScore);

        int lastRes1 = firstPlayerScore;
        int lastRes2 = secondPlayerScore;

        commitThrow(sides);
        int shouldContinue = readInt("To continue playing enter 1, to get results enter 0 ");
        while(shouldContinue != 0 && shouldContinue != 1){
            shouldContinue = readInt("Please enter 1 or 0: ");
        }

        if(shouldContinue == 0){
            getConsole().clear();
            println(determineResult(lastRes1, lastRes2));
        }else if(shouldContinue == 1){
            infiniteThrows(sides);
        }
    }

    //asks for a number of sides on a dice
    private int getSides(){
        int diceSides = readInt("Enter number of sides on a dice: ");
        while(diceSides <= 0){
            diceSides = readInt("Number od sides cannot equal to non-natural number");
        }
        return diceSides;
    }

    //returns a ready-to-use string for a dice-roll result
    private String getThrowResultString(int first, int second){
        return ("First player rolled: " + first + " / Second player rolled: " + second);
    }

    //returns a string that describes who won
    private String determineResult(int res1, int res2){
        String result = "";
        if(res1 > res2){
            result = "First Player Won! ";
        }else if(res2 > res1){
            result = "Second Player Won! ";
        }else if(res1 == res2){
            result = "Tie! ";
        }
        return result + "Score: " + res1 + "/" + res2;
    }

    //gets a random number in range and add it to the score
    private void commitThrow(int sides){
        int res1 = rgen.nextInt(1, sides);
        int res2 = rgen.nextInt(1, sides);

        println(getThrowResultString(res1, res2));

        firstPlayerScore += res1;
        secondPlayerScore += res2;
    }

    //handles closing/repeating the program
    private void exitOptions(){
        println(""); //skips the line
        int shouldExit = readInt("To close enter 0, to come back to menu press 1 ");
        while (shouldExit != 0 && shouldExit != 1) {
            shouldExit = readInt("Wrong number! To close enter 0, to come back to menu press 1 ");
        }
        if(shouldExit == 0) {
            exit();
        }
    }
}
