/*
    Задача 4.
        Написати програму, що запитує у користувача два числа і обраховує корень квадратний з суми їх квадратів.

    Задача 5.
        Написати програму, що зчитує з клавіатури цілі числа (по одному числу за раз), поки користувач не введе число 0
        (ви маєте бути в змозі легко поміняти цю умову на якесь інше число). По закінченню вводу ваша програма має вивести найменше і найбільше число.
        Якщо користувач введе лише одне число, програма має повідомити що це число і найбільше і найменше
        Якщо користувач в першій же стрічці введе символ закінчення вводу, тоді вважається, що жодного числа не було введено і програма має це повідомити.

    Задача 6.
        Опис алгоритму:

        візьміть позитивне ціле число, назвемо його n
        якщо n парне, поділимо його на 2
        якщо n не парне, помножимой його на 3 і додамо 1
        продовжувати цей процес поки n не буде дорівнювати 1
        Напишіть програму, що реалізує вказаний алгоритм і наочно проілюструє його виконання. В кінці обов'язково повідомити кількість кроків.
 */

import acm.program.ConsoleProgram;

public class Calculations extends ConsoleProgram {
    int menuChoice = 0;
    public void run(){
        while(true) {
            printMenu();
            switch (menuChoice) {
                case 1 -> getHypotenuse();
                case 2 -> minmax();
                case 3 -> reduction();
            }
            exitOptions();
        }
    }

    public void printMenu(){
        getConsole().clear();
        println("Enter the corresponding number for needed function: ");
        println("1 - calculate hypotenuse with knowing two other sides");
        println("2 - get a minimum and maximum of entered numbers");
        println("3 - reduce a number to 1. Show number of steps");

        menuChoice = readInt();

        while(menuChoice != 1 && menuChoice != 2 && menuChoice != 3){
            println("Please enter 1, 2 or 3");
            menuChoice = readInt();
        }
    }

    //calculates Hypotenuse using the Pythagorean theorem
    public void getHypotenuse(){
        getConsole().clear();
        double a = readInt("Enter the first triangle side: ");
        while(a <= 0){
            a = readInt("A side can't be equal to a negative number: ");
        }
        double b = readInt("Enter the second triangle side: ");
        while(b <= 0){
            b = readInt("A side can't be equal to a negative number: ");
        }

        double c = Math.sqrt(a*a + b*b);

        getConsole().clear();
        println("First side = " + a);
        println("Seconds side = " + b);
        println("Hypotenuse = " + c);
    }

    //let user type numbers and print min and max of them
    public void minmax(){
        getConsole().clear();
        println("This program finds the largest and the smallest number. If you wanna stop enter 0");

        int min = 0;
        int max = 0;

        int input = readInt("? ");
        while(input != 0){
            if(input < min){
                min = input;
            }else if(input > max){
                max = input;
            }
            input = readInt("? ");
        }

        println("min: " + min);
        println("max: " + max);
    }

    //reduce a given number to 1 and calculate number of steps
    public void reduction(){
        int n = readInt("Enter a positive natural number");
        int steps = 0;

        while(n <= 0){
            n = readInt("This is not a positive natural number");
        }

        while(n != 1){
            if(n % 2 == 0){
                println("divided " + n + " by 2. Result: " + (n/2));
                n = n / 2;
                steps++;
            } else{
                println("multiplied " + n + " by 3 and added 1. Result: " + ((n * 3) + 1));
                n = (n * 3) + 1;
                steps++;
            }
        }
        println("Number of steps:" + steps);
    }

    //handles exit and replay
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
