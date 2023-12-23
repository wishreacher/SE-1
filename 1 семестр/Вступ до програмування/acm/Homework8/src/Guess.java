/*
    Гра "Вгадай число"

    Одна з найпростіших ігор для двох гравців є "Вгадай число". Перший гравець задумує таємне число
    в деякому відомому діапазоні, а другий гравець намагається вгадати число. Після кожного
    намагання вгадати число, перший гравець відповідає «Більше», «Менше» або «Вірно!" .
    У цьому проекті, ви будете будувати просту інтерактивну програму, де комп'ютер візьме на
    себе роль першого гравця в той час як ви граєте, як другій гравець.

    Ви маєте написати програму, що загадує число строго в діапазоні від 1 до 100 і очікує відповідей
    користувача з консолі. Ви маєте рахувати кількість спроб користувача.В кінці гри вивести за
    скільки спроб вгадали число.

    По завершенні гри пропонуєте розпочати її знову.

    File: Guess.java
    Author: Федорич Володимир
 */

import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;

public class Guess extends ConsoleProgram {
    private RandomGenerator rgen = RandomGenerator.getInstance();

    public void run(){
        while(true){
            menu();
            guessProcessing();
            exitOptions();
        }
    }
    
    //printing the description
    private void menu(){
        getConsole().clear();
        println("Computer has picked a random number in range (1-100), enter your " +
                "guess to get a response 'Higher' 'Lower' or 'Correct' ");
    }

    //generates a pseudo-random number in range and lets the user guess it
    private void guessProcessing(){
        int target = rgen.nextInt(1, 100);

        int guess = readInt("Enter your guess: ");
        while(guess <= 0 || guess > 100){
            guess = readInt("Guess should be in (1-100) range: ");
        }

        int steps = 1;
        while(guess != target){
            if(guess > target){
                println("The riddled number is lower");
            } else if(guess < target){
                println("The riddled number is higher");
            }
            guess = readInt("Enter your next guest: ");
            while(guess <= 0 || guess > 100){
                guess = readInt("Guess should be in (1-100) range");
            }
            steps++;
        }

        println("It's " + target + ". You guessed right in " + steps + " steps.");
    }

    //provides options to replay or quit the game
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
