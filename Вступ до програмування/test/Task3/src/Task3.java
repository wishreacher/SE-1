/*
    Написати програму (використовуючи систему рекурентних співвідношень) обчислення суми
     , де xn=3xn-1 + xn-2 + 2xn-3, x0=x1=x2=3,   n вводиться з клавіатури.

     File: Task3.java
     Author: Федорич Володимир
 */

import acm.program.ConsoleProgram;

public class Task3 extends ConsoleProgram {
    public void run(){
        while(true){
            getConsole().clear();
            int n = readInt("Enter a natural number:");
            while(n <= 0){
                n = readInt("This is not a natural number");
            }

            getConsole().clear();
            println("n = " + n);

            println(calculateSum(n));
            exitOptions();
        }
    }
        private int calculateSum(int n) {
        if (n <= 2) {
            if(n == 0){
                return 3;
            } else if(n == 1){
                return 6;
            } else if(n == 2){
                return 9;
            }
        } else {
            int x0 = 3;
            int x1 = 3;
            int x2 = 3;
            int total = 0;

            for (int i = 3; i <= n; i++) {
                int xn = 3 * x2 + x1 + 2 * x0;
                total += xn;
                x0 = x1;
                x1 = x2;
                x2 = xn;
            }

            return total;
        }
        return 0; //smt went wrong
    }

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
