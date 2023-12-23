/*
    Послідовність сум {sn}, де sn=1-x2/2!+…+(-1)nx2n/(2n)!, за умови |x|<= p /4 "достатньо швидко" сходиться до cos(x).
    Запрограмувати обчислення cos(x) при x [-p /4; p/4] з точністю ep , тобто за потрібне число приймається перше snтаке, що | sn-sn-1 |<ep .

    Розв'язати двома способами: з використанням циклів (але використовуючи рекурентність) та з використанням рекурсивних викликів методів.

    File: Cosinus.java
    Author: Федорич Володимир
 */

import acm.program.ConsoleProgram;

public class Cosines extends ConsoleProgram {
    public void run() {
        while(true){
            getConsole().clear();
            
            double x = readDouble("Enter x in range from -p/4 to p/4: ");
            while(x < (-1 * Math.PI / 4) || x > (Math.PI) / 4){
                x = readDouble("Enter x in range from -p/4 to p/4: ");
            }
            double ep = readDouble("Enter precision: ");
            while(ep < 0 || ep > 1){
                ep = readDouble("Please enter the correct precision: ");
            }

            println("cos(" + x + ") = " + cosIterative(x, ep));
            println("cos(" + x + ") = " + cosRecursive(x, ep, 1, 1, 2, -1));
            println(exactValue(x));

            exitOptions();
        }
    }

    //calculates cosines of x with precision ep iteratively
    private double cosIterative(double x, double epsilon) {
        double sn = 1.0;
        double term = 1.0;
        int n = 2;
        int sign = -1;

        while (Math.abs(term) >= epsilon) {
            term *= (x * x) / (n * (n - 1));
            sn += sign * term;
            n += 2;
            sign = -sign;
        }
        return sn;
    }

    //calculates cosines of x with precision ep recursively
    private double cosRecursive(double x, double epsilon, double sn, double term, int n, int sign) {
        if (Math.abs(term) < epsilon) {
            return sn;
        }

        term *= (x * x) / (n * (n - 1));
        sn += sign * term;

        return cosRecursive(x, epsilon, sn, term, n + 2, -sign);
    }

    //returns the exact value of cos(x)
    private double exactValue(double x){
        return Math.cos(x);
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
