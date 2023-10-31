/*
    Послідовність сум {sn}, де sn=1-x2/2!+…+(-1)nx2n/(2n)!, за умови |x|<= p /4 "достатньо швидко" сходиться до cos(x).
    Запрограмувати обчислення cos(x) при x [-p /4; p/4] з точністю ep , тобто за потрібне число приймається перше snтаке, що | sn-sn-1 |<ep .

    Розв'язати двома способами: з використанням циклів (але використовуючи рекурентність) та з використанням рекурсивних викликів методів.

    File: Cosinus.java
    Author: Федорич Володимир
 */

import acm.program.ConsoleProgram;

public class Cosinus extends ConsoleProgram {
    public void run() {
        double x = 0.1; // Your value of x
        double epsilon = 0.001; // Your desired accuracy (epsilon)

        println("cos(" + x + ") = " + cosCustom(x, epsilon));
        println("cos(" + x + ") = " + cosCustomRecursive(x, epsilon, 1, 1, 2, -1));
        println(Math.cos(x));
    }

    private double cosCustom(double x, double epsilon) {
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

    private double cosCustomRecursive(double x, double epsilon, double sn, double term, int n, int sign) {
        if (Math.abs(term) < epsilon) {
            return sn;
        }

        term *= (x * x) / (n * (n - 1));
        sn += sign * term;

        return cosCustomRecursive(x, epsilon, sn, term, n + 2, -sign);
    }
}
