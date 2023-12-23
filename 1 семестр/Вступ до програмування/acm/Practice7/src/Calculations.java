/*
    Програма має рахувати числа Фібоначі і виводити результати на екран у формі:
    0 - 0
    1 - 1
    2 - 1
    3 - 2
    і так далі
    Кількість чисел Фібоначі, що необхідно вивести вводить користувач.

    Програма має рахувати n! Число n вводить користувач.

    Написати программу обчислення кількості (ми не знаємо кількість цифр) десяткових цифр
    натурального числа. Не використовувати стрічки, суто математичні операції.

    Усі завданні мають бути реалізовані в одному класі.

    File: Calculations.java
    Author: Федорич Володимир
 */

import acm.program.ConsoleProgram;

public class Calculations extends ConsoleProgram {
    int menuChoice = 0;
    int n = 0;

    public void run(){
        while(true) {
            printMenu();
            switch (menuChoice) {
                case 1:
                    printFibonacci(n, true);
                    printFibonacci(n, false);
                    break;
                case 2:
                    printFactorial(n, true);
                    printFactorial(n, false);
                    break;
                case 3:
                    printDecimalDigits(n, true);
                    printDecimalDigits(n, false);
                    break;
            }
            exitOptions();
        }
    }

    //handles function choices
    private void printMenu(){
        getConsole().clear();
        println("Enter the corresponding number for needed function: ");
        println("1 - Fibonacci sequence for n elements");
        println("2 - n!");
        println("3 - Number of decimal digits in n");

        menuChoice = readInt();

        while(menuChoice != 1 && menuChoice != 2 && menuChoice != 3){
            println("Please enter 1, 2 or 3");
            menuChoice = readInt();
        }

        n = readInt("Enter a natural number: ");
        while (n < 0) {
            println("This is not a natural number");
            n = readInt("Enter a natural number: ");
        }
        getConsole().clear();
        print("Your number is: " + n);
    }

    //prints fibonacci solutions. n-member of fibonacci sequence is equal to sum of 2 previous members
    private void printFibonacci(int n, boolean shouldSolveRecursively){
        if(n == 0){
            println("0 - 0");
            return;
        }

        if(shouldSolveRecursively){
            println(); //skips the line so it looks cleaner
            println("Solved recursively: ");
            fibonacciRecursion(0, 1, n, n);
        } else{ //skips the line so it looks cleaner
            println("Solved recurrently: ");
            fibonacciRecurrent(n);
        }
    }

    //solves fibonacci sequence recursively
    private void fibonacciRecursion(int a, int b, int n, int max){
        if (n + 1 > 0) {
            println((max - n) + " - " + a + " ");
            fibonacciRecursion(b, a + b, n - 1, max);
        }
    }

    //solves fibonacci sequence recurrently
    private void fibonacciRecurrent(int n){
        int a = 0;
        int b = 1;

        for(int i = 0; i < n + 1; i++){
            println(i + " - " + a);
            int next = a + b;
            a = b;
            b = next;
        }
    }

    //prints n! solutions
    private void printFactorial(int n, boolean shouldSolveRecursively){
        if(shouldSolveRecursively){
            println(); //skips the line so it looks cleaner
            println(n + "!" + " solved recursively: " + factorialRecursion(n));

        } else{
            println(); //skips the line so it looks cleaner
            println(n + "!" + " solved recurrently: " + factorialRecurrent(n));
        }
    }

    //solves factorial recursively
    private long factorialRecursion(int n){
        long result;
        if (n == 0 || n == 1) {
            result = 1;
        } else {
            result = n * factorialRecursion(n - 1);
        }
        return result;
    }

    //solves factorial recurrently
    private long factorialRecurrent(int n){
        if (n == 0 || n == 1) {
            return 1;
        }
        long result = 1;
        for(int i = n; i > 0; i--){
            result = result * i;
        }
        return result;
    }

    //prints the number of decimal digits in a given number
    private void printDecimalDigits(int n, boolean shouldSolveRecursively){
        if(shouldSolveRecursively){
            println(); //skips the line so it looks cleaner
            println("Number of decimal digits in " + n + " solved recursively: "
                    + decimalDigitsRecursion(n));

        } else{
            println(); //skips the line so it looks cleaner
            println("Number of decimal digits in " + n + " solved recurrently: "
                    + decimalDigitsRecurrent(n));
        }
    }

    //finds number of decimal digits recursively
    private int decimalDigitsRecursion(int n){
        if (n < 10) {
            //Base case: When n is a single digit, return 1.
            return 1;
        } else {
            //Recursively remove one digit at a time and count.
            return 1 + decimalDigitsRecursion(n / 10);
        }
    }

    //finds number of decimal digits recurrently
    private int decimalDigitsRecurrent(int n){
        if (n < 10) {
            //Base case: When n is a single digit, return 1.
            return 1;
        }
        int result = 0;
        while (n != 0) {
            n /= 10;
            result++;
        }
        return result;
    }
    
    //handles restarting program and starting over
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