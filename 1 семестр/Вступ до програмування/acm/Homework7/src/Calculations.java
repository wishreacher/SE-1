/*
        Програма має рахувати числа Фібоначі і виводити результати на екран у формі:
        0 - 0
        1 - 1
        2 - 1
        3 - 2
        і так далі
        Користувач вводить число яке обмежує значення максимального числа Фібоначі,
        що має бути обраховане. Тобто вивід триває поки значення наступного числа фібоначі не перевищує
        введене користувачем число.

        File: Calculations.java
        Author: Федорич Володимир
 */

import acm.program.ConsoleProgram;

public class Calculations extends ConsoleProgram {
    public void run(){
        int n = readInt("Enter a natural number");
        while(n <= 0){
            n = readInt("This is not a natural number");
        }
        printFibonacci(n);
    }

    //prints fibonacci sequence until the biggest element is greater or equal to @n
    private void printFibonacci(int n){
        long fib1 = 0, fib2 = 1, nextFib;

        println("Fibonacci sequence up to " + n + ":");
        println("0 - " + fib1);

        if(n >= 2){
            println("1 - " + fib2);
            nextFib = fib1 + fib2;
            if(n >=3){
                int i = 2;
                while (nextFib <= n) {
                    println(i + " - " + nextFib);
                    fib1 = fib2;
                    fib2 = nextFib;
                    nextFib = fib1 + fib2;
                    i++;
                }
            }
        }
    }
}
