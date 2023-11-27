/*
    Написати процедуру обчислення за цілим N>3 таких натуральних A і B, що 5A-2B=N,
    причому A+B мінімально.

    File: HowToCallIt.java
    Author: Федорич Володимир
 */

import acm.program.ConsoleProgram;

public class HowToCallIt extends ConsoleProgram {
    public void run(){
        while(true){
            int n = readInt("Enter n: ");
            while(n <= 3){
                println("Error: n must be greater than 3");
                n = readInt("Enter n: ");
            }
            int[] result = calculate(n);
            println("A: " + result[0]);
            println("B: " + result[1]);
            handleExit();
        }
    }

    private void handleExit() {
        int exit = readInt("Enter 0 to exit and 1 to continue: ");
        while(exit != 0 && exit != 1){
            println("Error: value must be 0 or 1");
            exit = readInt("Enter 0 to exit and 1 to continue: ");
        }
        if(exit == 0){
            exit();
        }
    }

    private int[] calculate(int n) {
        int[] result = new int[2];
        int a = 0;
        int b = 0;
        int minSum = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(5 * i - 2 * j == n && i + j < minSum){
                    a = i;
                    b = j;
                    minSum = i + j;
                }
            }
        }
        result[0] = a;
        result[1] = b;
        return result;
    }
}
