/*
    Послідовність сум {sn}, де sn=1+x+x2/2!+…+xn/n!, за умови 0<=x<1 "достатньо швидко" сходиться до ex.
    ФЗапрограмувати обчислення ex при x [0;1) із точністю ep , тобто за потрібне число приймається перше snтаке, що | sn-sn-1 |<ep .

    Розв'язати двома способами: з використанням циклів (але використовуючи рекурентність) та з використанням рекурсивних викликів методів.

    File: Euler.java
    Author: Федорич Володимир
 */

import acm.program.ConsoleProgram;

public class Euler extends ConsoleProgram{
    public void run() {
        double x = readDouble("Введіть x (0 <= x < 1): ");
        double ep = readDouble("Введіть точність ep: ");

        println("e^" + x + " з точністю " + ep + " (циклічно) = " + calculateIteratively(x, ep));
        println("e^" + x + " з точністю " + ep + " (рекурсивно) = " + calculateRecursively(x, 1, 1, 1, ep));

        println(exactValue(x));
    }

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

    private double calculateRecursively(double x, int n, double term, double sn, double ep) {
        term = term * x / n;
        sn += term;
        if (Math.abs(term) < ep) {
            return sn;
        } else{
            return calculateRecursively(x,n + 1, term, sn, ep);
        }
    }

    private double exactValue(double x) {
        return Math.exp(x);
    }
}
