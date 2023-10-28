/*
    1. Обчисліть значення функції та виведіть його на екран.

    у=МАХ(a, b, c, d)
    y=x4
    y=ax2+bx+c
    Значення a, b, c, d, х задається з клавіатури.

    2. Розв'яжіть рівняння та виведіть на екран результат.

    y=x4
    y=ax2+bx+c
    y=ax+c
    Значення a, b, c, у задається з клавіатури.

    File: Formulas.java
    Author: Федорич Володимир
 */

import acm.program.ConsoleProgram;

public class Formulas extends ConsoleProgram {
    public void run(){
        this.setSize(666, 666);
        runCalculations();
    }

    /*
        Requests user input to assign values to the variables used in formulas.
        Calls corresponding method for each operation described in the task description.
     */
    private void runCalculations() {
        while(true){
            double a = readDouble("Enter a = ");
            double b = readDouble("Enter b = ");
            double c = readDouble("Enter c = ");
            double d = readDouble("Enter d = ");
            double x = readDouble("Enter x = ");

            println("Maximum number is: " + getMAX(a, b, c, d));
            println("X to the 4th power is: " + toForthPower(x));
            println("ax^2+bx+c is: " + findY(a, b, c, x));

            a = readDouble("Enter a = ");
            b = readDouble("Enter b = ");
            c = readDouble("Enter c = ");
            double y = readDouble("Enter y = ");

            println("root of y of the 4 power is: " + rootOfTheForthPower(y));
            println("x from square equation: " + solveQuadraticEquation(a, b, c, y));
            println("x from linear equation: " + solveLinearEquation(a, c, y));

            //Якщо вам це не сподобається, бо ми це ще не вчили, можна просто написати break ;)
            if(readInt("Enter 0 to stop the program or any other number to restart ") == 0){
                exit();
            } else{
                //Цього ми теж не вчили, але бісить засмічена консоль :)
                getConsole().clear();
            }
        }
    }

    //returns the highest number out of 4 double inputs
    private double getMAX(double a, double b, double c, double d){
        double max = 0.0;
        if((a >= b) && (a >= c) && (a >= d)){
            max = a;
        } else if((b >= a) && (b >= c) && (b >= d)){
            max = b;
        } else if((c >= a) && (c >= b) && (c >= d)) {
            max = c;
        } else if((d >= a) && (d >= b) && (d >= c)){
            max = d;
        }
        return max;
    }

    //returns the input raised to the power of 4
    private double toForthPower(double x){
        return x * x * x * x;
    }

    //solves square equation for y, when all other variables are given
    private double findY(double a, double b, double c, double x){
        return (a * x * x) + (b * x) + c;
    }

    //returns the root of the fourth power of a given number
    private String rootOfTheForthPower(double y){
        if(y < 0){
            return "y can't be equal to a negative number";
        }
        return String.valueOf(Math.pow(y, 0.25));
    }

    /*
        Solves quadratic equation for x, when all other variables are provided.
        Uses a discriminant formula. If a == 0, the equation becomes linear, therefore
        @solveLinearEquation is called. Supports the cases of wrongly inputted values.
     */
    private String solveQuadraticEquation(double a, double b, double c, double y){
        if(a == 0 && b == 0){
            if(y == c){
                return "No valid solution!";
            }
            return "x - any number";
        }
        if(a == 0){
            return solveLinearEquation(b, c, y);
        }

        double newC = c - y; // we need it to convert our square equation to the normal form
        double discriminant = Math.pow(b, 2) - 4 * a * newC;

        if(discriminant > 0){
            double firstSol = (-b + Math.sqrt(discriminant)) / 2 * a;
            double secondSol = (-b - Math.sqrt(discriminant)) / 2 * a;;
            return "First solution: " + firstSol + " Second solution: " + secondSol;
        } else if(discriminant == 0){
            return String.valueOf(-b / 2 * a);
        } else if(discriminant < 0){
            return "No valid solution!";
        }

        return "Something went wrong";
    }

    //solves linear equation and supports the cases of wrongly inputted values.
    private String solveLinearEquation(double k, double b, double y){
        if(k == 0 && b == y){
            return "x - any number";
        } else if(k == 0 && b != y){
            return "Equation can't be solved";
        }
        return String.valueOf((y - b) / k);
    }
}