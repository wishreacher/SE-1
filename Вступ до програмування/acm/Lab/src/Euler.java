/*
    Послідовність сум {sn}, де sn=1+x+x2/2!+…+xn/n!, за умови 0<=x<1 "достатньо швидко" сходиться до ex.
    Запрограмувати обчислення ex при x [0;1) із точністю ep , тобто за потрібне число приймається перше snтаке, що | sn-sn-1 |<ep .

    Розв'язати двома способами: з використанням циклів (але використовуючи рекурентність)
     та з використанням рекурсивних викликів методів.

    File: Euler.java
    Author: Федорич Володимир
 */

import acm.program.ConsoleProgram;

public class Euler extends ConsoleProgram{
    public void run() {
        while(true){
            getConsole().clear();

            double x = readDouble("Enter x (0 <= x < 1): ");
            while(x >= 1 || x < 0){
                x = readDouble("Enter x (0 <= x < 1): ");
            }
            double ep = readDouble("Enter precision: ");
            while(ep < 0 || ep > 1){
                ep = readDouble("Please enter the correct precisiom");
            }
            println("e^" + x + " with precision " + ep + " " +
                    "(iteratively) = " + calculateIteratively(x, ep));
            println("e^" + x + " with precision " + ep + " " +
                    "(recursively) = " + calculateRecursively(x, 1, 1, 1, ep));

            println(exactValue(x));

            exitOptions();
        }
    }

    //returns e to the power of x with precision ep, calculated iteratively
    private double calculateIteratively(double x, double ep) {
        double sumSequence = 1.0;
        double previousSumSequnce = sumSequence - 1;
        int n = 1;
        double sequenceStep = 1;

        while(Math.abs(sumSequence - previousSumSequnce) >= ep){
            previousSumSequnce = sumSequence;
            sequenceStep *= x / n;
            sumSequence += sequenceStep;
            n++;
        }

        return sumSequence;
    }

    //returns e to the power of x with precision ep, calculated recursively
    private double calculateRecursively(double x, int n, double term, double sn, double ep) {
        term = term * x / n;
        sn += term;
        if (Math.abs(term) < ep) {
            return sn;
        } else{
            return calculateRecursively(x,n + 1, term, sn, ep);
        }
    }

    //returns the exact(table) value of e to the power of x = lnx
    private double exactValue(double x) {
        return Math.exp(x);
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
